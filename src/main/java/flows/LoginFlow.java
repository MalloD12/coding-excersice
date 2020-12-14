package flows;

import org.openqa.selenium.WebDriver;
import pages.Login;
import testdata.LoginTestData;

public class LoginFlow
{
  private Login login;

  private WebDriver driver;

  public LoginFlow(WebDriver driver)
  {
    this.login = new Login(driver);
    this.driver = driver;
  }

  public DashboardFlow doLogin(LoginTestData loginCredentials)
  {
    this.login.setUsername(loginCredentials.getUserName());
    this.login.setPassword(loginCredentials.getUserPassword());
    this.login.selectLoginBtn();
    return new DashboardFlow(this.driver);
  }
}
