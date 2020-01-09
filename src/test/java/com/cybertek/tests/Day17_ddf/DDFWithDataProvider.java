package com.cybertek.tests.Day17_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    Object[][] testData() {
        String[][] dataInfo = {
                {"Fc Bar", "9"},
                {"Inter", "8"},
                {"Juv", "5"},
                {"AMT", "10"},
                {"AC", "9"},
                {"RMA", "9"},
                {"PSG", "9"},
                {"Moc", "9"},
                {"BRC", "9"},
                {"Malmö","7"}

                //it has to be same order!!
        };
        return dataInfo;
    }

    @Test(dataProvider ="testData")
    public void test1(String club, String rating){
        System.out.println("Club| "+club+" Rating|"+rating);

    }
}
