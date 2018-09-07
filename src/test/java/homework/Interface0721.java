package homework;

import io.restassured.RestAssured;
import io.restassured.config.SessionConfig;
import io.restassured.filter.session.SessionFilter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

/*利用SessionFilter或者自己定义的Filter实现Jenkins的登陆和带token触发job*/
public class Interface0721 {
    @Test
    public void SesstionJenkinsLogin(){
        RestAssured.config = RestAssured.config().sessionConfig(
                new SessionConfig().sessionIdName("JSESSIONID.9deb5c0f")
        );
        SessionFilter sessionFilter = new SessionFilter();

        useRelaxedHTTPSValidation();

        given()
                /*.log().all()*/.filter(sessionFilter)
                .queryParam("j_username", "root")
                .queryParam("j_password", "66524667")
                .queryParam("Submit", "登录")
        .when()
                .post("http://localhost:8080/j_acegi_security_check")
        .then()
                .statusCode(302);

        given()
                /*.log().all()*/.filter(sessionFilter)
                .queryParam("name", "JenkinsTest")
                .queryParam("mode", "hudson.model.FreeStyleProject")
                .queryParam("from", "")
                .queryParam("Jenkins-Crumb", "8e40029c659ddbd0dff79875e3554a9c")
        .when()
                .get("http://localhost:8080/newJob").prettyPeek()
        .then()
                .statusCode(200);

        given()
                /*.log().all()*/.filter(sessionFilter)
                .queryParam("builder.command", "dir")
                .queryParam("Submit", "保存")
        .when()
                .get("http://localhost:8080/job/JenkinsTest/configure").prettyPeek()
        .then()
                .statusCode(200);

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
