package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

public static WebDriver driver;
	
	@BeforeMethod
public void initializebrowser() {
	driver = new ChromeDriver();
	driver.get("https://letcode.in/test/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	}
	
	@AfterMethod
public void browserQuit() {
	driver.quit();
		

	}
}

