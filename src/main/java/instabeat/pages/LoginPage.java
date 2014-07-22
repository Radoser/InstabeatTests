package instabeat.pages;

import instabeat.dashboard.HomePage;
import instabeat.dashboard.ProfilePage;
import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends MainPagesFunc {

	public LoginPage(WebDriver driver) {
		super(driver);
		createRandomUser();
	}

	public boolean verifyLoginPage() {
		return verifyPageContent("Login");
	}

	public void logoutFromDashboard() {
		logout();
	}

	public boolean isUserLoggedIn() {
		return verifyPageContent("Home");
	}

	public void typeUserEmail() {
		values(By.id(parameters.EmailField), parameters.UserEmail);
	}

	public void typeWrongUserEmail() {
		values(By.id(parameters.EmailField), randomUser);
	}

	public void typeBLA(String data) {
		values(By.id(parameters.EmailField), data);
	}

	public void typeUserPassword() {
		values(By.id(parameters.PasswordField), parameters.UserPassword);
	}

	public HomePage LoginButton() {
		click(By.xpath(parameters.LoginButton));
		return new HomePage(driver);
	}

	public ForgotPasswordPage clickOnForgotPasswordLink() {
		click(By.xpath(parameters.ForgotPasswordLink));
		// driver.findElement(By.linkText("Click here")).click();
		return new ForgotPasswordPage(driver);
	}

	public GetStartedPage clickOnGetStartedLink() {
		click(By.xpath(parameters.GetStartedLink));
		// driver.findElement(By.linkText("Get started here")).click();
		return new GetStartedPage(driver);
	}
	
	public void checkAllLinksFromLoginPage(){
		GetAllLinksOnPage("Login");
	}
}
