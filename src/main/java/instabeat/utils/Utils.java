package instabeat.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebElement;

public class Utils {

	public static List<String> dataForTextFieldsInput = Arrays.asList(
			"123",
			"!@#$%^&*()_+",
			"QWE123",
			"123qwe",
			" ",
			" qwe",
			"qw er"
			);
	public static List <String> dataForDateFieldInput = Arrays.asList(
			"123",
			"!@#$%^&*()_+",
			"QWE123", "123qwe",
			" ",
			" qwe",
			"qw er",
			"05/32/200",
			"13/31/2000",
			"00/00/2000",
			"qw/12/2000",
			"01/qw/2000",
			"01/01/qwert",
			"01.01.2000",
			"01,01,01"
			);
	public static List<String> dataForEmailFieldInput = Arrays.asList(
			"#@%^%#$@#$@#.com",
			"@gmail.com",
			"test <test@gmail.com>",
			"test@gmail@gmail.com",
			" test@gmail.com",
			"test@gmail.com (test)",
			"test@gmail",
			/*"test@-gmail.com",*/
			"test@111.222.333.444",
			"test @gmail.com",
			"test@gmail. com"
			);

	public static List<String> dataForPassFieldInput = Arrays.asList(
			"1",
			"123",
			/*"12345678901234567",*/
			"1234567890123456789",
			"!@#$%^&*()_+-|?/.,:;"
			);
	public static List<String> dataForConfirmPassFieldInput = Arrays.asList(
			"123",
			"1234567"
			);

	public static List<String> dataForMinHeightFieldInput = Arrays.asList(
			"1",
			"99"
			);

	public static List<String> dataForMaxHeightFieldInput = Arrays.asList(
			"251",
			"999"
			);

	public static List<String> dataForMinWeightFieldInput = Arrays.asList(
			"1",
			"29"
			);

	public static List<String> dataForMaxWeightFieldInput = Arrays.asList(
			"301",
			"999"
			);

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

	public static Logger Log = Logger.getLogger(MainPagesFunc.class.getName());

	public static void logFile(){
		DOMConfigurator.configure("log4j.xml");
	}

	public static void clearField(WebElement field){
		field.clear();
	}		
}
