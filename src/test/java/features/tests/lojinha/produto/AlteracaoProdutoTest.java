package features.tests.lojinha.produto;

import features.tests.lojinha.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static support.commands.ApiCommands.cadastrarProdutoDoUsuario;
import static support.commands.ApiCommands.removerProdutosDoUsuario;
import static support.dataFactory.dataFactory.gerarTituloProduto;
import static support.spec_helper.InitializePage.*;

public class AlteracaoProdutoTest extends TestBase {
    private String tituloProduto;
    @Test
    @DisplayName("Validar alteração do produto para o usuário")
    public void testValidaralteracaoDoProdutoParaOUsuario(){
        removerProdutosDoUsuario();
        cadastrarProdutoDoUsuario();
        String valorProduto = "150,00";
        String mensagem = alterarProduto(valorProduto);
        Assertions.assertEquals("Produto alterado com sucesso", mensagem);
        String tituloProduto = paginaAdicionarProdutos()
                .clicarListaProdutos()
                .capturarTituloProduto();
        Assertions.assertEquals(this.tituloProduto, tituloProduto);
        Assertions.assertEquals("R$ " + valorProduto, paginaListaProdutos().capturarValorProduto());
    }
    @Test
    @DisplayName("Validar que não é possível alterar um produto com valor zero")
    public void testValidarQueNaoEPossivelAlterarUmProdutoComValorZero(){
        String mensagem = alterarProduto("0,00");
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagem);
    }
    @Test
    @DisplayName("Validar que não é possível alterar um produto com valor maior que 7000.00")
    public void testValidarQueNaoEPossivelAlterarUmProdutoComValorMaiorQueSeteMil(){
        String mensagem = alterarProduto("7000,01");
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagem);
    }
    private String alterarProduto(String valor){
        tituloProduto = "Book - " + gerarTituloProduto();
        return paginaLogin()
            .abrirPaginaLogin()
            .preencherFormularioLogin("jhon", "123")
            .submeterFormulario()
            .clicarEmUmProduto()
            .preencherDadosObrigatoriosProduto(tituloProduto, valor)
            .clicarEmSalvar()
            .capturarMensagem();
    }
}
