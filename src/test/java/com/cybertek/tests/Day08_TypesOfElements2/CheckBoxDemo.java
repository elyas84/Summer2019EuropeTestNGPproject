package com.cybertek.tests.Day08_TypesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {
    @Test
    public void test1() throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");



        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));
        //Verify that check box 1 is unselected and 2 is selected

        // checkBox1.isSelected()--> gives false;
        Assert.assertFalse(checkBox1.isSelected(),"Verify checkbox 1 is not selected");
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected(),"Very checkbox 2 is selected");;
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected(),"verify checkbox 1 is selected");
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected(),"checkbox 2 is unselected");
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());
        Thread.sleep(3000);
        driver.quit();


    }


}
