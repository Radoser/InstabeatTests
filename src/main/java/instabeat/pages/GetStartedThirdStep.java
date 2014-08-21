package instabeat.pages;

import instabeat.dashboard.HomePage;
import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GetStartedThirdStep extends MainPagesFunc {

	public GetStartedThirdStep(WebDriver driver) {
		super(driver);
	}

	public void printPageTitle() {
		Utils.Log.info("|Actual Page is: "+driver.getTitle());
	}

	public void verifyTextPresentOnPage() {
		verifyPageContent("Don't know your target zones?");
	}

	public void typeRHRValue() {
		RHRField.sendKeys("25");
	}

	public void clickOnCalculateButton() {
		CalculateHRButton.click();
	}
	
	public HomePage clickOnUpdateButton(){
		UpdateButton.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
}
