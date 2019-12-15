package com.cybertek.tests.Day14_pom_testes;

import com.cybertek.Pages.CalendarEventsPage;
import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.security.auth.login.Configuration;

public class PageSubTitlePage extends TestBase {

    @Test
    public void verifySubTitleTest(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);
        DashboardPage dashboardPage = new DashboardPage();
        //expected title
        String expectedSubtitle = "Quick Launchpad";
        //actual title from website
        String actualSubtitle = dashboardPage.getPageSubTitle();
        //verify titles are matching
        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify subtitles");
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify subtitles");
    }

}
