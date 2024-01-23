package carrinho;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

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
}



