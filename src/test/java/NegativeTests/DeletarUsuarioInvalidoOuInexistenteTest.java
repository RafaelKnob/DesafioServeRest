package NegativeTests;



import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletarUsuarioInvalidoOuInexistenteTest {

    @Test
    public void testDeletarUsuario() {
        baseURI = ("https://serverest.dev");
        basePath = "";

        //. Deve ser informado o ID de um usuario NÃO cadastrado na base ou INEXISTENTE
        String codigoUsuario = "INEXISTENTE--TESTE";

        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/usuarios/"+codigoUsuario)
                .then()
                .log().all()
                .statusCode(200);
        //.statusCode(400);  // Adicionado para lidar com ambos os casos
    }
}
