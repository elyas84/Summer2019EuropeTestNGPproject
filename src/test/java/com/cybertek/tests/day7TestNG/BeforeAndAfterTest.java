package com.cybertek.tests.day7TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @Test
    public void test1(){
        System.out.println("this is test 1");

    }
    //beginning of the each test
    // WebDriver code
    //driver.get
    //maximize window
    //After each
    //close browser
    @Test
    public void test2(){
        System.out.println("this is the test2");
    }
    @Ignore
    @Test
    public void  test3(){
        System.out.println("this is the test3");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method ");
        System.out.println("Opening the browser");
    }
@AfterMethod
    public void closing(){
    System.out.println("Close the browser");
}

@BeforeClass
    public void beforeClass(){
    System.out.println("before class code".toUpperCase());

}
@AfterClass
    public void afterClass(){
    System.out.println("After class code".toUpperCase());
    System.out.println("Reporting".toUpperCase());
}




}