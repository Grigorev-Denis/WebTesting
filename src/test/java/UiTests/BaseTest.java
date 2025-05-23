package UiTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

abstract public class BaseTest {
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        browser = "chrome";
        pageLoadTimeout = 120000;
        browserSize = "1920x1080";
        headless = false;
        timeout = 10000;
    }

    @BeforeEach
    public void init(){
        setUp();
        clearBrowserCache();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

}
