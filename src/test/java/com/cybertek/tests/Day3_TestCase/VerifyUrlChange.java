package com.cybertek.tests.Day3_TestCase;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChange {
    /**
     * open browser
     * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
     * enter any email
     * click on Retrieve password
     * verify that url changed to http://practice.cybertekschool.com/email_sent
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailBox = driver.findElement(By.name("email"));
        //send keys ()--> send keyboard actions to web element
        emailBox.sendKeys("email@exempel.com");

        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        retrievePassword.click();

        String expectedURL = "http://practice.cybertekschool.com/email_sent"; // What we want to see( expected result)
        String actualUrl = driver.getCurrentUrl();// to see actual URL;

        if(expectedURL.equals(actualUrl)){

            System.out.println("Pass");

        }else{
            System.out.println("Fail");
        }
        Thread.sleep(3000);
        driver.quit();











    }
}
