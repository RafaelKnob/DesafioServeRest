package org.TestCases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ExcluirCarrinhoTest {

    @Test
    public void testExcluirCarrinho() {
        baseURI = "https://serverest.dev";
        basePath = "";

        // Utiliza a classe LoginTest para obter o token
        LoginTest loginTest = new LoginTest();
        String token = loginTest.getToken();

        // Realiza a requisição para excluir o carrinho
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("/carrinhos/concluir-compra")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("message", equalTo("Registro excluído com sucesso | Não foi encontrado carrinho para esse usuário"));
    }
}
