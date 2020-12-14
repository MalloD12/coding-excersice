package flows;

import org.openqa.selenium.WebDriver;
import model.Organisation;
import pages.AddOrganisation;

public class AddNewOrganisationFlow
{
  private WebDriver driver;

  private AddOrganisation addOrganisation;

  public AddNewOrganisationFlow(WebDriver driver)
  {
    addOrganisation = new AddOrganisation(driver);
    this.driver = driver;
  }

  public DashboardFlow addNewOrganization(Organisation organisation)
  {
    addOrganisation.setBusinessName(organisation.getBusinessName());
    addOrganisation.setIndustry(organisation.getIndustry());
    addOrganisation.setCountry(organisation.getCountry());
    addOrganisation.setHaveOrHaveNotEmployees(organisation.isHasEmployees());
    addOrganisation.setRegisteredForGST(organisation.isRegisteredForGST());
    addOrganisation.selectStartTrialButton();
    return new DashboardFlow(this.driver);
  }
}
