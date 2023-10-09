package org.motorcycles;

import com.google.gson.Gson;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MotorcyclesControllerTest {

    @Test
    public void testHelloEndpoint() {
        MotorcyclesController motorcyclesController = new MotorcyclesController();
        Gson gson = new Gson();
        given()
          .when().get("/motorcycles")
          .then()
             .statusCode(200)
             .body(is(gson.toJson(motorcyclesController.getMotorcyclesList())));

    }

}