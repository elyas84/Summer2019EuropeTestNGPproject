package com.cybertek.tests.Day08_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement radioButton = driver.findElement(By.id("red"));
        radioButton.getAttribute("radio");
        radioButton.getAttribute("name");

        System.out.println(radioButton.getAttribute("name"));
        System.out.println(radioButton.getAttribute("id"));

        //attribute without value ( checked)
        System.out.println(radioButton.getAttribute("checked"));
        System.out.println(radioButton.getAttribute("outerHTML"));
        System.out.println(radioButton.getAttribute("innerHTML"));





    }
}
