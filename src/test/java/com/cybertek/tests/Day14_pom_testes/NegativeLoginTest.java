package com.cybertek.tests.Day14_pom_testes;

import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){
        LoginPage loginPage= new LoginPage();
        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("123456");
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
    }


    @Test
    public void wrongUsername(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("Mike Smith");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/user/login");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
    }



}
