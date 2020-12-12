package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    this.driver.findElement(username).sendKeys(userEmail);
  }

  public void setPassword(String userPassword)
  {
    LOG.info("Login - Entering user password: {}", userPassword);
    this.driver.findElement(password).sendKeys(userPassword);
  }

  public void selectLoginBtn()
  {
    LOG.info("Login - Log in button selected.");
    this.driver.findElement(loginBtn).click();
  }

}
