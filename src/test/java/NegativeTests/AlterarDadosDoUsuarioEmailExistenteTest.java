package NegativeTests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class AlterarDadosDoUsuarioEmailExistenteTest {

    @Test
    public void testAlterarDadosDoUsuarioComSucesso() {

        baseURI = "https://serverest.dev";
        basePath = "/usuarios";

        // Defina o ID do usuário que você deseja alterar, O e-mail informado já deve constar na base.
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
                .statusCode(400)  // Modificando a asserção para 400
                .body("message", equalTo("Este email já está sendo usado"));
    }
}
