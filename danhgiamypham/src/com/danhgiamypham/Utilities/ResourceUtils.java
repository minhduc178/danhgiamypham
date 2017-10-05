package com.danhgiamypham.Utilities;

import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.danhgiamypham.model.SanPham;


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
        String result = st.replaceAll("[&#+./%-\''^:,)(}{]","");
        return result;
    }
	
    
    //chuyen kieu ngay thang nam
    public static Date convertDate(Date date){
       String ngayDang = String.valueOf(date);
       String k = ngayDang.substring(0, 4);
       String l = ngayDang.substring(5, 7);
       String m = ngayDang.substring(8, 10);
       ngayDang = m + "/" + l + "/" + k;
       DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
       Date startDate = null;
       try {
           startDate = df.parse(ngayDang);
           
       } catch (ParseException e) {
           e.printStackTrace();
       }
       return startDate;
       
    }
    
    public static List<SanPham> checkTrungNhau(List<SanPham> sanPhamList){
    	List<SanPham> sanPhamChecked = new ArrayList<SanPham>(); 
    	for(SanPham sp: sanPhamList){
    		for(SanPham spChecked: sanPhamChecked){
    			if(sp.getMaSanPham() == spChecked.getMaSanPham()){
        			break;
    			} else {
    				sanPhamChecked.add(sp);
    			}
    		}
    	}
    	return sanPhamChecked;
    }
    
}
