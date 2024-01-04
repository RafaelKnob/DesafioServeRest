package org.example;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletarUsuarioTest {

    @Test
    public void testDeletarUsuario() {
        baseURI = ("https://serverest.dev");
        basePath = "";

        String codigoUsuario = "886nCnQfiGHkE8v9";

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
