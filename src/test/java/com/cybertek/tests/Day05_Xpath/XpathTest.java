package com.cybertek.tests.Day05_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTest {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

      /*  WebElement homeLink = driver.findElement(By.xpath("/html/body/nav/ul/li/a")); //Xpath Absolute way, from the root to child
        homeLink.click();
        */
      WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
      button1.click();
      WebElement text= driver.findElement(By.xpath("//h3[.='Multiple buttons']"));
      String printText = text.getText();
        System.out.println("printText = " + printText);

        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement signUpButton = driver.findElement(By.xpath("//button[.='Sign Up']"));
        String getText =signUpButton.getText();
        System.out.println("getText = " + getText);
        WebElement signUpPage = driver.findElement(By.xpath("//h2[.='Sign Up Page']"));
        String newText = signUpPage.getText();
        System.out.println("newText = " + newText);








    }
}
