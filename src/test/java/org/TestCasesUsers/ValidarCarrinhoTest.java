package org.TestCasesUsers;

import Actions.ValidarCarrinhoAction;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.io.File;


public class ValidarCarrinhoTest extends ValidarCarrinhoAction {

    Response response;


    @Test
    public void cadastrarCarrinhoComSucesso(){
        response = cadastrarNovoUsuario("rafa200000@teste.com", "123");
        Assert.assertEquals(response.getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
        Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");
        Assert.assertEquals(cadastrarCarrinhoComSucesso(Token).getStatusCode(),201, "Carrinho cadastrado");
    }

    @Test
    public void testCadastrarUsuarioEValidarQuantidadeItens() {
        Assert.assertEquals(cadastrarNovoUsuario("rafa508@teste.com", "123").getStatusCode(), 201, "Não foi possível cadastrar o usuário.");
        Assert.assertEquals(realizarLogin().getStatusCode(), 200, "API de login não retornou 200");

        response = cadastrarCarrinhoComAutenticacao(Token);

        Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
        Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));

    }

    @Test
    public void cadastrarCarrinhoComMesmaQuantidade2(){
        Assert.assertEquals(cadastrarNovoUsuario("rafa20233@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
        Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

        response = cadastrarCarrinhoComAutenticacao(Token);

        Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
        Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
    }

    @Test
    public void cadastrarCarrinhoComQuantidadeNula2(){
        Assert.assertEquals(cadastrarNovoUsuario("rafa203@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
        Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

        response = cadastrarCarrinhoComAutenticacao(Token);

        Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
        Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
    }

    @Test
    public void cadastrarCarrinhoComProdutoInvalido(){
        Assert.assertEquals(cadastrarNovoUsuario("rafa20445@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
        Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

        response = cadastrarCarrinhoComAutenticacao(Token);

        Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
        Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
    }

    @Test
    public void cadastrarCarrinhoComProdutoInvalidoProdutoValido(){
        Assert.assertEquals(cadastrarNovoUsuario("rafa205@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
        Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

        response = cadastrarCarrinhoComAutenticacao(Token);

        Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
        Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
    }

    @Test
    public void cadastrarCarrinhoComProdutoNulo(){
        Assert.assertEquals(cadastrarNovoUsuario("rafa400@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
        Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

        response = cadastrarCarrinhoComAutenticacao(Token);

        Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
        Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
    }

    @Test
    public void cadastrarCarrinhoComQuantidadeDoProdutoInsufiente(){
        Assert.assertEquals(cadastrarNovoUsuario("rafa207hj@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
        Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

        response = cadastrarCarrinhoComAutenticacao(Token);

        Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
        Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
    }

    @Test
    public void cadastrarCarrinhoComQuantidadeDoProdutoNegativa(){
        Assert.assertEquals(cadastrarNovoUsuario("rafa208@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
        Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

        response = cadastrarCarrinhoComAutenticacao(Token);

        Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
        Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
    }

    @Test
    public void cadastrarCarrinhoComQuantidadeDoInvalida(){
        Assert.assertEquals(cadastrarNovoUsuario("rafa209@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
        Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

        response = cadastrarCarrinhoComAutenticacao(Token);

        Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
        Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
    }

    @Test
    public void cadastrarCarrinhoComProdutoVazio(){
        Assert.assertEquals(cadastrarNovoUsuario("rafa210@teste.com", "123").getStatusCode(),201,"Não foi possivel cadastrar o usuario.");
        Assert.assertEquals(realizarLogin().getStatusCode(),200, "API de login não retornou 200");

        response = cadastrarCarrinhoComAutenticacao(Token);

        Assert.assertEquals(response.getStatusCode(), 400, "O carrinho foi cadastrado");
        Assert.assertTrue(response.getBody().asString().contains("Não é permitido possuir produto duplicado"),"O body não esta retornando a mensagem correta");

        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/java/Schemas/CadastroComSucessoSchemas.json")));
    }
}
