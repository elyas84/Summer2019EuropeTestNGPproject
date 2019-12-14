package com.cybertek.tests.Day9_PopupsTabsFrames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PopUpAndAlerts {
    //Global declaration to use everywhere;
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {


        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() {

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        //locating and clicking destroy button.
        driver.findElement(By.xpath("//*[text()='Destroy the World']")).click();

        //Clicking the No button
        driver.findElement(By.xpath("//*[text()='No']")).click();

    }

    @Test
    public void javaScriptPopUp() {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //Click the javaScript button
        driver.findElement(By.xpath("//button[1]")).click();

        //Alert is a new class and right side it should be switchTo() method;
        // Controlling alert using with alertClass.
        Alert alert = driver.switchTo().alert();//This must to use to handle this!!!!
        //alert accept means press the OK button;
        //alert.demises means to press the Cancel button;
        alert.accept();
    }

    @Test
    public void javaScriptAlert() {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[2]")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
         }
         @Test
    public void javaScriptSendKeys(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[3]")).click();
        Alert type= driver.switchTo().alert();
        type.sendKeys("Mike Smith");

        //The main role how to handle the JavaScript alert and popup, We have to use Alert Class to handle it!!!!

         }

    }