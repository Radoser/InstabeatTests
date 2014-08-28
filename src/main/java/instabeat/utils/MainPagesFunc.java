package instabeat.utils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import junit.framework.Assert;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//import org.apache.commons.lang.RandomStringUtils;

public class MainPagesFunc {

	protected WebDriver driver;
	protected ParametersManager parameters;
	Random random = new Random();
	// RandomStringUtils randomForLetters = new RandomStringUtils();
	
	
	@FindBy(xpath = "//div[@onclick='logOut()']")
	WebElement LogoutLink;

	/* Login Page */
	@FindBy(id = "email")
	public static WebElement EmailField;

	@FindBy(id = "passwordInput")
	public WebElement PasswordField;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement LoginButton;

	@FindBy(xpath = "//a[@href='/go']")
	public WebElement GetStartedLink;

	@FindBy(xpath = "//a[@href='/user/restore']")
	public WebElement ForgotPasswordLink;

	/* Reset Password Page */
	@FindBy(id = "passwordInput")
	public WebElement NewPasswordField;

	@FindBy(id = "password_conf")
	public WebElement ConfirmNewPasswordField;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement ResetPasswordButton;

	/* Get Started Page */
	@FindBy(xpath = "//button[@class = 'ibt-button subbut']")
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

	/* Heart Rate Zones Page */
	@FindBy(id = "MHR")
	public WebElement RHRField;

	@FindBy(id = "calcButton")
	public WebElement CalculateHRButton;

	@FindBy(xpath = "//*[@class='col-md-8 col-xs-8 col-md-offset-4']/input[@value='Update']")
	public WebElement UpdateButton;

	/* Home Page */
	@FindBy(xpath = "//div[@class='float-right calendar']")
	public WebElement CalendarButton;

	@FindBy(xpath = "//span[@class='cal-day']")
	public WebElement CalendarButtonDate;

	@FindBy(xpath = "//span[@class='cal-month']")
	public WebElement CalendarButtonMonth;

	@FindBy(how = How.CSS, using = ".day")//(xpath = "//*[@class = 'day ']")
	public WebElement DateContainsSessions;

	@FindBy(how = How.CSS, using = ".day.active")
	public WebElement ActiveDateWithSession;
	
	@FindBy(how = How.CSS, using = ".day.old")
	public WebElement oldDay;

	@FindBy(xpath = ".//*[@id='cong-text']")
	public WebElement CongratsMessage;

	@FindBy(xpath = ".//*[@id='s2id_parentNode']/a")
	public WebElement ContextMenu;

	@FindBy(xpath = "//*[@class='top-button'][text()='Home']")
	public WebElement HomeTab;
	
	@FindBy(xpath = "//*[text()='+']")
	public WebElement PlusButton;
	
	@FindBy(xpath = "//*[@class='col-md-4 col-xs-4 face']")
	public WebElement FBShareGraphButton;

	/* Profile Page */
	@FindBy(xpath = "//*[text()='Profile']")
	public WebElement ProfileTab;

	@FindBy(xpath = "//*[@class='name ibt-title']")
	public WebElement UserNameTitle;

	@FindBy(xpath = "html/body/div[4]/div/div[4]/div[2]/div[2]/form/div[2]/div[4]/button")
	public WebElement ProfileUpdateButton;

	@FindBy(xpath = "//span[@class = 'suc-text']")
	public WebElement MessageAboutUpdateProfile;

	@FindBy(xpath = "//span[@class = 'glyphicon glyphicon-exclamation-sign']")
	public WebElement ExclamationMark;

	@FindBy(xpath = "//select[@name='f_level']")
	public WebElement FitnessLevel;

	@FindBy(id = "file")
	public WebElement UploadPictureButton;

	@FindBy(xpath = "//div[@onclick=\"goTo('.settings')\"]")
	public WebElement ProfileSettingsLink;

	@FindBy(xpath = "//input[@name='oldpassword']")
	public WebElement OldPasswordField;

	/* Profile Settings */
	@FindBy(id = "newpassword")
	public WebElement NewUserProfilePasswordField;

	@FindBy(id = "confirm")
	public WebElement ConfirmNewUserProfilePasswordField;

	@FindBy(xpath = "//*[@class= 'col-md-6 col-xs-6 col-md-offset-6']/input[@value = 'Update']")
	public WebElement UpdateUserProfileButton;

	@FindBy(xpath = "//select[@id='timezone2']")
	public WebElement UTCzones;

	@FindBy(xpath = "//input[@value='Erase data']")
	public WebElement SessionsEraseButton;

	@FindBy(xpath = "//input[@value='Delete account']")
	public WebElement AccountDeleteButton;

	@FindBy(xpath = "//*[@class='col-md-6 col-xs-6']/input[@value='OK']")
	public WebElement OkButtonForDelete;

	@FindBy(xpath = "//*[@class='col-md-6 col-xs-6']/input[@value='Cancel']")
	public WebElement CancelButton;

	@FindBy(id = "alertText")
	public WebElement EraseTextWindow;

	@FindBy(id = "alertText")
	public WebElement DeleteTextWindow;

	@FindBy(xpath = "//input[@class='ibt-button f-disc']")
	public WebElement ConnectToFBButton;
	
	/* Heart Rate Zones Page */
	@FindBy(xpath = "//*[@class='top-button'][text()='Heart rate zone']")
	public WebElement HRZTab;

	@FindBy(xpath = "//span[@class= 'suc-text'][text()='Your zones have been configured! Plug-in your device now to sync']")
	public WebElement sucMessage;

	@FindBy(xpath = "//form[@name='heartrate']")
	public WebElement formOfHR;
	
	/*Facebook window*/
	@FindBy(id = "email")
	public WebElement FBEmailField;

	@FindBy(id = "pass")
	public WebElement FBPasswordField;
	
	@FindBy(name = "login")
	public WebElement FBLoginButton;
	
	@FindBy(xpath = "//*[@class='col-md-6 col-xs-6 error-message']")
	public WebElement ErrorMessages;
	
	@FindBy(xpath = "//*[@class = 'error-message'][text()]")
	public WebElement DashboardErrorMessages;
	
	@FindBy(xpath = "//*[@class='col-md-5 col-xs-5 error-message']")
	public WebElement ResetPassErrorMessages;
	
	@FindBy(xpath = "//*[@class = 'float-right header-button']/a[@href = '/user/']")
	public WebElement LoginLink;
	
	public MainPagesFunc(WebDriver driver) {
		Utils.logFile();
		parameters = new ParametersManager();
		parameters.getPropertyFields();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}

	public String randomUser;// = "testusergl"+random.nextInt()+"@ukr.net";
	public String randomValues; // ="Name"+RandomStringUtils.randomAlphabetic(5);
	public String randomNumbers;

	public void createRandomUser() {
		randomUser = "fortestgl+" + random.nextInt(Integer.MAX_VALUE)
				+ "@gmail.com";
	}

	public void createRandomValues(int numberOfLetters) {
		randomValues = "Name"
				+ RandomStringUtils.randomAlphabetic(numberOfLetters);
	}

	public void createRandomNumbers(int minValue, int maxValue) {
		int min = minValue;
		int max = maxValue;
		randomNumbers = random.nextInt(max - min) + min + "";
	}

	public void values(By by, String values) {
		WebElement element = driver.findElement(by);
		element.sendKeys(values);
	}

	public void click(By by) {
		driver.findElement(by).click();
	}

	public boolean verifyPageContent(String data) {
		return driver.getPageSource().contains(data);
	}

	public void logout() {
		LogoutLink.click();
	}

	public void GoToIMAPServer() throws Exception {
		String confirmLink = IMAPGmail.GetConfirmationLink();
		driver.navigate().to(confirmLink);
	}

	public void LoginApp(String value) throws Exception {
		JSONObject response = HTTPMethod.AppLogin(value);
		String username = response.getString("user");
		String usertoken = response.getString("token");
		driver.get("http://user.instabeat.me/user/appconfirm?user=" + username
				+ "&token=" + usertoken + "&status=PARTIAL");
	}

	public void GetAllLinksOnPage() {
		
		List<WebElement> linkElement = driver.findElements(By.tagName("a"));
		String [] elements = new String [linkElement.size()]; 
		int i = 0;
		
		for (WebElement e : linkElement) {
			elements[i] = e.getAttribute("href");
			i++;
		}

		for (int a = 0; a<elements.length; a++){
			driver.navigate().to(elements[a]);
			driver.navigate().back();
			Utils.Log.info("|Got to page " + driver.getTitle() + " by link " + elements[a]);
		}
	}
	
	public void linksTest() {
		
		List<WebElement> linkElement = driver.findElements(By.tagName("a"));
		String[] linkText = new String[linkElement.size()];
		int i = 0;
		
		for (WebElement e : linkElement) {
			linkText[i] = e.getText();
			i++;
		}
		
		for (String t : linkText) {
			
			driver.navigate().to(t);
			driver.findElement(By.linkText(t)).click();
			if (driver.getTitle().equals("Login")) {
				
				System.out.println("\"" + t + "\"" + "--------->is out");
			} else {
				System.out.println("\"" + t + "\"" + "--------->>is working");
			}
			driver.navigate().back();
		}
	}
	public boolean verificationOfElementsOnPages(WebElement element) {
		try {
			element.isDisplayed();
			Utils.Log.info("|Element" + element + "is PRESENT!!!");
//			System.out.println("Element" + element + "is PRESENT!!!");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void typeValuesForValidation(String error, List<String> values, WebElement field, WebElement button, WebElement errorElement){

		for (int i = 0; i < values.size(); ++i) {
			Utils.clearField(field);
			field.sendKeys(values.get(i));		
			button.click();
			Utils.delay(500);
			Assert.assertEquals(error, errorElement.getText());
			field.clear();
		}
	}
}
