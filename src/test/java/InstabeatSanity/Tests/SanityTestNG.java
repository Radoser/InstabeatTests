package InstabeatSanity.Tests;

import instabeat.dashboard.HeartRateZonesPage;
import instabeat.dashboard.HomePage;
import instabeat.dashboard.ProfilePage;
import instabeat.dashboard.ProfilePageSettings;
import instabeat.pages.ForgotPasswordPage;
import instabeat.pages.ForgotPasswordPageResults;
import instabeat.pages.GetSartedFirstStep;
import instabeat.pages.GetStartedPage;
import instabeat.pages.GetStartedSecondStep;
import instabeat.pages.GetStartedThirdStep;
import instabeat.pages.LoginPage;
import instabeat.pages.ResetPasswordPage;
import instabeat.utils.Utils;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class SanityTestNG extends AbstractTestClass {


	@Test(priority = 0, enabled = false)
	public void checkAllLinksOnWebPage() {
		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.checkAllLinksFromLoginPage();
	}

	@Test(priority = 1, enabled = false)
	public void UserCanLogin() {
		
		LoginPage onLoginPage = new LoginPage(driver);
		
		onLoginPage.verifyPageTitle();
		onLoginPage.verifyLoginPage();

		onLoginPage.typeUserEmail();
		onLoginPage.typeUserPassword();
		onLoginPage.LoginButton();
		
		onLoginPage.isUserLoggedIn();

		onLoginPage.logout();
		Utils.waitPage();
	}

	@Test(priority = 2, enabled = false)
	public void UserCannotLogin() {
		
		LoginPage onLoginPage = new LoginPage(driver);
		
		onLoginPage.verifyPageTitle();
		
		onLoginPage.typeWrongUserEmail();
		onLoginPage.typeUserPassword();
		onLoginPage.LoginButton();

		Utils.waitPage();
		AssertJUnit.assertTrue(onLoginPage
				.verifyPageContent("Incorrect username or password"));
	}

	/*
	 * @Test public void UserForgotPassword () throws IOException { LoginPage
	 * onLoginPage = new LoginPage(driver); ForgotPasswordPage
	 * onForgotPasswordPage = onLoginPage.clickOnForgotPasswordLink();
	 * 
	 * onForgotPasswordPage.typeExistingUserEmail(); ForgotPasswordPageResults
	 * onForgotPasswordPageResults = onForgotPasswordPage.clickOnResetButton();
	 * 
	 * //Assert.assertTrue(onForgotPasswordPageResults.verifyTextPresent(
	 * "testusergl@ukr.net"));
	 * //Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='emailholder']"
	 * )).getText().contains("testusergl@ukr.net"));
	 * org.instabeat.sanity.utils.Utils.waitPage();
	 * Assert.assertTrue(onForgotPasswordPageResults.checkUserEmail());
	 * 
	 * GoToEmail onEmail =
	 * onForgotPasswordPageResults.getConfirmationFromEmail();
	 * 
	 * onEmail.getConfirmationFromEmailTest();
	 * 
	 * ResetPasswordPage onResetPasswordPage = onEmail.clickOnConfirmLink();
	 * 
	 * org.instabeat.sanity.utils.Utils.waitPage();
	 * 
	 * Assert.assertTrue(onResetPasswordPage.resetPasswordConfirmText());
	 * 
	 * onResetPasswordPage.typeNewPassword();
	 * onResetPasswordPage.typeConfirmPassword();
	 * onResetPasswordPage.afterResetPassword(); Utils.delay(3000);
	 * Assert.assertTrue(onLoginPage.verifyLoginPage());
	 * 
	 * }
	 */

	@Test(priority = 4, enabled = true)
	public void UserCanRegister() throws Exception {
		
		LoginPage onLoginPage = new LoginPage(driver);
		GetStartedPage onGetStartedPage = onLoginPage.clickOnGetStartedLink();
		
		/*First step of register*/
		onGetStartedPage.typeUserValues();
		GetSartedFirstStep onGetSartedFirstStep = onGetStartedPage
				.clickOnSignUpButton();
		Utils.waitPage();

		AssertJUnit.assertTrue(onGetSartedFirstStep
				.checkUserEmail(onGetStartedPage.randomUser));
		
		/*Second step of register*/
		GetStartedSecondStep onGetStartedSecondStep = onGetSartedFirstStep
				.getConfirmationLink();
		onGetStartedSecondStep.printPageTitle();
		onGetStartedSecondStep.verifyGetInstabeatConnectText();
		onGetStartedSecondStep.downloadApp();
		
		/*Login from App*/
		GetStartedThirdStep onGetStartedThirdStep = onGetStartedSecondStep
				.loginByApp(onGetStartedPage.randomUser);
		onGetStartedThirdStep.printPageTitle();
		onGetStartedThirdStep.verifyTextPresentOnPage();
		
		/*Third step of register*/
		onGetStartedThirdStep.typeRHRValue();
		onGetStartedThirdStep.clickOnCalculateButton();
		HomePage onHomePage = onGetStartedThirdStep.clickOnUpdateButton(); 
		onHomePage.isCongratsPresent();
		onHomePage.isHomePagePresent();
				
		Utils.delay(5000);
		onLoginPage.logout();
		
		/*Check if registered random user can login*/
		onLoginPage.typeUserAfterRegister(onGetStartedPage.randomUser);
		onLoginPage.typeUserPassword();
		onLoginPage.LoginButton();
		
		/*Delete random user*/
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		onProfilePageSettings.clickOnDeleteAccountButton();
		onProfilePageSettings.clickOnCancelButton();
		onProfilePageSettings.clickOnDeleteAccountButton();
		onProfilePageSettings.confirmDeleteAccout();
		
		Utils.waitPage();
	}

	@Test(priority = 3, enabled = true)
	public void UserForgotPassword() throws Exception {

		LoginPage onLoginPage = new LoginPage(driver);
		ForgotPasswordPage onForgotPasswordPage = onLoginPage
				.clickOnForgotPasswordLink();
		
		/*Forgot password page --> type user email*/
		onForgotPasswordPage.typeExistingUserEmail();
		ForgotPasswordPageResults onForgotPasswordPageResults = onForgotPasswordPage
				.clickOnResetButton();

		Utils.waitPage();
		Assert.assertTrue(onForgotPasswordPageResults.checkUserEmail());

		/*Get confirm message from email*/
		ResetPasswordPage onResetPasswordPage = onForgotPasswordPageResults
				.getConfirmationFromEmailIMAP();

		Assert.assertTrue(onResetPasswordPage.resetPasswordConfirmText());
		
		/*Reset password page --> new password*/
		onResetPasswordPage.typeNewPassword();
		onResetPasswordPage.typeConfirmPassword();
		onResetPasswordPage.afterResetPassword();
		Utils.delay(3000);
		onLoginPage.verifyLoginPage();
		Utils.waitPage();
	}
	
//	need to fix dates with id "...old"
	@Test(priority = 5, enabled = true)
	public void UserCanChooseExistSession() {

		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Assert.assertTrue(onHomePage.isHomePagePresent());
		onHomePage.isCalendarButtonPresent();

		onHomePage.cliclOnCalendarButton();
//		need assert
		onHomePage.isDateWithSessionsPresent();
//		assert if menu present
		onHomePage.clickOnContextMenu();
		onHomePage.clickOnSession();

		Utils.waitPage();
		onHomePage.logout();
	}
	
	@Test(priority = 6, enabled = true)
	public void UserCanUpdateProfile() throws IOException{
		
		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.typeUserEmail();
		onLoginPage.typeUserPassword();

		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
	
		onProfilePage.updateFirstNameField();		
		onProfilePage.updateLastNameField();
		onProfilePage.updateBirthdateField();
		onProfilePage.clickOnUpdateButton();
		onProfilePage.changeFitnessLevel();
		
		Utils.delay(1000);
		
		onProfilePage.checkMessageAboutUpdate();
		Assert.assertTrue(onProfilePage.checkIconToSyncDevice());
		onProfilePage.isUserTitleNameEqualsUserName();
		
		onProfilePage.updateUserPicture();
		
		onProfilePage.logout();
	}
	
	@Test(priority = 7, enabled = true)
	public void userCanChangePassword(){
		
		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		

		onProfilePageSettings.typeOldPassword();
		onProfilePageSettings.typeNewPassword();
		onProfilePageSettings.typeConfirmNewPassword();
		
		onProfilePageSettings.clickOnUpdateButton();
		//need to chech suc message
		onProfilePageSettings.logout();
	}
	
	@Test(priority = 8, enabled = true)
	public void userCanUpdateProfileSettings(){
		
		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		
//		need to finish -->choose a timezonee randomly
		onProfilePageSettings.changeUTC();
		
		onProfilePageSettings.clickOnUpdateButton();
		Utils.delay(2000);
		onProfilePageSettings.changeMetrics();
		onProfilePageSettings.logout();
	}
	
	@Test(priority = 9, enabled = true)
	public void userCanDeleteAllSessions(){
		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		
		onProfilePageSettings.clickOnEraseDataButton();
		onProfilePageSettings.checkIfEraseWindowOpened();
		onProfilePageSettings.clickOnCancelButton();
		onProfilePageSettings.clickOnEraseDataButton();
		onProfilePageSettings.confirmEraseAllSessions();
		
		Utils.delay(2000);
		onHomePage.isDateWithSessionsPresent();
		Utils.waitPage();
		
		onHomePage.logout();
	}
	
	
	@Test(priority = 10, enabled = true)
	public void userCanUpdateHRZPage(){
		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		HeartRateZonesPage onHeartRateZonesPage = onHomePage.clickOnHRZTab();
		
		/*Change heart rate using RHR field*/
		onHeartRateZonesPage.typeRHR();
		onHeartRateZonesPage.clickOnCalculateButton();
		onHeartRateZonesPage.clickOnUpdateButton();
		Utils.delay(2000);
		onHeartRateZonesPage.isSuccessMessagePresent();
		
		/*Change heart rate in boxes randomly*/
		onHeartRateZonesPage.typeHeartRateIntoBoxes();
		Utils.waitPage();
		onHeartRateZonesPage.clickOnUpdateButton();
		onHeartRateZonesPage.isSuccessMessagePresent();
		
		onHeartRateZonesPage.logout();
		
	}

}
