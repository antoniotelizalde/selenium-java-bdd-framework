package com.ui.interview.drivers;

import com.ui.interview.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

    public static WebDriver createDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();

        WebDriver driver = switch (browser) {
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                yield new EdgeDriver(edgeOptions);
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                yield new ChromeDriver(chromeOptions);
            }
            default -> throw new RuntimeException("browser not supported" + browser);
        };
        driver.manage().window().maximize();
        return driver;
    }
}
