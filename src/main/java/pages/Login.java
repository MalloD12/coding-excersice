package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import constants.TestTimeOutSettings;

public class Login
{
  private WebDriver driver;

  private By username = By.id("xl-form-email");

  private By password = By.id("xl-form-password");

  private By loginBtn = By.id("xl-form-submit");

  private static final Logger LOG = LoggerFactory.getLogger(Login.class);

  public Login(WebDriver driver)
  {
    this.driver =  driver;
  }

  public void setUsername(String userEmail)
  {
    LOG.info("Login - Entering user email: {}", userEmail);
    WebElement usernameElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(username));
    usernameElement.sendKeys(userEmail);
  }

  public void setPassword(String userPassword)
  {
    LOG.info("Login - Entering user password: {}", userPassword);
    WebElement passwordElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(password));
    passwordElement.sendKeys(userPassword);
  }

  public void selectLoginBtn()
  {
    LOG.info("Login - Log in button selected.");
    WebElement loginBtndElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
    loginBtndElement.click();
  }

}
