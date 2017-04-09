package com.danhgiamypham.Utilities;

import java.io.File;

public class PathRsIMG {
	public static String pathHinhSanPham (String location){
		String pathRs="";
		
		//localhost
		
		String rootPath = "/Users/macbookair/Documents/apache-tomcat-7.0.70";
		pathRs = rootPath + File.separator + "webapps" + File.separator + location;		
		
		 //server
	//	 pathRs = "/FILE_UPLOAD/HINHSANPHAM";
		
		return pathRs;
	}
	
	
	
}
