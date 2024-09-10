import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRequestTest extends BaseTest {

    @Test
    public void testPostRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)  
                .body("data", equalTo(requestBody)) 
                .extract()
                .response();

        System.out.println("Response: " + response.asString());
    }
}
