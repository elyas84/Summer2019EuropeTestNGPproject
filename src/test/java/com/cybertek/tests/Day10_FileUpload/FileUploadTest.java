package com.cybertek.tests.Day10_FileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {

    WebDriver driver;
    @BeforeMethod
    public void SetUppMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");

      //"C:\Users\Elyas\Desktop\exampleDoc.txt" is my cpy Path!!!
      driver.findElement(By.cssSelector("#file-upload")).sendKeys("");
      driver.findElement(By.cssSelector("#file-submit")).click();

      //Verifying testCase!!
      System.out.println(driver.findElement(By.xpath("//*[.='File Uploaded!']")).getText());
      Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");

        System.out.println(System.getProperty("user.dir")); // user.dir = user directory : folder!!
        String projectPath = System.getProperty("user.dir");
        String relativePath ="/src/verifyContactInfoTest/Resources/testFile.txt";

        String filePath = projectPath+"/"+relativePath;
        System.out.println(filePath);

        driver.findElement(By.cssSelector("#file-upload")).sendKeys(filePath);
        driver.findElement(By.cssSelector("#file-submit")).click();

        //Verifying testCase!!
        System.out.println(driver.findElement(By.xpath("//*[.='File Uploaded!']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }
}
