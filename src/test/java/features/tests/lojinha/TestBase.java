package features.tests.lojinha;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import support.hooks.Environment;

import static support.hooks.Environment.initializeDriver;

public class TestBase {
    @BeforeEach
    public void setUp() throws Exception {
        initializeDriver();
    }
    @AfterEach
    public void tearDown(){
        Environment.browser.quit();
    }
}
