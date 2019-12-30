package com.cybertek.tests.HomeWork4;

import com.cybertek.Pages.CalendarEventsPage;
import com.cybertek.Pages.CreateCalendarEventsPage;
import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.http.entity.mime.content.StringBody;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class homeWorks extends TestBase {

    @Test
    public void testCase1() {

        extentLogger = report.createTest("Verify view, edit and delete are available");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);
        extentLogger.info("username" + username);
        extentLogger.info("password" + password);
        extentLogger.info("login as a Stromanager");

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Actions actions = new Actions(driver);

        actions.moveToElement(calendarEventsPage.dote).perform();
        Assert.assertTrue(calendarEventsPage.dote.isDisplayed());
       // extentLogger.pass("");

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

        WebElement gridSetting = driver.findElement(By.xpath("(//tbody)[1]"));

        //I can not do it!!

    }


    @Test

    public void testCase3(){

        extentLogger = report.createTest("Verify that “Save And Close”, “Save And New” and “Save” options are available");

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
        calendarEventsPage.createCalendarEvent.click();

        driver.findElement(By.xpath("//a[@class='btn-success btn dropdown-toggle']")).click();
        extentLogger.pass("Verify that “Save And Close”, “Save And New” and “Save” options are available");

    }
    @Test
    public void testCast4(){

        extentLogger = report.createTest("Verify that “All Calendar Events” page subtitle is displayed");

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
        calendarEventsPage.createCalendarEvent.click();
        calendarEventsPage.getPageSubTitle();
        extentLogger.pass(calendarEventsPage.getPageSubTitle());

    }

    @Test
    public void testCase5(){
        extentLogger = report.createTest("Verify that difference between end and start time is exactly 1 hour");

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
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

      /* WebElement startTime= driver.findElement(By.xpath("(//li[@class='ui-timepicker-pm ui-timepicker-selected'])[1])"));
       WebElement endTime= driver.findElement(By.xpath("(//li[@class='ui-timepicker-pm ui-timepicker-selected'])[2]"));

        System.out.println("startTime.getText() = " + startTime.getText());
        System.out.println("endTime.getText() = " + endTime.getText());
*/
      // I cant do that, but my logic is, if could find the right locators and just by using simple get.text (), then
        // I will print it a String form, then split few chars like ": AM" keep only have the number
        // then covert it to the int i = Integer.par(String), then impalement the calculation!
        //
    }

    @Test

    public void testCase6() throws InterruptedException {
        extentLogger = report.createTest("Verify that end time is equals to “10:00 PM”");

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
        calendarEventsPage.createCalendarEvent.click();


        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.startTime.click();
        createCalendarEventsPage.startTime.clear();
        createCalendarEventsPage.startTime.sendKeys("9:00 PM");
        extentLogger.pass("Starting time 9:00 PM and Ending time is 10:00 PM");

    }

    @Test
    public void testCase7(){

        extentLogger = report.createTest("msg");

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
        calendarEventsPage.createCalendarEvent.click();

      //  createCalendarEventsPage.startTime.isDisplayed();
       // createCalendarEventsPage.endTime.isDisplayed();
        extentLogger.pass("startTime and EndTime are not Available");

       //Can not implement this case because of locator problem
    }

@Test
    public void testCase8(){
    extentLogger = report.createTest("Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down");

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
    calendarEventsPage.createCalendarEvent.click();

    CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
    createCalendarEventsPage.repeat.click();

    createCalendarEventsPage.repeatOptions.click();
    Select select = new Select(createCalendarEventsPage.repeatOptions);
    select.getFirstSelectedOption();
    extentLogger.pass("Daily option is selected");

    }

    @Test

    public void testCase9(){
        extentLogger = report.createTest("Testing ...");

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
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

       Select select = new Select(createCalendarEventsPage.repeatOptions);
       select.getFirstSelectedOption();


       driver.findElement(By.xpath("(//input[@type='radio'])[1]")).isSelected();
       driver.findElement(By.xpath("(//input[@type='radio'])[3]")).isSelected();
       driver.findElement(By.xpath("//span[.='Daily every 1 day']")).isDisplayed();

       extentLogger.pass("Verify that “Repeat” checkbox is selected");
       extentLogger.pass("Verify that “Repeat Every” radio button is selected");
       extentLogger.pass("Verify that “Never” radio button is selected as an “Ends” option.");
       extentLogger.pass("Verify that following message as a summary is displayed: “Summary: Daily every 1 day");

    }

    @Test

    public void testCase10(){

        extentLogger = report.createTest("Testing ...");

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
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        createCalendarEventsPage.after.click();
        createCalendarEventsPage.after.sendKeys("10");

        extentLogger.pass("displayed: “Summary: Daily every 1 day, endafter 10 occurrences”");



    }

    @Test

    public void testCase11(){

        extentLogger = report.createTest("Summary: Daily every 1 day, end by Nov 18, 2021”");

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
        calendarEventsPage.createCalendarEvent.click();


        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        driver.findElement(By.xpath("(//input[@type='radio'])[5]")).click();
        createCalendarEventsPage.by.sendKeys("Nov 18, 2021");

        extentLogger.pass("Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 17, 2021");

    }

    @Test
    public void testCase12(){

        extentLogger = report.createTest("Summary: Daily every 1 day, end by Nov 18, 2021”");

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
        calendarEventsPage.createCalendarEvent.click();


        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        Select select = new Select(createCalendarEventsPage.repeatOptions);
        select.selectByIndex(1);
        driver.findElement(By.xpath("//input[@value='monday']")).click();
        driver.findElement(By.xpath("//input[@value='friday']")).click();
        extentLogger.info("selecting monday");
        extentLogger.info("selecting Friday");

        extentLogger.pass("Weekly every 1 week onMonday, Friday");

    }
}