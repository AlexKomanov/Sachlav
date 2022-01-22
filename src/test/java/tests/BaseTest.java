package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageObjects.Urls;

public abstract class BaseTest {

    protected WebDriver driver;
    protected static ExtentTest extentTest;
    protected static ExtentSparkReporter htmlReporter;
    protected static ExtentReports extentReports;

    @BeforeClass
    public static void startTest() {
        htmlReporter = new ExtentSparkReporter("reports/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void endTest() {
        extentReports.flush();
    }
}
