package features.pages.lojinha;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdicionarProdutoPage extends BasePage{
    @FindBy(id = "produtonome")
    private WebElement campoNomeProduto;
    @FindBy(id = "produtovalor")
    private WebElement campoValorProduto;
    @FindBy(id = "produtocores")
    private WebElement campoNomeCores;
    @FindBy(css = "button[name=action]")
    private WebElement botaoSalvarProduto;
    @FindBy(xpath = "//a[text()='Lista de Produtos']")
    private WebElement botaoListaProdutos;

    public AdicionarProdutoPage preencherDadosObrigatoriosProduto(String nomeProduto, String valorProduto){
        campoNomeProduto.sendKeys(nomeProduto);
        campoValorProduto.sendKeys(valorProduto);
        return this;
    }
    public AdicionarProdutoPage preencherCoresProduto(String coresProduto){
        campoNomeCores.sendKeys(coresProduto);
        return this;
    }
    public AdicionarProdutoPage clicarEmSalvar(){
        botaoSalvarProduto.click();
        return this;
    }
    public ListaProdutosPage clicarListaProdutos(){
        botaoListaProdutos.click();
        return new ListaProdutosPage();
    }
}
