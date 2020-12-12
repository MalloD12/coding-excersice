package flows;

import org.openqa.selenium.WebDriver;

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

}
