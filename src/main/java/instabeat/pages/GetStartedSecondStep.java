package instabeat.pages;

import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GetStartedSecondStep extends MainPagesFunc {

	public GetStartedSecondStep(WebDriver driver) {
		super(driver);
	}

	public void printPageTitle() {
			System.out.println("------------------>GetStarted 2 Page<------------------");
		}
	
	public void verifyGetInstabeatConnectText(){
		verifyPageContent("Get InstabeatConnect");
	}
	
	public void downloadApp(){
		if (driver.findElement(By.linkText("WINDOWS")).isDisplayed()){
			click(By.xpath("//a[@href='/user/files/Instabeat.exe']"));
		}else{
			driver.findElement(By.linkText("WINDOWS")).click();
			System.out.println("CLIKED BY LINK");
		}
	}
	
	public GetStartedThirdStep loginByApp(String value) throws Exception
	{
		LoginApp(value);
		return PageFactory.initElements(driver, GetStartedThirdStep.class);
	}
	
}
