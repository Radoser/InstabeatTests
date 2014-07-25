package instabeat.pages;

import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GetSartedFirstStep extends MainPagesFunc {

	public GetSartedFirstStep(WebDriver driver) {
		super(driver);
	}

	public void printPageTitle() {
		System.out.println("------------------>GetStarted 1 Page<------------------");
	}
	
	public boolean checkUserEmail(String value) {
		return driver.findElement(By.id("usermail")).getText().contains(value);
	}

	public GetStartedSecondStep getConfirmationLink() throws Exception {
		GoToIMAPServer();
		return PageFactory.initElements(driver, GetStartedSecondStep.class);
	}
}
