package NegativeTests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class CadastrarEmailRepetidoTest {

    @Test
    public void CadastrarNovoUsuarioComEmailRepetido() {

        baseURI = "https://serverest.dev";
        basePath = "/usuarios";

        String requestBody = "{\n" +
                "  \"nome\": \"Ken Masters\",\n" +
                "  \"email\": \"testealteracao9999@qa.com\",\n" +
                "  \"password\": \"mali23hot\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(400) // Código 400 indica que o E-mail já esta cadastrado
                .body("message", equalTo("Este email já está sendo usado"));

    }
}

