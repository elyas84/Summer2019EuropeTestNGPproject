package com.cybertek.tests.Day13_Properties_driver_testbase;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test(){
        //Singleton concept and reason---> The thing with that we shall use same browser whole the way!!!!
        //Singleton prevent the potential problems.

        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println(ConfigurationReader.get("UserName"));

    }

    @Test
    public void test2(){
        //This is how we create web driver object form now on
        //Type if rhe driver will come from Configuration.properties file

        WebDriver driver= Driver.get();
        driver.get(ConfigurationReader.get("url"));
        Driver.get().navigate().refresh();
    }
    @Test
    public  void test3(){
       Driver.get().get("http://amazon.com");
       Driver.closeDriver();

    }

}
