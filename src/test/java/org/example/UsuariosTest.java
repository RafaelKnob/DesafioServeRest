package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class UsuariosTest {

    private static final String BASE_URL = "https://api.serverest.dev";
    private static final String USUARIOS_ENDPOINT = "/usuarios";

    @Test
    public void testGetUsuarios() {
        RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get(USUARIOS_ENDPOINT)
                .then()
                .statusCode(200)
                .extract().response()
                .prettyPrint();
    }
}
