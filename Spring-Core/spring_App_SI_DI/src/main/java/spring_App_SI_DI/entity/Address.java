package spring_App_SI_DI.entity;

import java.beans.ConstructorProperties;

public class Address {

	private String houseno;
	private String lane;
	private String city;
	
	@ConstructorProperties({"houseno","lane","city"})
	public Address(String houseno, String lane, String city) {
		this.houseno = houseno;
		this.lane = lane;
		this.city = city;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [houseno=" + houseno + ", lane=" + lane + ", city=" + city + "]";
	}
	
	
}
