package InstabeatSanity.Tests;

import instabeat.dashboard.HomePage;
import instabeat.dashboard.ProfilePage;
import instabeat.pages.ForgotPasswordPage;
import instabeat.pages.GetStartedPage;
import instabeat.pages.LoginPage;
import instabeat.utils.Utils;

import org.testng.annotations.Test;

public class FieldsValidationTests extends AbstractTestClass{

	
	@Test(priority = 1, enabled = false)
	public void LoginValidation(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		
		Utils.Log.info("|Checking wrong user email");
		onLoginPage.typeWrongUserEmail();
		onLoginPage.typeUserPassword();
		onLoginPage.LoginButton();
		Utils.delay(1000);
		onLoginPage.checkErrorMessage();
		
		Utils.Log.info("|Checking wrong user password");
		onLoginPage.typeUserEmail();
		onLoginPage.typeWrongUserPassword();
		onLoginPage.LoginButton();
		onLoginPage.checkErrorMessage();
		Utils.delay(2000);
		
		Utils.Log.info("|Checking incorrect user email");
		onLoginPage.typeInvalidEmail();
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 2, enabled = false)
	public void ResetPasswordValidation(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		ForgotPasswordPage onForgotPasswordPage =  onLoginPage.clickOnForgotPasswordLink();
		
		Utils.Log.info("|Checking not existing user email");
		onForgotPasswordPage.typeWrongUserEmail();
		onForgotPasswordPage.checkErrorMessage();

		Utils.Log.info("|Checking incorrect user email");
		onForgotPasswordPage.emailFieldValidation();
		
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 3, enabled = false)
	public void GetStartedValidation(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		GetStartedPage onGetStartedPage = onLoginPage.clickOnGetStartedLink();
		
		Utils.Log.info("|Checking all fields...");
		onGetStartedPage.firstNameValidation();
		onGetStartedPage.lastNameValidation();
		onGetStartedPage.emailValidation();
		onGetStartedPage.passwordValidation();
		onGetStartedPage.confirmPasswordValidation();
		onGetStartedPage.dateOfBirthValidation();
		onGetStartedPage.minHeightFieldValidation();
		onGetStartedPage.maxHeightFieldValidation();
		onGetStartedPage.minWeightFieldValidation();
		onGetStartedPage.maxWeightFieldValidation();
		onGetStartedPage.goToLoginPage();		
		Utils.Log.info("|Fields are checked");		
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 4, enabled = false)
	public void ProfileValidation(){
		Utils.Log.info("<<========Started running=====<<");
		
		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.fullLogin();
		HomePage onHomePage = onLoginPage.LoginButton();
		ProfilePage onProfilePage = onHomePage.clickOnProfileTab();
		
		Utils.Log.info("|Checking all fields...");
		onProfilePage.firstNameValidation();
		onProfilePage.lastNameValidation();
		onProfilePage.dateOfBirthValidation();
		onProfilePage.minHeightFieldValidation();
		onProfilePage.maxHeightFieldValidation();
		onProfilePage.minWeightFieldValidation();
		onProfilePage.maxWeightFieldValidation();
		Utils.Log.info("|Fields are checked");		
		Utils.Log.info("<<-----Finishing running test-----< \n---------------------------------------------------");
	}
	
	@Test(priority = 5, enabled = false)
	public void ProfileSettingsValidation(){
		
	}
}
