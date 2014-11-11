package instabeat.dashboard;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends MainPagesFunc {

	public ProfilePage(WebDriver driver) {
		super(driver);
		createRandomValues(3);
		createRandomNumbers(120, 200);
	}
	
	public String heightFt;
	public String heightIn;
	public String heightValue;
	public String FtAndInchResult;
	public String weightValueInKg;
	public String weightValueInLbs;

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
		Process proc = Runtime.getRuntime().exec("D:\\Java\\eclipse-kepler\\eclipse\\a.exe");
		driver.findElement(By.xpath("//div[@onclick=\"$('#file').click()\"]")).click();
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

	public HomePage reloading() {
		Utils.Log.info("|Reloading the page...");
		driver.navigate().refresh();
		return PageFactory.initElements(driver, HomePage.class);		
	}
	
	public void checkChangesInHeightField() {
		try{
		Assert.assertEquals(heightValue, getTheValueFromFields(HeightField));
		}catch (Exception e){
			Assert.assertEquals(getValuesFromHeightField(), getValuesFromHeightFieldFtAndInch());
		}
	}
	
	
	
	public String getTheValueFromHeightField() {		
		heightValue = getTheValueFromFields(HeightField);
		Utils.Log.info("|The value from Height field is: " + heightValue);
		return heightValue;
	}
	
	public String getValuesFromHeightField() {
		try {				
			return getTheValueFromHeightField();		
			}catch (Exception e) {
				return getValuesFromHeightFieldFtAndInch();
			}
	}
	
	public String getValuesFromHeightFieldFtAndInch() {
		
		heightFt = getTheValueFromFields(HeightFtField);
		Utils.Log.info("|The value from Height field in Ft is: " + heightFt);
		
		heightIn = getTheValueFromFields(HeightInchField);
		Utils.Log.info("|The value from Height field in In is: " + heightIn);
		
		FtAndInchResult = heightFt + " ft " + heightIn + " inch";
		Utils.Log.info("|The result value from Height Feet and Inch fields are: " + FtAndInchResult);
		
		return FtAndInchResult;
	}
		
	public void checkConvertedValues() throws Exception {
		try{
			if(HeightField.isDisplayed()){
				Utils.Log.info("|Comparing the values that was given from field");
				Utils.Log.info("|Converting Cm into Feets and Inches...");
				
				Assert.assertEquals(Utils.conversion(driver.findElement(By.id("height-span")).getText(), heightValue), FtAndInchResult);
			}
		}catch(Exception e) {
			Utils.Log.info("|Comparing the values that was given from field");
			Utils.Log.info("|Converting Feets and Inches into Cm...");
			
			Assert.assertEquals(Utils.conversion(driver.findElement(By.xpath("//*[@class = 'ibt-metric'][text() = 'ft']")).getText(), FtAndInchResult), heightValue);
		}	
	}

	public String getTheValueFromWeightField() {
		
		if (driver.findElement(By.id("weight-span")).getText().equals("kg")){
			Utils.Log.info("|The kg metric is active");
			weightValueInKg = getTheValueFromFields(WeightField);
			Utils.Log.info("|The value from Weight field is: " + weightValueInKg);	
			return weightValueInKg;
		 
		}else {
			Utils.Log.info("|The lbs metric is active");	
			weightValueInLbs = getTheValueFromFields(WeightField);
				Utils.Log.info("|The value from Weight field is: " + weightValueInLbs);
				return weightValueInLbs;
			}
		}

	public void checkChangesInWeightField() {
		if(driver.findElement(By.id("weight-span")).getText().equals("kg")){
		Assert.assertEquals(weightValueInKg, getTheValueFromFields(WeightField));
		}else{
			Assert.assertEquals(weightValueInLbs, getTheValueFromFields(WeightField));
		}
	}
	
	public void checkChangesInWeightAfterConvert(){
		
		if(driver.findElement(By.id("weight-span")).getText().equals("kg")){
			Utils.Log.info("|Converting Kg into Lbs...");
			Assert.assertEquals(Utils.conversion(driver.findElement(By.id("weight-span")).getText(), weightValueInKg), weightValueInLbs);
			}else{
				Utils.Log.info("|Converting Lbs into Kg...");
				Assert.assertEquals(Utils.conversion(driver.findElement(By.id("weight-span")).getText(), weightValueInLbs), weightValueInKg);
			}
	}
	
}
