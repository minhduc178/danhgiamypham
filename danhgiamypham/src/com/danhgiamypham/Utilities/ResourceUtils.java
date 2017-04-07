package com.danhgiamypham.Utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.multipart.MultipartFile;

public class ResourceUtils {
	
	
	public static String ghiFile(MultipartFile multiFile) {
		Logger logger = Logger.getLogger("resource");
		String pathRs = "";
		//StringBuilder rs = new StringBuilder();
		try {
			// Creating the directory to store file
			
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "webapps" + File.separator + "FILE_UPLOAD");		
			
	//		File dir = new File("/FILE_UPLOAD/HINHSANPHAM");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			logger.log(Level.INFO, dir.getAbsolutePath());
			
			String fileName =Calendar.getInstance().getTimeInMillis() + multiFile.getOriginalFilename();
			Long ngaythang = Calendar.getInstance().getTimeInMillis(); 
			String date = String.valueOf(ngaythang);

			// saving the file
			File file = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + fileName);
			
			logger.log(Level.INFO, "file: " + file.getAbsolutePath());
			
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
			byte[] bytes = multiFile.getBytes();
			stream.write(bytes);
			stream.close();
			
			logger.log(Level.INFO, "write file success");
			
			pathRs = file.getAbsolutePath();
			int k =  pathRs.indexOf(date);
			//int k = pathRs.indexOf("FILE_UPLOAD");
			pathRs = pathRs.substring(k);
		} catch (Exception e) {
			logger.log(Level.INFO, "",e);
			//rs.append("Error: ").append(e.getMessage());
		}
		return pathRs;
	}
	
	public static int tinhTrangHienTai(int trangHienTai, int soLuongTrongTrang){
		trangHienTai = (trangHienTai-1)*soLuongTrongTrang;
		return trangHienTai;
	}
	
	public static float quyTron(float n) {
		int a = (int) n;
		float x = n - a;
		if (x < 0.29) {
			float l = Math.round(n);
			n = l;
		} else if (x < 0.49) {
			float m = Math.round(n) + 0.5f;
			n = m;
		} else if (x < 0.69) {
			float t = Math.round(n) - 0.5f;
			n = t;
		} else if (x < 1) {
			float z = Math.round(n);
			n = z;
		}
		return n;
	}
	public static String readUTF8 (String text){
		String s= null;
		if(text.equals("undefined")){
			return s;
		} else {
			try {
				byte[] b = text.getBytes("ISO-8859-15");
				s = new String(b, "UTF-8");
			}catch(Exception e){
					e.printStackTrace();
				}
				return s;
		}
	}
	
}
