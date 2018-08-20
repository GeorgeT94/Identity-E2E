package com.e2e.domain;

public class Car {
	private String regNumber;
	private String colour;
	private String make;
	
	public Car() {
		
	}
	
	public String toString() {
        return String.format("%s - %s", regNumber, colour);
    }
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
}
