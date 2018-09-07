package homework;

import io.restassured.RestAssured;
import io.restassured.config.SessionConfig;
import io.restassured.filter.session.SessionFilter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/*利用SessionFilter或者自己定义的Filter实现Jenkins的登陆和带token触发job*/
public class Interface0722 {
    public static SessionFilter sessionFilter;

    @BeforeClass
    public static void GetSessionFilter(){
        RestAssured.config = RestAssured.config().sessionConfig(
                new SessionConfig().sessionIdName("JSESSIONID.c9ca6ffb")
        );
        sessionFilter = new SessionFilter();
    }

//    登录
    @Test
    public void JenkinsLogin() {
        given()
                /*.log().all()*/.filter(sessionFilter)
                .queryParam("j_username", "root")
                .queryParam("j_password", "66524667")
//                .queryParam("Submit", "登录")
        .when()
                .post("http://localhost:8080/j_acegi_security_check")
        .then()
                .statusCode(302);
    }

//    新增-未完成 JenkinsSession/JenkinsCreate
    @Test
    public void JenkinsCreate() {
        given()
                /*.log().all()*/.filter(sessionFilter)
        .when()
                .get("http://localhost:8080/newJob").prettyPeek()
        .then()
                .statusCode(200);
    }

//    查看某个已存在的job
    @Test
    public void JenkinsSession() {
        given()
                /*.log().all()*/.filter(sessionFilter)
        .when()
                .get("http://localhost:8080/job/mvntest/").prettyPeek()
        .then()
                .statusCode(200);
    }
}
