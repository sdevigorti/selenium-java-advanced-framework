
package com.letskodeit.base;
import com.letskodeit.pageclasses.*;
import com.letskodeit.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    protected String baseURL;
    protected LoginPage login;
    protected NavigationPage nav;
    protected SearchBarPage search;
    protected ResultsPage result;
    protected CategoryFilterPage category;

    @BeforeClass
    @Parameters({"browser"})
    public void commonSetUp(String browser)  {
        driver = WebDriverFactory.getInstance().getDriver(browser);
        baseURL = Constants.BASE_URL;
        driver.get(baseURL);
        nav = new NavigationPage(driver);
        login = nav.login();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void methodSetUp(){
        CheckPoint.clearHashMap();
    }

    @AfterClass
    public void commonTearDown() {
        WebDriverFactory.getInstance().quitDriver();
    }
}






           // System.setProperty("webdriver.chrome.driver", "C:/Users/sreed/Downloads/chromedriver_win32 (9)/chromedriver.exe");
            //driver = WebDriverFactory.getInstance().getDriver("browser");
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

           // Thread.sleep(10000);




