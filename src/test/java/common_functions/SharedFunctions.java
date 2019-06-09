package common_functions;

import org.openqa.selenium.WebElement;
import test_settinga.TestSetUp;

import java.util.List;

public class SharedFunctions extends TestSetUp
{
    public static boolean ValListValuesIgnoreCase(List<WebElement> elm, String exp) {
        for (int i = 0; i < elm.size(); i++)
        {
            if (elm.get(i).getText().compareToIgnoreCase(exp) < 0) {
                return false;
            }
        }
        return true;
    }
}
