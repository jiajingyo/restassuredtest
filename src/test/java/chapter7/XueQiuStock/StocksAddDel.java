package chapter7.XueQiuStock;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


/*删除关注、添加关注 TestCase+参数化+排序*/

@RunWith(Parameterized.class)
public class StocksAddDel extends Login{
    //    添加、删除不同类型的股票，数据驱动
    @Parameterized.Parameters(name = "股票代号={0}")
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"AA"},
                {"00941"},
                {"SZ002024"}
        });
    }

    @Parameterized.Parameter
    public String symbol;

    @Before
    public void Proxy(){
        RestAssured.proxy("192.168.2.164", 6666);
    }


    @Test
    public void StocksAdd(){
        given()
                .queryParam("_t", "1GENYMOTION8863d82ff28644199d9234aef552ed93.6943611626.1535075339629.1535076815212")
                .queryParam("_s", "f5fa6b")
                .cookie("xq_a_token", token)
                .cookie("u", uid)
                .formParam("symbol", symbol)
                .formParam("x", "0.273")
                .formParam("category", "2")
        .when()
                .log().all().post("https://api.xueqiu.com/v4/stock/portfolio/addstock.json")
        .then()
                .log().all().statusCode(200)
                .body("success", equalTo(true));
    }

    @Test
    public void StocksDel(){

        given()
                .queryParam("_t", "1GENYMOTION8863d82ff28644199d9234aef552ed93.6943611626.1535075339629.1535076815212")
                .queryParam("_s", "f5fa6b")
                .cookie("xq_a_token", token)
                .cookie("u", uid)
                .formParam("symbol", symbol)
                .formParam("x", "0.504")
        .when()
                .log().all().post("https://api.xueqiu.com/v4/stock/portfolio/delstock.json")
        .then()
                .log().all().statusCode(200);

        //        判断返回值没有删除了的股票
        given()
                .queryParam("_t", "1GENYMOTION8863d82ff28644199d9234aef552ed93.6943611626.1535075339629.1535076815212")
                .queryParam("_s", "f5fa6b")
                .queryParam("size", 10000)
                .queryParam("type", 5)
                .queryParam("category", 2)
                .cookie("xq_a_token", token)
                .cookie("u", uid)
        .when()
                .log().all().get("https://api.xueqiu.com/v4/stock/portfolio/stock_list.json")
        .then()
                .log().all().statusCode(200)
                .body("stocks.code", not(hasItems("SH600000")));
    }



}
