package com.e2eTests.automation.authentication.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.e2eTests.automation.authentication.pageObjects.AuthenticationPage;
import com.e2eTests.automation.utils.CommonMethods;
import com.e2eTests.automation.utils.Setup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthenticationStepDef extends CommonMethods{

	public WebDriver driver;
	private AuthenticationPage authenticationPage = new AuthenticationPage();
	private CommonMethods commonMethods = new CommonMethods();
	public AuthenticationStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, AuthenticationPage.class);
	}

	@Given("^je me connecte sur l'application Orange HRM$")
	public void jeMeConnecteSurLApplicationOrangeHRM() throws Throwable {
		logger.info("je me connecte sur l'application Orange");
		commonMethods.openURLWithConfigFile("url1");
	}

	@When("^je saisie username \"([^\"]*)\"$")
	public void jeSaisieUsername(String username) throws Throwable {
		logger.info("je saisie username");
		authenticationPage.fillUsername(username);
	}

	@When("^je saisie le mot de passe \"([^\"]*)\"$")
	public void jeSaisieLeMotDePasse(String pswd) throws Throwable {
		logger.info("je saisie le mot de passe");
		authenticationPage.fillPassword(pswd);
	}

	@When("^je clique sur le bouton login$")
	public void jeCliqueSurLeBoutonLogin() throws Throwable {
		logger.info("je clique sur le bouton login");
		authenticationPage.clickLoginButton();
	}

	@Then("^je me redirige vers la page home \"([^\"]*)\"$")
	public void jeMeRedirigeVersLaPageHome(String message) throws Throwable {
		logger.info("je me redirige vers la page home");
		String messageToWelcome = AuthenticationPage.welcome.getText();
		Assert.assertTrue(messageToWelcome.contains(message));
	}

}
