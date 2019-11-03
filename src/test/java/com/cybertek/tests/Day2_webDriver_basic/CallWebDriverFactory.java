package com.cybertek.tests.Day2_webDriver_basic;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver( "chrome");

        driver.get("https://www.google.com");





    }
}
