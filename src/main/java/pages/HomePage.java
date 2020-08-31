package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {

  public boolean onPage(){
    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
    return wait.until(presenceOfElementLocated(By.id("browse_link"))).isDisplayed();
  }
}
