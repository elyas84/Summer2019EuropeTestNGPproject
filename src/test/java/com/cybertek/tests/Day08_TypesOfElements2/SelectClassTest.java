package com.cybertek.tests.Day08_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {
    @Test
    public void test1 () throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //Locate the dropDown elemenet with unique locator
        WebElement dropDownElement = driver.findElement(By.cssSelector("#state"));
        //We used constructor here!!!!!!
        Select sateList = new Select(dropDownElement);
        List<WebElement> options =sateList.getOptions();
        for (WebElement option : options){
            System.out.println("listOfElements = " + option.getText());
        }

        Thread.sleep(3000);
        String actualOption = sateList.getFirstSelectedOption().getText();
        sateList.selectByVisibleText("Texas");
        System.out.println("sateList.getOptions().size() = " + sateList.getOptions().size());


    }
    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");



    }



}
