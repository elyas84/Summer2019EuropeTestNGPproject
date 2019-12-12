package com.cybertek.tests.Day13_Properties_driver_testbase;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

    @Test
    public void test(){
        Driver.get().get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.cssSelector("input#prependedInput")).sendKeys("User1");
        driver.findElement(By.cssSelector("input#prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);

    }
}
