package carrinho;

import Actions.ValidarCarrinhoAction;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class CarrinhoListarTodosCadastradosTest {

    @Test
    public void testListarCarrinhos() {
        baseURI = "https://serverest.dev";
        basePath = "";

        given()
                .when()
                .get("/carrinhos")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all(); // Detalhar a resposta do LOG
    }

    public static class ValidarCarrinhoTest extends ValidarCarrinhoAction {

        Response response;


        @Test
        public void cadastrarCarrinhoComSucesso(){
            response = cadastrarNovoUsuario("rafa2009000@teste.com", "123");
            Assert.assertEquals(response.getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
            Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");
            Assert.assertEquals(cadastrarCarrinhoComSucesso(Token).getStatusCode(),201, "Carrinho cadastrado");
        }

        @Test
        public void testCadastrarUsuarioEValidarQuantidadeItens() {
            Assert.assertEquals(cadastrarNovoUsuario("rafa5098@teste.com", "123").getStatusCode(), 201, "Não foi possível cadastrar o usuário.");
            Assert.assertEquals(realizarLogin().getStatusCode(), 200, "API de login não retornou 200");

            response = cadastrarCarrinhoComAutenticacao(Token);

            Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
            Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));

        }

        @Test
        public void cadastrarCarrinhoComMesmaQuantidade2(){
            Assert.assertEquals(cadastrarNovoUsuario("rafa2023883@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
            Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

            response = cadastrarCarrinhoComAutenticacao(Token);

            Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
            Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
        }

        @Test
        public void cadastrarCarrinhoComQuantidadeNula2(){
            Assert.assertEquals(cadastrarNovoUsuario("rafa29903@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
            Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

            response = cadastrarCarrinhoComAutenticacao(Token);

            Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
            Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
        }

        @Test
        public void cadastrarCarrinhoComProdutoInvalido(){
            Assert.assertEquals(cadastrarNovoUsuario("rafa2000445@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
            Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

            response = cadastrarCarrinhoComAutenticacao(Token);

            Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
            Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
        }

        @Test
        public void cadastrarCarrinhoComProdutoInvalidoProdutoValido(){
            Assert.assertEquals(cadastrarNovoUsuario("rafa29905@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
            Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

            response = cadastrarCarrinhoComAutenticacao(Token);

            Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
            Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
        }

        @Test
        public void cadastrarCarrinhoComProdutoNulo(){
            Assert.assertEquals(cadastrarNovoUsuario("rafa40990@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
            Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

            response = cadastrarCarrinhoComAutenticacao(Token);

            Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
            Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
        }

        @Test
        public void cadastrarCarrinhoComQuantidadeDoProdutoInsufiente(){
            Assert.assertEquals(cadastrarNovoUsuario("rafa29907hj@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
            Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

            response = cadastrarCarrinhoComAutenticacao(Token);

            Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
            Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
        }

        @Test
        public void cadastrarCarrinhoComQuantidadeDoProdutoNegativa(){
            Assert.assertEquals(cadastrarNovoUsuario("rafa20998@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
            Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

            response = cadastrarCarrinhoComAutenticacao(Token);

            Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
            Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
        }

        @Test
        public void cadastrarCarrinhoComQuantidadeDoInvalida(){
            Assert.assertEquals(cadastrarNovoUsuario("rafa20999@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
            Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

            response = cadastrarCarrinhoComAutenticacao(Token);

            Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
            Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
        }

        @Test
        public void cadastrarCarrinhoComProdutoVazio(){
            Assert.assertEquals(cadastrarNovoUsuario("rafa29910@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
            Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

            response = cadastrarCarrinhoComAutenticacao(Token);

            Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
            Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

            response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
        }
    }
}



