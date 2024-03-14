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
    @Test
    @DisplayName("Validar que não é possível acessar a página secreta com credenciais inválidas")
    public void testValidarQueNaoEPossivelAcessarAPaginaSecretaComCredenciaisInvalidas(){
        String mensagemErro = submeterFormulario("usuario_invalido", "senha_invalida")
            .capturarMensagem();

        Assertions.assertEquals("Falha ao fazer o login", mensagemErro);
        Assertions.assertFalse(elementVisible(paginaListaProdutos().getBotaoAdicionarProduto()));
    }
    @Test
    @DisplayName("Validar mensagem de erro ao tentar acessar a página secreta sem credenciais de usuario e senha")
    public void testValidarMensagemDeErroAoTentarAcessarAPaginaSecretaSemCredenciaisDeUsuarioESenha(){
        String mensagemErro = submeterFormulario("", "")
            .capturarMensagem();

        Assertions.assertEquals("Falha ao fazer o login", mensagemErro);
        Assertions.assertFalse(elementVisible(paginaListaProdutos().getBotaoAdicionarProduto()));
    }
    private ListaProdutosPage submeterFormulario(String usuario, String senha){
        return paginaLogin()
            .abrirPaginaLogin()
            .preencherFormularioLogin(usuario, senha)
            .submeterFormulario();
    }
}
