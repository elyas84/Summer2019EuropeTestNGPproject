package com.cybertek.tests.Day11_Action_JsExcecution;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutionDemo {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
       Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void click(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement link = driver.findElement(By.linkText("Dropdown")); // sometimes selenium click it doesn't work
        //then we can use JS click and provide the click function

        //create JS executor object
        //run js code with that object

        //how to create jes object
        JavascriptExecutor jse = (JavascriptExecutor) driver; //kind of casting
        jse.executeScript("arguments[0].click();",link); //code inside of the() has been copied from the google.com
    }
    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputText = driver.findElement(By.xpath("//input[@type='text']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String str = "Mike Smith";
        jse.executeScript("arguments[0].setAttribute('value', '" + str +"')",inputText);

        //Using Google and copy and past.
        //We can send a message by using JS code, even input box not enable;
    }


    @Test
    public void Scroll() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //With help of loop, we can see apparently how scrolling is working
        //This is scrolling down
        for (int i=0; i<10; i++){
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,250)");
        }

        //Thees code are available in Google.
        //This is scrolling up
        for (int i=0; i<10; i++){
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,-250)");
        }
    }

    @Test

    public void imgTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        //Hover one bu one by using Loop and then we can get a Dynamic manner
        for(int i=1; i<4; i++){
            String imgXpath= "(//img)["+i+"]";
            WebElement img = driver.findElement(By.xpath(imgXpath));
            Actions actions = new Actions(driver);
            actions.moveToElement(img).perform();
        }



        }
        @Test
    public void goToGoogle(){
        driver.get("http://www.google.com");
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("java"+ Keys.ENTER);// to hit the Enter key Keys.ENTER

            WebElement pickFirst = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3/span"));
            pickFirst.click();
            driver.navigate().back();

        }
    }


