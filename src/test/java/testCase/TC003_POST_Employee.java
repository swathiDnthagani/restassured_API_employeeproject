package testCase;

import utilities.RestUtils;
import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC003_POST_Employee extends TestBase {

    String empName = RestUtils.empName();

    String empSalary = RestUtils.empSal();
    String empAge = RestUtils.empAge();

    @BeforeClass
    public void getEmplyeeData() throws InterruptedException {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        JSONObject rbody= new JSONObject();
        rbody.put("name",empName);
        rbody.put("salary",empSalary);
        rbody.put("age",empAge);
        response = given()
                .header("Content-Type","application/json")
                .body(rbody)
                .post("/create");
        Thread.sleep(5000);
    }
    @Test
    void checkResponseBody(){
        ResponseBody RBody=response.getBody();
        String responseBody= RBody.asString();
        logger.info("POST_responseBody : "+ responseBody);
        Assert.assertEquals(responseBody.contains(empName), true);
        Assert.assertEquals(responseBody.contains(empSalary), true);
        Assert.assertEquals(responseBody.contains(empAge), true);
    }
    @Test
    void checkStatusCode(){
        logger.info("POST_checkStatusCode : "+ response.statusCode());
        Assert.assertEquals(response.statusCode(),200);

    }
}
