package com.cybertek.tests.HomeWork4;

import com.cybertek.Pages.CalendarEventsPage;
import com.cybertek.Pages.CreateCalendarEventsPage;
import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class homeWorks extends TestBase {

    @Test
    public void testCase1(){

        extentLogger= report.createTest("Verify view, edit and delete are available");
        LoginPage loginPage = new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);
        extentLogger.info("username"+username);
        extentLogger.info("password"+password);
        extentLogger.info("login as a Stromanager");

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Actions actions = new Actions(driver);

        actions.moveToElement(calendarEventsPage.donte).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//tbody/tr[18]/td[9]")).isDisplayed());

    }

    @Test

    public void testCase2(){
        extentLogger = report.createTest("Check box is visual");

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);
        extentLogger.info("UserName"+username);
        extentLogger.info("Password"+password);
        extentLogger.info("login as StoreManager");


        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.gridSettingBtn.click();

        //Can not deselect all options except Title, need help

    }

    @Test

    public void testCase3(){

        extentLogger = report.createTest("message");

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);
        extentLogger.info("UserName"+username);
        extentLogger.info("Password"+password);
        extentLogger.info("login as StoreManager");


        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        dashboardPage.waitUntilLoaderScreenDisappear();

        driver.findElement(By.xpath("//a[@class='btn-success btn dropdown-toggle']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@data-options='{\"align\": \"right\", \"attachToParent\": \"true\"}']")).isDisplayed());

    }
    @Test
    public void testCast4(){

        extentLogger = report.createTest("message");

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username,password);
        extentLogger.info("UserName"+username);
        extentLogger.info("Password"+password);
        extentLogger.info("login as StoreManager");


        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        driver.findElement(By.xpath("//a[@title='Create Calendar event']")).click();
        dashboardPage.waitUntilLoaderScreenDisappear();

        driver.findElement(By.xpath("//*[@title='Cancel']")).click();
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.getPageSubTitle();
        extentLogger.pass(calendarEventsPage.getPageSubTitle());

    }

}
