package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllProductsTest {

    @Test
    public void getAllProductsTest() {
        RestAssured.baseURI = "https://automationexercise.com";

        Response response =
                given()
                        .when()
                        .get("/api/productsList")
                        .then()
                        .statusCode(200)
                        .extract().response();

        // Convert response to string for validation
        String responseBody = response.asString();
        //System.out.println(responseBody);
        // Basic assertion (safe + stable for this API)
        Assert.assertTrue(responseBody.contains("products"),
                "Response does not contain 'products' keyword");
    }
}
