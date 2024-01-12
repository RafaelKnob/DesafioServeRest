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
                        "  \"email\": \"fulano@qa.com\",\n" +
                        "  \"password\": \"teste\"\n" +
                        "}")
                .when()
                    .post("/login")
                .then()
                .extract().path("authorization");  // Extrai o Token para passar para o carrinho
                  //  .log().all().toString();
                System.out.println("token" + token);


      // if (statusCode == 200) {
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


           // System.out.println("Mensagem do Cadastro do Carrinho: " + mensagemCadastroCarrinho);
       // } else if (statusCode == 401) {
        //    System.out.println("Token expirado ou inválido. Realize o login novamente.");

       // } else {
       //     System.out.println("Erro desconhecido ao realizar o login. Código de Status: " + statusCode);
        }
    }

