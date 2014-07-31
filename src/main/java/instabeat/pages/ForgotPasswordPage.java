package instabeat.pages;

import instabeat.utils.MainPagesFunc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ForgotPasswordPage extends MainPagesFunc{

	
	
	public ForgotPasswordPage(WebDriver driver){
		super(driver);
	}
	
	
	public void verifyPageTitle() {
		String	expected = "Login";
		String	actual = driver.getTitle();
			Assert.assertEquals(expected, actual);
			System.out.println("------------------>" + actual+" Page" + "<------------------");
		}
	
	public void typeExistingUserEmail ()
	{
		EmailField.sendKeys(parameters.UserEmail);
//		values(By.id(parameters.EmailField), parameters.UserEmail);
	}
	
	public ForgotPasswordPageResults clickOnResetButton(){
		ResetPasswordButton.click();
//		click(By.xpath(parameters.ResetPasswordButton));
		return PageFactory.initElements(driver, ForgotPasswordPageResults.class);
	}
}
