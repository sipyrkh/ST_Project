package browser;

import com.codeborne.selenide.Browsers;
import exceptions.InvalidBrowserException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.JsonReader.getBrowserParameter;

public class Browser {

    private static Browser instanceDriver = null;
    private static WebDriver driver;

    public WebDriver getDriver(String browserName) {
        try {
            switch (browserName.toLowerCase()) {
                case Browsers.CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case Browsers.FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case Browsers.IE:
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new InvalidBrowserException("Invalid browser name entered!");
            }
        } catch (InvalidBrowserException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public RemoteWebDriver getRemoteDriver(String browserName) throws MalformedURLException {
        DesiredCapabilities capabilities = null;
        try {
            switch (browserName.toLowerCase()) {
                case Browsers.CHROME:
                    capabilities = DesiredCapabilities.chrome();
                    break;
                case Browsers.FIREFOX:
                    capabilities = DesiredCapabilities.firefox();
                    break;
                case Browsers.IE:
                    capabilities = DesiredCapabilities.internetExplorer();
                    break;
                default:
                    throw new InvalidBrowserException("Invalid remote browser name entered!");
            }
        } catch (InvalidBrowserException e) {
            e.printStackTrace();
        }
        return new RemoteWebDriver(new URL(getBrowserParameter("hubUrl")), capabilities);
    }

    public static Browser getInstance() {
        if (instanceDriver == null) {
            instanceDriver = new Browser();
        }
        return instanceDriver;
    }
}
