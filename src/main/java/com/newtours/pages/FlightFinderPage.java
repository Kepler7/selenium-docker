package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

public class FlightFinderPage extends BasePage
{
    public FlightFinderPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    protected By flightFinder = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");
    protected By passengersDropDown = By.xpath("//select[@name='passCount']");
    protected By departingFromDropDown = By.xpath("//select[@name='fromPort']");
    protected By onMonthDropDown = By.xpath("//select[@name='fromMonth']");
    protected By onDayDropDown = By.xpath("//select[@name='fromDay']");
    protected By arrivingDropDown = By.xpath("//select[@name='toPort']");
    protected By returningMonthDropDown = By.xpath("//select[@name='toMonth']");
    protected By returningDayDropDown = By.xpath("//select[@name='toDay']");

    private Select select;

    public void assert_flightFinderPage()
    {
        Assert.assertTrue(getElement(flightFinder).isDisplayed());
    }

    private void select(int index, WebElement element)
    {
        select = new Select(element);
        if(index >= select.getOptions().size())
            throw new IndexOutOfBoundsException();
        select.selectByIndex(index);
    }

    private void select(String value, WebElement element)
    {
        select = new Select(element);
        select.selectByValue(value);
    }

    public void selectPassengers(int passengers)
    {
        passengers = passengers - 1;
        select(passengers,getElement(passengersDropDown));
    }

}
