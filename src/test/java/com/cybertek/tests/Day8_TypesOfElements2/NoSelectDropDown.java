package com.cybertek.tests.Day8_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));
        // open the dropDown;
        dropDownElement.click();
        List<WebElement> listOfLinks = driver.findElements(By.className("dropdown-item"));
        System.out.println("listOfLinks = " + listOfLinks.size());
        // print one ofText of each link
        System.out.println("listOfLinks.get(0).getText() = " + listOfLinks.get(0).getText());
        // print each elements
        for (WebElement link:listOfLinks){
            System.out.println("link = " + link.getText());
        }
        //locate the element and click it
     //   driver.findElement(By.linkText("Yahoo")).click();

        //index number and click it
        listOfLinks.get(3).click();


    }
}
