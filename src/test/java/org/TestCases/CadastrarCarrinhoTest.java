package org.TestCases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CadastrarCarrinhoTest {

    @Test
    @DisplayName("Teste de Cadastro de Carrinho com Autenticação")
    public void testCadastrarCarrinhoComAutenticacao() {
        baseURI = "https://serverest.dev";
        basePath = "";

        // Realiza o login para obter o token
        String token = "";
        token = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"email\": \"kenbody1000000@lift.com\",\n" +
                        "  \"password\": \"mali23hot\"\n" +
                        "}")
                .when()
                    .post("/login")
                .then()
                    .extract().path("authorization");  // Extrai o Token para passar para o carrinho
                  //  .log().all().toString();  // Apeas exibe o Log, Não passa o token
                System.out.println("token" + token);


            System.out.println("Token: " + token);

            // Cadastra carrinho com o token fornecido
             given()
                   .contentType(ContentType.JSON)
                     .header("Authorization", token)
                   .body("{\n" +
                             "  \"produtos\": [\n" +
                            "    {\n" +
                            "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
                            "      \"quantidade\": 2\n" +
                             "    }\n" +
                            "  ]\n" +
                             "}")
             .when()
                    .post("/carrinhos")
             .then()
                    .log().all();

        }
    }

