package stepdefinition;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CreateIssueForm;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;


public class StepDefinitions {

    @Before
    public void beforeCucumberScenario(Scenario scenario) {
        WebDriverFactory.createInstance("Chrome");
    }

    @After
    public void afterCucumberScenario(Scenario scenario) {
        if (scenario.getStatus().toString().contains("FAILED")) {
            try {
                takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WebDriverFactory.getDriver().close();
    }

    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
        System.out.println("SAVING Screenshot to " + trgtFile.getAbsolutePath());
        trgtFile.getParentFile().mkdir();
        trgtFile.createNewFile();
        Files.copy(scrFile, trgtFile);
    }

    @Then("^I navigate to Jira Login Page$")
    public void navigateToLoginPage() {
        new LoginPage().navigateTo();
    }

    @Then("^I enter user name - \"(.*?)\"$")
    public void enterUserName(String userName) {
        new LoginPage().enterUserName(userName);
    }

    @Then("^I enter password - \"(.*?)\"$")
    public void enterPassword(String password) {
        new LoginPage().enterPassword(password);
    }

    @Then("^I click on the login button$")
    public void clickLoginButton() {
        new LoginPage().clickLogin();
    }

    @When("^I am on the Home Page$")
    public void atTheHomePage() {
        assert new HomePage().onPage();
    }

    @When("^I debug$")
    public void debug() {
        int a = 0;
    }

    @When("^I click Create button$")
    public void clickCreate() {
        new HomePage().clickCreate();
    }

    @Then("^I am in the Create Issue form$")
    public void projectFieldIsClickable() {
        new CreateIssueForm().projectFieldIsClickable();
    }

    @When("^I fill Project field - \"(.*?)\"$")
    public void fillProjectField(String projectName) {
        new CreateIssueForm().projectFieldIsClickable();
        new CreateIssueForm().clearProjectField();
        new CreateIssueForm().enterProjectName(projectName);
        new CreateIssueForm().tabProjectName();

    }

    @Then("^I fill Issue Type field - \"(.*?)\"$")
    public void fillIssueTypeField(String issueTypeName) {
        new CreateIssueForm().issueTypeFieldIsClickable();
        new CreateIssueForm().clearIssueTypeField();
        new CreateIssueForm().enterIssueTypeName(issueTypeName);
        new CreateIssueForm().tabIssueType();
    }

    @Then("^I fill Summary field - \"(.*?)\"$")
    public void fillSummaryField(String summaryName) {
        new CreateIssueForm().summaryFieldIsClickable();
        new CreateIssueForm().clearSummaryField();
        new CreateIssueForm().enterSummaryName(summaryName);
        new CreateIssueForm().tabSummary();
    }

    @Then("^I fill Reporter field - \"(.*?)\"$")
    public void fillReporterField(String reporterName) {
        new CreateIssueForm().reporterFieldIsClickable();
        new CreateIssueForm().clearReporterField();
        new CreateIssueForm().enterReporterName(reporterName);
        new CreateIssueForm().tabReporter();
    }

    @When("^I click Submit button$")
    public void clickSubmit() {
        new CreateIssueForm().clickSubmit();
    }

    @Then("^Pop up with number of created issue is shown$")
    public void popUpIsDisplayed() {
        new CreateIssueForm().popUpIssueName();
    }

    @Then("^I enter user \"([^\"]*)\"$")
    public void enterUserNameForLogin(String nameLogin) {
        new LoginPage().enterUserName(nameLogin);

    }

    @Then("^I enter \"([^\"]*)\"$")
    public void enterUserPasswordForLogin(String passwordLogin) {
        new LoginPage().enterPassword(passwordLogin);
    }

    @Then("^I see \"([^\"]*)\"$")
    public void result(String message) {
        if (new LoginPage().errorMessageIsPresent(message)) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Failed");
        }
    }
}