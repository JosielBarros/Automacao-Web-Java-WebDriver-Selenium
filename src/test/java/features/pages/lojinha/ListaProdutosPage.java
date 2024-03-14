package features.pages.lojinha;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListaProdutosPage extends BasePage{
    @FindBy(xpath = "//a[text()='Adicionar produto']")
    private WebElement botaoAdicionarProduto;
    @FindBy(css = "#nav-mobile > li > a")
    private WebElement nomeUsuario;

    public WebElement getBotaoAdicionarProduto() {
        return botaoAdicionarProduto;
    }
    public AdicionarProdutoPage clicarAdicionarProduto(){
        botaoAdicionarProduto.click();
        return new AdicionarProdutoPage();
    }
    public String capturarNomeUsuarioNaPaginaSecreta(){
        return nomeUsuario.getText();
    }
}
