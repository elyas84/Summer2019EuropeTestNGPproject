package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class PoupAndAlerts {
    //Global declaration to use everywhere;
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
       driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {


       // driver.quit();
    }
    @Test
    public void test1(){

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//*[@id=\"j_idt710:j_idt711\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"j_idt710:j_idt714\"]")).click();
        }

        @Test
        public void javaScriptAlert () throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[1]")).click();
        //Controlling alert using with alert class!
        Alert alert = driver.switchTo().alert(); //This is a special class!!
            Thread.sleep(2000);
            //Accept alert--> clicking in the alert
            alert.accept();
          driver.findElement(By.xpath("//button[2]")).click();
          Thread.sleep(2000);
         alert.dismiss();

          driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[3]")).click();

            alert.sendKeys("Don't put any text here!!!");
            alert.accept();








    }
}
