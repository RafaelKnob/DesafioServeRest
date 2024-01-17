package org.TestCases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CadastrarUsuarioNovoTest {

    @Test
    public void testCadastrarNovoUsuario() {

        baseURI = "https://serverest.dev";
        basePath = "/usuarios";

        String requestBody = "{\n" +
                "  \"nome\": \"Ken Masters\",\n" +
                "  \"email\": \"kenbody1000000@lift.com\",\n" +
                "  \"password\": \"mali23hot\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(201); // Código 201 indica que o usuário foi criado com sucesso


    }
}

