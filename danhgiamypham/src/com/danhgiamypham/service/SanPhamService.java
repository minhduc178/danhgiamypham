package com.danhgiamypham.service;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.dto.SanPhamYeuThichNhom;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.SanPham;

public interface SanPhamService {
	public Set<SanPham>getSanPham(int trangHienTai, int soLuongTrongTrang, String[] chuoiNhom);
	public int getTongSoSanPham();
	public int getTongSoSanPhamTheoNhom(String[] nhomsanphams);
	
	public Set<SanPham> getSanPhamTheoDanhMuc(int trangHienTai, int soLuongTrongTrang,int id, String[] chuoiNhom );
	public int getTongSoSanPhamMaDanhMuc(int maDanhMuc);
	public int getTongSoSanPhamMaDanhMucChuoiNhom(int maDanhMuc,String[] chuoiNhom);
	
	public Set<SanPham> getSanPhamTheoNhomSanPham(int trangHienTai, int soLuongTrongTrang,int maNhomSanPham, String[] chuoiNhom );
	public int getTongSoSanPhamMaNhomSP(int maNhomSP);
	public int getTongSoSanPhamMaNhomSPChuoiNhom(int maNhomSP,String[] chuoiNhom);
	
	public List<SanPham> getSanPhamTimKiem(int trangHienTai, int soLuongTrongTrang, String timKiem);
	public int getTongSoSanPhamTimKiem(String timKiem);

	public SanPham getChiTietSanPham(int maSP);
	public List<SanPham> getDuongDa();
	public List<SanPham> getDuyetSanPham(int tinhTrang);
	public boolean getDuyetSanPhamDang(int maSP);
	public boolean getXoaSanPhamDang(int maSP);
	public Set<SanPham> getSanPhamTheoNhomSP(int maNSP);
	public List<SanPhamYeuThichNhom> getSanPhamYeuThich(int maND);
	public List<Hang> getHangYeuThich(int maND);
	public Set<SanPham> locSanPham(String chuoiMN);




}
