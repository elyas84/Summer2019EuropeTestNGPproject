package com.cybertek.tests.Day15_pomTests;

import com.cybertek.Pages.CalendarEventsPage;
import com.cybertek.Pages.CreateCalendarEventsPage;
import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class repeatOptionTest extends TestBase {
    @Test
    public void repeatRadioButtonTest(){

        //login as driver
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        DashboardPage dashboardPage= new DashboardPage();

        dashboardPage.navigateToModule("Activities","Calendar Events");

        //Click Calendar Events
       CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
       calendarEventsPage.waitUntilLoaderScreenDisappear();
       calendarEventsPage.createCalendarEvent.click();

       //Click on createCalendarEventsPages repeat button
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        //Verify that repeat everyday is checked

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify days rb is selected");

    }

    @Test
    public void verifyRepeatOptionTest(){

        //Logging step
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

        //Go to dashboard steps
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //Inside the Calender Event
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        //This part is not so clear!!!!!!!!

       List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<WebElement> actualOptions = createCalendarEventsPage.repeatOptionsList().getOptions();

        List<String> actualList = BrowserUtils.getElementsText(actualOptions);


        //We don't need to use these steps !!!!
       /* List<String> actualList = new ArrayList<>();

        for (WebElement option: actualOptions){

            actualList.add(option.getText());

        }
    */
        Assert.assertEquals(expectedList,actualList);

    }

}
