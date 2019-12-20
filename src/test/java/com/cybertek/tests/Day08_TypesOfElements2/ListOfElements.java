package com.cybertek.tests.Day08_TypesOfElements2;

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
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        System.out.println("buttons = " + buttons.size());

        for (WebElement lists : buttons){
            System.out.println("lists = " + lists.getText());
        }
    }

    @Test
    public void test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        // wrong locator doest give us wrong massage, it gives empty list

        List<WebElement> buttons = driver.findElements(By.cssSelector("div.radio"));
        System.out.println("buttons.size() = " + buttons.size());

        for (WebElement value : buttons){
            System.out.println("value = " + value.getText());
        }


    }
}
