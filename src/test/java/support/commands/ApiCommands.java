package support.commands;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import java.util.List;
import static io.restassured.RestAssured.given;

public class ApiCommands {
    private static final String PATH = "http://165.227.93.41/lojinha/v2/";
    private static String gerarToken(){
        return given()
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
    }
    public static void cadastrarProdutoDoUsuario(){
        given()
            .contentType(ContentType.JSON)
            .header("token", gerarToken())
            .body("{\n" +
                    "  \"produtoNome\": \"MacBook\",\n" +
                    "  \"produtoValor\": 5592.25,\n" +
                    "  \"produtoCores\": []\n" +
                    "}")
        .when()
            .post(PATH + "produtos")
        .then()
            .statusCode(HttpStatus.SC_CREATED);
    }
    public static void removerProdutosDoUsuario() {
        List< Integer > ids = given()
            .header("token", gerarToken())
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
                    .header("token", gerarToken())
                .when()
                    .delete(PATH + "produtos/" + id)
                .then()
                    .statusCode(HttpStatus.SC_NO_CONTENT);
            }
        }
    }
}
