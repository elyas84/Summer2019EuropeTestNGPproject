package com.cybertek.tests.Day13_Properties_driver_testbase;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PropertiesTest {
    @Test
    public void test1(){

        //This is a central structure that we gonna use!!!
        System.out.println(ConfigurationReader.get("browser"));
        System.out.println(ConfigurationReader.get("url"));
        System.out.println(ConfigurationReader.get("UserName"));
        System.out.println(ConfigurationReader.get("UserPassword"));


    }
}
