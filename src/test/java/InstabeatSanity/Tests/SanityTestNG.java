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
import org.testng.annotations.Test;

public class SanityTestNG extends AbstractTestClass /*ParallelBrowserSanity*/ {
	
	
		
	@Test(priority = 0, enabled = false)
	public void checkAllLinksOnWebPage() {
		Utils.Log.info("<<========Started running=====<<");
		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.checkAllLinksFromLoginPage();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}

	@Test(priority = 1, enabled = false)
	public void UserCanLogin() {
		Utils.Log.info("<<========Started running=====<<");
		LoginPage onLoginPage = new LoginPage(driver);
		
		onLoginPage.verifyPageTitle();
		onLoginPage.verifyLoginPage();

		Utils.Log.info("|Typing user credentials...");
		onLoginPage.typeUserEmail();
		onLoginPage.typeUserPassword();
		onLoginPage.LoginButton();
		
		Utils.Log.info("|Checking if user successfully logged in");
		onLoginPage.isUserLoggedIn();

		Utils.Log.info("|Logging out...");
		onLoginPage.logout();
		Utils.waitPage();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
//		throw new SkipException("Skipping - This is not ready for testing ");
	}

	@Test(priority = 2, enabled = false)
	public void UserCannotLogin() {
		Utils.Log.info("<<========Started running=====<<");
		LoginPage onLoginPage = new LoginPage(driver);
		
		onLoginPage.verifyPageTitle();
		
		Utils.Log.info("|Typing wrong user credentials...");
		onLoginPage.typeWrongUserEmail();
		onLoginPage.typeUserPassword();
		onLoginPage.LoginButton();

		Utils.waitPage();
		Utils.Log.info("|Checking if error message appear");
		Assert.assertTrue(onLoginPage
				.verifyPageContent("Incorrect username or password"));
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 4, enabled = false)
	public void UserCanRegister() throws Exception {
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		GetStartedPage onGetStartedPage = onLoginPage.clickOnGetStartedLink();
		
		/*First step of register*/
		Utils.Log.info("|Filling in user data...");
		onGetStartedPage.typeUserValues();
		
		Utils.Log.info("|Chossing user's date of birth...");
		onGetStartedPage.chooseMonthOfBitrh();
		onGetStartedPage.chooseDayOfBitrh();
		onGetStartedPage.chooseYearOfBitrh();
		
		Utils.Log.info("|Chossing user's country...");
		onGetStartedPage.chooseCountry();
		
		GetSartedFirstStep onGetSartedFirstStep = onGetStartedPage.clickOnSignUpButton();
		Utils.waitPage();
		Utils.Log.info("|Checking user email");
		Assert.assertTrue(onGetSartedFirstStep.checkUserEmail(onGetStartedPage.randomUser));
		
		/*Second step of register*/
		Utils.Log.info("|Getting confirmation link from IMAP server...");
		GetStartedSecondStep onGetStartedSecondStep = onGetSartedFirstStep.getConfirmationLink();
		onGetStartedSecondStep.printPageTitle();
		Utils.Log.info("|Check second step of register - Download page");
		onGetStartedSecondStep.verifyGetInstabeatConnectText();
		onGetStartedSecondStep.downloadApp();
		onGetStartedSecondStep.clickOnSave();
		
		/*Login from App*/
		Utils.Log.info("|Logging from App using new created user...");
		GetStartedThirdStep onGetStartedThirdStep = onGetStartedSecondStep.loginByApp(onGetStartedPage.randomUser);
		onGetStartedThirdStep.printPageTitle();
		Utils.Log.info("|Check for success login from App");
		onGetStartedThirdStep.verifyTextPresentOnPage();
		
		/*Third step of register*/
		Utils.Log.info("|Filling in RHR data");
		onGetStartedThirdStep.typeRHRValue();
		onGetStartedThirdStep.clickOnCalculateButton();
		HomePage onHomePage = onGetStartedThirdStep.clickOnUpdateButton(); 
		Utils.Log.info("|Check if registration is successfully");
		onHomePage.isCongratsPresent();
		onHomePage.isHomePagePresent();
				
		Utils.delay(5000);
		Utils.Log.info("|Logging out...");
		onLoginPage.logout();
		
		/*Check if registered random user can login*/
		Utils.Log.info("|Logging by new created Random user");
		onLoginPage.typeUserAfterRegister(onGetStartedPage.randomUser);
		onLoginPage.typeUserPassword();
		onLoginPage.LoginButton();
		
		/*Delete random user*/
		Utils.Log.info("|Deleting created Random User...");
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		onProfilePageSettings.clickOnDeleteAccountButton();
		onProfilePageSettings.clickOnCancelButton();
		onProfilePageSettings.clickOnDeleteAccountButton();
		onProfilePageSettings.confirmDeleteAccout();
		
		Utils.waitPage();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}

	@Test(priority = 3, enabled = false)
	public void UserForgotPassword() throws Exception {
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		ForgotPasswordPage onForgotPasswordPage = onLoginPage.clickOnForgotPasswordLink();
		
		/*Forgot password page --> type user email*/
		Utils.Log.info("|Filling in user email...");
		onForgotPasswordPage.typeExistingUserEmail();
		ForgotPasswordPageResults onForgotPasswordPageResults = onForgotPasswordPage.clickOnResetButton();
		
		Utils.Log.info("|Checking for proper user email");
		Utils.waitPage();
		Assert.assertTrue(onForgotPasswordPageResults.checkUserEmail());

		/*Get confirm message from email*/
		Utils.Log.info("|Getting Reset link from IMAP server...");
		ResetPasswordPage onResetPasswordPage = onForgotPasswordPageResults.getConfirmationFromEmailIMAP();
		
		Utils.Log.info("|Check for proper page");
		Assert.assertTrue(onResetPasswordPage.resetPasswordConfirmText());
		
		/*Reset password page --> new password*/
		Utils.Log.info("|Filling in new password");
		onResetPasswordPage.typeNewPassword();
		onResetPasswordPage.typeConfirmPassword();
		onResetPasswordPage.afterResetPassword();
//		Utils.delay(3000);
		onLoginPage.verifyLoginPage();
		
//		Utils.waitPage();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 5, enabled = false)
	public void UserCanChooseExistSession() {
		Utils.Log.info("<<========Started running=====<<");
		
		Utils.Log.info("|Logging in...");
		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Utils.Log.info("|Check if user logged in");
		Assert.assertTrue(onHomePage.isHomePagePresent());
		onHomePage.isCalendarButtonPresent();

		Utils.Log.info("|Check if user has date with sessions...");
		onHomePage.cliclOnCalendarButton();
		onHomePage.isDateWithSessionsPresent();
		
		Utils.Log.info("|Choosing date with sessions...");
		onHomePage.showDatesWithSessions();
		onHomePage.chooseDateWithSessionRandomly();
		
		Utils.Log.info("|Choose session");
		onHomePage.clickOnContextMenu();
		onHomePage.clickOnSession();

		Utils.waitPage();
		onHomePage.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 6, enabled = false) //=====> need to check random numbers for weight and height
	public void UserCanUpdateProfile() throws IOException{
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		Utils.Log.info("|Logging in...");
		onLoginPage.typeUserEmail();
		onLoginPage.typeUserPassword();

		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Utils.Log.info("|Check if user logged in");
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		
		Utils.Log.info("|Updating user data...");
		onProfilePage.updateFirstNameField();		
		onProfilePage.updateLastNameField();
		onProfilePage.updateHeightfield();
		onProfilePage.updateWeightField();
		onProfilePage.updateBirthdateField();
		onProfilePage.updateCountryField();
		onProfilePage.changeFitnessLevel();
		
		onProfilePage.clickOnUpdateButton();
		
		Utils.delay(1000);
		
		Utils.Log.info("|Check if updating successfull");
		onProfilePage.checkMessageAboutUpdate();
		Assert.assertTrue(onProfilePage.checkIconToSyncDevice());
		onProfilePage.isUserTitleNameEqualsUserName();
		
		Utils.Log.info("|Uploading new user's profile picture");
		onProfilePage.updateUserPicture();
		
		Utils.Log.info("|Logging out...");
		onProfilePage.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 7, enabled = false)
	public void userCanChangePassword(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		Utils.Log.info("|Logging in...");
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Utils.Log.info("|Check if user logged in");
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		
		Utils.Log.info("|Changing user's password...");
		onProfilePageSettings.typeOldPassword();
		onProfilePageSettings.typeNewPassword();
		onProfilePageSettings.typeConfirmNewPassword();
		
		onProfilePageSettings.clickOnChangePasswordButton();
		Utils.waitPage();
		onProfilePageSettings.checkIfPasswordSucChanged();
		Utils.Log.info("|Password was successfully changed");
		
		Utils.Log.info("|Logging out...");
		onProfilePageSettings.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 8, enabled = false)
	public void userCanUpdateProfileSettings(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		Utils.Log.info("|Logging in...");
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Utils.Log.info("|Check if user logged in");
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		
		Utils.Log.info("|Updating profile settings");
		onProfilePageSettings.changeSettingsRandomly();
		Utils.waitPage();		
		onProfilePageSettings.clickOnMetricUpdate();
		
		Utils.Log.info("|Logging out...");
		onProfilePageSettings.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 9, enabled = false)
	public void userCanDeleteAllSessions(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		Utils.Log.info("|Logging in...");
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Utils.Log.info("|Check if user logged in");
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		
		Utils.Log.info("|Deleting all sessions...");
		onProfilePageSettings.clickOnEraseDataButton();
		onProfilePageSettings.checkIfEraseWindowOpened();
		onProfilePageSettings.clickOnCancelButton();
		onProfilePageSettings.clickOnEraseDataButton();
		onProfilePageSettings.confirmEraseAllSessions();
		
		Utils.delay(2000);
		Utils.Log.info("|Check if sessions exist");
		onHomePage.isDateWithSessionsPresent();
		Utils.waitPage();
		
		Utils.Log.info("|Logging out...");
		onHomePage.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 10, enabled = false)
	public void userCanUpdateHRZPage(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		Utils.Log.info("|Logging in...");
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		HeartRateZonesPage onHeartRateZonesPage = onHomePage.clickOnHRZTab();
		
		/*Change heart rate using RHR field*/
		Utils.Log.info("|Change HR zones using RHR field");
		onHeartRateZonesPage.typeRHR();
		onHeartRateZonesPage.clickOnCalculateButton();
		onHeartRateZonesPage.clickOnUpdateButton();
		Utils.delay(2000);
		Utils.Log.info("|Check if HR updated");
		onHeartRateZonesPage.isSuccessMessagePresent();
		
		/*Change heart rate in boxes randomly*/
		Utils.Log.info("|Change HR zones using boxes with random data");
		onHeartRateZonesPage.typeHeartRateIntoBoxes();
		Utils.waitPage();
		onHeartRateZonesPage.clickOnUpdateButton();
		Utils.Log.info("|Check if HR updated");
		onHeartRateZonesPage.isSuccessMessagePresent();
		
		Utils.Log.info("|Logging out...");
		onHeartRateZonesPage.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
		
	}

	@Test(priority = 11, enabled = false)
	public void userCanConnectToFB(){	
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		Utils.Log.info("|Logging in...");
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Utils.Log.info("|Check if user logged in");
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		Utils.Log.info("|Connecting to FB...");
		onProfilePageSettings.FaceBookConnect();
		
		onProfilePageSettings.checkIfFBConnectionSuc();
		
		Utils.Log.info("|Logging out...");
		onProfilePageSettings.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 12, enabled = false)
	public void UserCanShareGraphFB(){
		
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		Utils.Log.info("|Logging in...");
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Utils.Log.info("|Check if user logged in");
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		Utils.Log.info("|Connecting to FB...");
		onProfilePageSettings.FaceBookConnect();
		
		onProfilePageSettings.clickOnHomeTab();
				
		Utils.Log.info("|Sharing data to FB...");
		onHomePage.clickOnPlusButton();
		onHomePage.clickOnFBShareButton();
		onHomePage.checkIfFBShareWindowOpened();
		Utils.waitPage();
		
		onHomePage.cancelShareDataFB();
		onHomePage.clickOnFBShareButton();
		onHomePage.confirmShareDataFB();
		Utils.waitPage();
		
		Utils.Log.info("|Logging out...");
		onHomePage.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
		
	}
	
	@Test(priority = 13, enabled = false)
	public void UserCanConnectToTwitter(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		Utils.Log.info("|Logging in...");
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Utils.Log.info("|Check if user logged in");
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		
		Utils.Log.info("|Connecting to Twitter...");
		onProfilePageSettings.TwitterConnect();
		
		Utils.Log.info("|Checking if connection is success");
		onHomePage.clickOnProfileTab();
		onProfilePage.clickOnProfilePageSettings();
		
		onProfilePageSettings.checkIfTwitterConnectionSuc();
		
		Utils.Log.info("|Logging out...");
		onHomePage.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 14, enabled = false)
	public void UserCanShareGraphTwitter(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		Utils.Log.info("|Logging in...");
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Utils.Log.info("|Check if user logged in");
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		ProfilePageSettings onProfilePageSettings = onProfilePage.clickOnProfilePageSettings();
		
		Utils.Log.info("|Connecting to Twitter...");
		onProfilePageSettings.TwitterConnect();
		
		onProfilePageSettings.clickOnHomeTab();
		
		Utils.Log.info("|Sharing data to Twitter...");
		onHomePage.clickOnPlusButton();
		onHomePage.clickOnTwitterShareButton();
		onHomePage.checkIfTwitterShareWindowOpened();
		
		onHomePage.cancelShareDataFB();
		onHomePage.clickOnTwitterShareButton();
		onHomePage.confirmShareDataFB();
		
		onHomePage.checkIfShareIsSucced();
		
		Utils.Log.info("|Logging out...");
		onHomePage.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 14, enabled = true)
	public void ValidateValuesInFooter() throws Exception{
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		
		Utils.Log.info("|Sending session to the server...");
		onLoginPage.sendSession();
		
		Utils.Log.info("|Logging in...");
		onLoginPage.fullLogin();
		HomePage onHomePage = onLoginPage.LoginButton();
		
		Utils.Log.info("|Checking if duration time is proper...");
		onHomePage.checkIfDurationTimeIsProper();
		
		Utils.Log.info("|Checking if total distance is proper...");
		onHomePage.chheckIfTotalDistanceIsProper();
		
		//====>T O D O<====
		onHomePage.checkIfAvaragePaceIsProper(); /*need access to total laps duration on the server side*/
		
		Utils.Log.info("|Logging out...");
		onHomePage.logout();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 15, enabled = false)
	public void editActivityCheck(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		Utils.Log.info("|Logging in...");
		onLoginPage.fullLogin();
		
		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Utils.Log.info("|Check if user logged in");
		Assert.assertTrue(onHomePage.isHomePagePresent());
		
		/*........*/
	}
	
	@Test(priority = 16, enabled = false)
	public void checkMetricsSettings() {
		
	}
}
