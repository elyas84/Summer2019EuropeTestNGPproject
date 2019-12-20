package com.cybertek.tests.Day14_PageObjectModel_testes;

import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

     // Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }

    @Test

    public void loginAsStoreManager(){
        LoginPage loginPage = new LoginPage();
        String username= ConfigurationReader.get("StoreManager");
        String password = ConfigurationReader.get("StoreManager_Password");
        loginPage.login(username,password);

      //  Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }
}
