package features.tests.lojinha.login;

import features.pages.lojinha.ListaProdutosPage;
import features.tests.lojinha.TestBase;
import org.junit.jupiter.api.*;

import static support.commands.Commands.elementVisible;
import static support.spec_helper.InitializePage.paginaListaProdutos;
import static support.spec_helper.InitializePage.paginaLogin;
@DisplayName("Login do usuário")
public class LoginTest extends TestBase {
    @Test
    @DisplayName("Validar acesso a página secreta do usuário")
    public void testValidarAcessoAPaginaSecretaDoUsuario() {
        String boasVindasUsuario = submeterFormulario("jhon", "123")
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
