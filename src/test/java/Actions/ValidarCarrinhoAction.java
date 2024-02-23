package Actions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ValidarCarrinhoAction {

    public static String Token = "";
     static String emailcadastrado = "";
     static String senhacadastrada = "";

    public static Response cadastrarNovoUsuario(String email, String senha) {
        emailcadastrado = email;
        senhacadastrada = senha;

        baseURI = "https://serverest.dev";
        basePath = "/usuarios";

        String requestBody = "{\n" +
                "  \"nome\": \"Teste Quantidade\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"password\": \""+senha+"\",\n" +
                "  \"administrador\": \"true\"\n" +
                "}";


        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post();
                response.prettyPrint();
                return response;


    }

    public static Response realizarLogin() {
        baseURI = "https://serverest.dev";
        basePath = "";

        // Dados do usuário para login

        // Realiza a requisição de login
         Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"" + emailcadastrado + "\", \"password\": \"" + senhacadastrada + "\"}")
                .when()
                .post("/login");

         if (response.getStatusCode()==200){
             Token = response.jsonPath().getString("authorization");
         }

         return response;

    }

    public static Response cadastrarCarrinhoComSucesso(String token){
        Response response = given()
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
                .post("/carrinhos");

        String responseBody = response.getBody().asString();
        System.out.println("Corpo da resposta: " + responseBody);

        return response;

    }

    public static Response cadastrarCarrinhoComAutenticacao(String token) {
        baseURI = "https://serverest.dev";
        basePath = "/carrinhos";

// Cadastra o carrinho com dois produtos iguais
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
                        "      \"quantidade\": 1\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
                        "      \"quantidade\": 2\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post();

        response.prettyPrint();
        return response;
    }



    public static Response cadastrarCarrinhoComMesmaQuantidade(String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
                        "      \"quantidade\": 1\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
                        "      \"quantidade\": 1\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("/carrinhos");
        return response;

    }

    public static Response cadastrarCarrinhoComQuantidadeNula(String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
                        "      \"quantidade\": \n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("/carrinhos");
        return response;

    }

    public static Response produtoInvalido(String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \"Produto&Invalido\",\n" +
                        "      \"quantidade\": 1\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("/carrinhos");
        return response;

    }

    public static Response produtoInvalidoProdutoValido(String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \"Produto&Invalido\",\n" +
                        "      \"quantidade\": 1\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
                        "      \"quantidade\": 1\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("/carrinhos");
        return response;

    }

    public static Response produtoNulo(String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \"\",\n" +
                        "      \"quantidade\": 1\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("/carrinhos");
        return response;

    }

    public static Response produtoQuantidadeIndisponivel(String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
                        "      \"quantidade\": 1000000000\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("/carrinhos");
        return response;

    }

    public static Response produtoQuantidadeNegativa(String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
                        "      \"quantidade\": -5\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("/carrinhos");
        return response;

    }

    public static Response produtoQuantidadeInvalida(String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \"BeeJh5lz3k6kSIzA\",\n" +
                        "      \"quantidade\": @$\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("/carrinhos");
        return response;

    }

    public static Response produtoVazio(String token) {
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"produtos\": [\n" +
                        "    {\n" +
                        "      \"idProduto\": \" \",\n" +
                        "      \"quantidade\": 1\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("/carrinhos");
        return response;

    }

}
