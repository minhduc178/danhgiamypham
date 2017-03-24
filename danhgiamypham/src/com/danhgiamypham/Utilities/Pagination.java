package com.danhgiamypham.Utilities;

import java.util.ArrayList;
import java.util.List;

import com.danhgiamypham.model.SanPham;


public class Pagination {

	public static List<SanPham> PhanTrang(int trangHienTai, int soLuongTrongTrang, int tongSoSanPham, List<SanPham> sanpham) {
		List<SanPham> sppt = new ArrayList<SanPham>();
		int thutusanphamdautien =  (trangHienTai-1) * soLuongTrongTrang;
		int thutusanphamcuoi;
		int soTrang; 
		
		if(tongSoSanPham%soLuongTrongTrang==0){
			 soTrang = tongSoSanPham/soLuongTrongTrang;
		} else {
			soTrang = tongSoSanPham/soLuongTrongTrang + 1;
		}

		if(trangHienTai== soTrang){
			thutusanphamcuoi = tongSoSanPham-1;
			
		} else {
			thutusanphamcuoi = thutusanphamdautien+soLuongTrongTrang-1;
		
		}
		
		for(int i= thutusanphamdautien; i <= thutusanphamcuoi; i++ ){
			sppt.add(sanpham.get(i));
		}
		return sppt;
	}


}
