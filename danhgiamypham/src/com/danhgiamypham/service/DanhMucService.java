package com.danhgiamypham.service;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.dto.DanhMucNhom;
import com.danhgiamypham.dto.HangNhom;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;

public interface DanhMucService {
	public List<DanhMuc> getAll();
	public List<NhomSanPham> getNhomSanPham();
	public List<DanhMucNhom> getDanhMucNhom();
	public Set<SanPham> getSanPhamTheoNhomSP(int maNSP);
	public List<SanPham> getSanPhamTheoDanhMuc(int trangHienTai, int soLuongTrongTrang, int maDM);
	public List<SanPham> getDuongDa();
	public boolean themNhomSanPham(int MaDanhMuc, String TenNhomSanPham);
	public List<Hang> getHang();
	public List<NhomHang> getNhomHang();
	public List<HangNhom> getHangNhom();
}
