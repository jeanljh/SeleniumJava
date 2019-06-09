package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test_settinga.TestSetUp;

public class CommonPO extends TestSetUp
{
    public WebElement Loading()
    {
        return driver.findElement(By.cssSelector(".pageInterstitialLoader"));
    }
}
