package com.cybertek.tests.Day2_WebDriverBasic;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver( "chrome");

        driver.get("https://www.google.com");





    }
}
