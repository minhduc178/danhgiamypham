package com.danhgiamypham.dao;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.SanPham;

public interface SanPhamDao {
	public Set<SanPham> getSanPham(int trangHienTai, int soLuongTrongTrang);
	public int getTongSanPham();
	public SanPham getChiTietSanpham(int id);
	public List<SanPham> getSanPhamYeuThich(int id);
	public List<Hang> getHangYeuThich(int id);
	public List<SanPham> getSanPhamTimKiem(int trangHienTai, int soLuongTrongTrang, String timKiem);
	public int getTongSanPhamTimKiem(String timKiem);
	public int getTongSoSanPhamMaDanhMuc(int maDanhMuc);
	public List<SanPham> getDuyetSanPham(int tinhTrang);	
	public boolean getDuyetSanPhamDang(int maSP);	
	public boolean getXoaSanPhamDang(int maSP);
	public int getTimMaDanhMuc(int maSP);

}
