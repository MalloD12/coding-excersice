package flows;

import org.openqa.selenium.WebDriver;
import model.BankAccount;
import pages.Dashboard;

public class DashboardFlow
{
  private WebDriver driver;
  private Dashboard dashboard;

  public DashboardFlow(WebDriver driver)
  {
    dashboard = new Dashboard(driver);
    this.driver = driver;
  }

  public DashboardFlow selectOrganizationNavMenu()
  {
    dashboard.selectNavigationMenu();
    return this;
  }

  public AddNewOrganisationFlow selectAddNewOrganisationOption()
  {
    dashboard.selectAddNewOrganisationOption();
    return new AddNewOrganisationFlow(this.driver);
  }

  public AddBankAccountFlow navigateToBankAccountManagement()
  {
    dashboard.selectAccountingOption();
    dashboard.selectBankAccountOption();
    return new AddBankAccountFlow(this.driver);
  }

  public boolean bankAccountAddedDisplaysOnDashboard(BankAccount bankDetails)
  {
    //TODO: Verify if dashboard displays
    return dashboard.isBankAccountDisplayed(bankDetails);
  }
}
