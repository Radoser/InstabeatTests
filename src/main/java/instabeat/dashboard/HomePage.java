package instabeat.dashboard;

import instabeat.utils.MainPagesFunc;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends MainPagesFunc {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isHomePagePresent() {
		return verifyPageContent("Home");
	}

	public boolean isCongratsPresent() {
		Assert.assertTrue(verificationOfElementsOnPages(CongratsMessage));
		return verifyPageContent("Congratulations! Please sync your device and you are ready to swim!");

		// xpath .//*[@id='cong-text']
	}

	public void cliclOnCalendarButton() {
		CalendarButton.click();
	}

	public void isCalendarButtonPresent() {
		verificationOfElementsOnPages(CalendarButton);
	}

	public void isDateWithSessionsPresent() {
		if (ActiveDateWithSession.isDisplayed()) {
			DateContainsSessions.click();
		} else {
			System.out.println("This user has no sessions in past =(");
		}
	}
	
	public void clickOnContextMenu() {
		ContextMenu.click();
		}
	
	public void clickOnSession(){
		driver.findElement(By.xpath(".//*[@id='select2-result-label-8']")).click();
	}

	public ProfilePage clickOnProfileTab(){
		ProfileTab.click();
		return PageFactory.initElements(driver, ProfilePage.class);
	}
	
	public HeartRateZonesPage clickOnHRZTab(){
		HRZTab.click();
		return PageFactory.initElements(driver, HeartRateZonesPage.class);
	}
	
	/*
	 * public boolean IsCalendarPresent() { return
	 * fields(By.xpath(parameters.CalendarButton)); }
	 */

}
