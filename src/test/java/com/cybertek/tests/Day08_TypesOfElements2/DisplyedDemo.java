package com.cybertek.tests.Day08_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplyedDemo {
    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement usernameInput = driver.findElement(By.id("username"));
        System.out.println(usernameInput.isDisplayed());
        Assert.assertFalse(usernameInput.isDisplayed(),"verify that username input is displayed");
        System.out.println("usernameInput = " + usernameInput.isDisplayed());
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();
        Thread.sleep(10000);
        System.out.println("usernameInput = " + usernameInput.isDisplayed());

        driver.quit();











    }
}
