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
	
	public void encewcwec(){
		if (DateContainsSessions.isDisplayed()){
			DateContainsSessions.click();
			System.out.println(DateContainsSessions.getText());
			System.out.println(oldDay.getText());
		}else if (oldDay.isDisplayed()){
			System.out.println(oldDay);
			oldDay.click();
		}else{
			System.out.println("___________________");
		}
	}
	
	public void clickOnContextMenu() {
		ContextMenu.click();
		}
	
	public void clickOnSession(){
		driver.findElement(By.xpath("//*[@role='option']")).click();
	}

	public ProfilePage clickOnProfileTab(){
		ProfileTab.click();
		return PageFactory.initElements(driver, ProfilePage.class);
	}
	
	public HeartRateZonesPage clickOnHRZTab(){
		HRZTab.click();
		return PageFactory.initElements(driver, HeartRateZonesPage.class);
	}
	
	public void shareGraphByFB(){
		PlusButton.click();
		FBShareGraphButton.click();
	}
	
	/*
	 * public boolean IsCalendarPresent() { return
	 * fields(By.xpath(parameters.CalendarButton)); }
	 */

}
