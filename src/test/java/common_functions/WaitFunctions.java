package common_functions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_settinga.TestSetUp;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class WaitFunctions extends TestSetUp
{
    public static void WaitUntilElementVisible(WebElement elm, long timeOutInSeconds)
    {
        FluentWait<WebDriver> fWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
    }

    public static void WaitUntilElementPresent(By by, long timeOutInSeconds)
    {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void WaitUntilElementInvisible(WebElement elm, long timeOutInSeconds)
    {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.invisibilityOf(elm));
    }
}
