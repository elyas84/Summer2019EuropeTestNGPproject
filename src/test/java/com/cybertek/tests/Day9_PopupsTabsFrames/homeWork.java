package com.cybertek.tests.Day9_PopupsTabsFrames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class homeWork {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void testCase_1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");
        System.out.println(driver.findElement(By.xpath("//small[.='The date of birth is not valid']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//small[.='The date of birth is not valid']")).isDisplayed());
    }
    @Test
    public void testCase_2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        List<WebElement> options = driver.findElements(By.xpath("//div[@class='form-check form-check-inline']"));
        for (WebElement op : options){
            System.out.println(op.getText());
        }
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='form-check form-check-inline']")).isDisplayed());
    }

    @Test
    public void testCase3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("A");
        System.out.println(driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']")).isDisplayed());
    }
    @Test
    public void testCase_4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("A");
        System.out.println(driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']")).isDisplayed());
    }

    @Test
    public void testCase_5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Mike");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Smith");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("MikeSmith");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("smith@hotmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456456");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("456-789-4561");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("01/05/2019");
        Select departList = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        departList.selectByVisibleText("Department of Engineering");
        Select jobList = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobList.selectByVisibleText("SDET");
        driver.findElement(By.cssSelector("input#inlineCheckbox2")).click();
        driver.findElement(By.xpath("//button[.='Sign up']")).click();
        System.out.println("driver.findElement(By.xpath(\"//p\")).getText() = " + driver.findElement(By.xpath("//p")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//p")).isDisplayed());
    }
    @Test
    public void testCase_6(){
        driver.get("https://www.tempmailaddress.com/");
        String email =driver.findElement(By.xpath("//span[@class='animace']")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[.='Sign Up For Mailing List']")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Mike Smith");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[.='Sign Up']")).click();
        String message =driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(message.endsWith(" home page."));
    }


}
