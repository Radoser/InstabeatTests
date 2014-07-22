package instabeat.dashboard;

import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends MainPagesFunc {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isHomePagePresent() {
		return verifyPageContent("Home");
	}
	
	public boolean isCongratsPresent(){
		return verifyPageContent("Congratulations! Please sync your device and you are ready to swim!");
//			xpath	.//*[@id='cong-text']
	}

	public void cliclOnCalendarButton() {
		click(By.xpath(parameters.CalendarButton));
	}

	public boolean IsCalendarPresent() {
		return fields(By.xpath(parameters.CalendarButton));
	}

	
}
