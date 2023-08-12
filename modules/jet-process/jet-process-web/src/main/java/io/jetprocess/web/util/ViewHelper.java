package io.jetprocess.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ViewHelper {

	public static String getViewDate(Date date) {
		String formatedDate="";
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		if(date !=null) {
			formatedDate = simpleFormat.format(date);
		}
		return formatedDate;
		
	}

	public static String getViewDateTime(Date date) {
		String formatedDate="";
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
		simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		
		if(date !=null) {
			formatedDate=simpleformat.format(date);
		}
		return formatedDate;
	}
	
}
