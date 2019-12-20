package com.cybertek.tests.Day09_PopupsTabsFrames;

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
        Thread.sleep(2000);

        driver.quit();
    }
        @Test
    public void windowsHandle(){

        driver.get("http://practice.cybertekschool.com/windows");
        //Before clicking the nwe tap link
            System.out.println("before clicking the the LINK-->"+driver.getTitle());

        //after clicking the new tab link
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
            System.out.println("after clicking the LINK-->"+driver.getTitle());

            String currentWindowsHandles = driver.getWindowHandle();
            System.out.println("currentWindowsHandles = " + currentWindowsHandles);


            //above!!!We can not see if new tab is opened or not by using this method!!!!

            //code for switching windows
            // driver.switchTo().window();
            //Set is just like an arrayList but without duplicate value

            Set<String> widowsHandles = driver.getWindowHandles(); //import the Set List
            System.out.println("widowsHandle.size() = " + widowsHandles.size());

            //Our problem is how can we get new windows handle from Set of handles. there is no index

            for (String handle : widowsHandles){
                if(!currentWindowsHandles.equals(handle)){
                    driver.switchTo().window(handle);
                }
            }
            System.out.println("After switching "+ driver.getTitle());

            //Getting text of the new window
            System.out.println(driver.findElement(By.xpath("//h3")).getText());

        }

        @Test
    public void moreThan2Window(){

            driver.get("http://practice.cybertekschool.com/windows");

            String targetWindowTitle = "New Window";

            driver.findElement(By.xpath("//a[text()='Click Here']")).click();

            //Check how many window wa have
            System.out.println(driver.getWindowHandles().size());

            Set<String> windowHandles = driver.getWindowHandles();

            //We will keep switching windows until our title equal to targetWindowTitle

            for(String handle : windowHandles){
                driver.switchTo().window(handle);
                if(driver.getTitle().equals(targetWindowTitle)){
                    break;
                }
            }
            System.out.println("After loop title "+driver.getTitle());
            
        }

}
