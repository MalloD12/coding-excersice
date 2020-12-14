package flows;

import org.openqa.selenium.WebDriver;
import model.BankAccount;
import pages.AddBankAccount;

public class AddBankAccountFlow
{
  private WebDriver driver;
  private AddBankAccount addBankAccount;

  public AddBankAccountFlow(WebDriver driver)
  {
    this.driver = driver;
    addBankAccount = new AddBankAccount(driver);
  }

  public AddBankAccountFlow addBankAccount(BankAccount bankAccount)
  {
    addBankAccount.selectAddBankAccountButton();
    addBankAccount.selectBankOption(bankAccount.getBankBrand());
    addBankAccount.setAccountName(bankAccount.getAccountName());
    addBankAccount.selectAccountType(bankAccount.getAccountType());
    if(bankAccount.getAccountType().equalsIgnoreCase("Credit Card"))
      addBankAccount.setCreditCardLast4Digits(bankAccount.getLast4DigitsCC());
    else
      addBankAccount.setAccountNumber(bankAccount.getAccountNumber());
    addBankAccount.selectContinueButton();
    addBankAccount.allowBankToSendTransactions();
    addBankAccount.uploadFormLater();
    return this;
  }

  public DashboardFlow goBackToDashboard()
  {
    addBankAccount.goBackToDashboard();
    return new DashboardFlow(this.driver);
  }
}
