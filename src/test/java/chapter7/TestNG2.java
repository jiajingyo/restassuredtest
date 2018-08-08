package chapter7;

import org.testng.annotations.*;

public class TestNG2  {
    @BeforeSuite
    public void beforesuite() {
        System.out.println("beforesuite");
    }

    @AfterSuite
    public void aftersuite() {
        System.out.println("aftersuite");
    }

    @BeforeTest
    public void beforetest() {
        System.out.println("beforeTest");
    }

    @AfterTest
    public void AfterTest() {
        System.out.println("aftertest");
    }

    @BeforeClass
    public void beforeclass(){
        System.out.println("beforeclass's TestNG2");
    }

    @AfterClass
    public void aftertclass() {
        System.out.println("afterclass's TestNG2");
    }

    @BeforeMethod
    public void beforemethod() {
        System.out.println("TestNG2's beforemethod");
    }

    @AfterMethod
    public void aftertmethod() {
        System.out.println("TestNG2's aftermethod");
    }

    @BeforeGroups
    public void beforegroups() {
        System.out.println("TestNG2's beforegroups");
    }

    @AfterGroups
    public void aftergroups() {
        System.out.println("TestNG2's aftergroups");
    }

    @Test
    public void test1() {
        System.out.println("TestNG2's testt1");
    }

    @Test(groups="gr")
    public void test2() {
        System.out.println("TestNG2's testt2");
    }

    //        @Test
    public void ff() {
        System.out.println("nothing");
    }
}
