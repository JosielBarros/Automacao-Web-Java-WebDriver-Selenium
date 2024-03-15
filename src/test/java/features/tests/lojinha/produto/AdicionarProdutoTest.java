package features.tests.lojinha.produto;

import features.tests.lojinha.TestBase;
import org.junit.jupiter.api.*;

import static support.commands.ApiCommands.removerProdutosDoUsuario;
import static support.dataFactory.dataFactory.gerarTituloProduto;
import static support.spec_helper.InitializePage.paginaAdicionarProdutos;
import static support.spec_helper.InitializePage.paginaLogin;

@DisplayName("Adicionar produtos a um usuário")
public class AdicionarProdutoTest extends TestBase {
    private String tituloProduto;

    @Test
    @DisplayName("Validar cadastro de produto para o usuário")
    public void testValidarCadastroDeProdutoParaOUsuario(){
        removerProdutosDoUsuario();
        String mensagem = cadastrarProdutoComValor("400000");
        Assertions.assertEquals("Produto adicionado com sucesso", mensagem);
        String tituloProduto = paginaAdicionarProdutos()
                .clicarListaProdutos()
                .capturarTituloProduto();
        Assertions.assertEquals(this.tituloProduto, tituloProduto);
    }
    @Test
    @DisplayName("Validar que não é possível cadastrar um produto com valor zero")
    public void testValidarQueNaoEPossivelCadastrarUmProdutoComValorZero(){
        String mensagem = cadastrarProdutoComValor("0,00");
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagem);
    }
    @Test
    @DisplayName("Validar que não é possível cadastrar um produto com valor maior que 7000.00")
    public void testValidarQueNaoEPossivelCadastrarUmProdutoComValorMaiorQueSeteMil(){
        String mensagem = cadastrarProdutoComValor("7000,01");
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagem);
    }
    private String cadastrarProdutoComValor(String valor){
        tituloProduto = "Book - " + gerarTituloProduto();
        return paginaLogin()
            .abrirPaginaLogin()
            .preencherFormularioLogin("jhon", "123")
            .submeterFormulario()
            .clicarAdicionarProduto()
            .preencherDadosObrigatoriosProduto(tituloProduto, valor)
            .clicarEmSalvar()
            .capturarMensagem();
    }
}
