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

       LoginPage loginPage = new LoginPage();
       String username = ConfigurationReader.get("driver_username");
       String password = ConfigurationReader.get("driver_password");
       loginPage.login(username,password);

       DashboardPage dashboardPage = new DashboardPage();
       dashboardPage.navigateToModule("Customers","Contacts");
       dashboardPage.waitUntilLoaderScreenDisappear();


        ContactsPage contactsPage = new ContactsPage();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
       contactsPage.waitUntilLoaderScreenDisappear();

       ContactInfoPage contactInfoPage = new ContactInfoPage();


       contactsPage.waitUntilLoaderScreenDisappear();
       String actualFullName = contactInfoPage.fullName.getText();
       String expectedFullName ="Ms Mariam Brackstone";

       Assert.assertEquals(actualFullName,expectedFullName);

       String actualEmail = contactInfoPage.email.getText();
       String expectedEmail = "mbrackstone9@example.com";

       Assert.assertEquals(actualEmail,expectedEmail,"Verify that email is matching");



   }
}
