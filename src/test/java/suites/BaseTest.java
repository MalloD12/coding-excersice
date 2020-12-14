package suites;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import driver.Browser;
import driver.DriverFactory;
import flows.LoginFlow;
import constants.TestTimeOutSettings;

public class BaseTest
{
  private WebDriver driver;
  protected LoginFlow loginFlow;

  @BeforeEach
  public void setUp()
  {
    driver = DriverFactory.getDriver(Browser.CHROME);
    driver.get("https://login.xero.com/identity/user/login");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(TestTimeOutSettings.NORMAL_WAIT_SECONDS, TimeUnit.SECONDS);
    loginFlow = new LoginFlow(driver);
  }

  @AfterEach
  public void tearDown(){
    driver.quit();
  }
}
