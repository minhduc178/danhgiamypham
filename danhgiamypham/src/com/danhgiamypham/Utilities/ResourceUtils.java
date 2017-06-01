package com.danhgiamypham.Utilities;

import java.net.URLDecoder;
import java.text.Normalizer;
import java.util.regex.Pattern;


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
	
	//chuyen kieu du lieu
	public static String readUTF8 (String text) throws Exception  {
		 String correctDecoded = URLDecoder.decode(text, "UTF-8");
		 return correctDecoded;
	}
	
	 //chuyen tieng viet thanh tieng viet khong dau, them dau noi
    public static String unAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String st =  pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d");
        st = st.replaceAll("\\s+","-");
        String result = st.replaceAll("[+.^:,]","");
        return result;
    }
	
}
