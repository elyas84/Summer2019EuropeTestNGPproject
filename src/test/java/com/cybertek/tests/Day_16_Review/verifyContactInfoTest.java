package com.cybertek.tests.Day_16_Review;

import com.cybertek.Pages.ContactInfoPage;
import com.cybertek.Pages.ContactsPage;
import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

   @Test

    public void contactDetailsTest(){
      extentLogger = report.createTest("Verify full name");
       LoginPage loginPage = new LoginPage();

       String username = ConfigurationReader.get("driver_username");
       extentLogger.info("Enter username");
       String password = ConfigurationReader.get("driver_password");
       extentLogger.info("Enter password");
       loginPage.login(username,password);

       DashboardPage dashboardPage = new DashboardPage();
       dashboardPage.navigateToModule("Customers","Contacts");
       extentLogger.info("Navigate to Customers and Contacts");
       dashboardPage.waitUntilLoaderScreenDisappear();


        ContactsPage contactsPage = new ContactsPage();
        extentLogger.info("Click the email link");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
       contactsPage.waitUntilLoaderScreenDisappear();

       ContactInfoPage contactInfoPage = new ContactInfoPage();


       contactsPage.waitUntilLoaderScreenDisappear();
       extentLogger.info("Getting the actual full name");
       String actualFullName = contactInfoPage.fullName.getText();
       extentLogger.info("Expected full name");
       String expectedFullName ="Ms Mariam Brackstone";

       extentLogger.pass("actual full name and expected full name is equal");
       Assert.assertEquals(actualFullName,expectedFullName);

       extentLogger.info("Actual email");
       String actualEmail = contactInfoPage.email.getText();
       extentLogger.info("Expected email");
       String expectedEmail = "mbrackstone9@example.com";

       extentLogger.pass("Actual email and expected email is matching");
       Assert.assertEquals(actualEmail,expectedEmail,"Verify that email is matching");



   }
}
