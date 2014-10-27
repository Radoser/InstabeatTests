package instabeat.dashboard;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
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

	public void clickOnChangePasswordButton() {
		PasswordUpdateButton.click();
	}

	public void changeSettingsRandomly() {
		List<WebElement> a = driver.findElements(By.xpath("//*[@class ='col-md-9 col-xs-9 custom-inputs']//span"));
		for (WebElement b : a){
			b = a.get(new Random().nextInt(a.size()));
			b.click();
			System.out.println(b.getText());
		}
	}
	
	public void changeHeightUnit(){
		
	}
	
	public void changeWeightUnit() {
		
	}
	
	public void changeDefaultActivity() {
		
	}
	
	public void changeDefaultPoolLength() {
		
	}
	
	public void changeDefaultPoolLengthMetric() {
		
	}
	
	public void changeDistanceUnit() {
		
	}
	
	public void clickOnMetricUpdate() {
		MetricUpdateButton.click();		
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
	
	public void checkIfPasswordSucChanged(){
		WebElement sucMessage = driver.findElement(By.xpath("//span[@class = 'suc-text']"));
		Assert.assertTrue(sucMessage.getText().contains("Your password has been changed!"));
	}

	public void confirmDeleteAccout() {
		OkButtonForDelete.click();
	}

	public void FaceBookConnect() {

		String parent = driver.getWindowHandle();

		if (ConnectToFBButton.getAttribute("value").contains("Click to unlink")){
			ConnectToFBButton.click();		
		} 

		Utils.waitPage();
		ConnectToFBButton.click();

		for (String child : driver.getWindowHandles()) {		
			driver.switchTo().window(child);
			Utils.waitPage();
		}	

		if(driver.getTitle().equals("Facebook")){	
			System.out.println(driver.getTitle());
			FBEmailField.sendKeys(parameters.FBUserEmail);
			FBPasswordField.sendKeys(parameters.UserPassword);
			FBLoginButton.click();
		}
		
		if(driver.getTitle().equals("Log in with Facebook")){
			boolean switcher = driver.getTitle().equals("Log in with Facebook");
			while(switcher){
				FBOKButton.click();	
				Utils.delay(2000);
				try{
					switcher = driver.getTitle().equals("Log in with Facebook");
				}catch(NoSuchWindowException e) {
					switcher = false;
				}
			}
		}
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
				PasswordUpdateButton.click();
				//				Utils.waitPage();
			}
			while(DashboardErrorMessages.getText() == errors.get(i));
		}
	}

	public void passwordsFieldsValidationForDifferentCases(){

		Utils.clearField(OldPasswordField);
		do {
			PasswordUpdateButton.click();
		}while(DashboardErrorMessages.getText() == parameters.EMoldPasswordRequired);

		do{
			OldPasswordField.sendKeys(parameters.UserPassword);
			Utils.clearField(NewUserProfilePasswordField);
			PasswordUpdateButton.click();
		}while (DashboardErrorMessages.getText() == parameters.EMconfirmRequired);

		do{
			NewUserProfilePasswordField.sendKeys(parameters.UserPassword);
			Utils.clearField(ConfirmNewUserProfilePasswordField);
			PasswordUpdateButton.click();
		}while(DashboardErrorMessages.getText() == parameters.EMconfirmRequired);
	}

	public void checkIfFBConnectionSuc(){
		Assert.assertTrue(ConnectToFBButton.getAttribute("value").contains("Click to unlink"));
	}

	public void TwitterConnect() {
		if (ConnectToTwitterButton.getAttribute("value").contains("Click to unlink")){
			ConnectToTwitterButton.click();
		}
		ConnectToTwitterButton.click();
		
		if(driver.getPageSource().contains("Sign up for Twitter")){
			TwitterEmailField.sendKeys(parameters.TwitterUserEmail);
			TwitterPasswordField.sendKeys(parameters.TwitterUserPassword);
			TwitterAuthorizeButton.click();	
		}
		
		if(!driver.getPageSource().contains("Sign up for Twitter")){
			TwitterAuthorizeButton.click();
		}
	}
	
	public void confirmTwitterConnection(){
		
	}

	public void checkIfTwitterConnectionSuc() {
		Assert.assertTrue(ConnectToTwitterButton.getAttribute("value").contains("Click to unlink"));
	}

	
}
