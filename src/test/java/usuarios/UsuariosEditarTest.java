package usuarios;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsuariosEditarTest {

    @Test
    public void testAlterarDadosDoUsuarioComSucesso() {

        baseURI = "https://serverest.dev";
        basePath = "/usuarios";

        // Defina o ID do usuário que você deseja alterar
        String userId = "0GAHJFyspFWU1muQ";

        String requestBody = "{\n" +
                "  \"nome\": \"YY editado\",\n" +
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
