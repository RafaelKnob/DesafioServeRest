package NegativeTests;



import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ExibirUsuarioInvalido {

    @Test
    public void testExibirUsuarioEspecifico() {

        baseURI = "https://serverest.dev";
        basePath = "/usuarios";

        // Defina o ID do usuário que você deseja exibir, Deve ser Informado um usuario que não esteja cadastrado na base
        String userId = "UsuarioInvalido";

        given()
                .contentType(ContentType.JSON)
                .pathParam("_id", userId)
                .when()
                .get("/{_id}")
                .then()
                .statusCode(400)
                .log().all();    // Exibe o log da resposta, pode ser removido se não for necessário
    }
}
