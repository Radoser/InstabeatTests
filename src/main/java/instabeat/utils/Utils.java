package instabeat.utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Utils {

	public static void waitPage() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void delay(final long amount) {
		try {
			Thread.sleep(amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static WebElement getRandomFromList(List<WebElement> list){
		int size = list.size();
		int item = new Random().nextInt(size); 
		int i = 0;
		for(WebElement obj : list)
		{
		    if (i == item)
		        return obj;
		    i = i + 1;
		    
		}
		return null;
	}
}
