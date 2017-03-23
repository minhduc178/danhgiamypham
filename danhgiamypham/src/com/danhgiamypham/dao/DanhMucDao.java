package com.danhgiamypham.dao;

import java.util.List;

import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.model.NhomSanPham;

public interface DanhMucDao {
	public List<DanhMuc> getAll();
	public List<NhomSanPham> getNhomSanPham();
	public boolean themNhomSanPham(int MaDanhMuc, String TenNhomSanPham);
	public List<Hang> getHang();
	public List<NhomHang> getNhomHang();
	public boolean themHang(String tenHang, int maNhomSanPham);
	public List<Hang> getHangTheoNhom(int maNhomHang);
}
