package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage {

    private By userNameInput = By.id("login-form-username");
    private By passwordInput = By.id("login-form-password");
    private By loginButton = By.id("login");
    private String message = "Sorry, your username and password are incorrect - please try again.";
    private By errorMessage = By.xpath("//*[text()[contains(.,'" + message + "')]]");

    public void enterUserName(String name) {
        WebDriverFactory.getDriver().findElement(userNameInput).clear();
        WebDriverFactory.getDriver().findElement(userNameInput).sendKeys(name);
    }

    public void enterPassword(String password) {
        WebDriverFactory.getDriver().findElement(passwordInput).sendKeys(password);
    }

    public boolean errorMessageIsPresent(String message) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(30).getSeconds());
        return wait.until(presenceOfElementLocated(errorMessage)).isDisplayed();
    }
    public void clickLogin() {
        WebDriverFactory.getDriver().findElement(loginButton).click();
    }

    public void navigateTo() {
        WebDriverFactory.getDriver().get("https://jira.hillel.it/secure/Dashboard.jspa");
    }
}
