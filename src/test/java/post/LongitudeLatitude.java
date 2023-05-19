package post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import static io.restassured.path.xml.XmlPath.given;

public class LongitudeLatitude {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users/2";
    }

    @Test
    public static void verify_latitude_longitude_should_be_correct() {
        Response response = RestAssured
                .given()
               // .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .extract()
                .response();
        response.prettyPrint();

        // Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getDouble("address.geo.lat"), -43.9509);
        Assert.assertEquals(response.jsonPath().getDouble("address.geo.lng"), -34.4618);

    }
}
