package com.cybertek.tests.day4_BasicLocators;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement nameBox = driver.findElement(By.name("full_name"));
        nameBox.sendKeys("Your name here");
        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("your@mail.com");
        WebElement signBox = driver.findElement(By.name("wooden_spoon"));
        signBox.click();

        WebElement comformingMessage= driver.findElement(By.name("signup_message"));
        String actualMessage = comformingMessage.getText();

        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";

        if (actualMessage.equals(expectedMessage)){
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("pass");

        }else{
            System.out.println("fail");
        }
        Thread.sleep(3000);
        driver.quit();




    }
}
