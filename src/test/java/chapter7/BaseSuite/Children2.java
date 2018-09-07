package chapter7.BaseSuite;

//import org.testng.annotations.*;
//
//public class Children2 extends Base {
//    @BeforeClass
//    public void children2beforeclass(){
//        System.out.println("Children2 BeforeClass");
//    }
//
//    @AfterClass
//    public void children2fterclass(){
//        System.out.println("Children2 AfterClass");
//    }
//
//    @Test
//    public void children2demo(){
//        System.out.println("Children2 demo");
//    }
//
//    @Test
//    public void children2demo2(){
//        System.out.println("Children2 demo2");
//    }
//
//    @Test
//    public void children2demo1(){
//        System.out.println("Children2 demo1");
//    }
//
//    @BeforeMethod
//    public void children2beforemethod(){
//        System.out.println("Children2 BeforeMethod");
//    }
//
//    @AfterMethod
//    public void children2aftermethd(){
//        System.out.println("Children2 AfterMethod");
//    }
//}


import org.junit.*;

public class Children2 extends Base {
    @BeforeClass
    public static void children2beforeclass(){
        System.out.println("Children2 BeforeClass");
    }

    @AfterClass
    public static void children2fterclass(){
        System.out.println("Children2 AfterClass");
    }

    @Test
    public void children2demo(){
        System.out.println("Children2 demo");
    }

    @Test
    public void children2demo2(){
        System.out.println("Children2 demo2");
    }

    @Test
    public void children2demo1(){
        System.out.println("Children2 demo1");
    }

    @Before
    public void children2beforemethod(){
        System.out.println("Children2 BeforeMethod");
    }

    @After
    public void children2aftermethd(){
        System.out.println("Children2 AfterMethod");
    }
}

