package instabeat.dashboard;

import java.io.BufferedReader;
import java.util.List;

import instabeat.utils.MainPagesFunc;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeartRateZonesPage extends MainPagesFunc{

	
	public HeartRateZonesPage(WebDriver driver) {
		super(driver);
		createRandomNumbers(30,119);
	}

	public void typeRHR() {
	RHRField.sendKeys(randomNumbers);
	}
	
	public void clickOnCalculateButton(){
		CalculateHRButton.click();
	}
	
	public void clickOnUpdateButton(){
		UpdateButton.click();
	}
	
	/*public void isSuccessMessagePresent() {
		
		String message = driver.findElement(By.tagName("span")).getAttribute("class");
		Assert.assertTrue("There is no such as text", message.contains("Your zones have been configured! Plug-in your device now to sync"));
	}*/
	
	public void isSuccessMessagePresent() {
	Assert.assertTrue(verifyPageContent("Your zones have been configured! Plug-in your device now to sync"));
	}
	
	public void typeHeartRateIntoBoxes(){
		 WebElement a =  formOfHR;
		 List<WebElement> b = a.findElements(By.xpath("//*[@class='col-md-4 col-xs-4']/input[@name]"));
		 for (WebElement element: b) {
		      System.out.println(element.getAttribute("name"));//getText());
		      element.clear();
		      element.sendKeys(randomNumbers);
		      randomNumbers=Integer.toString(Integer.parseInt(randomNumbers)+5);
         }
	}
	
	
}
