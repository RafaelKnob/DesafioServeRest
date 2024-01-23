package produtos;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class ProdutosListarTodosCadastradosTest {

    // Defina baseURI e basePath como variáveis estáticas se pretende reutilizá-las em vários testes
    private static final String BASE_URI = "https://serverest.dev";
    private static final String BASE_PATH = "";

    @Test
    public void testListarProdutos() {
        baseURI = BASE_URI;
        basePath = BASE_PATH;

        try {
            String responseBody = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get("/produtos")
                    .then()
                    .statusCode(200)
                    .extract().response()
                    .asString();

            // Adicione verificações adicionais no responseBody conforme necessário

            System.out.println(responseBody);
        } catch (Exception e) {
            // Trate exceções aqui, se necessário
            e.printStackTrace();
        }
    }
}
