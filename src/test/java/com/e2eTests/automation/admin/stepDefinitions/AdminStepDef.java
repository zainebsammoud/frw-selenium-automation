package com.e2eTests.automation.admin.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.e2eTests.automation.admin.pageObjects.AdminPage;
import com.e2eTests.automation.utils.Setup;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminStepDef{
	 
	public WebDriver driver;
	private AdminPage adminPage = new AdminPage();
	public AdminStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, AdminPage.class);
	}

	@When("^je clique sur le menu Admin$")
	public void jeCliqueSurLeMenuAdmin() throws Throwable {
		adminPage.clickAdminMenu();	   
	}

	@When("^je clique sur le menu User Management$")
	public void jeCliqueSurLeMenuUserManagement() throws Throwable {
		adminPage.clickUserManagementMenu();  
	}

	@When("^je saisie Username \"([^\"]*)\"$")
	public void jeSaisieUsername(String username) throws Throwable {
		adminPage.fillUsername(username);
	}

	@When("^je clique sur le bouton search$")
	public void jeCliqueSurLeBoutonSearch() throws Throwable {
		adminPage.clickSearchButton();    
	}

	@Then("^je trouve un seul employé \"([^\"]*)\"$")
	public void jeTrouveUnSeulEmployé(String username ) throws Throwable {
		String resultMessage = AdminPage.result.getText();
		Assert.assertTrue(resultMessage.contains(username));
		System.out.println("L'employé est trouvé");
	}

	@Then("^je déconnecte du compte$")
	public void jeDéconnecteDuCompte() throws Throwable {
	    
	}

}
