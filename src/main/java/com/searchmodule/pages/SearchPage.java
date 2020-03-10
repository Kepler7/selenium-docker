package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

public class SearchPage extends BasePage
{
    protected By searchTxt = By.name("q");
    protected By searchBtn = By.id("search_button_homepage");
    protected By videosLink = By.linkText("Videos");
    protected By allVideos = By.className("tile--vid");

    public SearchPage(WebDriver driver) {
        super();
    }

    public void doSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(getElement(searchTxt)));
        getElement(searchTxt).sendKeys(keyword);
        getElement(searchBtn).click();
    }

    public void goToVideos(){
        this.wait.until(ExpectedConditions.visibilityOf(getElement(videosLink)));
        getElement(videosLink).click();
    }

    public int getResult(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        System.out.println("Search Result : " + getElements(allVideos).size());
        return getElements(allVideos).size();
    }
}
