package com.cybertek.tests.Day13_Properties_driver_testbase;

import org.testng.annotations.Test;

public class Singleton {

    //Singleton class will have private constructor
    //Singleton class will have private constructor
    private Singleton(){}

    private static String str;

    public static String getInstance(){
        //if str has no value, initialize it and return it
        if(str==null){
            System.out.println("String is null. Assigning value to it ");
            str="someValue";
        }else{
            //if it has value just return it
            System.out.println("It has value just return it");
        }

        return str;
    }



}
