package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import test_settinga.TestSetUp;

import java.util.List;

public class HotelSearchPO extends TestSetUp
{
    public WebElement LbGoingTo()
    {
        return driver.findElement(By.cssSelector("label[for='hotel-destination-hp-hotel'] span:first-child"));
    }

    public WebElement TfGoingTo()
    {
        return driver.findElement(By.cssSelector("#hotel-destination-hp-hotel"));
    }

    public WebElement BtnClearGoingTo()
    {
        return driver.findElement(By.cssSelector(".autocomplete-open button"));
    }

    public By ByBtnClearGoingTo()
    {
        return By.cssSelector(".autocomplete-open button");
    }

    public WebElement PaneGoingToAutoSuggest()
    {
        return driver.findElement(By.cssSelector("#section-hotel-tab-hp .ab25184-location .autocomplete"));
    }

    public List<WebElement> LbGoingToAutoSuggest()
    {
        return driver.findElements(By.cssSelector(".singleLineText"));
    }

    public WebElement LinkCloseAutoSuggest()
    {
        return driver.findElement(By.cssSelector(".footer.userfeedback  > a"));
    }

    public WebElement LbCheckin()
    {
        return driver.findElement(By.cssSelector("label[for='hotel-checkin-hp-hotel'] > span:first-child"));
    }

    public WebElement TfCheckin()
    {
        return driver.findElement(By.cssSelector("#hotel-checkin-hp-hotel"));
    }



    public WebElement LbCheckout()
    {
        return driver.findElement(By.cssSelector("label[for='hotel-checkout-hp-hotel'] > span:first-child"));
    }

    public WebElement TfCheckout()
    {
        return driver.findElement(By.cssSelector("#hotel-checkout-hp-hotel"));
    }

    public WebElement LbCurrentMonthHeader() {
        return driver.findElement(By.cssSelector(".datepicker-cal :nth-child(4) caption"));
    }

    public WebElement LbNextMonthHeader() {
        return driver.findElement(By.cssSelector(".datepicker-cal :nth-child(5) caption"));
    }

    public WebElement TfTravellers()
    {
        return driver.findElement(By.cssSelector(".gcw-traveler-amount-select"));
    }

    public WebElement LbTravellers()
    {
        return driver.findElement(By.cssSelector(".gcw-traveler-amount-select > span > span:last-child"));
    }

    public WebElement LbAdult()
    {
        return driver.findElement(By.cssSelector("#traveler-selector-hp-hotel .adults"));
    }

    public WebElement LbChildren()
    {
        return driver.findElement(By.cssSelector("#traveler-selector-hp-hotel .children"));
    }

    public WebElement LbRoom()
    {
        return driver.findElement(By.cssSelector("#traveler-selector-hp-hotel .rooms"));
    }

    public List<WebElement> PaneRoom()
    {
        return driver.findElements(By.cssSelector("#traveler-selector-hp-hotel .traveler-selector-room-data"));
    }

    public List<WebElement> LinkRemoveRoom()
    {
        return driver.findElements(By.cssSelector("a[class*='remove-cloned'] > span:first-child"));
    }

    public List<WebElement> BtnMinusAdult()
    {
        return driver.findElements(By.cssSelector(".traveler-selector-room-data > .gcw-step-input " +
                ".uitk-step-input-minus"));
    }

    public List<WebElement> BtnAddAdult()
    {
        return driver.findElements(By.cssSelector(".traveler-selector-room-data > .gcw-step-input " +
                ".uitk-step-input-plus"));
    }

    public List<WebElement> LbAdultCount()
    {
        return driver.findElements(By.cssSelector(".traveler-selector-room-data > .gcw-step-input " +
                ".uitk-step-input-value"));
    }

    public List<WebElement> BtnMinusChild()
    {
        return driver.findElements(By.cssSelector("div[class*='gcw-menu'][style*='right'] .children-wrapper " +
                "button[class*='minus']"));
    }

    public List<WebElement> BtnAddChild()
    {
        return driver.findElements(By.cssSelector("div[class*='gcw-menu'][style*='right'] .children-wrapper " +
                "button[class*='plus']"));
    }

    public List<WebElement> LbChildCount()
    {
        return driver.findElements(By.cssSelector("div[class*='gcw-menu'][style*='right'] .children-wrapper " +
                ".uitk-step-input-value"));
    }

    public List<WebElement> CbbChildAge()
    {
        return driver.findElements(By.cssSelector("#traveler-selector-hp-hotel label:not(.gcw-disabled) select"));
    }

    public List<WebElement> CbbChildAge(int idx)
    {
        return driver.findElements(By.cssSelector(".traveler-selector-room-data:nth-child(" + idx + ") label:not(" +
                ".gcw-disabled) select"));
    }

    public WebElement BtnAddRoom()
    {
        return driver.findElement(By.cssSelector(".gcw-clone-field"));
    }

    public WebElement BtnClose()
    {
        return driver.findElement(By.cssSelector(".close.btn-text"));
    }

    public WebElement CbAddFlight()
    {
        return driver.findElement(By.id("hotel-add-flight-checkbox-hp-hotel"));
    }

    public WebElement TfFlyingFrom()
    {
        return driver.findElement(By.id("hotel-flight-origin-hp-hotel"));
    }

    public By PaneFlyingFromAutoSuggest()
    {
        return By.cssSelector(".display-group-results");
    }

    public List<WebElement> LbFlyingFromAutoSuggest()
    {
        return driver.findElements(By.cssSelector(".results-item a > span:last-child"));
    }

    public WebElement BtnSearch()
    {
        return driver.findElement(By.cssSelector("form[id*='form-hp-hotel'] .btn-primary"));
    }
}
