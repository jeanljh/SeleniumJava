package test_cases;

import common_functions.JSFunctions;
import common_functions.SharedFunctions;
import common_functions.WaitFunctions;
import org.testng.annotations.Test;
import test_settinga.TestSetUp;

import static org.testng.Assert.*;


public class HotelSearchTC extends TestSetUp
{
    @Test(description = "Test Going To text field label")
    public void TestGoingToLabel() {
        mainSearchPO.TabSearch().get(0).click();
        assertEquals("Going to", hotelSearchPO.LbGoingTo().getText());
    }

    @Test(description = "Test Going To text field placeholder")
    public void TestGoingToPlaceholder() {
        mainSearchPO.TabSearch().get(0).click();
        assertEquals(hotelSearchPO.TfGoingTo().getAttribute("placeholder"), "Destination, hotel name, airport, " +
                "train station, landmark, or address");
    }

    @Test(description = "Test Check-in field label")
    public void TestCheckinLabel() {
        mainSearchPO.TabSearch().get(0).click();
        assertEquals(hotelSearchPO.LbCheckin().getText(), "Check-in");
    }

    @Test(description = "Test Check-out field label")
    public void TestCheckoutLabel() {
        mainSearchPO.TabSearch().get(0).click();
        assertEquals(hotelSearchPO.LbCheckout().getText(), "Check-out");
    }

    @Test(description = "Test select travellers feature")
    public void TestSelectTravellers() throws InterruptedException
    {
        String strExpect;

        mainSearchPO.TabSearch().get(0).click();
        strExpect = hotelSearchPF.SetTravellers(2, new int[] { 1, 1 }, new int[] { 1, 1 },
                new String[][] { {"1"}, {"1"} });
        assertEquals(hotelSearchPO.LbTravellers().getText(), strExpect, "Travellers text field value");

        strExpect = hotelSearchPF.SetTravellers(5, new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 1, 1, 1, 1 },
                new String[][] { {"1"}, {"2"}, {"3"}, {"4"}, {"5"} });
        assertEquals(hotelSearchPO.LbTravellers().getText(), strExpect, "Travellers text field value");
    }

    @Test(description = "Test \"Add a Flight\" feature")
    public void TestAddFlight()
    {
        boolean result;

        mainSearchPO.TabSearch().get(0).click();
        JSFunctions.JSClickElement(hotelSearchPO.CbAddFlight());
        assertTrue(JSFunctions.JSIsChecked(hotelSearchPO.CbAddFlight()), "Add a Flight checkbox");
        assertTrue(hotelSearchPO.TfFlyingFrom().isDisplayed(), "Flying from text field");

        JSFunctions.JSClickElement(hotelSearchPO.CbAddFlight());
        assertFalse(JSFunctions.JSIsChecked(hotelSearchPO.CbAddFlight()), "Add a Flight checkbox");
        assertFalse(hotelSearchPO.TfFlyingFrom().isDisplayed(), "Flying from text field");
    }

    @Test(description = "Test auto-suggest feature for 'Going to' input")
    public void TestAutoSuggest() throws InterruptedException
    {
        String location = "Cyberjaya";

        hotelSearchPO.TfGoingTo().sendKeys(location);
        WaitFunctions.WaitUntilElementVisible(hotelSearchPO.PaneGoingToAutoSuggest(), 3000);
        SharedFunctions.ValListValuesIgnoreCase(hotelSearchPO.LbGoingToAutoSuggest(), location);
        WaitFunctions.WaitUntilElementPresent(hotelSearchPO.ByBtnClearGoingTo(), 3000);
        JSFunctions.JSClickElement(hotelSearchPO.BtnClearGoingTo());

        JSFunctions.JSClickElement(hotelSearchPO.CbAddFlight());
        WaitFunctions.WaitUntilElementVisible(hotelSearchPO.TfFlyingFrom(), 3000);
        hotelSearchPO.TfFlyingFrom().sendKeys(location);
        WaitFunctions.WaitUntilElementPresent(hotelSearchPO.PaneFlyingFromAutoSuggest(), 3000);
        SharedFunctions.ValListValuesIgnoreCase(hotelSearchPO.LbFlyingFromAutoSuggest(), location);
    }

    @Test(description = "Test page loading feature")
    public void TestPageLoading() {
        JSFunctions.JSEnterValue(hotelSearchPO.TfGoingTo(), "Kuala Lumpur");
        JSFunctions.JSClickElement(hotelSearchPO.BtnSearch());
        WaitFunctions.WaitUntilElementInvisible(commonPO.Loading(), 60000);
    }
}
