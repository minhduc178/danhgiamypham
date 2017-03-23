package com.danhgiamypham.Utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class ResourceUtils {
	public static boolean ghiFileHA(String path, String fileName, MultipartFile multiFile) {
		StringBuilder rs = new StringBuilder();
		try {
			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "webapps" + File.separator + "FILE_UPLOAD"+ File.separator + path );
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			// saving the file
			File file = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
			
			byte[] bytes = multiFile.getBytes();
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			rs.append("Error: ").append(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public String ghiFile(MultipartFile multiFile) {
		String pathRs = "";
		StringBuilder rs = new StringBuilder();
		try {
			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "webapps" + File.separator + "FILE_UPLOAD");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			String fileName =multiFile.getOriginalFilename() +  Calendar.getInstance().getTimeInMillis();
			
			// saving the file
			File file = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + fileName);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
			
			byte[] bytes = multiFile.getBytes();
			stream.write(bytes);
			stream.close();
			pathRs = file.getAbsolutePath();
			int k = pathRs.indexOf("FILE_UPLOAD");
			pathRs = pathRs.substring(k);
		} catch (Exception e) {
			rs.append("Error: ").append(e.getMessage());
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
	
	

}
