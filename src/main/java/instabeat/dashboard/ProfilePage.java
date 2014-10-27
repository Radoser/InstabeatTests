package instabeat.dashboard;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends MainPagesFunc {

	public ProfilePage(WebDriver driver) {
		super(driver);
		createRandomValues(3);
		createRandomNumbers(120, 200);
	}

	public void updateFirstNameField() {
		FirstNameField.clear();
		FirstNameField.sendKeys(randomValues);
	}

	public void updateLastNameField() {
		LastNameField.clear();
		LastNameField.sendKeys(randomValues);
	}

	public void updateBirthdateField() {
		chooseRandomValuesFromDropDownList(MonthSelectOnProfile);
		chooseRandomValuesFromDropDownList(DaySelectOnProfile);
		chooseRandomValuesFromDropDownList(YearSelectOnProfile);
	}
	
	public void updateCountryField() {
		chooseRandomValuesFromDropDownList(UTCzones);
	}

	public void updateHeightfield() {
		HeightField.sendKeys(randomNumbers);
	}

	public void updateWeightField() {
		WeightField.sendKeys(randomNumbers);
	}

	public void clickOnUpdateButton() {
		ProfileUpdateButton.click();
	}

	public void changeFitnessLevel() {
		FitnessLevel.click();
		WebElement element = Utils.getRandomFromList(FitnessLevel
				.findElements(By.tagName("option")));
		element.click();
	}

	public void checkMessageAboutUpdate() {
		if (MessageAboutUpdateProfile.isDisplayed()) {
			MessageAboutUpdateProfile
					.getText()
					.contains(
							"Your profile has been updated! Plug-in your device now to sync");
			System.out
					.println("--------------Update with after sync device--------------");
		} else {
			MessageAboutUpdateProfile.getText().contains(
					"Your profile has been updated!");
			System.out
					.println("--------------Update without sync device--------------");
		}
	}

	public boolean checkIconToSyncDevice() {
		return verificationOfElementsOnPages(ExclamationMark);
	}

	public void isUserTitleNameEqualsUserName() {
		Assert.assertTrue(UserNameTitle.getText().contains(
				FirstNameField.getText()));
	}

	public void updateUserPicture() throws IOException {
		Process proc = Runtime.getRuntime().exec(
				"D:\\eclipse-java-juno-SR1-win32-x86_64\\eclipse-jee-kepler-SR2-win32-x86_64\\eclipse\\a.exe");
		driver.findElement(By.xpath("//div[@onclick=\"$('#file').click()\"]"))
				.click();
		Utils.waitPage();
	}
	
	public ProfilePageSettings clickOnProfilePageSettings(){
		ProfileSettingsLink.click();
		return PageFactory.initElements(driver, ProfilePageSettings.class);
	}

	public void firstNameValidation() {
//		Utils.clearField(FirstNameField);
		typeValuesForValidation(parameters.EMonlyLettersFirstName, Utils.dataForTextFieldsInput, FirstNameField, UpdateUserProfileButton, DashboardErrorMessages);
		FirstNameField.sendKeys(randomValues);		
	}

	public void lastNameValidation() {
		typeValuesForValidation(parameters.EMonlyLettersLastName, Utils.dataForTextFieldsInput, LastNameField, UpdateUserProfileButton, DashboardErrorMessages);
		LastNameField.sendKeys(randomValues);		
	}

	public void dateOfBirthValidation() {
		typeValuesForValidation(parameters.EMwrongBirthdate, Utils.dataForDateFieldInput, DateOfBirthField, UpdateUserProfileButton, DashboardErrorMessages);
		DateOfBirthField.sendKeys("1/1/1990");		
	}

	public void minHeightFieldValidation() {
		typeValuesForValidation(parameters.EMminimumNumberHeight, Utils.dataForMinHeightFieldInput, HeightField, UpdateUserProfileButton, DashboardErrorMessages);		
	}

	public void maxHeightFieldValidation() {
		typeValuesForValidation(parameters.EMmaximumNumberHeight, Utils.dataForMaxHeightFieldInput, HeightField, UpdateUserProfileButton, DashboardErrorMessages);
		HeightField.sendKeys(randomNumbers);		
	}

	public void minWeightFieldValidation() {
		typeValuesForValidation(parameters.EMminimumNumberWeight, Utils.dataForMinWeightFieldInput, WeightField, UpdateUserProfileButton, DashboardErrorMessages);		
	}

	public void maxWeightFieldValidation() {
		typeValuesForValidation(parameters.EMmaximumNumberWeight, Utils.dataForMaxWeightFieldInput, WeightField, UpdateUserProfileButton, DashboardErrorMessages);
		WeightField.sendKeys(randomNumbers);		
	}
	
	
	
}
