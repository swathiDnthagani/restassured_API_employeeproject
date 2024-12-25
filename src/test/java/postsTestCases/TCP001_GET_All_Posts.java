package postsTestCases;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TCP001_GET_All_Posts extends TestBase {

	@Test
	void checkResponseBody(){
		logger.info("*****Started TCP001_GET_All_Posts ******");
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
		response = given()
				.get("/posts");
		System.out.println("Response : "+ response.getBody().asString());
		logger.info("***** checkResponseBody()*****");
		ResponseBody body = response.getBody();
		String responseBody = body.asString();
		logger.info("responseBody : "+ responseBody);
		Assert.assertTrue(responseBody !=null);
		logger.info("***----------checkStatus***---------------");
		int statusCode=response.statusCode();
		logger.info("statusCode : "+ statusCode);
		Assert.assertEquals(statusCode, 200);//200);

	}
}
