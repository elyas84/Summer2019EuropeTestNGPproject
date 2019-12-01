package com.cybertek.tests.Day3_TestCase;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLNotChang {
    /**
     * Verify URL not changed
     * open browser
     * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     * click on Retrieve password
     * verify that url did not change
     *
    */

    public static void main(String[] args) throws InterruptedException {

      WebDriver driver = WebDriverFactory.getDriver("chrome");

      driver.get(" http://practice.cybertekschool.com/forgot_password");
      // save urk to string variable
        String expectidUrl = driver.getCurrentUrl();
      //click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        Thread.sleep(3000);
        // save URL after clicking button
        String actualUrl = driver.getCurrentUrl();

        if(expectidUrl.equals(actualUrl)){

            System.out.println("Pass");

        }else {
            System.out.println("Fail");
        }


        driver.quit();







    }

}
