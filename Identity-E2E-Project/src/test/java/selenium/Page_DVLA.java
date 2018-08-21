package selenium;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2e.domain.Car;


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
	
	public boolean isCarFound() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("reg-mark")));
			 return true;
		}catch (Exception e) {
			return false;
		}
		
		 
	}
	
	public String getCarColor() {
		 String returnedRegNumber = driver.findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[3]/span[2]/strong")).getText();
		 
		 logger.debug("found regnumber is : " + returnedRegNumber);
		 
		 String colour = driver.findElement(By.xpath("//*[@id=\"pr3\"]/div/ul/li[3]/span[2]/strong")).getText();
		 
		 logger.debug("found colour is : " + colour);
		 
		 return colour;
	}
	
	public String getCarMake() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		 wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.className("reg-mark")));
		 		 
		 String make = driver.findElement(By.xpath("/html/body/main/form/div/div/ul/li[2]/span[2]/strong")).getText();
		 
		 return make;
	}
	
	public void testCarList(List<Car> carList, List<Car> validCars, List<Car> invalidCars) {
		for(Car car: carList) {
			String carReg = car.getRegNumber();
			
			openDVLAURL();
			
			enterRegNumber(carReg);
			
			if(isCarFound()) {
				String carColour = getCarColor();
				String carMake = getCarMake();
				
				logger.debug("car found: color : " + carColour + " make : " + carMake);
				
				if(car.isMatch(carColour, carMake)) {
					validCars.add(car);
				}
			}else {
				logger.debug("car : " + car.getRegNumber() + "was not found");
				invalidCars.add(car);
			}
			
		}
	}
		
	public void quit() {
		driver.quit();
	}
}
