package chapter7;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG1 {
    @BeforeClass
    public void beforeclass() {
        System.out.println("Beforeclass's TestNG1");
    }

    @AfterClass
    public void afterclass() {
        System.out.println("Afterclass's TestNG1");
    }

    @Test
    public void test3() {
        System.out.println("TestNG1's test3");
    }

    @Test(groups="haha")
    public void test4() {
        System.out.println("TestNG1's test4");
    }
}
