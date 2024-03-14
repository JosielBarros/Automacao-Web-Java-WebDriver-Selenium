package support.hooks;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Environment {
    public static WebDriver browser;
    public static void initializeDriver() throws Exception {
        String navegador = System.getProperty("browser");
        if (navegador == null){
            navegador = "chrome";
        }
        switch (navegador){
            case "chrome":
                browser = new ChromeDriver();
                break;
            case "chrome-ci":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                browser = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
                browser = new EdgeDriver();
                break;
            default:
                throw new Exception("Não há implementação para o browser " + browser + ".");
        }
        configBrowser();
    }
    public static void configBrowser(){
        String mobile = System.getProperty("mobile");
        int largura = (Objects.equals(mobile, "true") ? 360 : 1366);
        int altura = (Objects.equals(mobile, "true") ? 740 : 768);
        browser.manage().window().setSize(new Dimension(largura, altura));
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
