package com.cybertek.tests.Day3_TestCase;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    /**
     * Verify confirmation message
     * open browser
     * go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     * enter any email
     * verify that email is displayed in the input box
     * click on Retrieve password
     * verify that confirmation message says 'Your e-mail's been sent!'
     *
     */
    public static void main(String[] args) throws InterruptedException {
        // open the browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //navigate to web site
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
       WebElement emailBox = driver.findElement(By.name("email"));

       String expectedEmail = "test@gmail.com";

        //send expectedEmail
        emailBox.sendKeys(expectedEmail);
        String actualEmail = emailBox.getAttribute("value");// this we use if get.text doesn't work!

        if(expectedEmail.equals(actualEmail)){
            System.out.println("Pass");

        }else {
            System.out.println("Fail");
        }

        WebElement retrieveButton = driver.findElement(By.id("form_submit"));
        retrieveButton.click();

        String expectedMessage = " Your e-email's been sent ";

        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));

        String actualMessage = confirmationMessage.getText();
        System.out.println("actualMessage = " + actualMessage);

        if(expectedEmail.equals(actualEmail)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage e= "+expectedEmail);
        }
    Thread.sleep(3000);
        driver.quit();



    }
}
