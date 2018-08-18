package com.e2e.service.repository;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.e2e.domain.Car;


public class ExcelReaderTest {
	private ExcelReader reader;
	private final String excelFilePath = "C:\\TestFiles\\cars.xlsx";
	
	final static Logger logger = Logger.getLogger(ExcelReaderTest.class);
	
	@Before
	public void setup() {
		reader = new ExcelReader();
	}  
	
	@Test
	public void readCarsFromExcelFileTest() throws IOException{

		List<Car> listCars = reader.readCarsFromExcelFile(excelFilePath);
		logger.debug("cars read from excel file: '" + excelFilePath + " ': " + listCars );
	}
}
