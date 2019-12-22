package com.cybertek.tests.Day15_ExtendReport;

import com.aventstack.extentreports.ExtentReports;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        extentLogger = report.createTest("Wrong password test");
        LoginPage loginPage = new LoginPage();

        loginPage.userInput.sendKeys("user10");
        extentLogger.info("Enter username: user1");

        loginPage.passwordInput.sendKeys("UserUser"+ Keys.ENTER);
        extentLogger.info("Enter password: UserUser");
        loginPage.loginBtn.click();
        extentLogger.info("Click the button");
        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("PAss: Wrong password Test");


    }

    @Test
    public void wrongUserName(){
        extentLogger = report.createTest("Wrong username");
        LoginPage loginPage= new LoginPage();

        loginPage.userInput.sendKeys("USER");
        extentLogger.info("Enter username: USER");

        loginPage.passwordInput.sendKeys("UserUser123"+Keys.ENTER);
        extentLogger.info("Enter password: UserUser123");
        loginPage.loginBtn.click();
        extentLogger.info("Click the login button");
        extentLogger.info("Verify the url");

        Assert.assertNotEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("Wrong username test");

    }

}
