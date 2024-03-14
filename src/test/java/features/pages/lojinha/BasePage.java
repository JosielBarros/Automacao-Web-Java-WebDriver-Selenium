package features.pages.lojinha;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.hooks.Environment;

import static support.commands.Commands.elementVisible;

public class BasePage {
    @FindBy(css = ".toast.rounded")
    private WebElement tostMensagem;
    protected final String BASE_URL = "http://165.227.93.41/lojinha-web/v2/";
    protected BasePage(){
        PageFactory.initElements(Environment.browser, this);
    }
    public String capturarMensagem() {
        return tostMensagem.getText();
    }
    public boolean elementoVisivel(WebElement elemento) {
        return elementVisible(elemento);
    }
}
