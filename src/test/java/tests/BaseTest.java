package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.BasePage;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest extends BasePage
{
    private  String BROWSER;
    @BeforeMethod
    @Parameters("BROWSER")
    public void setupDriver(ITestContext context, String BROWSER) throws MalformedURLException
    {
        this.BROWSER = BROWSER;
        String host = "localhost";
        DesiredCapabilities desiredCapabilities;
        String browser = System.getProperty("BROWSER");
        String hub = System.getProperty("HUB_HOST");
        if((System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) || BROWSER.equalsIgnoreCase("firefox"))
        {
            desiredCapabilities = DesiredCapabilities.firefox();
        }
        else
        {
            desiredCapabilities = DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST") != null)
        {
            host = System.getProperty("HUB_HOST");
        }
        String testName = context.getCurrentXmlTest().getName();
        desiredCapabilities.setCapability("name", testName);
        String completeURL = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), desiredCapabilities);
        if(System.getProperty("MODULE").equalsIgnoreCase("login-module"))
        {
            goTo("http://newtours.demoaut.com/mercurysignon.php");
        }
        else {
            goTo("https://duckduckgo.com/");
        }
    }

    @AfterMethod
    public void tearDown()
    {
        if(driver!=null)
        {
            driver.close();
            driver.quit();
        }
    }
}
