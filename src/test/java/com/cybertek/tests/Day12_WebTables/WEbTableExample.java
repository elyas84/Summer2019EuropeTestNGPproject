package com.cybertek.tests.Day12_WebTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WEbTableExample {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void printTable(){

        WebElement table = driver.findElement(By.id("table1"));
        // if we want to print whole table, we can print " table"
        String wholeTable = table.getText();
        System.out.println("wholeTable = " + wholeTable);
        //verify that jsmith@gmail.com is there in the table.
        Assert.assertTrue(wholeTable.contains("jsmith@gmail.com"),"Verify jsmith@gmail.com is in the table");
    }
    @Test
    public void getAllHeaders(){

       List<WebElement> headers= driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("number of columns "+headers.size());
        for (WebElement header: headers){
            System.out.println(header.getText());
        }
    }

    @Test
    public void printTableSize(){

        //numbers of columns
        List<WebElement> headers= driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("number of columns "+headers.size());

        //Number of rows with headers
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("allRowsWithHeader = " + allRowsWithHeader.size());


        //Number of rows without header( we prefer this)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("allRowsWithoutHeader = " + allRowsWithoutHeader.size());
        System.out.println("allRowsWithoutHeader = " + allRowsWithoutHeader);

    }
    @Test
    public void getRows(){

        WebElement secondRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println("secondRow = " + secondRow.getText());
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for(int i=1; i<=allRows.size(); i++){
            String rowXpath ="//table[@id='table1']/tbody/tr[" + i + "]";
            WebElement singleRow = driver.findElement(By.xpath(rowXpath));
            System.out.println("rowXpath = " + rowXpath);
            System.out.println(singleRow.getText());
        }

    }
    @Test
    public void  getEachCells(){
        List<WebElement> allCellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        for (WebElement cells : allCellInOneRow){
            System.out.println(cells.getText());
        }
    }
    @Test
    public void getSingleCellByIndex(){

        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[2]"));
        System.out.println(singleCell.getText());
    }
    @Test

    public void printAllCellByIndex(){
        //number of rows
        int rowNumber = getNumberOfRows();
        //number of columns
        int colNumber = getNumberOfColumns();
        //iterate through each row in the table
        for (int i = 1; i <=rowNumber; i++) {
            //iterate through each cell in the table
            for (int j = 1; j <= colNumber ; j++) {

                //creating dynamic xpath
                String xpath = "//table[@id='table1']/tbody/tr["+ i +"]/td["+ j +"]";
                System.out.println(xpath);

                //getting each cell value and printing it
                WebElement singleCell = driver.findElement(By.xpath(xpath));
                System.out.println(singleCell.getText());
            }
        }
    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String firstName ="Tim";

        String xpath = "//table[@id='table1']//td[.='"+firstName +"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());
    }


    private int getNumberOfColumns() {
        List<WebElement> allColumns = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return allColumns.size();
    }
    private int getNumberOfRows() {
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRows.size();
    }


}

