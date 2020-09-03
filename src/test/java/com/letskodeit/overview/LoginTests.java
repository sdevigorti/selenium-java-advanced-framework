package com.letskodeit.overview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {


    WebDriver driver;
    String baseURL;

    @BeforeMethod
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/sreed/Downloads/chromedriver_win32 (9)/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        baseURL = "https://learn.letskodeit.com";
       // baseURL = "https://letskodeit.com/automationpractice";
        driver.get(baseURL);
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(@href, 'sign_in')]")).click();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("devimalladi.68@gmail.com");
        WebElement passwordElement = driver.findElement(By.id("user_password"));
        passwordElement.clear();
        passwordElement.sendKeys("test@123");

        driver.findElement(By.name("commit")).click();
        Thread.sleep(10000);
        WebElement accountImage = null;
        try {
            accountImage = driver.findElement(By.className("gravatar"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(accountImage);
        driver.close();


    }

    @Test
    public void testInValidLogin() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("devimalladi.68@gmail.com");
        WebElement passwordElement = driver.findElement(By.id("user_password"));
        passwordElement.clear();
        passwordElement.sendKeys("est@123");
        driver.findElement(By.name("commit")).click();
        Thread.sleep(10000);
        WebElement accountImage = null;
        try {
            accountImage = driver.findElement(By.className("gravatar"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(accountImage);
        driver.close();
    }


}





