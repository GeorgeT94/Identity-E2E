package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.Page_DVLA;

import java.util.List;

import org.apache.log4j.Logger;

import com.e2e.domain.Car;
import com.e2e.service.repository.ExcelReader;
 

public class stepDefinitionsDVLA {
	final static Logger logger = Logger.getLogger(stepDefinitionsDVLA.class);
	Page_DVLA dvlaPage = new Page_DVLA();

	private ExcelReader reader = new ExcelReader();
	private final String excelFilePath = "C:\\TestFiles\\car_data.xlsx";
	private List<Car> carList;

	@Given("^I have loaded spreadsheets containing vehicle data$")
	public void i_have_loaded_spreadsheets_containing_vehicle_data() throws Throwable {
		carList = reader.readCarsFromExcelFile("C:\\TestFiles\\car_data.xlsx");
	
		dvlaPage.launchBrowser();  
	    logger.debug("loading spreadsheets");
	    dvlaPage.openDVLAURL();
	    
	}
	
	@When("^I run the checkValidVehicle method$")
	public void i_run_the_checkValidVehicle_method() throws Throwable {
		List<Car> testList = carList.subList(0, 5);
		
		for(Car car: testList) {
			String carReg = car.getRegNumber();
			
			dvlaPage.openDVLAURL();
			
			dvlaPage.enterRegNumber(carReg);
			
			String carColour = dvlaPage.getCarColor();
			
			Assert.assertEquals(carColour.toUpperCase(), car.getColour().toUpperCase());
		
		}
		
	}
	
	@Then("^I am returned a list of valid vehicles$")
	public void i_am_returned_a_list_of_valid_vehicles() throws Throwable {
		
		logger.debug("returning valid vehicles");
		dvlaPage.quit();
	}
}