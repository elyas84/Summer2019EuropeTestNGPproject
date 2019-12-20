package com.cybertek.tests.Day11_Action_JsExcecution;

import com.cybertek.utilities.WebDriverFactory;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

//WE HAVE TO START FROM THAT STEP SETTING THE DRIVER AND GET IT USED
public class ActionTest {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod() {
        // driver.quit();
    }

    @Test
    public void HoverTest() {
        driver.get("http://practice.cybertekschool.com/hovers");

        //Actions is is class that contains all the user interactions
        //how to create actions object / passing driver as a constructor
        Actions actions = new Actions(driver);
        WebElement img = driver.findElement(By.xpath("//img"));

        //Perform ()--> perform the action. complete the action
        actions.moveToElement(img).perform();
        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed(),"Verify that the message is displayed");


    }

    @Test
    public void DragAndDropTest(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);
        //we have to provide source

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();
        actions.dragAndDrop(source,target).perform();
        //pause ()--> waiting just like thread.sleep, accepts milliseconds
        actions.pause(1000);


    }
        @Test
        public void DragAndDropTestChaining(){

            driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

            Actions actions = new Actions(driver);
            //we have to provide source

            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droptarget"));
            actions.pause(1000);
            driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();


            //If you are chaining actions we add build () method before perform
            actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();

        }


}

