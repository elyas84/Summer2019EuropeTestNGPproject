package com.cybertek.tests.Day01_basic_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic_navigation {
    public static void main(String[] args) {
    // we have to stup weddriver based on the browser that we gonna use

        WebDriverManager.chromedriver().setup();

        // creating object for using selenuim driver

        WebDriver driver = new ChromeDriver();

        // open the browser
        driver.get("http://www.google.com");

        driver.get("http://www.amazon.com");

        System.out.println(driver.getTitle());











    }
}
