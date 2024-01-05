package NegativeTests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AlterarDadosDoUsuarioNaoExistenteTest {

    @Test
    public void testAlterarDadosDoUsuarioComSucesso() {

        baseURI = "https://serverest.dev";
        basePath = "/usuarios";

        // Defina o ID do usuário que você deseja alterar, Neste caso deve ser fornecido um ID que não esta incluido na base
        String userId = "AlteracaoNovo2Usuario";

        String requestBody = "{\n" +
                "  \"nome\": \"NOVO_CAD2 TESTE5\",\n" +
                "  \"email\": \"testealteracao2@qa.com\",\n" +
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
                .statusCode(201)  // Modificando a asserção para 201
                .body("message", equalTo("Cadastro realizado com sucesso"));
    }
}
