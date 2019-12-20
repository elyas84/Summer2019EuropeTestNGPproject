package com.cybertek.tests.Day14_PageObjectModel_testes;

import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PageSubTitle extends TestBase {

    @Test
    public void verifySubTitleTest(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        String expectedSubtitle = "Quick LaunchPad";





    }



}
