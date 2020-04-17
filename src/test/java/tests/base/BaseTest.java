package tests.base;

import browser.Browser;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {

    @Parameters("driver-name")
    @BeforeClass
    public void setUp(String browserName) throws MalformedURLException {
        WebDriver driver = Browser.getInstance().getRemoteDriver(browserName);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        open("https://www.st.by/");
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}
