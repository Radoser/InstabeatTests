package instabeat.dashboard;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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
		UTCzones.click();
		Utils.waitPage();

		WebElement element = Utils.getRandomFromList(UTCzones.findElements(By
				.tagName("option")));
		System.out.println(element.getAttribute("value"));
		element.submit();
		Utils.waitPage();
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
		OkButtonForDeleteSessions.click();
	}

	public void cancelEraseAllSessions() {
		CancelButtonForDeleteAllSessions.click();
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
	
	public void clickOnCancelButton(){
		
	}
	
	
}
