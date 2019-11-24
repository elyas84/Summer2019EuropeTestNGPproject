package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        driver.quit();
    }
        @Test
    public void windwosHandle(){
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(new By.ByLinkText("Click Here")).click();
        System.out.println("After clicking the link"+driver.getTitle());

        String currentWindowHandle = driver.getWindowHandle();
            System.out.println("currentWindowHandle = " + currentWindowHandle);
        Set<String> windowsHandles = driver.getWindowHandles();
            System.out.println(windowsHandles.size());

            for (String handlde: windowsHandles){
                if (!currentWindowHandle.equals(handlde)){
                    driver.switchTo().window(handlde);
                }
            }

            System.out.println("After Switching new Window: "+driver.getTitle());

        }
        @Test
    public void moreThan2Window(){
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        //check how many window we have
            System.out.println(driver.getWindowHandles().size());
            Set<String> windowsHandles = driver.getWindowHandles();

            // we will keep switching windows until our title equals to targetWindowsTitle

           /* for (String handle : windowsHandles) {
                //switch them one by one
                driver.switchTo().window(handle);
                //checking if the window title equals to my target window title
                if(driver.getTitle().equals()){
                    //if they are equal stop looping.I want to keep that window driver.
                    break;
                }
            }
            System.out.println("After loop title is : "+driver.getTitle());
        }

            */




        }
}
