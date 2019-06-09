package common_functions;

import org.openqa.selenium.WebElement;
import test_settinga.TestSetUp;

public class JSFunctions extends TestSetUp
{
    public static void JSClickElement(WebElement elm)
    {
        js.executeScript("arguments[0].click()", elm);
    }

    public static void JSScrollIntoView(WebElement elm)
    {
        js.executeScript("arguments[0].scrollIntoView()", elm);
    }

    public static boolean JSIsChecked(WebElement elm)
    {
        return (Boolean) js.executeScript("return arguments[0].checked", elm);
    }

    public static void JSEnterValue(WebElement elm, String value)
    {
        js.executeScript("arguments[0].value=arguments[1]", elm, value);
    }
}
