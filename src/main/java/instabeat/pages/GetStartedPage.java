package instabeat.pages;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GetStartedPage extends MainPagesFunc {



	public GetStartedPage(WebDriver driver) {
		super(driver);
		createRandomUser();
		createRandomNumbers(100, 250);
		createRandomValues(5);
		map.put(parameters.FirstNameField, "TestAuto");
		map.put(parameters.LastNameField, "User");
		map.put(parameters.EmailField, randomUser);
		map.put(parameters.PasswordField, parameters.UserPassword);
		map.put(parameters.ConfirmNewPasswordField, parameters.UserPassword);
		map.put(parameters.HeightField, randomNumbers);
		map.put(parameters.WeightField, randomNumbers);
		map.put(parameters.DefaultPoolLength, randomNumbers);
	}

	private Map<String, String> map = new HashMap();

	public void typeUserValues() {
		for (String key : map.keySet()) {
			values(By.id(key), map.get(key));
			Utils.Log.info(map.get(key) + "ENTRED VALUE!!!!!!!!!!");
		}
	}

	public GetSartedFirstStep clickOnSignUpButton() {
		SignUpButton.click();
		return PageFactory.initElements(driver, GetSartedFirstStep.class);
	}

	public void randomUserValues() {
		FirstNameField.sendKeys(randomValues);
	}
	
	public void chooseMonthOfBitrh() {
		chooseRandomValuesFromDropDownList(MonthSelect);
	}
	
	public void chooseDayOfBitrh() {
		chooseRandomValuesFromDropDownList(DaySelect);
	}
	
	public void chooseYearOfBitrh() {
		chooseRandomValuesFromDropDownList(YearSelect);
	}
	
	public void chooseHeightMetric() {
		chooseRandomValuesFromDropDownList(HeightMetric);
	}
	
	public void chooseWeightMetric() {
		chooseRandomValuesFromDropDownList(WeightMetric);
	}
	
	public void choosePoolDistanceMetric() {
		chooseRandomValuesFromDropDownList(PoolDistanceMetric);
	}
	
	public void chooseCountry() {
		chooseRandomValuesFromDropDownList(ChooseCountry);
	}

	public void firstNameValidation() {
		typeValuesForValidation(parameters.EMonlyLettersFirstName, Utils.dataForTextFieldsInput, FirstNameField, SignUpButton, ErrorMessages);
		FirstNameField.sendKeys(randomValues);
	}
	
	public void lastNameValidation(){
		typeValuesForValidation(parameters.EMonlyLettersLastName, Utils.dataForTextFieldsInput, LastNameField, SignUpButton, ErrorMessages);
		LastNameField.sendKeys(randomValues);
	}
	
	public void emailValidation(){
		typeValuesForValidation(parameters.EMinvalidEmail, Utils.dataForEmailFieldInput, EmailField, SignUpButton, ErrorMessages);
		EmailField.sendKeys(randomUser);
	}
	
	public void passwordValidation(){
		typeValuesForValidation(parameters.EMinvalidPassword, Utils.dataForPassFieldInput, PasswordField, SignUpButton, ErrorMessages);
		PasswordField.sendKeys(parameters.UserPassword);
	}
	
	public void confirmPasswordValidation(){
		typeValuesForValidation(parameters.EMpasswordNotMatch, Utils.dataForConfirmPassFieldInput, ConfirmNewPasswordField, SignUpButton, ErrorMessages);
		ConfirmNewPasswordField.sendKeys(parameters.UserPassword);
	}
	
	/*need a rework*/
	public void dateOfBirthValidation(){
		typeValuesForValidation(parameters.EMwrongBirthdate, Utils.dataForDateFieldInput, DateOfBirthField, SignUpButton, ErrorMessages);
		DateOfBirthField.sendKeys("1/1/1990");
	}
	
	public void minHeightFieldValidation(){
		typeValuesForValidation(parameters.EMminimumNumberHeight, Utils.dataForMinHeightFieldInput, HeightFieldOnGo, SignUpButton, ErrorMessages);
	}
	
	public void maxHeightFieldValidation(){
		typeValuesForValidation(parameters.EMmaximumNumberHeight, Utils.dataForMaxHeightFieldInput, HeightField, SignUpButton, ErrorMessages);
		HeightField.sendKeys(randomNumbers);
	}
	
	public void minWeightFieldValidation(){
		typeValuesForValidation(parameters.EMminimumNumberWeight, Utils.dataForMinWeightFieldInput, WeightField, SignUpButton, ErrorMessages);
	}
	
	public void maxWeightFieldValidation(){
		typeValuesForValidation(parameters.EMmaximumNumberWeight, Utils.dataForMaxWeightFieldInput, WeightField, SignUpButton, ErrorMessages);
		WeightField.sendKeys(randomNumbers);
	}
	
	public void defaultPoolLengthValidation(){
		typeValuesForValidation(parameters.EMdefaultPoolLength, Utils.dataForDefaultPoolLenghtInput, PoolLengthField, SignUpButton, ErrorMessages);
		PoolLengthField.sendKeys(randomNumbers);
	}

	public void goToLoginPage() {
	LoginLink.click();		
	}

}
