package InstabeatSanity.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import instabeat.dashboard.HomePage;
import instabeat.pages.ForgotPasswordPage;
import instabeat.pages.ForgotPasswordPageResults;
import instabeat.pages.GetSartedFirstStep;
import instabeat.pages.GetStartedPage;
import instabeat.pages.GetStartedSecondStep;
import instabeat.pages.GetStartedThirdStep;
import instabeat.pages.LoginPage;
import instabeat.pages.ResetPasswordPage;
import instabeat.utils.Utils;
import org.testng.Assert;
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

		AssertJUnit.assertTrue(onLoginPage.verifyLoginPage());

		onLoginPage.typeUserEmail();
		onLoginPage.typeUserPassword();
		onLoginPage.LoginButton();

		instabeat.utils.Utils.waitPage();
		// Assert.assertTrue(onLoginPage.isUserLoggedIn());

		onLoginPage.logout();
		Utils.waitPage();
	}

	@Test(priority = 2, enabled = false)
	public void UserCannotLogin() {
		LoginPage onLoginPage = new LoginPage(driver);

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

	@Test(priority = 4, enabled = false)
	public void UserCanRegister() throws Exception {
		LoginPage onLoginPage = new LoginPage(driver);
		GetStartedPage onGetStartedPage = onLoginPage.clickOnGetStartedLink();
		onGetStartedPage.typeUserValues();

		GetSartedFirstStep onGetSartedFirstStep = onGetStartedPage
				.clickOnSignUpButton();
		Utils.waitPage();

		AssertJUnit.assertTrue(onGetSartedFirstStep
				.checkUserEmail(onGetStartedPage.randomUser));

		GetStartedSecondStep onGetStartedSecondStep = onGetSartedFirstStep
				.getConfirmationLink();
		onGetStartedSecondStep.printPageTitle();
		onGetStartedSecondStep.verifyGetInstabeatConnectText();
		onGetStartedSecondStep.downloadApp();

		GetStartedThirdStep onGetStartedThirdStep = onGetStartedSecondStep
				.loginByApp(onGetStartedPage.randomUser);
		onGetStartedThirdStep.printPageTitle();
		onGetStartedThirdStep.verifyTextPresentOnPage();
		
		onGetStartedThirdStep.typeRHRValue();
		onGetStartedThirdStep.clickOnCalculateButton();
		HomePage onHomePage = onGetStartedThirdStep.clickOnUpdateButton(); 
		onHomePage.isCongratsPresent();
		onHomePage.isHomePagePresent();
		
		
		Utils.delay(5000);

		onLoginPage.logout();

		onLoginPage.typeUserAfterRegister(onGetStartedPage.randomUser);
		onLoginPage.typeUserPassword();
		onLoginPage.LoginButton();
		Utils.waitPage();
		onLoginPage.logoutFromDashboard();
		// asssert
	}

	@Test(priority = 3, enabled = false)
	public void UserForgotPassword() throws Exception {

		LoginPage onLoginPage = new LoginPage(driver);
		ForgotPasswordPage onForgotPasswordPage = onLoginPage
				.clickOnForgotPasswordLink();

		onForgotPasswordPage.typeExistingUserEmail();
		ForgotPasswordPageResults onForgotPasswordPageResults = onForgotPasswordPage
				.clickOnResetButton();

		Utils.waitPage();
		Assert.assertTrue(onForgotPasswordPageResults.checkUserEmail());

		ResetPasswordPage onResetPasswordPage = onForgotPasswordPageResults
				.getConfirmationFromEmail2();

		AssertJUnit.assertTrue(onResetPasswordPage.resetPasswordConfirmText());

		onResetPasswordPage.typeNewPassword();
		onResetPasswordPage.typeConfirmPassword();
		onResetPasswordPage.afterResetPassword();
		Utils.delay(3000);
		AssertJUnit.assertTrue(onLoginPage.verifyLoginPage());
		Utils.waitPage();

	}
	
//	NEED TO ADD TEST TO PROFILE + SETTINGS PAGES!!!
	
	@Test(priority = 5, enabled = true)
	public void UserCanToUpdateProfile() {

		LoginPage onLoginPage = new LoginPage(driver);
		onLoginPage.typeUserEmail();
		onLoginPage.typeUserPassword();

		HomePage onHomePage = onLoginPage.LoginButton();
		Utils.waitPage();
		Assert.assertTrue(onHomePage.isHomePagePresent());
		onHomePage.isCalendarButtonPresent();
		

		onHomePage.cliclOnCalendarButton();
		onHomePage.isDateWithSessionsPresent();
		onHomePage.clickOnContextMenu();
		onHomePage.clickOnSession();
		
//		Assert.assertTrue(onHomePage.IsCalendarPresent());

		Utils.waitPage();

		onHomePage.logout();

	}

}
