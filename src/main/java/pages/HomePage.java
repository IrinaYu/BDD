package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {
  private By userNameDisplay = By.id("header-details-user-fullname");
  private By createButton = By.id("create_link");
  private By projectNameField = By.id("project-field");

  public boolean onPage(){
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(30).getSeconds());
    return wait.until(presenceOfElementLocated(userNameDisplay)).isDisplayed();
  }

  private void clickOnElementWithRetry(By elementToBeClicked, By successCriteriaElement, int attempts, int timeOutInSeconds) {
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), timeOutInSeconds);
    for (int i = 0; i < attempts; i++) {
      try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successCriteriaElement)).isDisplayed();
        break;
      } catch (TimeoutException e) {
        wait.until(ExpectedConditions.elementToBeClickable(elementToBeClicked));
        WebDriverFactory.getDriver().findElement(elementToBeClicked).click();
      }
      // break - прервёт только цикл
    }

  }

  public void clickCreate() {
    clickOnElementWithRetry(createButton, projectNameField, 3, 30);
  }
}
