package com.jk1504.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;



public class dateturn implements Converter<String,Date>{

	@Override
	public Date convert(String arg0) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return simpleDateFormat.parse(arg0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
