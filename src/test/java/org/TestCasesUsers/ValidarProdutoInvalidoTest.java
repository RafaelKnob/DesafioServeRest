package org.TestCasesUsers;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ValidarProdutoInvalidoTest {

    @Test
    public void testCadastrarUsuarioEValidarQuantidadeItens() {
        // Cria um novo usuário
        String token = cadastrarNovoUsuario();

        // Cadastra o carrinho com autenticação
        cadastrarCarrinhoComAutenticacao(token);
    }

    // Método para cadastrar um novo usuário e obter o token
    private String cadastrarNovoUsuario() {
        baseURI = "https://serverest.dev";
        basePath = "/usuarios";

        String requestBody = "{\n" +
                "  \"nome\": \"Teste Quantidade\",\n" +
                "  \"email\": \"produtoinvalido2@qa.com\",\n" +
                "  \"password\": \"teste1\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";

        // Cadastra o novo usuário
        int statusCode = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .extract().statusCode(); // Obtem o código de status

        // Verifica o código de status e exibe mensagem adequada
        if (statusCode == 201) {
            System.out.println("Usuário cadastrado com sucesso!");
        } else if (statusCode == 400) {
            System.out.println("Erro ao cadastrar usuário: E-mail já cadastrado. Cadastre outro usuário/e-mail.");
            // Faz o teste falhar explicitamente
            throw new RuntimeException("Falha no teste: E-mail já cadastrado. Cadastre outro usuário.");
        } else {
            System.out.println("Erro inesperado ao cadastrar usuário. Código de status: " + statusCode);
        }

        // Realiza o login e retorna o token
        return realizarLogin();
    }

    // Método para cadastrar o carrinho com autenticação
    private void cadastrarCarrinhoComAutenticacao(String token) {
        baseURI = "https://serverest.dev";
        basePath = "/carrinhos";

        // Cadastra o carrinho
        int statusCode = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \"Produto#Invalido\",\n" +
                        "      \"quantidade\": 1\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post()
                .then()
                .extract().statusCode(); // Obtem o código de status

        // Adicione verificações adicionais conforme necessário
        if (statusCode == 400) {
            System.out.println("Carrinho não pôde ser cadastrado: Produto invalido.");
        } else if (statusCode == 201) {
            System.out.println("Carrinho cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar carrinho: Código de status desconhecido - " + statusCode);
        }
    }

    // Método para realizar o login e obter o token
    private String realizarLogin() {
        baseURI = "https://serverest.dev";
        basePath = "";

        // Dados do usuário para login
        String email = "produtoinvalido2@qa.com";
        String password = "teste1";

        // Realiza a requisição de login
        return given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .path("authorization");
    }
}
