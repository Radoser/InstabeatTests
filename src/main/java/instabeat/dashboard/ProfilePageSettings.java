package instabeat.dashboard;

import java.util.List;
import java.util.Random;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProfilePageSettings extends MainPagesFunc {

	public ProfilePageSettings(WebDriver driver) {
		super(driver);
	}

	public void typeOldPassword() {
		OldPasswordField.sendKeys(parameters.UserPassword);
	}

	public void typeNewPassword() {
		NewUserProfilePasswordField.sendKeys(parameters.UserPassword);
	}

	public void typeConfirmNewPassword() {
		ConfirmNewUserProfilePasswordField.sendKeys(parameters.UserPassword);
	}

	public void clickOnUpdateButton() {
		UpdateUserProfileButton.click();
	}

	public void changeUTC() {
		
/*//		UTCzones.click();
		WebElement button = driver.findElement(By.xpath("//span[@id='select2-chosen-6'][@class='select2-chosen']"));
		button.click();
		Utils.waitPage();*/
				
/*		WebElement element = Utils.getRandomFromList(((WebDriver) oSelection).findElements(By
				.tagName("option")));
		System.out.println(element.getAttribute("value"));
		element.submit();*/

		List<WebElement> options = new Select(UTCzones).getOptions();
		for(WebElement city:options)
		{
		    city.equals(new Random().nextInt());
		   
		    city.click();
//			System.out.println(city.getText());    //It will return the text of each option
//		      System.out.println(city.getAttribute("option"));    //it will return the value attribute of each option
		}
		
	/*	List<WebElement> options = UTCzones.findElements(By.tagName("option"));
		Random r = new Random();*/
//		options.get(new Random().nextInt()).click();
		
		
		
		Utils.waitPage();
	}
	
	public int RandomSelectInt(List<WebElement> elements)
	{
	    int options = elements.size();
	    Random random = new Random();
	    return random.nextInt(options);
	}

	public void changeMetrics() {
		// need to add random click

	}

	public void clickOnEraseDataButton() {
		SessionsEraseButton.click();
	}

	public void checkIfEraseWindowOpened(){
		String text = "Are you sure you want to erase your data? Erased data cannot be recovered!";
		Assert.assertEquals(text, EraseTextWindow.getText());
	}
	
	public void confirmEraseAllSessions() {
		OkButtonForDelete.click();
	}

	public void clickOnCancelButton() {
		CancelButton.click();
	}

	public HomePage clickOnHomeTab() {
		HomeTab.click();
		return PageFactory.initElements(driver, HomePage.class);
	}

	public void clickOnDeleteAccountButton() {
		AccountDeleteButton.click();		
	}
	
	public void checkIfDeleteWindowOpened(){
		String text = "Are you sure you want to delete your account? Deleted accounts cannot be recovered!";
		Assert.assertEquals(text, EraseTextWindow.getText());
	}
	
	public void confirmDeleteAccout(){
		OkButtonForDelete.click();
	}
	
	public void FaceBookConnect(){
		String parent = driver.getWindowHandle();
		ConnectToFBButton.click();
		for (String child : driver.getWindowHandles())
		{
			
			driver.switchTo().window(child);
			Utils.waitPage();
		}
		FBEmailField.sendKeys(parameters.FBUserEmail);
		FBPasswordField.sendKeys(parameters.UserPassword);
		FBLoginButton.click();
			driver.switchTo().window(parent);
	}
}
