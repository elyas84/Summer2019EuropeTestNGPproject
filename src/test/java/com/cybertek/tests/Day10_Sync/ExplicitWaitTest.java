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

        //Clicking the start button
        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebElement userName= driver.findElement(By.cssSelector("input#username"));

        //How to wait explicitly
        //Create explicitly object
        WebDriverWait wait = new WebDriverWait(driver, 10);//This constructor is dealing with the current driver


        //When we wait a specific element from driver then we gonna use explicitly wait!!!!!
        //call until method from wait object
        //Waiting for the specific element to be visible( up to 10 sec.)
        wait.until(ExpectedConditions.visibilityOf(userName));

        //Sending some username
        userName.sendKeys("Mike Smith");

        WebElement passwordInput = driver.findElement(By.cssSelector("input#pwd"));
        WebDriverWait wait1 = new WebDriverWait(driver,10);
        wait1.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys("1233456");

    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        // Click enable button
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

        //Finding input box
         WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@onclick='swapInput()']"))));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mike Smith");

    }
}
