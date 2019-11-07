package com.cybertek.tests.day4_BasicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class idLocatorsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // maximize the browser
     //   driver.manage().window().maximize();

       driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement dnotClickBottom =driver.findElement(By.id("disappearing_button"));
        dnotClickBottom.click();
        Thread.sleep(2000);

        driver.quit();





    }
}
