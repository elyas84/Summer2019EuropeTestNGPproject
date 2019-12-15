package com.cybertek.tests.Day14_pom_testes;

import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginPage extends TestBase {

    @Test
    public void loginAsDriver(){
        LoginPage loginPage = new LoginPage();
        String username= ConfigurationReader.get("driver_username");

        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");

    }
    @Test
    public void loginAsStoreManager(){
        LoginPage loginPage = new LoginPage();
        String username= ConfigurationReader.get("Storemanager_usernam");
        String password = ConfigurationReader.get("Storemanager_password");
        loginPage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");

    }
}
