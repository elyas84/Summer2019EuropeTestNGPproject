package com.cybertek.tests.day06_CssLocator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CssTest {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDownMethod(){
         driver.quit();
    }
    @Test
    public void testOne(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
       WebElement dontClickButton = driver.findElement(By.cssSelector("#disappearing_button"));
        String message = dontClickButton.getText();

       System.out.println("message = " + message);

    }
    @Test
    public void cssTest(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement buttonOne = driver.findElement(By.cssSelector("button[onclick='button1()']"));
        String message = buttonOne.getText();
        System.out.println("message = " + message);
    }


}

