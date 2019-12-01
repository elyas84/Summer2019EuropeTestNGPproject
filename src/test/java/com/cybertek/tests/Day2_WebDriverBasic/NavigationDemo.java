package com.cybertek.tests.Day2_WebDriverBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // Getting the facebook.com
        driver.get("http://www.facebook.com");

        // then goes to amazon.com
        driver.navigate().to("http://www.amazon.com");

        //and goes back to facebook
        driver.navigate().back();

        //slepping 3s
        Thread.sleep(3000);

        //goes back to start point
        driver.navigate().forward();

        // refresh the page

        driver.navigate().refresh();

        driver.quit();














    }


}
