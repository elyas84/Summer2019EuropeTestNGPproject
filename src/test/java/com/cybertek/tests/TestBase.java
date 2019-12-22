package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

   public WebDriver driver;
   public Actions actions;
   public WebDriverWait wait;

    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,20);
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();


    }

    //ITESTRESUT class describe the result of a verifyContactInfoTest in TestNG
    @AfterMethod
    public void tearDownMethod(ITestResult result) throws InterruptedException {

        if(result.getStatus()==ITestResult.FAILURE){

        }




        Thread.sleep(2000);
        Driver.closeDriver(); // if we use driver.quit, then we can not implement using one by one!!!
    }

}
