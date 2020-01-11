package com.cybertek.tests.Day17_ddf;

import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest  extends TestBase {

    @DataProvider

    public Object [][] userInfo(){

        ExcelUtil excelUtil = new ExcelUtil("src/test/Resources/Vytracktestdata.xlsx","QA2-short");
        String [][] Credential = excelUtil.getDataArrayWithoutFirstRow();
        return Credential;
    }

    @Test(dataProvider = "userInfo")
    public void gettingCredential(String username, String password, String firstname, String lastname, String result){

        extentLogger= report.createTest("Test "+firstname + lastname);

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = firstname+" "+lastname;

        Assert.assertEquals(actualFullName,expectedFullName,"Comparing full names");
    }

    }


    // This test gives me wrong FirstName and LastName compare to Expected!