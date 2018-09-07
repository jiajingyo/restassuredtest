package chapter7.XueQiuStock;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

/*自选股票刷新 TestCase
每种股票列表 TestCase+数据驱动、参数化*/

@RunWith(Parameterized.class)
public class Stocks extends Login{
//    所有股票的列表
    @Test
    public void AllStocks(){
//        采用统一的请求头
        given().spec(requestSpecification)
//            .queryParam("_t", "1GENYMOTION8863d82ff28644199d9234aef552ed93.6943611626.1535075339629.1535076815212")
//            .queryParam("_s", "f5fa6b")
            .queryParam("size", "10000")
            .queryParam("type", "1")
            .queryParam("category", "2")
//            .cookie("xq_a_token", token)
//            .cookie("u", uid)
        .when()
            .log().all().get("https://api.xueqiu.com/v4/stock/portfolio/stock_list.json")
        .then()
            .log().all().statusCode(200);
    }

//    不同类型的股票，数据驱动
    @Parameterized.Parameters(name = "{4}")
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {2, 1, 10000, "SH", "全部"}, //全部
                {2, 5, 10000, "SH", "沪深"}, //沪深
                {2, 7, 10000, "HK", "港股"}, //港股
                {2, 6, 10000, "NASDAQ", "美股"}, //美股

                {2, 7, 5, "HK", "列表为5"}, //港股
        });
    }

    @Parameterized.Parameter
    public Integer category;
    @Parameterized.Parameter(1)
    public Integer type;
    @Parameterized.Parameter(2)
    public Integer size;
    @Parameterized.Parameter(3)
    public String exchange;
    @Parameterized.Parameter(4)
    public String name;

    @Test
    public void KindOfStock(){
//        RestAssured.proxy("192.168.2.164", 6666);

        given()
                .queryParam("_t", "1GENYMOTION8863d82ff28644199d9234aef552ed93.6943611626.1535075339629.1535076815212")
                .queryParam("_s", "f5fa6b")
                .queryParam("size", size)
                .queryParam("type", type)
                .queryParam("category", category)
                .cookie("xq_a_token", token)
                .cookie("u", uid)
        .when()
                .log().all().get("https://api.xueqiu.com/v4/stock/portfolio/stock_list.json")
        .then()
                .log().all().statusCode(200)
//                返回值数量大于(1)
//                .body("stocks.size()", greaterThan(1))
//                返回值数量至少小于size
                .body("stocks.size", lessThanOrEqualTo(size))
                .body("stocks.exchange", hasItems(exchange));
    }

}
