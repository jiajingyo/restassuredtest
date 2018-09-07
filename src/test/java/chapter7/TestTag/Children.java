package chapter7.TestTag;

//import org.testng.annotations.*;
//
//public class Children extends Base {
//    @BeforeClass
//    public void childrenbeforeclass(){
//        System.out.println("Children BeforeClass");
//    }
//
//    @AfterClass
//    public void childrenfterclass(){
//        System.out.println("Children AfterClass");
//    }
//
//    @Test
//    public void childrendemo(){
//        System.out.println("Children demo");
//    }
//
//    @Test
//    public void childrendemo2(){
//        System.out.println("Children demo2");
//    }
//
//    @Test
//    public void childrendemo1(){
//        System.out.println("Children demo1");
//    }
//
//    @BeforeMethod
//    public void childrenbeforemethod(){
//        System.out.println("Children BeforeMethod");
//    }
//
//    @AfterMethod
//    public void childrenaftermethd(){
//        System.out.println("Children AfterMethod");
//    }
//}


import chapter7.BaseSuite.Base;
import org.junit.*;
import org.junit.experimental.categories.Category;

public class Children extends Base {
    @BeforeClass
    public static void childrenbeforeclass(){
        System.out.println("Children BeforeClass");
    }

    @AfterClass
    public static void childrenfterclass(){
        System.out.println("Children AfterClass");
    }

    @Test
    @Category(Prod.class)
    public void childrendemo(){
        System.out.println("Children demo");
    }

    @Test
    @Category(Stage.class)
    public void childrendemo2(){
        System.out.println("Children demo2");
    }

    @Test
    @Category(Children.class)
    public void childrendemo1(){
        System.out.println("Children demo1");
    }

    @Before
    public void childrenbeforemethod(){
        System.out.println("Children BeforeMethod");
    }

    @After
    public void childrenaftermethd(){
        System.out.println("Children AfterMethod");
    }
}