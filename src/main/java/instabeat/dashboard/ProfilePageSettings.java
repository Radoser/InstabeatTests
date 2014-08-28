package instabeat.dashboard;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProfilePageSettings extends MainPagesFunc {

	public ProfilePageSettings(WebDriver driver) {
		super(driver);
		createRandomNumbers(100000, 99999999);
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
	
	public void checkErrorMessage() {
		Assert.assertEquals(parameters.EMuserNotFound, ResetPassErrorMessages.getText());
	}
	
	public void passwordsFieldsValidation(){
		List<WebElement> fields = Arrays.asList(OldPasswordField, NewUserProfilePasswordField, ConfirmNewUserProfilePasswordField);
		List<String> errors = Arrays.asList(parameters.EMnewPasswordRequiered, parameters.EMnewPasswordRequiered, parameters.EMconfirmRequired);
		
		for(int i = 0; i<fields.size(); i++){
			do {	
				fields.get(i).sendKeys(randomNumbers);	
				UpdateUserProfileButton.click();
//				Utils.waitPage();
			}
			while(DashboardErrorMessages.getText() == errors.get(i));
			}
	}
	
	public void passwordsFieldsValidationForDifferentCases(){
		
		Utils.clearField(OldPasswordField);
		do {
			UpdateUserProfileButton.click();
		}while(DashboardErrorMessages.getText() == parameters.EMoldPasswordRequired);
		
		do{
			OldPasswordField.sendKeys(parameters.UserPassword);
			Utils.clearField(NewUserProfilePasswordField);
			UpdateUserProfileButton.click();
		}while (DashboardErrorMessages.getText() == parameters.EMconfirmRequired);
		
		do{
			NewUserProfilePasswordField.sendKeys(parameters.UserPassword);
			Utils.clearField(ConfirmNewUserProfilePasswordField);
			UpdateUserProfileButton.click();
		}while(DashboardErrorMessages.getText() == parameters.EMconfirmRequired);
	}
}
