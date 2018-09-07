package chapter7.BaseSuite;

//import org.testng.annotations.*;
//
//public class Base {
//    @BeforeClass
//    public void basebeforeclass(){
//        System.out.println("Base BeforeClass");
//    }
//
//    @AfterClass
//    public void baseafterclass(){
//        System.out.println("Base AfterClass");
//    }
//
//    @Test
//    public void basedemo(){
//        System.out.println("Base demo");
//    }
//
//    @Test
//    public void basedemo2(){
//        System.out.println("Base demo2");
//    }
//
//    @Test
//    public void basedemo1(){
//        System.out.println("Base demo1");
//    }
//
//    @BeforeMethod
//    public void basebeforemethod(){
//        System.out.println("Base BeforeMethod");
//    }
//
//    @AfterMethod
//    public void baseaftermethd(){
//        System.out.println("Base AfterMethod");
//    }
//}


import org.junit.*;

public class Base {
    @BeforeClass
    public static void basebeforeclass(){
        System.out.println("Base BeforeClass");
    }

    @AfterClass
    public static void baseafterclass(){
        System.out.println("Base AfterClass");
    }

    @Test
    public void basedemo(){
        System.out.println("Base demo");
    }

    @Test
    public void basedemo2(){
        System.out.println("Base demo2");
    }

    @Test
    public void basedemo1(){
        System.out.println("Base demo1");
    }

    @Before
    public void basebeforemethod(){
        System.out.println("Base BeforeMethod");
    }

    @After
    public void baseaftermethd(){
        System.out.println("Base AfterMethod");
    }
}
