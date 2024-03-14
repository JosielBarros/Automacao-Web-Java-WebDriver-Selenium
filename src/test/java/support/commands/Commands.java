package support.commands;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Commands {
    public static boolean elementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
