package instabeat.pages;


import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends MainPagesFunc{

	
	public ResetPasswordPage(WebDriver driver) {
		super(driver);
	}

	//Assert.assertEquals("Choose a new password" , driver.getTitle());
	public boolean resetPasswordConfirmText ()
	{
		return verifyPageContent("Choose a new password");
	}
	
	public void typeNewPassword() 
	{
		NewPasswordField.sendKeys(parameters.UserPassword);
	}


	public void typeConfirmPassword() 
	{
		ConfirmNewPasswordField.sendKeys(parameters.UserPassword);
	}


	public LoginPage afterResetPassword(){
		ResetPasswordButton.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public void ResetButton() 
	{
		WebElement resetButton = driver.findElement(By.xpath("//button[@type='submit']"));
		resetButton.click();
	}

}
