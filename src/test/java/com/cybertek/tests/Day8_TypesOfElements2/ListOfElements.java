package com.cybertek.tests.Day8_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    @Test
    public void test1 (){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        List<WebElement> buttons = driver.findElements(By.tagName("buttons"));
        System.out.println("buttons = " + buttons.size());



    }

    @Test
    public void tese2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        // wrong lacator doest give us wrong messg, it gives empty list
        List<WebElement> buttons = driver.findElements(By.tagName("buttonsdafdg"));
        System.out.println(buttons.size());


    }
}
