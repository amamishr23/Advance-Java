package com.cisco.prj.web;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor extends PropertyEditorSupport {

	private Date date;

	// FORM to Controller
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = sdf.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getAsText() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String str = sdf.format(date);
		return str;
	}

	// Controller to Product
	@Override
	public Object getValue() {
		return date;
	}
}
