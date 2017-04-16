package com.danhgiamypham.Utilities;

import java.net.URLDecoder;


public class ResourceUtils {
	
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
	
	public static String readUTF8 (String text) throws Exception  {
		 String correctDecoded = URLDecoder.decode(text, "UTF-8");
		 return correctDecoded;
	}
	
	
}
