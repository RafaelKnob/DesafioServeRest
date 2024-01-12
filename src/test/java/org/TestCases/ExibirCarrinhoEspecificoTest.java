package org.TestCases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ExibirCarrinhoEspecificoTest {

    @Test
    public void testExibirCarrinhoEspecifico() {
        baseURI = "https://serverest.dev";
        basePath = "";

        String idCarrinho = "qbMqntef4iTOwWfg";

        given()
                .pathParam("_id", idCarrinho)  // Adiciona o parâmetro do caminho
                .when()
                .get("/carrinhos/{_id}")  // Utiliza o caminho com o parâmetro
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all(); // Detalhar a resposta do LOG
    }
}
