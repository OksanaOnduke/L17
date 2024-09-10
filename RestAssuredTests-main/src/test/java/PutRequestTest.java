import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutRequestTest extends BaseTest {

    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        String cookieValue = "s%3A_tBOGZRPFc_NsDysJG6ETR_d3NpOWm66.XxONh3sSTPSaFEolygwfpRDUYivA7AhlRb7AVCDapj8";

        Response response = given()
                .header("Content-Type", "text/plain")
                .cookie("sails.sid", cookieValue)
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)  
                .body("data", equalTo(requestBody)) 
                .extract()
                .response();

        System.out.println("Response: " + response.asString());
    }
}
