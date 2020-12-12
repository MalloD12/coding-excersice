package suites;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import driver.Browser;
import driver.DriverFactory;
import flows.LoginFlow;
import constants.TestTimeOutSettings;

public class BaseTest
{
  private WebDriver driver;
  protected LoginFlow loginFlow;

  @BeforeAll
  public void setUp()
  {
    driver = DriverFactory.getDriver(Browser.CHROME);
    driver.get("https://login.xero.com/identity/user/login");
    driver.manage().timeouts().implicitlyWait(TestTimeOutSettings.NORMAL_WAIT_SECONDS, TimeUnit.SECONDS);
    loginFlow = new LoginFlow(driver);
  }

  @AfterAll
  public void tearDown(){
    driver.quit();
  }
}
