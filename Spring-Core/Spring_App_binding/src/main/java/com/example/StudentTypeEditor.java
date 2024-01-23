package com.example;

import java.beans.PropertyEditorSupport;

public class StudentTypeEditor extends PropertyEditorSupport{
	
	@Override
	public String getAsText() {
		return "geeting object as STring";
		
	}
	
	@Override
	public void setAsText(String Text) {
		StudentType stype= new StudentType();
		String[] vals = Text.split("-");
		stype.setType(vals[0].toUpperCase());
		stype.setDepartment(vals[1].toUpperCase());
		setValue(stype);
	}

}
