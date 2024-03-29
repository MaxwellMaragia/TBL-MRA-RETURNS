package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

//Base class to allow access to browser from hooks
public class BaseClass {
	//local variable that gets assigned below after properties class is instantiated
	public static WebDriver driver;
	public static Properties prop;

//	public static WebDriver getDriver() throws IOException
//	{
//		prop = new Properties();
//		FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
//		prop.load(fls);
//		System.setProperty("webdriver.gecko.driver", "Browsers\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
//
//        return driver;
//
//	}
public static void scrollIntoView(WebElement element) {
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("arguments[0].scrollIntoView()", element);

}

	public static WebDriver getDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
		prop.load(fls);

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu");
		System.setProperty("webdriver.chrome.driver", "Browsers\\chromedriver.exe");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		return driver;

	}
	public static String randomDate() {
	        
	        LocalDate from = LocalDate.of(2000, 1, 1);
	        LocalDate to = LocalDate.of(2017, 1, 1);
	        long days = from.until(to, ChronoUnit.DAYS);
	        long randomDays = ThreadLocalRandom.current().nextLong(days + 1);
	        LocalDate randomDate = from.plusDays(randomDays);
	        return randomDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	    }

	public static String daysFromToday(int i){
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(i, ChronoUnit.DAYS);
		String formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return formattedDate;
	}
	
	public static String todaysDate() {
		LocalDate today = LocalDate.now();
    	String formattedDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    	return formattedDate;
	}
	public static String tomorrowsDate() {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
    	String formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	return formattedDate;
	}

	public static String getRandom(int n)
	{

		// length is bounded by 256 Character
		byte[] array = new byte[256];
		new Random().nextBytes(array);
		String randomString
				= new String(array, Charset.forName("UTF-8"));
		// Create a StringBuffer to store the result
		StringBuffer r = new StringBuffer();
		// Append first 20 alphanumeric characters
		// from the generated random String into the result
		for (int k = 0; k < randomString.length(); k++) {
			char ch = randomString.charAt(k);
			if (((ch >= 'a' && ch <= 'z')
					|| (ch >= 'A' && ch <= 'Z')
					|| (ch >= '0' && ch <= '9'))
					&& (n > 0)) {
				r.append(ch);
				n--;
			}
		}
		// return the resultant string
		return r.toString();
	}
}
