package com.danhgiamypham.Utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class PathRsIMG {
	public static String pathHinh (String location){
		String pathRs="";
		//localhost
		//String rootPath = "/Users/macbookair/Documents/apache-tomcat-7.0.70";
	//	pathRs = rootPath + File.separator + "webapps" + File.separator + location;		
		
		 //server
		pathRs = "/FILE_UPLOAD/"+ location;
		
		return pathRs;
	}
	
	public static String ghiFile(MultipartFile multiFile, String location, String nameImage) {
		String pathRs = "";
		StringBuilder rs = new StringBuilder();
		try {
			File dir = new File("");			
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			
			String locationHinh = PathRsIMG.pathHinh(location);
			String fileName =nameImage + Calendar.getInstance().getTimeInMillis();
			System.out.println(multiFile.getOriginalFilename());
			System.out.println(ResourceUtils.unAccent(multiFile.getOriginalFilename()));
			pathRs = locationHinh + File.separator+ fileName;
			System.out.println(pathRs);
			 dir = new File(locationHinh);

			// saving the file
			File file = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + fileName);				
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
				
			byte[] bytes = multiFile.getBytes();
			stream.write(bytes);
			stream.close();
			
			pathRs = file.getAbsolutePath();
			int k = pathRs.indexOf(location);
			int h = location.length();
			pathRs = pathRs.substring(k+h+1);
			
			
		} catch (Exception e) {
			rs.append("Error: ").append(e.getMessage());
		}
		return pathRs;
	}
	
	
	
	
	
}
