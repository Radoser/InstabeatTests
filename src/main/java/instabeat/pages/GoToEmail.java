package instabeat.pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.instabeat.sanity.utils.*;

public class GoToEmail extends MainPagesFunc
{
	
	public GoToEmail (WebDriver driver){
		super(driver);
	}


	public void getConfirmationFromEmailTest ()
	{
		List<WebElement> fields = driver.findElements(By.tagName("input"));
		for (WebElement field : fields)
		{
			if(field.getAttribute("name").contains("Login"))
			{
				field.sendKeys("testusergl@ukr.net");
			}
			if(field.getAttribute("name").contains("Password"))
			{
				field.sendKeys("123456");
				break;
			}
		}
		
		List<WebElement> button = driver.findElements(By.tagName("button"));
		for(WebElement buttons : button)
		{
			if(buttons.getText().equals("Login"))
			{
				buttons.click();
				break;
			}
		}
		
		List<WebElement> unreadLine = driver.findElements(By.tagName("span"));
			for (WebElement unread : unreadLine)
			{
				if (unread.getText().equals("Unread"))
				{
					unread.click();
					break;
				}
			}
			
			
			 /*if (verifyTextPresent("admin@instabeat.me"))
         	{
				//WebElement newEmail = driver.findElement(By.partialLinkText("Reset"));
				WebElement newEmail = driver.findElement(By.xpath("//span[@class='from-name']"));
				newEmail.click();
				
         	}*/
			 WebElement newEmail = driver.findElement(By.xpath("//span[@class='from-name']"));
				newEmail.click();
			 
	}	 
			 

	public ResetPasswordPage clickOnConfirmLink () throws IOException 
	{
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[img/@width='167']")).click();
		driver.switchTo().window(parent).close();
		for (String child : driver.getWindowHandles())
		{
			driver.switchTo().window(child);
			break;
		}
	
		return new ResetPasswordPage(driver);
	}		

	public boolean verifyTextPresent (String text)
	{
        return driver.getPageSource().contains(text);
    }

}
		