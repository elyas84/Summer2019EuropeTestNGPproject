package com.cybertek.tests.Day05_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        WebElement inputBox = driver.findElement(By.id("twotabsearchtextbox"));
        inputBox.sendKeys("Sumsung");

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton.click();
        WebElement gettingNumber = driver.findElement(By.xpath("//span[contains(text(),'1-16')]"));
        String number = gettingNumber.getText();
        System.out.println(number);


    }
}
