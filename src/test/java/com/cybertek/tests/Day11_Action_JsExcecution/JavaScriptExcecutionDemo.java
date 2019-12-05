package com.cybertek.tests.Day11_Action_JsExcecution;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExcecutionDemo{

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod(){
      //  driver.quit();
    }
    @Test
    public void click(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement link = driver.findElement(By.linkText("Dropdown"));

        //create JS executor object
        //run js code with that object

        //how to create jes object
        JavascriptExecutor jse = (JavascriptExecutor) driver; //kind of casting
        jse.executeScript("arguments[0].click();",link); //code inside of the() has been copied from the google.com
    }
    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.tagName("input[type='text']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String str = "Hello disable inputBox";
        js.executeScript("  jse.executeScript(\"arguments[0].setAttribute('value', '" + str +"'),inputBox");
        // it didn't get throught!
    }


    @Test
    public void Scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor srl = (JavascriptExecutor)driver;

        for (int i=0; i<10; i++){ // scrolling down
            Thread.sleep(500);
            srl.executeScript("window.scrollBy(0,250)");
        }

        for (int i=0; i<5; i++){
            Thread.sleep(1000);
            srl.executeScript("window.scrollBy(0,-250)");
        }

    }
    @Test
    public void imgTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");


        }
    }


