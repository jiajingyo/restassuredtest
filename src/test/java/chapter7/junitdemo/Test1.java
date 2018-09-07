package chapter7.junitdemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Test1 {

    @BeforeClass
    public void BeforeClass(){
        System.out.println("Test1 BeforeClass");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("Test1 AfterClass");
    }

    @Test
    public void Funtion1(){
        System.out.println("Test1 Funtion1");
    }
}
