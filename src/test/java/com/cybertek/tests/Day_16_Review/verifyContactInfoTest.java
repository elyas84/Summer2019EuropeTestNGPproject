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
      extentLogger = report.createTest("contactDetailsTest");
       LoginPage loginPage = new LoginPage();

       String username = ConfigurationReader.get("salesmanager_username");
       String password = ConfigurationReader.get("salesmanager_password");
       extentLogger.info("username: "+username);
       extentLogger.info("password: "+password);
       extentLogger.info("Login as a salaesmanager");

       loginPage.login(username,password);

        ContactsPage contactsPage = new ContactsPage();
        extentLogger.info("Navigate to Customers--> Contacts");
        contactsPage.navigateToModule("Customers","Contacts");

        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on mbrackstone9@example.com ");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();



        ContactInfoPage contactInfoPage = new ContactInfoPage();
        String actualFullName = contactInfoPage.fullname.getText();
        String expectedFullName = "Mariam Brackstone";

        contactInfoPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Verify fullName is "+expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"Verify fullName");

        //Short way
        extentLogger.info("Verify email is mbrackstone9@example.com");
        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com");

        extentLogger.info("Verify phoneNumber +18982323434");
        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434");

   }
}
