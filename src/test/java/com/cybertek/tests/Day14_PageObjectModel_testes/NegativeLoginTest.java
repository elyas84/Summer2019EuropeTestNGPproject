package com.cybertek.tests.Day14_PageObjectModel_testes;

import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

  @Test
    public void wrongPasswordTest(){

      //how to use POM locators

      LoginPage loginPage = new LoginPage();
      loginPage.userInput.sendKeys("user10");
      loginPage.passwordInput.sendKeys("UserUser123"+ Keys.ENTER);


  }

  @Test
  public void wrongUserName(){
    LoginPage loginPage= new LoginPage();
    loginPage.userInput.sendKeys("USER");
    loginPage.passwordInput.sendKeys("UserUser123"+Keys.ENTER);
    Assert.assertNotEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com");

  }

}
