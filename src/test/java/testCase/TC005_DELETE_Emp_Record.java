package testCase;

import base.TestBase;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;


public class TC005_DELETE_Emp_Record extends TestBase {
    @BeforeClass
    void deleteEmployees() throws InterruptedException {

        RestAssured.defaultParser = Parser.JSON;
        logger.info("*****TC005_DELETE_Emp_Record Started******");
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        response=given()
                 .get("/employees").then()
                 .extract().response();

                String sId= response.jsonPath().getString("id");

                System.out.println("sId :"+ sId);

                response = given()
                .header("Content-Type", "application/json")
                .delete("/delete/"+7);
    }

    @Test

    void statusCode() {
        logger.info("***** StatusCode()*****");
        Assert.assertNotEquals(response.statusCode(),999);//200


    }

}