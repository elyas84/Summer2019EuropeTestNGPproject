package com.cybertek.tests.day4_BasicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassLocatorTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement message = driver.findElement(By.className("h3"));
        String text = message.getText();
        System.out.println("text = " + text);
        String actualText = message.getText();
        String expectText = "Multiple buttons";
        if(actualText.equals(expectText)){
            System.out.println("pass");

        }else {
            System.out.println("failed");
        }


    }
}
