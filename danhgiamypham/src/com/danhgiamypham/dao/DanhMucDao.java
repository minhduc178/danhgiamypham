package com.danhgiamypham.dao;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;

public interface DanhMucDao {
	public List<DanhMuc> getAll();
	public List<NhomSanPham> getNhomSanPham();
	public Set<SanPham> getSanPhamTheoNhomSP(int id);
	public List<SanPham> getSanPhamTheoDanhMuc(int trangHienTai, int soLuongTrongTrang,int id);
	public List<SanPham> getDuongDa();
	public boolean themNhomSanPham(int MaDanhMuc, String TenNhomSanPham);
}
