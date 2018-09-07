package chapter7.XueQiuStock;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*修改排序 TestCase*/
public class StocksModify extends Login{
    @Test
    public void AllStocks() {
        RestAssured.proxy("192.168.2.164", 6666);

//        采用统一的请求头
        given()
                .queryParam("_t", "1GENYMOTION8863d82ff28644199d9234aef552ed93.6943611626.1535075339629.1535076815212")
                .queryParam("_s", "f5fa6b")
                .cookie("xq_a_token", token)
                .cookie("u", uid)
                .formParam("x", "0.274")
                .formParam("type", "1")
                .formParam("pid", "-1")
                .formParam("stocks", "01810,GOOG,AMZN,AAPL,BABA,SH601155,SH600048,SZ000002,SZ000725")
        .when()
                .log().all().post("https://api.xueqiu.com/v4/stock/portfolio/modifystocks.json")
        .then()
                .log().all().statusCode(200);
    }
}
