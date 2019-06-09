package page_objects;

import org.openqa.selenium.*;
import test_settinga.TestSetUp;

import java.util.List;

public class MainSearchPO extends TestSetUp
{
    public List<WebElement> TabSearch() {
        return driver.findElements(By.cssSelector("ul[class='tabs cf col'] button"));
    }
}
