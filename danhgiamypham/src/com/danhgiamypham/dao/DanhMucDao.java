package com.danhgiamypham.dao;

import java.util.List;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.model.NhomSanPham;

public interface DanhMucDao {
	public ResponseData<List<DanhMuc>> getAll();
	public ResponseData<List<NhomSanPham>> getNhomSanPham();
	public ResponseData<Boolean> themNhomSanPham(int MaDanhMuc, String TenNhomSanPham);
	public ResponseData<List<Hang>> getHang();
	public List<NhomHang> getNhomHang();
	public ResponseData<Boolean> themHang(String tenHang, int maNhomSanPham, String link, int maND);
	public List<Hang> getHangTheoNhom(int maNhomHang);
	public ResponseData<List<Hang>> getHangDaThem();
}
