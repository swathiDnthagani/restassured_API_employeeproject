package base;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;


public class TestBase {
    public static RequestSpecification request;
    public static Response response;
    public String empID = "51838";

    public Logger logger ;

    @BeforeClass
    public void setup() {
        logger = (Logger)LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        logger.setLevel(Level.INFO);


    }
}


