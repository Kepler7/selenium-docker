package com.newtours.tests;

import com.newtours.pages.FlightFinderPage;
import com.newtours.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BookFlightTest extends BaseTest
{
    private String username;
    private String password;
    @Test
    @Parameters({"username","password"})
    public void loginTest(String username, String password)
    {
        this.username = username;
        this.password = password;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserDetails(username,password);
        FlightFinderPage finderPage = new FlightFinderPage(driver);
        finderPage.assert_flightFinderPage();
    }

    @Test
    @Parameters({"username","password"})
    public void selectDropDown(String username, String password)
    {
        this.username = username;
        this.password = password;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserDetails(username,password);
        FlightFinderPage finderPage = new FlightFinderPage(driver);
        finderPage.assert_flightFinderPage();
        finderPage.selectPassengers(3);
    }

}
