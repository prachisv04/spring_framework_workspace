package com.example.resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("address")
@Scope(value="prototype")
public class Address {
	
	private String Building;
	private String street;
	private String Area;
	private String City;
	private String State;
	private String Country;
	
	Address(){
//		System.out.println("address Created :"+hashCode());
	}
	
	public String getBuilding() {
		return Building;
	}
	public void setBuilding(String building) {
		Building = building;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}

	@Override
	public String toString() {
		return "[ City=" + City + "State="
				+ State + "Country=" + Country + "]";
	}
	
	

}
