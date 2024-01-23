package usuarios;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UsuariosExcluirTest {

    @Test
    public void testDeletarUsuario() {
        baseURI = ("https://serverest.dev");
        basePath = "";

        //. Deve ser informado o ID de um usuario cadastrado na base
        String codigoUsuario = "zSzQt9m93UNmuItp";

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
