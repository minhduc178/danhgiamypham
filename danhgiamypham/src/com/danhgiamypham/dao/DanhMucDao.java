package com.danhgiamypham.dao;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;

public interface DanhMucDao {
	public List<DanhMuc> getAll();
	public List<NhomSanPham> getNhomSanPham();
	public Set<SanPham> getSanPhamTheoNhomSP(int id);
	public List<SanPham> getSanPhamTheoDanhMuc(int trangHienTai, int soLuongTrongTrang,int id);
	public List<SanPham> getDuongDa();
	public boolean themNhomSanPham(int MaDanhMuc, String TenNhomSanPham);
	public List<Hang> getHang();
	public List<NhomHang> getNhomHang();
	public boolean themHang(String tenHang, int maNhomSanPham);
	public List<Hang> getHangTheoNhom(int maNhomHang);
}
