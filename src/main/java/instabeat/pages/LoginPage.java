package instabeat.pages;

import instabeat.dashboard.HomePage;
import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends MainPagesFunc {

	public LoginPage(WebDriver driver) {
		super(driver);
		createRandomUser();
		
	}

	public void verifyPageTitle() {
		String	expected = "Login";
		String	actual = driver.getTitle();
			Assert.assertEquals(expected, actual);
			Utils.Log.info("|Actual Page is: "+actual);
		}
	
	public void verifyLoginPage() {
		Utils.delay(2000);
		Assert.assertTrue(verifyPageContent("Login"));
	}

	public void isUserLoggedIn() {
		Utils.delay(2000);
		Assert.assertTrue(verifyPageContent("Home"));
	}

	public void typeUserEmail() {
		Utils.clearField(EmailField);
		EmailField.sendKeys(parameters.UserEmail);
	}

	public void typeWrongUserEmail() {
		EmailField.sendKeys(randomUser);
	}

	public void typeUserAfterRegister(String data) {
		EmailField.sendKeys(data);
	}

	public void typeUserPassword() {
		PasswordField.sendKeys(parameters.UserPassword);
	}
	
	public void fullLogin(){
		EmailField.sendKeys(parameters.UserEmail);
		PasswordField.sendKeys(parameters.UserPassword);
	}
	
	public HomePage LoginButton() {
//		click(By.xpath(parameters.LoginButton));
		LoginButton.click();
		return PageFactory.initElements(driver, HomePage.class);
	}

	public ForgotPasswordPage clickOnForgotPasswordLink() {
//		click(By.xpath(parameters.ForgotPasswordLink));
		ForgotPasswordLink.click();
		return PageFactory.initElements(driver, ForgotPasswordPage.class);
	}

	public GetStartedPage clickOnGetStartedLink() {
		GetStartedLink.click();
		// driver.findElement(By.linkText("Get started here")).click();
		return PageFactory.initElements(driver, GetStartedPage.class);
	}
	
	public void checkAllLinksFromLoginPage(){
		GetAllLinksOnPage();	
//		linksTest();
	}

	public void checkErrorMessage() {
		Assert.assertEquals(parameters.EMincorrectCredentials, ErrorMessages.getText());
	}

	public void typeWrongUserPassword() {
		PasswordField.sendKeys("123");		
	}

	public void typeInvalidEmail() {
//		Utils.clearField(EmailField);
		typeValuesForValidation(parameters.EMinvalidEmail, Utils.dataForEmailFieldInput, EmailField, LoginButton, ErrorMessages);
		EmailField.sendKeys(randomUser);
	}
	
	public HomePage sendSession() throws Exception{
		sendSessionFromDevice();
		return PageFactory.initElements(driver, HomePage.class);
	}
}
