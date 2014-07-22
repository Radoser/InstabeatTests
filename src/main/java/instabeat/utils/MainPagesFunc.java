package instabeat.utils;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPagesFunc {

	protected WebDriver driver;
	protected ParametersManager parameters;
	Random random = new Random();

	public MainPagesFunc(WebDriver driver) {
		parameters = new ParametersManager();
		parameters.getPropertyFields();
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

	/*public boolean fields(By by) {
		 WebElement  by = driver.findElement(by);
		return by; 
	}*/

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
		driver.findElement(By.xpath(parameters.LogoutLink)).click();

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
	
	
}

// login page

/*
 * By email_Field = By.id(EmailField); By password_Field = By.id(PasswordField);
 * //public By login_Button = By.xpath(LoginButton);
 * 
 * By get_started_link = By.linkText("Get started here"); //By get_started_Link
 * = By.xpath(""); By forgotPassword_link = By.xpath(""); By logout_link =
 * By.xpath("");
 * 
 * //forgot password page By existingEmail_Field = By.id("email"); By
 * forgot_Button =
 * By.xpath(".//*[@id='response-false']/form/div[3]/div[2]/button");
 * 
 * //reset password page By newPassword_Field = By.xpath("//div[
 */// text()='New Password']/descendant::input[@id='passwordInput']");
// By confirmPassword_Field =
// By.xpath("//div[*/text() = 'Confirm New Password']/descendant::input[@id='password_conf']");
// By reset_Button =
// By.xpath("html/body/div[4]/div/div[2]/form/div[1]/div[3]/button");*/

// ////////
