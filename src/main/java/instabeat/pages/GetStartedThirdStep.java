package instabeat.pages;

import instabeat.dashboard.HomePage;
import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetStartedThirdStep extends MainPagesFunc {

	public GetStartedThirdStep(WebDriver driver) {
		super(driver);
	}

	public void printPageTitle() {
		System.out
				.println("------------------>GetStarted 3 Page<------------------");
	}

	public void verifyTextPresentOnPage() {
		verifyPageContent("Don't know your target zones?");
	}

	public void typeRHRValue() {
		values(By.id(parameters.RHRField), "25");
	}

	public void clickOnCalculateButton() {
		click(By.id(parameters.CalculateHRButton));
	}
	
	public HomePage clickOnUpdateButton(){
		click(By.xpath(parameters.UpdateButton));
		return new HomePage(driver);
	}
}
