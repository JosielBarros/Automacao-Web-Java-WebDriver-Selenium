package features.pages.lojinha;
import org.openqa.selenium.support.PageFactory;
import support.hooks.Environment;

public class BasePage {
    protected final String BASE_URL = "http://165.227.93.41/lojinha-web/v2/";
    protected BasePage(){
        PageFactory.initElements(Environment.browser, this);
    }
}
