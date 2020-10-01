package webdriverMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver(); 
		
	}
	
	@Test
	public void doLogin() {
		
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("flglhh");
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		
	}

}
