package testCase;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.junit.AfterClass;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class TC002_Get_Employee extends TestBase {

    @BeforeClass
    public void getEmplyeeData() throws InterruptedException {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
        response = given()
                .get(empID);
        Thread.sleep(3000);

    }
       // @Test
        void checkResponseBody_employee() {
            logger.info("***** checkResponseBody_employee()*****");
            ResponseBody body = response.getBody();
            String responseBody = body.asString();
            Assert.assertTrue(responseBody.contains(empID));
        }
        @Test
        void checkStatus(){
            int statusCode = response.statusCode();
            Assert.assertEquals(statusCode,200);
        }
        @Test
        void checkResponseTime(){
            long responseTime=response.getTime();
            Assert.assertTrue(responseTime<5000);
        }
        @Test
        void checkStatusLine(){
            String statusLine = response.statusLine();
            Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
        }
        //@Test
        void checkContentType(){
            String contentType= response.header("Content-Type");
            Assert.assertEquals(contentType,"text/html; charset=UTF-8");
        }
       // @Test
        void checkServerType(){
            String serverType = response.header("Server");
            Assert.assertEquals(serverType,"nginx/1.14.1");
        }
        @Test
        void checkContentLength(){
            String contentLen=response.header("Content-Length");
            Assert.assertTrue(Integer.parseInt(contentLen)<1500);
        }
        @AfterClass
        void tearDown(){
            logger.info("*****Finished*****");
        }


}
