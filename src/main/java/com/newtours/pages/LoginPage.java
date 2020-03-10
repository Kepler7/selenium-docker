package com.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class LoginPage extends BasePage
{
    protected By username = By.name("userName");
    protected By password = By.name("password");
    protected  By submitButton = By.name("login");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void enterUserDetails(String user, String pass)
    {
        getElement(username).sendKeys(user);
        getElement(password).sendKeys(pass);
        getElement(submitButton).click();
    }

}
