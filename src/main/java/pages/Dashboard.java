package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Organisation;

public class Dashboard
{
  private WebDriver driver;
  private static final Logger LOG = LoggerFactory.getLogger(Dashboard.class);

  private By navigationMenu = By.xpath(String.format("//span[contains(text(),'%s')]", Organisation.getParentOrganisation()));
  private By addNewOrganization = By.xpath("//a[contains(text(),'Add a new organisation')]");

  public Dashboard(WebDriver driver)
  {
    this.driver = driver;
  }

  public void selectNavigationMenu()
  {
    LOG.info("Dashboard: Navigation menu selected.");
    this.driver.findElement(navigationMenu).click();
  }

  public void selectAddNewOrganisationOption()
  {
    LOG.info("Dashboard: Add a new organisation option selected.");
    this.driver.findElement(addNewOrganization).click();
  }
}
