package com.example.inmemory;

import java.util.Arrays;

import org.springframework.stereotype.Component;
@Component

public class Country {

	private String name;
	private byte[] flag;
	private String constitution_title;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getFlag() {
		return flag;
	}
	public void setFlag(byte[] flag) {
		this.flag = flag;
	}
	public String getConstitution_title() {
		return constitution_title;
	}
	public void setConstitution_title(String constitution_title) {
		this.constitution_title = constitution_title;
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", flag=" + flag.hashCode() + ", constitution_title="
				+ constitution_title + "]";
	}
	
	Country(){
		
	}
	public Country(String name, byte[] flag, String constitution_title) {
		super();
		this.name = name;
		this.flag = flag;
		this.constitution_title = constitution_title;
	}
	
	
}
