package com.danhgiamypham.dao;

import java.util.List;

import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.HinhAnhSanPham;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPhamMoi;

public interface SanPhamMoiDao {
	public List<Hang> getHang();
	public List<NhomSanPham> getNhomSanPhamTheoDanhMuc(int MaDanhMuc);
	public boolean themSanPham(SanPhamMoi spm);
	public boolean themHinhAnh(int maSP,String fileName);
	public boolean themSanPhamNhomSanPham(int maSP, int k);
	public boolean capnhatSanPham(SanPhamMoi spm);
	public boolean capnhatHinhAnh(int maSP,String fileName);
	public List<NhomSanPham> getNhomSanPhamTheoSP(int maSP, int MaDanhMuc);
	public boolean themNhomSanPhamMoi(int maSP,int maNhom);
	public boolean themHinhAnhMoi(HinhAnhSanPham hasp);
}
