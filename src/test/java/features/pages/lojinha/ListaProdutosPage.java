package features.pages.lojinha;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListaProdutosPage extends BasePage{
    @FindBy(xpath = "//a[text()='Adicionar produto']")
    private WebElement botaoAdicionarProduto;
    @FindBy(css = "#nav-mobile > li > a")
    private WebElement nomeUsuario;
    @FindBy(css = ".title > a")
    private WebElement tituloProduto;
    @FindBy(css = "a .material-icons")
    private WebElement botaoRemoverProduto;
    @FindBy(css = ".collection-item.avatar p")
    private WebElement valorProduto;

    public WebElement getBotaoAdicionarProduto() {
        return botaoAdicionarProduto;
    }
    public AdicionarProdutoPage clicarAdicionarProduto(){
        botaoAdicionarProduto.click();
        return new AdicionarProdutoPage();
    }
    public String capturarNomeUsuarioNaPaginaSecreta(){
        return capturarTextoDoElemento(nomeUsuario);
    }

    public String capturarTituloProduto(){
        return capturarTextoDoElemento(tituloProduto);
    }
    public ListaProdutosPage clicarEmRemoverProduto(){
        botaoRemoverProduto.click();
        return this;
    }
    public WebElement getBotaoRemoverProduto() {
        return botaoRemoverProduto;
    }
    public AdicionarProdutoPage clicarEmUmProduto(){
        tituloProduto.click();
        return new AdicionarProdutoPage();
    }
    public String capturarValorProduto(){
        return capturarTextoDoElemento(valorProduto);
    }
}
