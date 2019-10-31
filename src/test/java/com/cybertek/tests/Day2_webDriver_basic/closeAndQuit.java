package com.cybertek.tests.Day2_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class closeAndQuit {
    public static void main(String[] args) throws InterruptedException {

      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();

      driver.get("http://practice.cybertekschool.com");
      Thread.sleep(3000);
      driver.close();
      driver= new ChromeDriver();
      driver.get("http://practice.cybertekschool.com/new_tab");
      Thread.sleep(5000);
      driver.close();
     // quit colse evething, but close command colsing the stying page.
      driver.quit();






    }
}
