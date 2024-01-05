package org.example;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ExibirUsuarioEspecificoTest {

    @Test
    public void testExibirUsuarioEspecifico() {

        baseURI = "https://serverest.dev";
        basePath = "/usuarios";

        // Defina o ID do usuário que você deseja exibir
        String userId = "02FUeDIJe6R785B9";

        given()
                .contentType(ContentType.JSON)
                .pathParam("_id", userId)
                .when()
                .get("/{_id}")
                .then()
                .statusCode(200) // Espera um status 200 para um usuário encontrado
                .log().all();    // Exibe o log da resposta, pode ser removido se não for necessário
    }
}
