package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UsuariosTest {



    @Test
    @DisplayName("")
    public void testGetUsuarios() {

        baseURI = ("https://serverest.dev");
        basePath = "";

                String token = given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("/usuarios")
                .then()
                .statusCode(200)
                .extract().response()
                .prettyPrint();
        System.out.println(token);
    }
}
