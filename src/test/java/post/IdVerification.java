package post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class IdVerification {
@BeforeClass
    public static  void setup(){

    RestAssured.baseURI="https://jsonplaceholder.typicode.com/todos";
}@Test
    public void id_should_not_be_completed(){
        Response response= given()
                .when()
                .get("2")
                .then()
                .extract()
                .response();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("completed"),"false");
    }
    @Test
    public static void id_number_four_shoild_be_completed(){
    Response response= given()
            .when()
            .get("4")
            .then()
            .extract()
            .response();
    Assert.assertEquals(response.getStatusCode(),200);
    Assert.assertEquals(response.jsonPath().getString("completed"),"true");
        response.prettyPrint();

    }

}
