package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {
    WebDriver driver;
    @BeforeMethod
    public void setUppMethod(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDownMethod(){
       //driver.quit();
    }
    @Test
    public void test1 () throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        //How to switch Frames
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Hello");

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Nijat");
        driver.switchTo().defaultContent(); //--> back to HTML!


        // using Index
        driver.switchTo().frame(0); // eger kichik websida din bir si bosla, uning index nr [0] bolidu.
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Kasim");
        driver.switchTo().defaultContent();


        //WedElement
        WebElement iframbutton = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframbutton);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("ABS");

    }

    @Test
    public void multipleFrames(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top").switchTo().frame(0);

        System.out.println(driver.findElement(By.xpath("/html/body")).getText());




    }
}
