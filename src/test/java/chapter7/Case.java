package chapter7;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

//RunWith
@RunWith(Parameterized.class)
public class Case {
//    参数化
//    标注测试数据 提供读取数据源的方法 Parameterized
    @Parameterized.Parameters(name = "{0} vs {1}")
//    准备的测试数据 static Parameters
    public static Integer[][]data(){
        return new Integer[][]{
                {0,0},{1,1},{2,3}
        };
    }

//    Parameter
    @Parameterized.Parameter
    public int first;
    @Parameterized.Parameter(1)
    public int second;

    @Test
    public void restDemo(){
        assertThat(first, equalTo(second));
    }

    @Test
    public void BaiduTest(){
        given()
                .get("http://baidu.com/s?wd=201" + first)
        .then()
                .statusCode(200)
                .body("html.head.title", equalTo("201" + second + "_百度搜索"));
    }
}
