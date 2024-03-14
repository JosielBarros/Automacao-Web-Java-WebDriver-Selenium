package features.tests.lojinha.login;

import org.junit.jupiter.api.*;
import support.hooks.Environment;
import static support.hooks.Environment.initializeDriver;
import static support.spec_helper.InitializePage.paginaLogin;

@DisplayName("Login do usuário")
public class LoginTest {
    @BeforeEach
    public void setUp() throws Exception {
        initializeDriver();
    }
    @Test
    @DisplayName("Validar acesso a página secreta do usuário")
    public void testValidarAcessoAPaginaSecretaDoUsuario() {
        String boasVindasUsuario = paginaLogin().preencherFormularioLogin("jhon", "123")
            .submeterFormulario()
            .capturarNomeUsuarioNaPaginaSecreta();
        Assertions.assertEquals("Boas vindas, Jhon!", boasVindasUsuario);
    }
    @AfterEach
    public void tearDown(){
        Environment.browser.quit();
    }
}
