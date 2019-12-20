package com.cybertek.tests.Day07_TypesofElement;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void radioButton(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueButton = driver.findElement(By.cssSelector("input#blue"));
        WebElement redButton = driver.findElement(By.cssSelector("input#red"));

        //Hot to check radio button is selected or not

        System.out.println("blueButton.isSelected() = " + blueButton.isSelected());
        System.out.println("redButton.isSelected() = " + redButton.isSelected());

        //Verify that blue radio button is selected
        Assert.assertTrue(blueButton.isSelected(),"verify that blue button is selected");

        //Verify that red radio button is selected
        redButton.click();
        Assert.assertTrue(redButton.isSelected(),"verify that red button is selected");

        driver.quit();



    }


}
