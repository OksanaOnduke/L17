import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteRequestTest extends BaseTest {

    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200) 
                .body("data", equalTo(requestBody)) 
                .extract()
                .response();

       System.out.println("Response: " + response.asString());
    }
}
