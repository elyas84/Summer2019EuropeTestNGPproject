package com.cybertek.tests.Day7_TypesofElement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioBottunTest {
    @Test
    public void radioButton(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement blueButton = driver.findElement(By.id("blue"));
        WebElement redButton = driver.findElement(By.id("red"));
        // How to cheak radio button selected or not?


        System.out.println("redButton = " + redButton.isSelected());
        System.out.println("blueButton = " + blueButton.isSelected());

        Assert.assertTrue(blueButton.isSelected(),"Verify that blue button is selected");
        Assert.assertFalse(redButton.isSelected(),"Verify that red button is not selected");

       redButton.click();
        System.out.println("redButton is Selected= " + redButton.isSelected());
        System.out.println("blueButton is selected = " + blueButton.isSelected());

        Assert.assertFalse(blueButton.isSelected(),"Verify that blue button is not selected");
        Assert.assertTrue(redButton.isSelected(),"Verify that red button is selected");

        driver.quit();

    }

}
