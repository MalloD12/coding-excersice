package driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.TestTimeOutSettings;

public final class WebDriverUtils
{
  public static boolean isElementDisplayed(WebDriver driver, By locator)
  {
    boolean isDisplayed;
    driver.manage().timeouts().implicitlyWait(TestTimeOutSettings.MIN_WAIT_SECONDS, TimeUnit.SECONDS);
    try
    {
      WebElement element = driver.findElement(locator);
      isDisplayed = element.isDisplayed();
    }
    catch (NoSuchElementException e)
    {
      isDisplayed = false;
    }
    driver.manage().timeouts().implicitlyWait(TestTimeOutSettings.NORMAL_WAIT_SECONDS, TimeUnit.SECONDS);

    return isDisplayed;
  }

  public static void selectOptionFromAutocompleteField(WebDriver driver, By locator, String value)
  {
    WebElement element = new WebDriverWait(driver, TestTimeOutSettings.NORMAL_WAIT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(locator));
    List<WebElement> listOptions = element.findElements(By.tagName("li"));
    for(WebElement option : listOptions)
    {
      if(option.getText().contains(value))
      {
        option.click();
        break;
      }
    }
  }
}
