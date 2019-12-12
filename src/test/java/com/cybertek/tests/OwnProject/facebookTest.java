package com.cybertek.tests.OwnProject;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class facebookTest extends TestBase {

    @Test
    public void loginTest(){
        driver.get("https://www.facebook.com/");

        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        emailInput.sendKeys("example@email.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
        password.sendKeys("00000");
        WebElement loginButton = driver.findElement(By.cssSelector("input#u_0_b"));
        loginButton.click();
    }

}
