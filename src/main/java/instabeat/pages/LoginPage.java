package instabeat.pages;

import instabeat.dashboard.HomePage;
import instabeat.utils.MainPagesFunc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends MainPagesFunc {

	public LoginPage(WebDriver driver) {
		super(driver);
		createRandomUser();
	}

	public boolean verifyLoginPage() {
		return verifyPageContent("Login");
	}

	public boolean isUserLoggedIn() {
		return verifyPageContent("Home");
	}

	public void typeUserEmail() {
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
		click(By.xpath(parameters.LoginButton));
		return PageFactory.initElements(driver, HomePage.class);
	}

	public ForgotPasswordPage clickOnForgotPasswordLink() {
		click(By.xpath(parameters.ForgotPasswordLink));
		// driver.findElement(By.linkText("Click here")).click();
		return PageFactory.initElements(driver, ForgotPasswordPage.class);
	}

	public GetStartedPage clickOnGetStartedLink() {
		click(By.xpath(parameters.GetStartedLink));
		// driver.findElement(By.linkText("Get started here")).click();
		return PageFactory.initElements(driver, GetStartedPage.class);
	}
	
	public void checkAllLinksFromLoginPage(){
		GetAllLinksOnPage("Login");
	}
}
