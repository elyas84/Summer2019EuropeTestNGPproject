package com.cybertek.tests.Day17_ddf;

import com.cybertek.Pages.DashboardPage;
import com.cybertek.Pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//DDF --> Data Drive Framwork
public class DDFLoginTest  extends TestBase {

    @DataProvider Object[][] UserData(){
        ExcelUtil dataInfo = new ExcelUtil("C:\\Users\\Elyas\\IdeaProjects\\Summer2019EuropeTestNGProject\\src\\test\\Resources\\Vytracktestdata.xlsx","QA3-short");
        String [][] dataArray = dataInfo.getDataArrayWithoutFirstRow();
        return dataArray;

    }
    @Test(dataProvider = "UserData")
        public void loginTestDDF(String userName, String password, String firstName, String lastName){
        extentLogger= report.createTest(firstName+lastName);
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName= dashboardPage.getUserName();
        String expectedFullName = firstName+""+lastName;



    }

}
