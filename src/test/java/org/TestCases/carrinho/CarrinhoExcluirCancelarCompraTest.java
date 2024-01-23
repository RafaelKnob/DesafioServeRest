package org.TestCases.carrinho;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CarrinhoExcluirCancelarCompraTest {

    @Test
    public void testExcluirCarrinhoCancelarCompraComAutenticacao() {
        baseURI = "https://serverest.dev";
        basePath = "";

        // Realiza o login para obter o token
        String token = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"email\": \"kenbody1000000@lift.com\",\n" +
                        "  \"password\": \"mali23hot\"\n" +
                        "}")
                .when()
                .post("/login")
                .then()
                .extract().path("authorization");

        System.out.println("Token: " + token);

        // Conclui a compra e cancela o carrinho
        given()
                .header("Authorization", token)
                .when()
                .delete("/carrinhos/cancelar-compra")
                .then()
                .log().all();
    }
}
