package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Page_DVLA {
	final static Logger logger = Logger.getLogger(Page_DVLA.class);
	public static WebDriver driver;
	
	
	public void launchBrowser() {		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void openDVLAURL() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://vehicleenquiry.service.gov.uk/");
		 wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.id("Vrm"))); 
	}
	
	public void enterRegNumber(String regNumber) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement regInput = driver.findElement(By.id("Vrm")); 
		regInput.sendKeys(regNumber);
		  
		WebElement continueButton = driver.findElement(By.className("button"));
		continueButton.click();
		

	}
	
	public String getCarColor() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		 wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.className("reg-mark")));
		 
		 String returnedRegNumber = driver.findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[3]/span[2]/strong")).getText();
		 
		 logger.debug("found regnumber is : " + returnedRegNumber);
		 
		 String colour = driver.findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[3]/span[2]/strong")).getText();
		 
		 logger.debug("found colour is : " + colour);
		 
		 return colour;
	}
	
	public void quit() {
		driver.quit();
	}
}
