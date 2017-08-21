package com.danhgiamypham.dao;

import java.util.List;

import com.danhgiamypham.model.SoLuongDang;
import com.danhgiamypham.model.SoSanPhamThem;

public interface ThongTinWebDao {
	public SoSanPhamThem soSanPham();
	public List<SoLuongDang> soLuongDangSP(String thang, String ngay);
}
