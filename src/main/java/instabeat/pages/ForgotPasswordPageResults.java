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

	/*
	 * public boolean verifytext(String text){
	 * System.out.println(verifytext("testusergl@ukr.net")); return
	 * driver.findElement
	 * (By.xpath(".//*[@id='emailholder']")).getText().contains(text);
	 * 
	 * }
	 */

	public boolean checkUserEmail() {
		return driver.findElement(By.tagName("span")).getText()
				.contains("fortestgl+2@gmail.com");
	}

	public boolean verifyTextPresent(String text) {
		return driver.getPageSource().contains(text);
	}

	public ResetPasswordPage getConfirmationFromEmail2() throws Exception {
		GoToIMAPServer();
		return PageFactory.initElements(driver, ResetPasswordPage.class);

	}

	public GoToEmail getConfirmationFromEmail() {
		driver.navigate().to("https://freemail.ukr.net/");
		return new GoToEmail(driver);
	}

}
