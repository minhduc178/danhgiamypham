package com.danhgiamypham.dao;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.SanPham;

public interface SanPhamDao {
	public Set<SanPham> getSanPham(int trangHienTai, int soLuongTrongTrang);
	public Set<SanPham> getSanPhamTheoNhomSP(int maNhom);
	public int getTongSanPham();
	public int getTongSanPhamTheoNhom(int maNhom);
	
	public Set<SanPham> getSanPhamTheoDanhMuc(int trangHienTai, int soLuongTrongTrang, int maDM);
	public Set<SanPham> getSanPhamTheoDanhMucMaChuoi(int maDM, int nhomChuoi);
	public int getTongSoSanPhamMaDanhMuc(int maDanhMuc);
	public int getTongSoSanPhamMaDanhMuc(int maDanhMuc, int maNhom);
	
	public Set<SanPham> getSanPhamTheoNhomSPham(int trangHienTai, int soLuongTrongTrang, int maNhom);
	public Set<SanPham> getSanPhamMaNhomSPMaChuoi(int maNhomSP, int nhomChuoi);
	public int getTongSoSanPhamMaNhomSP(int maNhomSP);
	public int getTongSoSanPhamMaNhomSPChuoiNhom(int maNhomSP, int nhomChuoi);

	public List<SanPham> getSanPhamTimKiem(int trangHienTai, int soLuongTrongTrang, String timKiem);
	public int getTongSanPhamTimKiem(String timKiem);
	
	public List<SanPham> getSanPhamYeuThich(int id);
	public List<Hang> getHangYeuThich(int id);
	
	public SanPham getChiTietSanpham(int id);
	public List<SanPham> getDuyetSanPham(int tinhTrang);	
	public boolean getDuyetSanPhamDang(int maSP);	
	public boolean getXoaSanPhamDang(int maSP);
	public int getTimMaDanhMuc(int maSP);
	public List<SanPham> getDuongDa();


}
