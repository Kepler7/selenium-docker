package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebElement getElement(By by)
    {
        return driver.findElement(by);
    }

    public void goTo(String URL)
    {
        driver.get(URL);
    }

    public List<WebElement> getElements(By by)
    {
        return driver.findElements(by);
    }
}
