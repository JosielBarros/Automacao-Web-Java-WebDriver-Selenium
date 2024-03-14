package features.tests.lojinha.produto;

import features.tests.lojinha.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static support.commands.ApiCommands.cadastrarProdutoDoUsuario;
import static support.commands.ApiCommands.removerProdutosDoUsuario;
import static support.commands.Commands.elementVisible;
import static support.spec_helper.InitializePage.paginaListaProdutos;
import static support.spec_helper.InitializePage.paginaLogin;

public class RemoverProdutoTest extends TestBase {
    @Test
    @DisplayName("Validar remoção do produto do usuário")
    public void testValidarRemocaoDoProdutoDoUsuario(){
        removerProdutosDoUsuario();
        cadastrarProdutoDoUsuario();
        String mensagemDeProdutoRemovido = paginaLogin()
            .abrirPaginaLogin()
            .preencherFormularioLogin("jhon", "123")
            .submeterFormulario()
            .clicarEmRemoverProduto()
            .capturarMensagem();
        Assertions.assertEquals("Produto removido com sucesso", mensagemDeProdutoRemovido);
        Assertions.assertFalse(elementVisible(paginaListaProdutos().getBotaoRemoverProduto()));
    }
}
