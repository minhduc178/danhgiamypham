package com.danhgiamypham.dao;

import java.util.List;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.HinhAnhSanPham;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;
import com.danhgiamypham.model.SanPhamMoi;

public interface SanPhamMoiDao {
	public ResponseData<List<Hang>> getHang();
	public ResponseData<List<NhomSanPham>> getNhomSanPhamTheoDanhMuc(int MaDanhMuc);
	public ResponseData<List<NhomSanPham>> getNhomSanPhamTheoSP(String link, int MaDanhMuc);

	public ResponseData<Boolean> themSanPham(SanPhamMoi spm);
	public ResponseData<Boolean> themHinhAnhMoi(HinhAnhSanPham hasp);
	public ResponseData<Boolean> themNhomSanPhamMoi(int maSP,int maNhom);
	
	public ResponseData<Boolean> capNhatSanPham(SanPham spm);
	public ResponseData<Boolean> capNhatHinhAnh(int maSP, HinhAnhSanPham hasp);
	public ResponseData<Boolean> capNhatNhomSanPham(int maSP, int maNhom);
	public ResponseData<Boolean> xoaHinhAnhSanPham(int maSP);
	public ResponseData<Boolean> xoaNhomSanPham(int maSP);
}
