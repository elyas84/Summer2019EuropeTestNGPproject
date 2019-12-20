package com.cybertek.tests.Day05_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LocatorHomeWork1 {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDownMethod(){
       // driver.quit();
    }
    @Test
    public void ebayTestCase1(){
        driver.get("https://www.ebay.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("Books");
        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        searchButton.click();
        WebElement searchText = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String printText = searchText.getText();
        System.out.println("printText = " + printText);

        Assert.assertTrue(searchText.isDisplayed(), "Verify that search Text is appeared");

    }
    @Test
    public void wikTestCase3(){
        driver.get("http://wikipedia.org/");
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchInput.sendKeys("Selenium(software)");
        WebElement searchButton = driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']"));
        searchButton.click();
        WebElement searchResult = driver.findElement(By.xpath("//p[@class='mw-search-createlink']"));
        String text = searchResult.getText();
        System.out.println("text = " + text);
        Assert.assertFalse(text.endsWith("Selenium(software"),"Verify that the result show the same text ");
    }
}
