package instabeat.pages;

import instabeat.dashboard.HomePage;
import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GetStartedThirdStep extends MainPagesFunc {

	public GetStartedThirdStep(WebDriver driver) {
		super(driver);
	}

	public void printPageTitle() {
		System.out.println("------------------>GetStarted 3 Page<------------------");
		System.out.println("--------------->"+driver.getTitle()+"<---------------");
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
