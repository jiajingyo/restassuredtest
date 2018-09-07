package chapter7.TestTag;

//import org.testng.annotations.*;
//
//public class children3 extends Base {
//    @BeforeClass
//    public void children3beforeclass(){
//        System.out.println("children3 BeforeClass");
//    }
//
//    @AfterClass
//    public void children3fterclass(){
//        System.out.println("children3 AfterClass");
//    }
//
//    @Test
//    public void children3demo(){
//        System.out.println("children3 demo");
//    }
//
//    @Test
//    public void children3demo2(){
//        System.out.println("children3 demo2");
//    }
//
//    @Test
//    public void children3demo1(){
//        System.out.println("children3 demo1");
//    }
//
//    @BeforeMethod
//    public void children3beforemethod(){
//        System.out.println("children3 BeforeMethod");
//    }
//
//    @AfterMethod
//    public void children3aftermethd(){
//        System.out.println("children3 AfterMethod");
//    }
//}


import org.junit.*;
import org.junit.experimental.categories.Category;

public class Children3 {
    @BeforeClass
    public static void children3beforeclass(){
        System.out.println("children3 BeforeClass");
    }

    @AfterClass
    public static void children3fterclass(){
        System.out.println("children3 AfterClass");
    }

    @Test
    @Ignore("Ingore methond")
    public void children3demo(){
        System.out.println("children3 demo");
    }

    @Test
    public void children3demo2(){
        System.out.println("children3 demo2");
    }

    @Test
    @Category(Prod.class)
    public void children3demo1(){
        System.out.println("children3 demo1");
    }

    @Before
    public void children3beforemethod(){
        System.out.println("children3 BeforeMethod");
    }

    @After
    public void children3aftermethd(){
        System.out.println("children3 AfterMethod");
    }
}

