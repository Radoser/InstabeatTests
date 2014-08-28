package instabeat.pages;

import java.io.IOException;

import instabeat.utils.MainPagesFunc;
import instabeat.utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GetStartedSecondStep extends MainPagesFunc {

	public GetStartedSecondStep(WebDriver driver) {
		super(driver);
	}

	public void printPageTitle() {
		Utils.Log.info("|Actual Page is: "+driver.getTitle());
		
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

//	Access denied --> Parity =(
	public void clickOnSave() throws IOException{
		
		Utils.delay(2000);
		Process proc = Runtime.getRuntime().exec(
				"D:\\Projects\\clickDownload.exe");
		Utils.waitPage();
	}
	
	public GetStartedThirdStep loginByApp(String value) throws Exception
	{
		LoginApp(value);
		return PageFactory.initElements(driver, GetStartedThirdStep.class);
	}
	
}
