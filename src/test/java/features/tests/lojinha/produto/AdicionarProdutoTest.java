package features.tests.lojinha.produto;

import features.tests.lojinha.TestBase;
import org.junit.jupiter.api.*;
import static support.spec_helper.InitializePage.paginaLogin;

@DisplayName("Adicionar produtos a um usuário")
public class AdicionarProdutoTest extends TestBase {

    @Test
    @DisplayName("Validar cadastro de produto para o usuário")
    public void testValidarCadastroDeProdutoParaOUsuario(){
        String mensagem = cadastrarProdutoComValor("400000");
        Assertions.assertEquals("Produto adicionado com sucesso", mensagem);
    }
    @Test
    @DisplayName("Validar que não é possível cadastrar um produto com valor zero")
    public void testValidarQueNaoEPossivelCadastrarUmProdutoComValorZero(){
        String mensagem = cadastrarProdutoComValor("000");
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagem);
    }
    @Test
    @DisplayName("Validar que não é possível cadastrar um produto com valor maior que 7000.00")
    public void testValidarQueNaoEPossivelCadastrarUmProdutoComValorMaiorQueSeteMil(){
        String mensagem = cadastrarProdutoComValor("700001");
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagem);
    }
    private String cadastrarProdutoComValor(String valor){
        return paginaLogin()
            .abrirPaginaLogin()
            .preencherFormularioLogin("jhon", "123")
            .submeterFormulario()
            .clicarAdicionarProduto()
            .preencherDadosObrigatoriosProduto("Smartphone Samsung", valor)
            .preencherCoresProduto("Preto, Amarelo")
            .clicarEmSalvar()
            .capturarMensagem();
    }
}
