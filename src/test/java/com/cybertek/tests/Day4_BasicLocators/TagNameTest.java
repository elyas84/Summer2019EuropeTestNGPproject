package com.cybertek.tests.Day4_BasicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Jesur Arkin");
        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("exemple@emial.com");
        WebElement signBottom = driver.findElement(By.name("wooden_spoon"));
        signBottom.click();
        WebElement message = driver.findElement(By.tagName("h3"));
        String messageElemet = message.getText();

        System.out.println("messageElemet = " + messageElemet);

        driver.get("http://practice.cybertekschool.com/sign_up");



    }
}
