package instabeat.pages;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ForgotPasswordPage extends MainPagesFunc{

	
	
	public ForgotPasswordPage(WebDriver driver){
		super(driver);
		createRandomUser();
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


	public void emailFieldValidation() {
		typeValuesForValidation(parameters.EMinvalidEmail, Utils.dataForEmailFieldInput, EmailField, ResetPasswordButton, ResetPassErrorMessages);
//		EmailField.sendKeys(randomUser);
	}


	public void typeWrongUserEmail() {
		EmailField.sendKeys(randomUser);
		ResetPasswordButton.click();
		Utils.delay(2000);
	}


	public void checkErrorMessage() {
		Assert.assertEquals(parameters.EMuserNotFound, ResetPassErrorMessages.getText());
	}
	
	
}
