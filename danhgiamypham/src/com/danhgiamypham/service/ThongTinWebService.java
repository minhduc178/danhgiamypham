package com.danhgiamypham.service;

import java.util.List;

import com.danhgiamypham.model.SoLuongDang;
import com.danhgiamypham.model.SoSanPhamThem;

public interface ThongTinWebService {
	public SoSanPhamThem soSanPham();
	public List<SoLuongDang> soLuongDangSP();
}



