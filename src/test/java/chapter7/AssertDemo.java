package chapter7;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by jiajingyo on 2018/7/19.
 */
public class AssertDemo {
    @Test
    public void AssertTest(){
        String str1 = "testerhome";
        String str2 = "testerhome1";
        Assert.assertEquals(str1,str2,"判断是否相等");


        boolean bl = true;
        boolean b2 = false;
        Assert.assertTrue(bl,"判断是否为true");
        Assert.assertFalse(b2,"判断是否为false");


        Object str3 = null ;
        Assert.assertNull(str3,"判断是否为nul");
        Assert.assertNotNull(str3,"判断是否不为null");


    }
}


