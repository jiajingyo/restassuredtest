package chapter7;

import org.testng.annotations.Test;

/**
 * Created by jiajingyo on 2018/7/12.
 */
public class practice {
    //    测试用例
    @Test/*(groups = {"group1"})*/
    public void abc(){
        System.out.println("abc function");
    }

    @Test/*(groups = {"group2"})*/
    public void qwe(){
        System.out.println("qwe function");
    }

    @Test/*(groups = {"group2"})*/
    public void asd(){
        System.out.println("asd function");
    }

//
//    @Test
//    public void fgh(){
//        System.out.println("fgh funtion");
//    }

/*    //    未完成的用例，不希望被执行,通过ture和false来控制此方法是否要执行
    @Test(enabled = true)
    public void enabled(){
        System.out.println("enabled function");
    }*/

/*    @Test
    public void errorfuntion(){
        System.out.println(10/0);
    }*/


/*//    依赖测试
    @Test(dependsOnMethods = {"qwe","asd"})    *//* 依赖其他用例执行完后再执行本用例*//*
    public void dependsOnfuntion(){
        System.out.println("dependsOn funtion");
    }*/


/*    //    参数化
    @Test
    @Parameters("username")
    public void parameter(String name){
        System.out.println("This is " + name);
    }*/


/*//    执行在任何属于<test>标签内的类的测试方法运行之前，将会运行带注释的方法
    @BeforeClass
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }*/


/*//    一运行practice类的时，会被执行一次
    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass被首先运行");
    }

//    运行practice类的最后时，会被执行一次
    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass被最后运行");
    }*/


/*//    运行每个测试方法进都会被执行到
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod被运行");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod被运行");
    }*/


/*//    在调用属于该组的第一个测试方法之前运行
    @BeforeGroups(groups = {"group2"})
    public void BeforeGroups(){
        System.out.println("BeforeGroups被运行");
    }

//    在调用属于组的最后一个测试方法之后运行
    @AfterGroups(groups = {"group2"})
    public void AfterGroups(){
        System.out.println("AfterGroups被运行");
    }*/
}
