package com.danhgiamypham.service;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.dto.SanPhamYeuThichNhom;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.SanPham;

public interface SanPhamService {
	public Set<SanPham>getSanPham(int trangHienTai, int soLuongTrongTrang);
	public SanPham getChiTietSanPham(int maSP);
	//public int getSoTrang(int trangHienTai, int soLuongTrongTrang);
	public List<SanPhamYeuThichNhom> getSanPhamYeuThich(int maND);
	public List<Hang> getHangYeuThich(int maND);
	public Set<SanPham> locSanPham(String chuoiMN);
	public Set<SanPham> locSanPhamTheoNhom(int trangHienTai, int soLuongTrongTrang, String[] chuoiMN);
	public int getTongSoSanPham();
	public int getTongSoSanPhamTimKiem(String timKiem);
	public int getTongSoSanPhamMaDanhMuc(int maDanhMuc);
	public List<SanPham> getSanPhamTimKiem(int trangHienTai, int soLuongTrongTrang, String timKiem);
	public List<SanPham> getDuyetSanPham(int tinhTrang);
	public boolean getDuyetSanPhamDang(int maSP);
	public boolean getXoaSanPhamDang(int maSP);
}
