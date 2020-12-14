package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import constants.TestTimeOutSettings;
import driver.WebDriverUtils;
import model.BankAccount;

public class Dashboard
{
  private WebDriver driver;
  private static final Logger LOG = LoggerFactory.getLogger(Dashboard.class);

  private By navigationMenu = By.xpath("//div[@class='xnav-appbutton--body']");

  private By addNewOrganization = By.xpath("//a[contains(text(),'Add a new organisation')]");

  private By changeOrganization = By.xpath("//button[contains(text(),'Change organisation')]");

  private By accounting = By.xpath("//button[contains(text(),'Accounting')]");

  private By bankAccount = By.xpath("//a[contains(text(),'Bank accounts')]");

  private By bankAccountWidget = By.className("xdash-shared__container-toggle___4gS60");

  public Dashboard(WebDriver driver)
  {
    this.driver = driver;
  }

  public void selectNavigationMenu()
  {
    LOG.info("Dashboard: Navigation menu selected.");
    WebElement navigationMenuElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(navigationMenu));
    navigationMenuElement.click();
  }

  public void selectAddNewOrganisationOption()
  {
    LOG.info("Dashboard: Add a new organisation option selected.");
    if(!WebDriverUtils.isElementDisplayed(this.driver, addNewOrganization))
    {
      this.driver.findElement(changeOrganization).click();
    }
    this.driver.findElement(addNewOrganization).click();
  }

  public void selectAccountingOption()
  {
    LOG.info("Dashboard: Accounting navigation option selected.");
    WebElement accountingElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(accounting));
    accountingElement.click();
  }

  public void selectBankAccountOption()
  {
    LOG.info("Dashboard: Accounting navigation option selected.");
    WebElement bankAccountElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(bankAccount));
    bankAccountElement.click();
  }

  public boolean isBankAccountDisplayed(BankAccount bankDetails)
  {
    List<WebElement> listBankAccounts = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(bankAccountWidget));
    for(WebElement dashboardElement : listBankAccounts)
    {
      if(!bankDetails.getAccountType().equalsIgnoreCase("Credit Card") && dashboardElement.getText().contains(String.format("%s\n%s", bankDetails.getAccountName(), bankDetails.getAccountNumber())))
        return true;
      else
        if(bankDetails.getAccountType().equalsIgnoreCase("Credit Card") && dashboardElement.getText().contains(String.format("%s\n%s", bankDetails.getAccountName(), bankDetails.getLast4DigitsCC())))
          return true;
    }
    return false;
  }
}
