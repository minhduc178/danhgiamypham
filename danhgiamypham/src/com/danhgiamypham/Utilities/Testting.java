package com.danhgiamypham.Utilities;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;






public class Testting {

	public static void main(String[] args) throws Exception {
		
	       String ngayDang = "04/05/2017";
	       System.out.println(ngayDang);
	       
	       DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
	       Date startDate = null;
	       try {
	           startDate = df.parse(ngayDang);
	           System.out.print(startDate);
	           
	       } catch (ParseException e) {
	           e.printStackTrace();
	       }
		}
	
	
	
}
