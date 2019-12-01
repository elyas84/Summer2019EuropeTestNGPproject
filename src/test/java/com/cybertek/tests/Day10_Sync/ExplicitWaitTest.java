package com.cybertek.tests.Day10_Sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {
    WebDriver driver;
    @BeforeMethod
    public void SetUppMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.tagName("button"));
        WebElement start= driver.findElement(By.xpath("//*[@id=\"start\"]/button"));
        start.click();
        WebElement userName= driver.findElement(By.id("username"));
        //How to wait explicitly
        // Create explicitly object
        WebDriverWait wait = new WebDriverWait(driver, 60);
        //
        wait.until(ExpectedConditions.visibilityOf(userName));

        userName.sendKeys("Mike Smith");
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        // Click enable button
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("Mike Smith");




    }
}
