package com.danhgiamypham.service;

import java.util.List;

import com.danhgiamypham.dto.DanhMucNhom;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.model.NhomSanPham;

public interface DanhMucService {
	public List<DanhMuc> getAll();
	public List<NhomSanPham> getNhomSanPham();
	public List<DanhMucNhom> getDanhMucNhom();
	public boolean themNhomSanPham(int MaDanhMuc, String TenNhomSanPham);
	public List<Hang> getHang();
	public List<NhomHang> getNhomHang();
	public boolean themHang(String tenHang);
	public List<Hang> getHangTheoNhom(int maNhomHang);
}
