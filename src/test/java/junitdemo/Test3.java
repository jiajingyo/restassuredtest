package junitdemo;

import org.testng.annotations.*;

public class Test3 {

    @BeforeClass
    public void BeforeClass(){
        System.out.println("Test3 BeforeClass");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("Test3 AfterTest");
    }

    @BeforeMethod
    public void Before(){
        System.out.println("Test3 BeforeMethod");
    }

    @AfterMethod
    public void After(){
        System.out.println("Test3 AfterMethod");
    }

    @Test
    public void Funtion1(){
        System.out.println("Test3 Funtion1");
    }

    @Test
    public void Funtion2(){
        System.out.println("Test3 Funtion2");
    }

    public void Funtion3(){
        System.out.println("Test3 Funtion3");
    }

}
