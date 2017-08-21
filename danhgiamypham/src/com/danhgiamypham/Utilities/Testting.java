package com.danhgiamypham.Utilities;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.danhgiamypham.model.SoLuongDang;






public class Testting {

	public static void main(String[] args) throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String ngayDang = String.valueOf(dateFormat.format(date));
	    String k = ngayDang.substring(0, 4);
	    String l = ngayDang.substring(5, 7);
	    String m = ngayDang.substring(8, 10);
	    String ngayDangnew = k + "-" + l + "-" + m;
	    String thangDang = k + "-" + l;
	}
	
	
	
}
