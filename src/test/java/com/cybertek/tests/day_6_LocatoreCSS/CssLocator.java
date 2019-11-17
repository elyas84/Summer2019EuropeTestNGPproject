package com.cybertek.tests.day_6_LocatoreCSS;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement dontClickButton = driver.findElement(By.cssSelector("#disappearing_button"));
        String message = dontClickButton.getText();
        System.out.println("message = " + message);
        Thread.sleep(3000);
        driver.quit();

    }
}
