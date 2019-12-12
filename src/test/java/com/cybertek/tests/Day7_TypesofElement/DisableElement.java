package com.cybertek.tests.Day7_TypesofElement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisableElement {
    @Test
    public void test1()  {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement greenRadioButton = driver.findElement(By.cssSelector("input#green"));
        System.out.println("greenRadioButton.isEnabled() = " + greenRadioButton.isEnabled());

        Assert.assertTrue(greenRadioButton.isDisplayed());
    }
    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement disableInput = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("disableInput.isEnabled() = " + disableInput.isEnabled());
        Assert.assertFalse(disableInput.isEnabled());

    }
    @Test
    public void testMine() throws InterruptedException {
        // Verify that disable button is clicked
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement enableButton =  driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();





        //driver.quit();
    }
}
