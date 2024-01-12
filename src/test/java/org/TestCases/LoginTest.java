package org.TestCases; // Certifique-se de que o pacote está correto

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class LoginTest {

    @Test
    public void testLogin() {
        baseURI = "https://serverest.dev";
        basePath = "";

        // Dados do usuário para login
        String email = "fulano@qa.com";
        String password = "teste";


        // Realiza a requisição de login
        String token = given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .path("authorization");

        // Imprime o token para verificar no console
        System.out.println("Token: " + token);

        // Verifica se o token não é nulo e não está vazio
        assertEquals(true, token != null && !token.isEmpty());
    }

    // Método para obter o token
    public String getToken() {
        // Dados do usuário para login
        String email = "fulano@qa.com";
        String password = "teste";

        // Realiza a requisição de login
        return given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .path("authorization");
    }
}
