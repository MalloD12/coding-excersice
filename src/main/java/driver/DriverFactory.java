package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

  public static WebDriver getDriver(Browser browser)
  {
    switch (browser) {
      case CHROME:
        System.setProperty("webdriver.chrome.driver",
            System.getProperty("user.dir") + "/automationDrivers/chromedriver.exe");
        return new ChromeDriver();
      case FIREFOX:
        System.setProperty("webdriver.gecko.driver",
            System.getProperty("user.dir") + "/automationDrivers/geckodriver.exe");
        return new FirefoxDriver();
    }
    return null;
  }

}

