package chapter7.XueQiuStock;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;


/*登陆、未登录 BeforeClass+继承关系：获取到的token供给后面请求使用*/

public class Login {
    public static String token = "a9c085a9dff00217d797d1dffdeaf7f8941689f2";
    public static String uid = "6943611626";


    public static RequestSpecification requestSpecification;

    @BeforeClass
    public static void login(){
        useRelaxedHTTPSValidation();

//    统一构造请求参数
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addCookie("xq_a_token", token);
        requestSpecBuilder.addCookie("u", uid);
        requestSpecBuilder.addQueryParam("_t", "1GENYMOTION8863d82ff28644199d9234aef552ed93.6943611626.1535075339629.1535076815212");
        requestSpecBuilder.addQueryParam("_s", "f5fa6b");
//        requestSpecBuilder.addHeader("host", "api.xueqiu.com");
//        requestSpecBuilder.addHeader("User-Agent", "Apache-HttpClient/4.5.3 (Java/1.8.0_141)");

        requestSpecification = requestSpecBuilder.build();
    }
}
