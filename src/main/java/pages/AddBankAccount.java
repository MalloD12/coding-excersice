package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import constants.TestTimeOutSettings;
import driver.WebDriverUtils;

public class AddBankAccount
{
  private WebDriver driver;
  private static final Logger LOG = LoggerFactory.getLogger(AddBankAccount.class);

  private By addBankAccount = By.xpath("//a[@id='ext-gen16']");

  private By searchYourBank = By.xpath("//input[@id='xui-searchfield-1018-inputEl']");

  private By searchBankList = By.xpath("//div[@data-automationid='searchBanksList']");

  private By accountName = By.xpath("//input[@id='accountname-1037-inputEl']");

  private By accountType = By.xpath("//input[@id='accounttype-1039-inputEl']");

  private By accountTypeList = By.xpath("//ul[@id='boundlist-1076-listEl']");

  private By continueBtn = By.xpath("//span[@id='common-button-submit-1015-btnInnerEl']");

  private By accountNumber = By.xpath("//input[@id='accountnumber-1068-inputEl']");

  private By last4DigitsCC = By.xpath("//input[@id='accountnumber-1063-inputEl']");

  private By iGotAForm = By.xpath("//span[contains(text(),\"I've got a form\")]");

  private By illDoItLater = By.xpath("//a[@data-automationid='uploadForm-uploadLaterButton']");

  private By goToDashboard = By.xpath("//a[@data-automationid='uploadFormLater-goToDashboardButton']");

  public AddBankAccount(WebDriver driver)
  {
    this.driver = driver;
  }

  public void selectAddBankAccountButton()
  {
    LOG.info("Add Bank Account - Select 'Add Bank Account' button.");
    WebElement addBankAccountElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(addBankAccount));
    addBankAccountElement.click();
  }

  public void selectBankOption(String bankBrand)
  {
    LOG.info("Add Bank Account - Select {} option from list.", bankBrand);
    WebElement searchYourBankElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(searchYourBank));
    searchYourBankElement.sendKeys(bankBrand);
    WebDriverUtils.selectOptionFromAutocompleteField(this.driver, searchBankList, bankBrand);
  }

  public void setAccountName(String bankAccountName)
  {
    LOG.info("Add Bank Account - Set Account Name as: {}.", bankAccountName);
    WebElement accountNameElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(accountName));
    accountNameElement.sendKeys(bankAccountName);
  }

  public void selectAccountType(String bankAccountType)
  {
    LOG.info("Add Bank Account - Select Account Type: {} from list.", bankAccountType);
    WebElement accountTypeElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(accountType));
    accountTypeElement.click();
    WebDriverUtils.selectOptionFromAutocompleteField(this.driver, accountTypeList, bankAccountType);
  }

  public void setCreditCardLast4Digits(String last4Digits)
  {
    LOG.info("Add Bank Account - Set Credit Card last 4 digits: {}.", last4DigitsCC);
    WebElement cc4DigitsElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(last4DigitsCC));
    cc4DigitsElement.click();
    cc4DigitsElement.sendKeys(last4Digits);
  }

  public void setAccountNumber(String bankAccountNumber)
  {
    LOG.info("Add Bank Account - Set Account Number: {}.", bankAccountNumber);
    WebElement accountNumberElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(accountNumber));
    accountNumberElement.click();
    accountNumberElement.sendKeys(bankAccountNumber);
  }

  public void selectContinueButton()
  {
    LOG.info("Add Bank Account - Select 'Continue' button.");
    WebElement continueElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(continueBtn));
    continueElement.click();
  }

  public void allowBankToSendTransactions()
  {
    //Just to simplify this part of the flow I've decided to move forward from this part by not downloading the form.
    LOG.info("Add Bank Account - Select 'I've got a form' option.");
    WebElement iGotAFormElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(iGotAForm));
    iGotAFormElement.click();
  }

  public void uploadFormLater()
  {
    //Just to simplify this part of the flow I've decided to move forward from this part by not downloading the form.
    LOG.info("Add Bank Account - Select 'I'll do it later' option.");
    WebElement illDoItLaterElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(illDoItLater));
    illDoItLaterElement.click();
  }

  public void goBackToDashboard()
  {
    LOG.info("Add Bank Account - Select 'Go to dashboard' button.");
    WebElement goToDashboardElement = new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(goToDashboard));
    goToDashboardElement.click();
  }
}
