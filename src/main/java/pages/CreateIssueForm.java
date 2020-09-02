package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CreateIssueForm {


    private By projectNameField = By.id("project-field");
    private By issueTypeField = By.id("issuetype-field");
    private By summaryField = By.id("summary");
    private By reporterField = By.id("reporter-field");
    private By submitButton = By.id("create-issue-submit");
    private By popUpSuccessfulCreate = By.xpath("//*[@id='aui-flag-container']/div");


    //waiting until elements are clickable or displayed
    public boolean projectFieldIsClickable() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(30).getSeconds());
        return wait.until(elementToBeClickable(projectNameField)).isDisplayed();
    }

    public boolean issueTypeFieldIsClickable() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(30).getSeconds());
        return wait.until(elementToBeClickable(issueTypeField)).isDisplayed();
    }

    public boolean summaryFieldIsClickable() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(30).getSeconds());
        return wait.until(elementToBeClickable(summaryField)).isDisplayed();
    }

    public boolean reporterFieldIsClickable() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(30).getSeconds());
        return wait.until(elementToBeClickable(reporterField)).isDisplayed();
    }

    public boolean popUpIssueName() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(30).getSeconds());
        return wait.until(presenceOfElementLocated(popUpSuccessfulCreate)).isDisplayed();
    }

    //clearing fields
    public void clearProjectField() {
        WebDriverFactory.getDriver().findElement(projectNameField).clear();
    }

    public void clearIssueTypeField() {
        WebDriverFactory.getDriver().findElement(issueTypeField).clear();
    }

    public void clearSummaryField() {
        WebDriverFactory.getDriver().findElement(summaryField).clear();
    }

    public void clearReporterField() {
        WebDriverFactory.getDriver().findElement(reporterField).clear();
    }

    //sending string keys
    public void enterProjectName(String projectName) {
        WebDriverFactory.getDriver().findElement(projectNameField).sendKeys(projectName);
    }

    public void enterIssueTypeName(String issueTypeName) {
        WebDriverFactory.getDriver().findElement(issueTypeField).sendKeys(issueTypeName);
    }

    public void enterSummaryName(String summaryName) {
        WebDriverFactory.getDriver().findElement(summaryField).sendKeys(summaryName);
    }

    public void enterReporterName(String reporterName) {
        WebDriverFactory.getDriver().findElement(reporterField).sendKeys(reporterName);
    }

    //sending TAB to fields
    public void tabProjectName() {
        WebDriverFactory.getDriver().findElement(projectNameField).sendKeys(Keys.TAB);
    }

    public void tabIssueType() {
        WebDriverFactory.getDriver().findElement(issueTypeField).sendKeys(Keys.TAB);
    }

    public void tabSummary() {
        WebDriverFactory.getDriver().findElement(summaryField).sendKeys(Keys.TAB);
    }

    public void tabReporter() {
        WebDriverFactory.getDriver().findElement(reporterField).sendKeys(Keys.TAB);
    }

    //clicking
    public void clickSubmit() {
        WebDriverFactory.getDriver().findElement(submitButton).click();
    }

}
