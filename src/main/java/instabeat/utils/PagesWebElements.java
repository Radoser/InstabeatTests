package instabeat.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagesWebElements extends ParametersManager {

	
	WebDriver driver;
	
	protected ParametersManager parameters;

	@FindBy(xpath = "//div[@onclick='logOut()']")
	WebElement LogoutLink;
	
	/*Login Page*/
	@FindBy(id = "email")
	public WebElement EmailField2;
	
	@FindBy(id = "passwordInput")
	public WebElement PasswordField;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement LoginButton;
	
	@FindBy(xpath = "//a[@href='/user/register']")
	public WebElement GetStartedLink;
	
	@FindBy(xpath = "//a[@href='/user/restore']")
	public WebElement ForgotPasswordLink;
		
	/*Reset Password Page*/
	@FindBy(id = "passwordInput")
	public WebElement NewPasswordField;
	
	@FindBy(id = "password_conf")
	public WebElement ConfirmNewPasswordField;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement ResetPasswordButton;
	
	/*Get Started Page*/
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement SignUpButton;
	
	@FindBy(id = "firstName")
	public WebElement FirstNameField;
	
	@FindBy(id = "lastName")
	public WebElement LastNameField;
	
	@FindBy(id = "birthdate")
	public WebElement DateOfBirthField;
	
	@FindBy(id = "heightCm")
	public WebElement HeightField;
	
	@FindBy(id = "weight")
	public WebElement WeightField;
	
	/*Heart Rate Zones Page*/
	@FindBy(id = "MHR")
	public WebElement RHRField;
	
	@FindBy(id = "calcButton")
	public WebElement CalculateHRButton;
	
	@FindBy(xpath = "//input[@class='ibt-button']")
	public WebElement UpdateButton;
	
	/*Home Page*/
	@FindBy(xpath = "//div[@class='float-right calendar']")
	public WebElement CalendarButton;
	
	@FindBy(xpath = "//span[@class='cal-day']")
	public WebElement CalendarDate;
	
	@FindBy(xpath = "//span[@class='cal-month']")
	public WebElement CalendarMonth;
	
	
	public PagesWebElements(WebDriver driver) {
		parameters = new ParametersManager();
		parameters.getPropertyFields();
		this.driver = driver;
	}
	

	
//	public WebElement email_Field = driver.findElement(By.id(parameters.EmailField)); 
//	public By password_Field = By.id(parameters.PasswordField);
//	public By login_Button = By.xpath(parameters.LoginButton);
	
	
	
}
