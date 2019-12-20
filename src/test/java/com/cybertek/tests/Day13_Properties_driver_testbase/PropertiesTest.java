package com.cybertek.tests.Day13_Properties_driver_testbase;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PropertiesTest {
    @Test
    public void test1(){

        //This is a central structure that we gonna use!!!

        //to get these information we use get method
        System.out.println(ConfigurationReader.get("browser"));

        System.out.println(ConfigurationReader.get("url"));

        System.out.println(ConfigurationReader.get("driver_username"));

        System.out.println(ConfigurationReader.get("salesmanger_username"));


    }
}
