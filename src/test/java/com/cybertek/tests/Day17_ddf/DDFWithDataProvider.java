package com.cybertek.tests.Day17_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider

    public Object[][] testData(){

        String[][]data={
                {"Game of Throw","9"},
                {"How meet your mother ","7"},
                {"Simpson","8"},
                {"You","10"},
        };


        return data;
    }

    @Test(dataProvider = "testData") //dataProvider is method name and This is how we connect Test and DataProver each other!!
    public void test1(String TVShow, String Rating){
        System.out.println("Tv Show: "+TVShow +" |Rating: "+ Rating);

    }

    @DataProvider
    public Object[][]testData2(){

        String [] [] dataOfPlayer = {
                {"Call Of Duty","9.5"},
                {"Pes 2020","9"},
                {"Fifa 2020","7"},
                {"Need for Speed & hit","8.8"},
        };

        return dataOfPlayer;
    }

    @Test(dataProvider = "testData2")
    public void test2(String GameName, String GameRate){

        System.out.println("The Name Of Game: "+GameName+ "| The Rate Of Game: "+GameRate);
    }
}
