package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Browser {
	static WebDriver driver;
	
	
	@BeforeSuite
		public static void setUp() {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
  }
	
	@AfterSuite
	public static void tearDown() {
			driver.manage().deleteAllCookies();
			driver.close();	
	}
}