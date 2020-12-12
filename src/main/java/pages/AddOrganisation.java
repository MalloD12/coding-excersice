package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import driver.WebDriverUtils;

public class AddOrganisation
{
  private WebDriver driver;
  private static final Logger LOG = LoggerFactory.getLogger(AddOrganisation.class);

  private By businessName = By.xpath("//input[@data-automationid='organisation-name--input']");

  private By industry = By.xpath("//input[@data-automationid='industry-autocompleter--input']");

  private By industryAutocompleteList = By.xpath("//div[@data-automationid='industry-autocompleter--list--scrollable-content']");

  private By country = By.xpath("//input[@data-automationid='country-autocompleter--input']");

  public AddOrganisation(WebDriver driver)
  {
    this.driver = driver;
  }

  public void setBusinessName(String organisationName)
  {
    LOG.info("Add Organisation - Entering business name: {}.", organisationName);
    this.driver.findElement(businessName).sendKeys(organisationName);
  }

  public void setIndustry(String industryName)
  {
    LOG.info("Add Organisation - Entering Industry: {}.", industryName);
    WebElement industryElement = this.driver.findElement(industry);
    industryElement.sendKeys(industryName);
    WebDriverUtils.selectOptionFromAutocompleteField(this.driver, industryAutocompleteList, industryName);
  }

  public void setCountry(String countryName)
  {
    LOG.info("Add Organisation - Entering Country: {}.", countryName);
    WebElement countryElement = this.driver.findElement(country);
    countryElement.getText().length();
    countryElement.clear();
    countryElement.sendKeys(countryName);
  }
}
