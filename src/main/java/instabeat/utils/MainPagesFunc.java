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
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(id = "month-select")
	public WebElement MonthSelect;
	
	@FindBy(id = "day-select")
	public WebElement DaySelect;
	
	@FindBy(id = "year-select")
	public WebElement YearSelect;
	
	@FindBy(id = "metric_height")
	public WebElement HeightMetric;
	
	@FindBy(id = "metric_weight")
	public WebElement WeightMetric;
	
	@FindBy(id = "pool_distance_metric")
	public WebElement PoolDistanceMetric;
	
	@FindBy(id = "timezone")
	public WebElement ChooseCountry;
	
	/* Heart Rate Zones Page */
	@FindBy(id = "MHR")
	public WebElement RHRField;

	@FindBy(id = "calcButton")
	public WebElement CalculateHRButton;

	@FindBy(xpath = "//*[@class='col-md-12 col-xs-12']/input[@value='Update']")
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
	
	@FindBy (xpath = "//*[@class = 'datepicker-days']//th[@class = 'switch']")
	public WebElement ActiveMonth;
	
	@FindBys({@FindBy(xpath = "//*[@class = 'datepicker-days']//td[@class = 'day ']")})
	public List<WebElement> DatesWithSessions;

	@FindBy(how = How.CSS, using = ".day.active")
	public WebElement ActiveDateWithSession;

	@FindBy(how = How.CSS, using = ".day.old")
	public WebElement oldDay;

	@FindBy(xpath = ".//*[@id='cong-text']")
	public WebElement CongratsMessage;

	@FindBy(xpath = ".//*[@id='s2id_parentNode']/a")
	public WebElement ContextMenu;

	@FindBy(xpath = "//*[@class='top-content'][text()='Home']")
	public WebElement HomeTab;

	@FindBy(xpath = "//*[text()='+']")
	public WebElement PlusButton;

	@FindBy(xpath = "//*[@class='col-md-4 col-xs-4 face']")
	public WebElement FBShareGraphButton;

	@FindBy(xpath = "//*[@onclick = 'alertToTwitter()']")
	public WebElement TwitterShareButton;
	
	@FindBy(xpath = "//div[4][@class = 'session-container']")
	public WebElement SessionDuration;

	@FindBy(xpath = "//*[@id = 'duration']")
	public WebElement SessionDurationInFooter;
	
	@FindBy(xpath = "//*[@class = 'pool-length']")
	public WebElement PoolLength;
	
	@FindBy(xpath = "//*[@id = 'laps']")
	public WebElement LapsAmount;
	
	@FindBy(xpath = "//*[@id = 'totalDist']")
	public WebElement SessionTotalDistance;
	
	@FindBy(xpath = "//*[@class = 'pool-edit']")
	public WebElement EditActivityButton;
	
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
	
	@FindBy(xpath = "//div[@onclick=\"goTo('.profile')\"]")
	public WebElement ProfileLinkOnSettingsPage;

	@FindBy(xpath = "//input[@name='oldpassword']")
	public WebElement OldPasswordField;
	
	@FindBy(xpath = "//select[@id='timezone2']")
	public WebElement UTCzones;
	
	@FindBy(xpath = "//select[@id = 'month-select'][@class = 'form-control ibt-input select2-offscreen']")
	public WebElement MonthSelectOnProfile;
	
	@FindBy(xpath = "//select[@id = 'day-select'][@class = 'form-control ibt-input select2-offscreen']")
	public WebElement DaySelectOnProfile;
	
	@FindBy(xpath = "//select[@id = 'year-select'][@class = 'form-control ibt-input select2-offscreen']")
	public WebElement YearSelectOnProfile;
	
	@FindBy(id = "heightFt")
	public WebElement HeightFtField;

	@FindBy(id = "heightIn")
	public WebElement HeightInchField;

	/* Profile Settings */
	@FindBy(id = "newpassword")
	public WebElement NewUserProfilePasswordField;

	@FindBy(id = "confirm")
	public WebElement ConfirmNewUserProfilePasswordField;

	@FindBy(id = "PassUpdate")
	public WebElement PasswordUpdateButton;

	@FindBy(xpath = "//*[@class = 'col-md-12 col-xs-12']/button[@type = 'submit'][text() = 'Update']")
	public WebElement UpdateUserProfileButton;

	@FindBy(xpath = "//input[@value='Erase data']")
	public WebElement SessionsEraseButton;

	@FindBy(xpath = "//input[@value='Delete account']")
	public WebElement AccountDeleteButton;
	
	@FindBy(css = "input[name = 'metric_height']:not(:checked) + span")
	public WebElement NotActiveHeightUnit;
	
	@FindBy(css = "input[name = 'metric_weight']:not(:checked) + span")
	public WebElement NotActiveWeightUnit;
	
	@FindBy(css = "input[name = 'metric_activity']:not(:checked) + span")
	public WebElement NotActiveDefaultActivity;
	
	@FindBy(css = "input[name = 'metric_distance']:not(:checked) + span")
	public WebElement NotActiveDistanceUnit;

	/*@FindBy(xpath = "//*[@class='col-md-6 col-xs-6']/input[@value='OK']")
	public WebElement OkButtonForDelete;*/

	@FindBy(xpath = "//input[@value='OK']")
	public WebElement OkButtonForDelete;

	@FindBy(xpath = "//*[@class='col-md-6 col-xs-6']/input[@value='Cancel']")
	public WebElement CancelButton;

	@FindBy(id = "alertText")
	public WebElement EraseTextWindow;

	@FindBy(id = "alertText")
	public WebElement DeleteTextWindow;

	@FindBy(xpath = "//input[@class='ibt-button f-disc']")
	public WebElement ConnectToFBButton;

	@FindBy(xpath = "//input[@class='ibt-button t-disc']")
	public WebElement ConnectToTwitterButton;
	
	@FindBy(id = "MetricUpdate")
	public WebElement MetricUpdateButton;
	
	@FindBy(xpath = "//span[text() = 'cm']")
	public WebElement HeightUnitCm;
	
	@FindBy(xpath = "")
	public WebElement HeightUnitFt;
	
	@FindBy(xpath = "")
	public WebElement WeightUnitKg;
	
	@FindBy(xpath = "")
	public WebElement WeightUnitLbs;

	/* Heart Rate Zones Page */
	@FindBy(xpath = "//*[@class='top-content'][text()='Heart rate zone']")
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

	@FindBy(xpath = "//button[@name='__CONFIRM__']")
	public WebElement FBOKButton;

	@FindBy(id = "username_or_email")
	public WebElement TwitterEmailField;

	@FindBy(id = "password")
	public WebElement TwitterPasswordField;

	@FindBy(id = "allow")
	public WebElement TwitterAuthorizeButton;

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
	
	public void chooseRandomValuesFromDropDownList(WebElement listField){
		
		Random random = new Random();
		List<WebElement> options = new Select(listField).getOptions();

		WebElement element = options.get(random.nextInt(options.size()));

		element.click();

		Utils.waitPage();
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
		driver.get(parameters.Amazon_Web_Testing_URL+"/appconfirm?user=" + username
				+ "&token=" + usertoken + "&status=PARTIAL");
		/*driver.get("http://user.instabeat.me/user/appconfirm?user=" + username
				+ "&token=" + usertoken + "&status=PARTIAL");*/
	}

	public void sendSessionFromDevice() throws Exception{
		HTTPMethod.PostSession();
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
			Utils.Log.info("|Got to page " + driver.getTitle() + " by link " + elements[a]);
			driver.navigate().back();
		}
		Utils.Log.info("|An amount of links on the page are: "+linkElement.size());
		Utils.Log.info("|An amount of passed links are: "+elements.length);
		driver.navigate().to(parameters.Amazon_Web_Testing_URL);
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

	public boolean isCongratsMessagePresent(String text, WebElement message){
		verificationOfElementsOnPages(message);
		return verifyPageContent(text);
	}

	public static String stripNonDigits(final CharSequence input){

		final StringBuilder sb = new StringBuilder(input.length());
		for(int i = 0; i < input.length(); i++){
			final char c = input.charAt(i);
			if(c > 47 && c < 58){
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public String convertCmToFt(String data){
		Utils.Log.info("|Converting values ... ");
		int intValue = Integer.parseInt(data);

		double foot = intValue/30.48;
		Utils.Log.info("|Ft: " + foot);

		double inch = (intValue / 2.54) - ((int)foot * 12);
		Utils.Log.info("|Inch: " + inch);

		int Ft = (int)foot;
		int In = (int)Math.round(inch);

		String convertedValues = Ft + " ft " + In + " inch";
		Utils.Log.info("|Result of converting is: " + convertedValues);

		return convertedValues;
	}
	
	public String convertFtToCm(String dataFoot, String dataInch){
		Utils.Log.info("|Converting values ... ");
		
		int intFtValue = Integer.parseInt(dataFoot);
		int intInchValue = Integer.parseInt(dataInch);

		double footConverted = intFtValue*30.48;
		Utils.Log.info("|Ft: " + footConverted);

		double inchconverted = intInchValue*2.54;
		Utils.Log.info("|Inch: " + inchconverted);

		int Ft = (int)footConverted;
		int In = (int)Math.round(inchconverted);
		int resultsInCm = Ft+In;
		
		String convrertedResultIntoString = Integer.toString(resultsInCm);
		System.out.println(convrertedResultIntoString);
//		String convertedValues = Ft + " ft " + In + " inch";
		Utils.Log.info("|Result of converting is: " + resultsInCm );

		return convrertedResultIntoString;
	}
	
	public String test(String feet, String inches){
		
		int intFtValue = Integer.parseInt(feet);
		int intInchValue = Integer.parseInt(inches);
		
		double cmToFeet = (int)intFtValue * 30.48;
		double cmToInches = intInchValue * 2.54;
		double ConvertedCm = cmToFeet + cmToInches;
		
		int a = (int)ConvertedCm;
		
		String convrertedResultIntoString = Integer.toString(a);
		
		return convrertedResultIntoString;
	}

	
	public String getTheValueFromFields(WebElement field) {
		return field.getAttribute("value");
	}
}
