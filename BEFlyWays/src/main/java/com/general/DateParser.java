package com.general;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParser {

	
	private final SimpleDateFormat date_format = new SimpleDateFormat("MM-DD-YYYY");
	private final SimpleDateFormat date_time_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public java.sql.Date getRealDate(String date) {
	    try {
	        return new Date(date_format.parse(date).getTime());
	        
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}
    
    
    public java.sql.Timestamp getRealDateTime(String timestamp) {
        try {
        	
            return new Timestamp(date_time_Format.parse(timestamp).getTime());
            
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
}
