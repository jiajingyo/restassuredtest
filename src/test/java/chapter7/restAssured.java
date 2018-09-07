package chapter7;

import io.restassured.RestAssured;
import io.restassured.config.SessionConfig;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class restAssured {
    public static String token;

    @BeforeClass
    public static void beforeclass(){
//        信任https的任何证书
        useRelaxedHTTPSValidation();

//        全局的url
/*        RestAssured.baseURI = "https://testerhome.com";*/

//        全局的proxy
/*        RestAssured.proxy("192.168.1.48", 8888);*/

//        全局filter
/*        RestAssured.filters((req, res, ctx)-> {
//            为request中添加cookie，可用于更新每次请求中的token、session啊
           req.cookie("testerhome", "jiajingyo");
           return ctx.next(req, res);
        });*/

//        RestAssured.filters();

//        清空掉filters的内容
/*        RestAssured.reset();*/
    }

    @Test
    public void GetFunction() throws Exception {
//        get请求 方法一 直接请求url 打印返回的response
        get("https://testerhome.com/api/v3/topics.json?limit=1&offset=0&type=last_actived").prettyPeek();

//        get请求 方法二 拆开请求参数 返回的是response
        Response response = given().param("limit",1).and().param("offset",0)
                .and().param("type","last_actived")
                .get("https://testerhome.com/api/v3/topics.json");

        Assert.assertEquals(200,response.statusCode(),"return 200");

//        get请求 方法三 new个对象传参 返回的是response
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("limit", 1);
        parameters.put("offset", 0);
        parameters.put("type", "last_actived");

        given().params(parameters).get("https://testerhome.com/api/v3/topics.json");

//        get请求 方法四 放到形参中请求
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("topics", "topics");
        map.put("topicid", 12192);

        get("https://testerhome.com/{topics}/{topicid}", map).prettyPeek();

//        get请求 方法五 直接请求
        get("https://testerhome.com/{topics}/{topicid}", "topics", "12192").prettyPeek();


    }


    @Test
    public void PostFunction() throws Exception {
/*//        post请求 方法一 直接请求url 打印返回的response
        post("https://testerhome.com/account/sign_in?username=741090420@qq.com&password=66524667").prettyPeek();*/


/*
//        post请求 方法二 拆开请求参数 返回的是response
        Response response = given().param("username","741090420@qq.com").and().param("password","66524667")
                .get("https://testerhome.com/account/sign_in");

        Assert.assertEquals(200,response.statusCode(),"return 200");
*/


/*
//        post请求 方法三 new个对象传参 返回的是response
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("username", "741090420@qq.com");
        parameters.put("password", "66524667");

//        int statuscode = given().params(parameters)
//                .post("https://testerhome.com/api/v3/topics.json").getStatusCode();

        given().params(parameters).post("https://testerhome.com/account/sign_in");
*/
    }


    @Test
    public void AssertGetFuntion() throws Exception {
/*        Response response = get("https://testerhome.com/api/v3/topics.json?limit=1&offset=0&type=last_actived");

        int statecode = response.getStatusCode();
        Assert.assertEquals(statecode, 200, "return equal");

        String title = response.jsonPath().getString("topics[0].title");
        Assert.assertEquals(title, "\uD83D\uDD25你心目中的明星讲师是他们吗？\uD83D\uDD25", "title campare");

        int topicsize = response.jsonPath().getList("topics").size();
        Assert.assertEquals(topicsize, 2);

//        提前构造测试数据
        List list = new ArrayList();
        list.add("\uD83D\uDD25你心目中的明星讲师是他们吗？\uD83D\uDD25");
        list.add("测试开发之路--k8s 下的大规模持续集成与环境治理");

        for (int i = 0; i<topicsize; i++){
            Assert.assertEquals(response.jsonPath().getString("topics["+i+"].title"), list.get(i));
        }*/
    }


    @Test
    public void JsonScheme() {
/*
        get("https://testerhome.com/api/v3/topics.json?limit=1&offset=0&type=last_actived")
                .then().assertThat().body(matchesJsonSchemaInClasspath("schema/topics.json"));
//                .then().assertThat().body(matchesJsonSchemaInClasspath("schema/practice.json"));
//                .then().assertThat().body(matchesJsonSchemaInClasspath("schema/1.json"));
//                .then().assertThat().body(matchesJsonSchemaInClasspath("schema/2.json"));
*/
    }


    @Test
    public void AssertGetHtml() {
/*        given()
                .log().all()
        .when()
                .get("https://testerhome.com")      *//*返回的接口数据是html*//*
        .then()     *//*从返回的数据中判断状态码和页面数据的head.title*//*
                .log().all().statusCode(200).body("html.head.title", equalTo("TesterHome"));
//                .body("html.head.meta.charset", equalTo("utf-8"));*/
    }


    @Test
    public void AssertGetJson() {
/*        Response response = given()
        .when()
                .get("https://testerhome.com/api/v3/topics.json")
        .then()
                .body("topics.id[0]", equalTo(10254))
                .body("topics[-1].abilities.update", equalTo(false))
                .body("topics.id", hasItems(10254, 15275))
                .body("topics.find {it.id == 15278}.title", equalTo("postman 中 body 格式的疑问"))
//        响应时间不能少于200ms
                .time(lessThan(200L))
//        把结果抛出来
        .extract().response();

//        深入使用返回的结果做下一步的操作
         Integer id1 = response.path("topics.id[0]");
         Integer id2 = response.path("topics.id[1]");
//        junit assert
        assertEquals(id1, id2);*/
    }


    @Test
    public void AssertGetXml(){
/*        given()
                .log().all()        *//*打印请求信息*//*
                .proxy("127.0.0.1",8888)        *//*请求走代理*//*
        .when()
                .get("http://127.0.0.1:8000/demo.xml").prettyPeek()     *//*打印请求返回信息*//*
        .then()
                .body("shopping.category.size()", equalTo(3))
                .body("shoppong.category.find {it.@type == 'supplies'}.size()", equalTo(1))
                .body("shoppong.category.find {it.@type == 'supplies'}.item.name[0]", equalTo("Paper"));*/
    }


    @Test
    public void AssertGetTHJson() {
/*        given()
        .when()
                .get("https://testerhome.com/api/v3/topics.json")
        .then()
                .body("topics.findAll {it.excellent == 1}.size()", greaterThan(4));  *//*大于*/
    }


    @Test
    public void RequestJson(){
/*        Map<String, Object> jsondatas = new HashMap<>();

        jsondatas.put("x", 1);
        jsondatas.put("xx", 2);

        given()
                .contentType(ContentType.JSON).body(jsondatas)
                .proxy("192.168.1.48", 8888)
        .when()
                .post("https://baidu.com/s")
        .then()
                .statusCode(200);*/
    }


    @Test
    public void HttpAttestation(){
/*//        given().when().get("http://shell.testing-studio.com:9002/").then().statusCode(200);

        given()
//                做了http验证后，就不会是401
                .auth().basic("hogwarts", "123456")
        .when()
                .get("http://shell.testing-studio.com:9002/")
        .then()
                .statusCode(200);*/
    }


/*    @Test
    public void QueryParamfuntion1() {
        Response response = given()
        .when()
                .get("https://testerhome.com/api/v3/topics.json")
        .then()
//        把结果抛出来
        .extract().response();

//        保存token为静态变量供其他地方使用
        token = response.path("topics.id[0]");
    }
    @Test
    public void QueryParamfuntion2() {
        given()
//                使用之前保存好的token供本次接口使用
                .queryParam("token", token)
        .when()
                .get("https://testerhome.com/api/v3/topics.json")
        .then()
                .statusCode(200);
    }*/


    @Test
    public void BaseURIfuntion() {
/*//        全局的url、proxy
        RestAssured.baseURI = "https://testerhome.com";
        RestAssured.proxy("192.168.1.48", 8888);

        Response response = given()
                .when()
                    .get("/api/v3/topics.json")
                .then()
                    .statusCode(200)
//        把结果抛出来
                .extract().response();*/

    }


    @Test
    public void Base64Test(){
/*        given().auth().basic("hogwarts", "123456").log().all()
//                filter对响应拦截
                .filter((req, res, ctx)->{
//                    拦截存储起来
                    Response responseOri = ctx.next(req, res);
//                    克隆响应数据
                    ResponseBuilder responseBuilder = new ResponseBuilder().clone(responseOri);
                    responseBuilder.setBody(
//                            解密
                            Base64.getDecoder().decode(
//                                    清洗数据-转成数据串-去换行-去空格
                                    responseOri.getBody().asString().trim().replace("\n", "")
                            )
                    );
//                    设置响应数据的格式
                    responseBuilder.setContentType(ContentType.JSON);
                    return  responseBuilder.build();
                })
        .when()
                .get("http://shell.testing-studio.com:9002/sec.json")
        .then()
                .log().all().statusCode(200).body("topics.id[0]", equalTo(15150));
    }*/
}


//    @Test
//    public void Base64Test(){
//        given().auth().basic("hogwarts", "123456").log().all()
//        .when()
//                .get("http://shell.testing-studio.com:9002/sec.json")
//                .filter((req, res, ctx)->{
//                    Response responseOri = ctx.next(req, res);
//                    ResponseBuilder responseBuilder = new ResponseBuilder().clone(responseOri);
//                    responseBuilder.setBody(
//                            Base64.getDecoder().decode(
//                                    responseOri.getBody().asString().trim().replace("\n", "")
//                            )
//                    );
//                    responseBuilder.setContentType(ContentType.JSON);
//                    return  responseBuilder.build();
//                })
//        .then()
//                .log().all().statusCode(200).body("topics.id[0]", equalTo(15150));
//    }


    @Test
    public void SesstionJenkinsLogin(){
/*        RestAssured.config = RestAssured.config().sessionConfig(
                new SessionConfig().sessionIdName("JSESSIONID.55cd899b")
        );
        SessionFilter sessionFilter = new SessionFilter();

        given()
                .log().all().filter(sessionFilter)
                .queryParam("j_username", "root")
                .queryParam("j_password", "66524667")
                .queryParam("Submit", "登录")
        .when()
                .post("http://localhost:8080/j_acegi_security_check")
        .then()
                .statusCode(302);

        given()
                .log().all().filter(sessionFilter)
        .when()
                .get("http://localhost:8080/newJob").prettyPeek()
        .then()
                .statusCode(200);*/
    }

    @Test
    public void SesstionJenkinsLogin2(){
/*        Response response = given()
                .log().all()
                .queryParam("j_username", "root")
                .queryParam("j_password", "66524667")
                .queryParam("Submit", "登录")
        .when()
                .post("http://localhost:8080/j_acegi_security_check")
        .then()
                .statusCode(302).extract().response();

//        String cookieValue = response.getCookie("JSESSIONID.55cd899b");
//        获取所有 cookie 键值对
        Map<String, String> allCookies = response.getCookies();

        RestAssured.config = RestAssured.config().sessionConfig(
                new SessionConfig().sessionIdName("JSESSIONID.55cd899b")
        );
        SessionFilter sessionFilter = new SessionFilter();

        given()
                .log().all().filter(sessionFilter)
        .when()
                .get("http://localhost:8080/newJob").prettyPeek()
        .then()
                .statusCode(200);*/

    }







}




















