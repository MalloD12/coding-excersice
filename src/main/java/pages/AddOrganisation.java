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

public class AddOrganisation
{
  private WebDriver driver;
  private static final Logger LOG = LoggerFactory.getLogger(AddOrganisation.class);

  private By businessName = By.xpath("//input[@data-automationid='organisation-name--input']");

  private By industry = By.xpath("//input[@data-automationid='industry-autocompleter--input']");

  private By industryAutocompleteList = By.xpath("//div[@data-automationid='industry-autocompleter--list--scrollable-content']");

  private By country = By.xpath("//input[@data-automationid='country-autocompleter--input']");

  private By yes = By.xpath("//div[@class='xui-styledcheckboxradio-group']/div[1]/label/div");

  private By noItsJustMe = By.xpath("//div[@class='xui-styledcheckboxradio-group']/div[2]/label/div");

  private By registeredForGST = By.xpath("//div[@class='xui-styledcheckboxradio--checkbox xui-styledcheckboxradio--checkbox-small']");

  private By startTrial = By.xpath("//button[@data-automationid='NewOrgProv-StartTrial']");

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
    WebDriverUtils.clearExistentValueFromTextInputIfExist(countryElement);
    countryElement.sendKeys(countryName);
  }

  public void setHaveOrHaveNotEmployees(boolean withEmployees)
  {
    WebDriverUtils.waitCustom(1000);
    if(withEmployees)
    {
      new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.elementToBeClickable(yes)).click();
      LOG.info("Add Organisation - Select 'Yes' option.");
    }
    else
    {
      LOG.info("Add Organisation - Select 'No, it's just me' option");
      new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.elementToBeClickable(noItsJustMe)).click();
    }
  }

  public void setRegisteredForGST(boolean isRegisteredForGST)
  {
    if(!isRegisteredForGST)
    {
      LOG.info("Add Organisation - Deselect 'Yes, calculate GST on my transactions' option");
      new WebDriverWait(this.driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.elementToBeClickable(registeredForGST)).click();
    }
    else
      LOG.info("Add Organisation - Leave selected 'Yes, calculate GST on my transactions' option.");
  }

  public void selectStartTrialButton()
  {
    LOG.info("Add Organisation - Select 'Start trial' button.");
    this.driver.findElement(startTrial).click();
  }

}
