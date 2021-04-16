package testCase;

import base.TestBase;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.Map;

public class TC001_GET_All_Employess extends TestBase {
	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		logger.info("*****Started TC0001_Get_All_Employees******");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		response = given()
				.get("/employees");
		System.out.println("Response : "+ response.getBody().asString());
	}
	@Test
	void checkResponseBody(){
		logger.info("***** checkResponseBody()*****");
		ResponseBody body = response.getBody();
		String responseBody = body.asString();
		logger.info("responseBody : "+ responseBody);
		Assert.assertTrue(responseBody !=null);
	}
	@Test
	void checkStatus(){
		logger.info("***----------checkStatus***---------------");
		int statusCode=response.statusCode();
		logger.info("statusCode : "+ statusCode);
		Assert.assertEquals(statusCode, 200);//200);

	}


}
