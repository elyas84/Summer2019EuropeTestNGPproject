package com.cybertek.tests.HomeWork4;

import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class xlSheetReading extends TestBase {
    @DataProvider

    public Object[][] userLoginTest (){

        ExcelUtil excelUtil = new ExcelUtil("src/test/Resources/Vytracktestdata.xlsx","QA1-short");

        String[][] userData = excelUtil.getDataArrayWithoutFirstRow();

        return userData;

    }

    @Test(dataProvider = "userLoginTest")
    public void test(String userName, String password, String firstName, String lastName, String Result ){
        extentLogger = report.createTest("TEST: "+firstName+" "+lastName+" "+Result);
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName =  dashboardPage.getUserName();
        String expectedFullName =firstName+" "+lastName;

        Assert.assertEquals(actualFullName, expectedFullName);

    }
}
