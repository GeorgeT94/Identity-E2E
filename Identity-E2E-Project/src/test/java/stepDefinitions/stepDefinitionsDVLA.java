package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import selenium.Page_DVLA;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.e2e.domain.Car;
import com.e2e.service.repository.ExcelReader;
import com.e2e.service.repository.FileLocalStorage;
 

public class stepDefinitionsDVLA {
	final static Logger logger = Logger.getLogger(stepDefinitionsDVLA.class);
	private final String excelMimeType = "application/vnd.ms-excel";
	
	Page_DVLA dvlaPage = new Page_DVLA();

	private ExcelReader reader = new ExcelReader();

	private List<Car> carList;
	private List<Car> validCars = new ArrayList<Car>();
	private List<Car> invalidCars = new ArrayList<Car>();
	private List<File> fileList;
	private FileLocalStorage localStorage = new FileLocalStorage();
	
	@Given("^I have loaded spreadsheets containing vehicle data$")
	public void i_have_loaded_spreadsheets_containing_vehicle_data() throws Throwable {
		localStorage.getAllFiles();
	}

	@When("^I select files with the excel mime type$")
	public void i_select_files_with_the_excel_mime_type() throws Throwable {
	    fileList = localStorage.getExcelFiles();
	}

	@Then("^I start the chrome driver$")
	public void i_start_the_chrome_driver() throws Throwable {
		dvlaPage.launchBrowser();    

	}

	@Then("^I connect to the dvla website$")
	public void i_connect_to_the_dvla_website() throws Throwable {
		 dvlaPage.openDVLAURL();
	}

	@Then("^I enter vehicles reg numbers from excel sheet$")
	public void i_enter_vehicles_reg_numbers_from_excel_sheet() throws Throwable {
		carList = reader.readCarsFromExcelFile(fileList.get(5).getPath());
		
		List<Car> testList = carList.subList(0, 15);
		
		dvlaPage.testCarList(testList, validCars, invalidCars);
	}

	@Then("^All the vehicles have valid registration numbers$")
	public void all_the_vehicles_have_valid_registration_numbers() throws Throwable {
		logger.debug("valid cars are----");
		logger.debug(validCars);
		
		logger.debug("invalid cars------");
		logger.debug(invalidCars);
		dvlaPage.quit();
		Assert.assertTrue(invalidCars.size() == 0);
	}

}