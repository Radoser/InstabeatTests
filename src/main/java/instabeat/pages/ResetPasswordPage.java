package instabeat.pages;


import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		values(By.id(parameters.NewPasswordField), parameters.UserPassword);
		/*WebElement newPasswordField = driver.findElement(By.id("passwordInput"));
		newPasswordField.sendKeys(userEmail);*/
	}


	public void typeConfirmPassword() 
	{
		values(By.id(parameters.ConfirmNewPasswordField), parameters.UserPassword);
		/*WebElement confirmPasswordField = driver.findElement(By.id("password_conf"));
		confirmPasswordField.sendKeys(password);		*/
	}


	public LoginPage afterResetPassword(){
		click(By.xpath(parameters.ResetPasswordButton));
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		return new LoginPage(driver);
	}
	
	public void ResetButton() 
	{
		WebElement resetButton = driver.findElement(By.xpath("//button[@type='submit']"));
		resetButton.click();
	}

}
