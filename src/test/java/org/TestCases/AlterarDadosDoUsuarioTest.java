package org.TestCases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AlterarDadosDoUsuarioTest {

    @Test
    public void testAlterarDadosDoUsuarioComSucesso() {

        baseURI = "https://serverest.dev";
        basePath = "/usuarios";

        // Defina o ID do usuário que você deseja alterar
        String userId = "0W85oRYaJYCtgKrs";

        String requestBody = "{\n" +
                "  \"nome\": \"NOVO_EDITADO TESTE5\",\n" +
                "  \"email\": \"teste5@qa.com\",\n" +
                "  \"password\": \"teste\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .pathParam("_id", userId)
                .body(requestBody)
                .when()
                .put("/{_id}")
                .then()
                .log().all()
                .statusCode(200)  // Modificando a asserção para 200
                .body("message", equalTo("Registro alterado com sucesso"));
    }
}
