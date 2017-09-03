package com.danhgiamypham.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.dao.ThongTinWebDao;
import com.danhgiamypham.model.SoLuongDang;
import com.danhgiamypham.model.SoSanPhamThem;
import com.danhgiamypham.service.ThongTinWebService;

@Service
public class ThongTinWebServiceImpl implements ThongTinWebService {

	@Autowired
	private ThongTinWebDao thongTinWebDao;

	@Override
	public SoSanPhamThem soSanPham() {
		SoSanPhamThem spt = thongTinWebDao.soSanPham();
		return spt;
	}
	
	@Override
	public List<SoLuongDang> soLuongDangSP() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String ngayDang = String.valueOf(dateFormat.format(date));
	    String k = ngayDang.substring(0, 4);
	    String l = ngayDang.substring(5, 7);
	    String m = ngayDang.substring(8, 10);
	    String ngayDangnew = k + "-" + l + "-" + m;
	    String thangDang = k + "-" + l;
		
		List<SoLuongDang> spt = thongTinWebDao.soLuongDangSP(thangDang, ngayDangnew);
		return spt;
	}
	
	@Override
	public List<SoLuongDang> soLuongBinhLuan() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String ngayDang = String.valueOf(dateFormat.format(date));
	    String k = ngayDang.substring(0, 4);
	    String l = ngayDang.substring(5, 7);
	    String m = ngayDang.substring(8, 10);
	    String ngayDangnew = k + "-" + l + "-" + m;
	    String thangDang = k + "-" + l;
		
		List<SoLuongDang> spt = thongTinWebDao.soLuongBinhLuan(thangDang, ngayDangnew);
		return spt;
	}


	


}
