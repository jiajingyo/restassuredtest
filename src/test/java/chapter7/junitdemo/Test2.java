package chapter7.junitdemo;

import org.junit.*;

public class Test2 {
    @BeforeClass
    public static void Before1(){
        System.out.println("Test2 BeforeClass");
    }

    @AfterClass
    public static void After1(){
        System.out.println("Test2 BeforeClass");
    }

    @Before
    public void Before(){
        System.out.println("Test2 Before");
    }

    @After
    public void After(){
        System.out.println("Test2 After");
    }

    @Test
    public void Funtion1(){
        System.out.println("Test2 Funtion1");
    }

    @Test
    public void Funtion2(){
        System.out.println("Test2 Funtion2");
    }

    @Test
    public void Funtion3(){
        System.out.println("Test2 Funtion3");
    }
}
