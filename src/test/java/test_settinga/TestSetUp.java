package test_settinga;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import page_functions.HotelSearchPF;
import page_objects.CommonPO;
import page_objects.HotelSearchPO;
import page_objects.MainSearchPO;

import java.lang.reflect.Method;

public class TestSetUp
{
    private ExtentReports extReport;
    private ExtentHtmlReporter extReporter;
    private ExtentTest extTest;

    protected static WebDriver driver;
    protected static JavascriptExecutor js;
    private String url = "https://www.expedia.com.my/";

    protected CommonPO commonPO;
    protected MainSearchPO mainSearchPO;
    protected HotelSearchPO hotelSearchPO;
    protected HotelSearchPF hotelSearchPF;

    @BeforeTest
    public void ReportSetUp() {
        extReporter = new ExtentHtmlReporter("report/report.html");
        extReport = new ExtentReports();
        extReport.attachReporter(extReporter);
    }

    @BeforeClass
    public void InitClassObjects() {
        commonPO = new CommonPO();
        mainSearchPO = new MainSearchPO();
        hotelSearchPO = new HotelSearchPO();
        hotelSearchPF = new HotelSearchPF();
    }

    @BeforeMethod
    public void SetUp(Method method) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor)driver;
        extTest = extReport.createTest(method.getName());
        driver.get(url);
    }

    @AfterMethod
    public void TearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            extTest.fail(result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            extTest.pass("Passed");
        }
        driver.quit();
    }

    @AfterTest
    public void ReportTearDown() {
        extReport.flush();
    }

}
