package com.cybertek.tests.Day07_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNGAssertionDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");

     Assert.assertEquals(1,1); //check the value

        System.out.println("Second Assertion");

        Assert.assertEquals("title","title");
        System.out.println("After second assertion");
    }

    @Test
    public void test2(){ //verify that title stats witch C
        String actualTitle = "Cybertek";
        String expecTitle = "C";
        System.out.println("First Assertion");
        Assert.assertTrue(actualTitle.startsWith(expecTitle),"Verify that title stats with C");

        Assert.assertTrue("Alim@email.com".contains("@"),"Verify that @ is in the mail");


    }

    @Test
    public void test3(){

        Assert.assertNotEquals("one","two","Pass");
    }

    @Test
    public void test4 (){

        Assert.assertFalse(1>4);
    }
    @Test
    public void testEmail(){
        Assert.assertTrue("email@example.com".contains("@"),"Verify that email contains @ sign");

    }

    @Test
    public void test5(){
        Assert.assertNotEquals("one","One","Verify that it is not equale..");
    }
    @Test
    public void test6(){
        Assert.assertFalse("one".contains("P"),"find false");
    }
}
