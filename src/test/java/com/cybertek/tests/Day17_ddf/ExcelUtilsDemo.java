package com.cybertek.tests.Day17_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //create an object from ExcelUtil
        //it accepts two argument
        //Argument 1: location of the file(path)
        //Argument 2: sheet that we want to open (sheetName)
        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");
        System.out.println("Count Rows: "+qa3short.rowCount());

        System.out.println("columnCount: "+qa3short.columnCount());

        //Get column names
        System.out.println("ColumnNames: "+qa3short.getColumnsNames());

        ExcelUtil qa1= new ExcelUtil("C:\\Users\\Elyas\\IdeaProjects\\Summer2019EuropeTestNGProject\\src\\test\\Resources\\Vytracktestdata.xlsx","QA1-short");
        System.out.println(qa1.rowCount());
        System.out.println(qa1.getColumnsNames());

        // This we gonna not use, we gonna use Array instead

        List<Map<String, String>> dataList = qa3short.getDataList(); //Alt+Enter to get the menu!!!
        //Map consist Key ans Value;

     //   for (Map<String,String> oneRow: dataList){
           // System.out.println(oneRow);
            // With this we can get data one by one!!!
       // }

       // System.out.println(dataList.get(0)); // By using index get (indexNumber), we can get the data in first row

        System.out.println(dataList.get(0).get("firstname"));// This is how to deal with collections

        String [] [] OneRowData = qa3short.getDataArray(); // 2D arrays

       System.out.println(Arrays.deepToString(OneRowData));
       // System.out.println("OneRowData = " + OneRowData); THIS IS ABSOLUTELY NOT WORKING BECAUSE IT POINTS A REFERENCE ADDRESS.
    }
}
