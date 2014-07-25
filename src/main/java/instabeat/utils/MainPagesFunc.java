package instabeat.utils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPagesFunc {


	protected WebDriver driver;
	protected ParametersManager parameters;
	Random random = new Random();

	@FindBy(xpath = "//div[@onclick='logOut()']")
	WebElement LogoutLink;
	
	/*Login Page*/
	@FindBy(id = "email")
	public static WebElement EmailField;
	
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
	public WebElement CalendarButtonDate;
	
	@FindBy(xpath = "//span[@class='cal-month']")
	public WebElement CalendarButtonMonth;
	
	@FindBy(xpath = "//*[@class = 'day ']")
	public WebElement DateContainsSessions;  
	
	@FindBy(how = How.CSS, using = ".day.active")
	public WebElement ActiveDateWithSession;
	
	@FindBy(xpath = ".//*[@id='cong-text']")
	public WebElement CongratsMessage;
	
	@FindBy(xpath = ".//*[@id='s2id_parentNode']/a")
	public WebElement ContextMenu;
	
	
	
	public MainPagesFunc(WebDriver driver) {
		parameters = new ParametersManager();
		parameters.getPropertyFields();
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	

	public String randomUser;// = "testusergl"+random.nextInt()+"@ukr.net";
	public String randomValues; // ="Name"+RandomStringUtils.randomAlphabetic(5);

	public void createRandomUser() {
		randomUser = "fortestgl+" + random.nextInt(Integer.MAX_VALUE)
				+ "@gmail.com";
	}

	public void createRandomValues() {
		randomValues = "Name" + RandomStringUtils.randomAlphabetic(5);
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
		driver.get("http://user.instabeat.me/user/appconfirm?user="
				+ username + "&token=" + usertoken + "&status=PARTIAL");
	}

	public void GetAllLinksOnPage(String title) {
		List<WebElement> linkElement = driver.findElements(By.tagName("a"));
		String[] linkText = new String[linkElement.size()];
		int i = 0;

		for (WebElement e : linkElement) {
			linkText[i] = e.getText();
			i++;
		}

		for (String t : linkText) {
			driver.findElement(By.linkText(t)).click();
			if (driver.getTitle().equals(title)) {
				
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
            System.out.println("Element"+element+"is PRESENT!!!");
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
	
	
}



