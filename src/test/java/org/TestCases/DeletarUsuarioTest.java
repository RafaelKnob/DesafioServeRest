package org.TestCases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletarUsuarioTest {

    @Test
    public void testDeletarUsuario() {
        baseURI = ("https://serverest.dev");
        basePath = "";

        //. Deve ser informado o ID de um usuario cadastrado na base
        String codigoUsuario = "0YS5A4HI1A4vazM2";

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
