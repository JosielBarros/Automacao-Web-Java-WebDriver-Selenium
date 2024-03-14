package support.commands;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.hooks.Environment;

public class WaitCommands {
    public static void waitElementBeClickable(WebElement element, Integer time) {
        WebDriverWait wait = new WebDriverWait(Environment.browser, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
