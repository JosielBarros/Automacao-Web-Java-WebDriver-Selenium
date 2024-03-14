package features.pages.lojinha;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.hooks.Environment;

public class LoginPage extends BasePage{
    @FindBy(id = "usuario")
    private WebElement campoUsuario;
    @FindBy(id = "senha")
    private WebElement campoSenha;
    @FindBy(css = "button[type=submit]")
    private WebElement botaoEntrar;
    public LoginPage(){
        Environment.browser.get(super.BASE_URL);
    }
    public LoginPage preencherFormularioLogin(String usuario, String senha) {
        campoUsuario.sendKeys(usuario);
        campoSenha.sendKeys(senha);
        return this;
    }
    public ListaProdutosPage submeterFormulario(){
        botaoEntrar.click();
        return new ListaProdutosPage();
    }
}
