package utils;

import constants.Browser;
import constants.DriverProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import utils.exceptions.DriverSetupException;
import utils.exceptions.PropertyFileException;

import java.util.Objects;


public class Environment {

    private WebDriver driver;


    public Environment() {
        Config config = new Config(DriverProperty.FILE_PATH.value);
        String browserLabel = config.get(DriverProperty.BROWSER.value);
        String versionLabel = config.get(DriverProperty.VERSION.value);
        Browser browser = null;
        try {
            browser = getBrowserType(browserLabel);
        } catch (PropertyFileException pfex) {
            pfex.printStackTrace();
        }
        setupDriver(Objects.requireNonNull(browser), versionLabel);
    }


    public WebDriver getDriver() {
        return driver;
    }


    private void setupDriver(Browser browser, String version) {
        switch(browser) {
            case CHROME:
                WebDriverManager.chromedriver().version(version).setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().version(version).setup();
                driver = new FirefoxDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().version(version).setup();
                driver = new OperaDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().version(version).setup();
                driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().version(version).setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                try {
                    throw new DriverSetupException("Environment class has no option to setup driver pointed in property file.");
                } catch (DriverSetupException dsex) {
                    dsex.printStackTrace();
                }
        }
    }


    private Browser getBrowserType(String browserString) throws PropertyFileException {
        for(Browser browser : Browser.values()) {
            if(browser.value.equals(browserString))
                return browser;
        }
        throw new PropertyFileException("Invalid driver label has been pointed in property file.");
    }
}