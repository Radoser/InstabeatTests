package instabeat.pages;

import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPageResults extends MainPagesFunc {

	// private static WebDriver driver;

	public ForgotPasswordPageResults(WebDriver driver) {
		super(driver);
	}

	public boolean checkUserEmail() {
		return driver.findElement(By.tagName("span")).getText()
				.contains("fortestgl+2@gmail.com");
	}

	public boolean verifyTextPresent(String text) {
		return driver.getPageSource().contains(text);
	}

	public ResetPasswordPage getConfirmationFromEmailIMAP() throws Exception {
		GoToIMAPServer();
		return PageFactory.initElements(driver, ResetPasswordPage.class);

	}

	public GoToEmail getConfirmationFromEmail() {
		driver.navigate().to("https://freemail.ukr.net/");
		return new GoToEmail(driver);
	}

}
