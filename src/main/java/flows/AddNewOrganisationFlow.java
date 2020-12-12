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

  public void addNewOrganization(Organisation organisation)
      throws InterruptedException
  {
    addOrganisation.setBusinessName(organisation.getBusinessName());
    addOrganisation.setIndustry(organisation.getIndustry());
    addOrganisation.setCountry(organisation.getCountry());
  }
}
