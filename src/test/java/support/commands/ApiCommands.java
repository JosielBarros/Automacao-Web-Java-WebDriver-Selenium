package support.commands;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.List;
import static io.restassured.RestAssured.given;

public class ApiCommands {
    private static final String PATH = "http://165.227.93.41/lojinha/v2/";
    public static void removerProdutosDoUsuario() {
        String token = given()
            .contentType(ContentType.JSON)
            .body("{\n" +
                    "  \"usuarioLogin\": \"jhon\",\n" +
                    "  \"usuarioSenha\": \"123\"\n" +
                    "}")
        .when()
            .post(PATH + "login")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
                .path("data.token");

        List< Integer > ids = given()
            .header("token", token)
        .when()
            .get(PATH + "produtos")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
                .response()
                    .jsonPath()
                        .getList("data.produtoId");

        if(!ids.isEmpty()){
            for (Integer id : ids) {
                given()
                    .header("token", token)
                .when()
                    .delete(PATH + "produtos/" + id)
                .then()
                    .statusCode(HttpStatus.SC_NO_CONTENT);
            }
        }
    }
}
