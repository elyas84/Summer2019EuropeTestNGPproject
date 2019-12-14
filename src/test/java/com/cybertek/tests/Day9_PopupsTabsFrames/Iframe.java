package com.cybertek.tests.Day9_PopupsTabsFrames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Iframe {
    WebDriver driver;
    @BeforeMethod
    public void setUppMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDownMethod()  {


       driver.quit();
    }

    @Test
    public void iframe(){
       driver.get("http://practice.cybertekschool.com/iframe");

       //how to switch FRAMES?
        driver.switchTo().frame("mce_0_ifr"); // just find the iframe tag and give the value of it!!!!
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Hello Cybertek!!!");

        //Going back to first frame useful when we have switched multiple frames!!
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tinymce")).sendKeys("Go back to here!!");


        // by entering index number we can go back to the first IFRAM in HTML!!!
        driver.switchTo().frame(0); //This is based on the order
        driver.findElement(By.id("tinymce")).sendKeys("NIKO is coming!!");

        //go back to first frame only to parent
        driver.switchTo().parentFrame();
        driver.findElement(By.id("tinymce")).sendKeys("WWW.facebook.com!!");


        //Using any web element
        WebElement frameElement = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(frameElement);
        driver.findElement(By.id("tinymce")).sendKeys("Study new thing is grate!!!!!");




    }


}
