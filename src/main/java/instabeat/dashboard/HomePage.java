package instabeat.dashboard;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import java.util.Random;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends MainPagesFunc {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isHomePagePresent() {
		return verifyPageContent("Home");
	}

	public void isCongratsPresent() {
		isCongratsMessagePresent("Congratulations! Please sync your device and you are ready to swim!", CongratsMessage);
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

	public void showDatesWithSessions() {

		Utils.Log.info("|Active month is: "+ActiveMonth.getText());		
		for(WebElement dayWithSessions : DatesWithSessions){				
			Utils.Log.info("|This is a day with sessions: "+" "+dayWithSessions.getText()+" "+ActiveMonth.getText());
		}
		Utils.Log.info("|This is an active day with sessions: "+ActiveDateWithSession.getText()+" "+ActiveMonth.getText());

		int daysWithSessions = DatesWithSessions.size() + 1;//this is an amount of an active day
		Utils.Log.info("|Number of days with sessions in "+ ActiveMonth.getText()+" are: " + daysWithSessions);		
	}

	public void chooseDateWithSessionRandomly() {

		Random random = new Random();

		WebElement element = DatesWithSessions.get(random.nextInt(DatesWithSessions.size()));
		element.click();
		Utils.waitPage();
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

	public void clickOnPlusButton(){
		PlusButton.click();
	}

	public void clickOnFBShareButton(){
		FBShareGraphButton.click();
	}

	public void checkIfFBShareWindowOpened(){
		Utils.waitPage();
		String shareName = "Ro Ma";
		String text = "Do you want to share this swimming session on Facebook as "+shareName+"?";
		Assert.assertEquals(text, EraseTextWindow.getText());
	}

	public void confirmShareDataFB(){
		OkButtonForDelete.click();
		//		driver.findElement(By.xpath("//input[@value='OK']")).click();
	}

	public void cancelShareDataFB(){
		CancelButton.click();	
	}

	public void clickOnTwitterShareButton() {
		TwitterShareButton.click();		
	}

	public void checkIfTwitterShareWindowOpened(){
		String shareName = "testusergl1";
		String text = "Do you want to share this swimming session on Twitter as "+shareName+"?";
		Assert.assertEquals(text, EraseTextWindow.getText());
	}

	public void checkIfShareIsSucced(){
		Utils.waitPage();
		Assert.assertTrue(isCongratsMessagePresent("Your swiming activity was successfully shared!", CongratsMessage));
	}

	public void checkAllLinksFromDashboard() {
		GetAllLinksOnPage();
	}

	public void checkIfDurationTimeIsProper() {
		Assert.assertEquals(SessionDuration.getText(), SessionDurationInFooter.getText());
	}

	public void chheckIfTotalDistanceIsProper() {

		/*fot replace digits -  String mk = PoolLength.getText().replaceAll("[0-9 m ]",""); //("[a-z ]", "");
		System.out.println(mk);*/

		if(PoolLength.getText().contains("pool")){

			Utils.Log.info("|Pool is activated - checking total distance");
			String result = stripNonDigits(PoolLength.getText());
			int PoolLengthDigit = Integer.parseInt(result);

			String result2 = stripNonDigits(LapsAmount.getText());
			int LapsAmountDigit = Integer.parseInt(result2);

			int TotalDistance = PoolLengthDigit * LapsAmountDigit;

			String result3 = stripNonDigits(SessionTotalDistance.getText());
			int SessionTotalDistanceDigit = Integer.parseInt(result3);

			Assert.assertEquals(SessionTotalDistanceDigit, TotalDistance);
			Utils.Log.info("|Total distance is proper");

		}else{
			Utils.Log.info("|Open water is activated - nothing to check");
		}

	}

	public void checkIfAvaragePaceIsProper() {
		// TODO Auto-generated method stub

	}

	

}
