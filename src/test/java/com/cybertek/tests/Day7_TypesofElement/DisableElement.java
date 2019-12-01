package com.cybertek.tests.Day7_TypesofElement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElement {
    @Test
            public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
       WebElement greenradioButton = driver.findElement(By.id("green"));
        System.out.println("green radioButton is enable = " + greenradioButton.isEnabled());
        Assert.assertFalse(greenradioButton.isEnabled());
        greenradioButton.click();


    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        System.out.println("inputBox is enable= " + inputBox.isEnabled());

        driver.quit();


    }



}
