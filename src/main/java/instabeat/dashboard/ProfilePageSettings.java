package instabeat.dashboard;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import java.util.List;
import java.util.Random;

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

	public void changeCountry() {

		Random random = new Random();
		List<WebElement> options = new Select(UTCzones).getOptions();

		WebElement element = options.get(random.nextInt(options.size()));

		element.click();

		Utils.waitPage();
	}

	public void changeMetrics() {
		// need to add random click

	}

	public void clickOnEraseDataButton() {
		SessionsEraseButton.click();
	}

	public void checkIfEraseWindowOpened() {
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

	public void checkIfDeleteWindowOpened() {
		String text = "Are you sure you want to delete your account? Deleted accounts cannot be recovered!";
		Assert.assertEquals(text, EraseTextWindow.getText());
	}

	public void confirmDeleteAccout() {
		OkButtonForDelete.click();
	}

	public void FaceBookConnect() {
		String parent = driver.getWindowHandle();
		ConnectToFBButton.click();
		for (String child : driver.getWindowHandles()) {
			driver.switchTo().window(child);
			Utils.waitPage();
		}
		FBEmailField.sendKeys(parameters.FBUserEmail);
		FBPasswordField.sendKeys(parameters.UserPassword);
		FBLoginButton.click();
		driver.switchTo().window(parent);
	}
}
