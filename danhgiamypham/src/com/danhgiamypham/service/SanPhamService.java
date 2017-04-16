package com.danhgiamypham.service;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.dto.SanPhamYeuThichNhom;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.SanPham;

public interface SanPhamService {
	public  ResponseData<Set<SanPham>> getSanPham(int trangHienTai, int soLuongTrongTrang, String[] chuoiNhom);
	public  ResponseData<Integer> getTongSoSanPham();
	public  ResponseData<Integer> getTongSoSanPhamTheoNhom(String[] nhomsanphams);
	
	public  ResponseData<Set<SanPham>> getSanPhamTheoDanhMuc(int trangHienTai, int soLuongTrongTrang,int id, String[] chuoiNhom );
	public  ResponseData<Integer> getTongSoSanPhamMaDanhMuc(int maDanhMuc);
	public  ResponseData<Integer> getTongSoSanPhamMaDanhMucChuoiNhom(int maDanhMuc,String[] chuoiNhom);
	
	public  ResponseData<Set<SanPham>> getSanPhamTheoHang(int trangHienTai, int soLuongTrongTrang,int id, String[] chuoiNhom );
	public  ResponseData<Integer> getTongSoSanPhamMaHang(int maHang);
	public  ResponseData<Integer> getTongSoSanPhamMaHangChuoiNhom(int maHang,String[] chuoiNhom);
	
	public  ResponseData<Set<SanPham>> getSanPhamTheoNhomSanPham(int trangHienTai, int soLuongTrongTrang,int maNhomSanPham, String[] chuoiNhom );
	public  ResponseData<Integer> getTongSoSanPhamMaNhomSP(int maNhomSP);
	public  ResponseData<Integer> getTongSoSanPhamMaNhomSPChuoiNhom(int maNhomSP,String[] chuoiNhom);
	
	public  ResponseData<List<SanPham>> getSanPhamTimKiem(int trangHienTai, int soLuongTrongTrang, String timKiem);
	public  ResponseData<Integer> getTongSoSanPhamTimKiem(String timKiem);

	public  ResponseData<SanPham> getChiTietSanPham(int maSP);
	public  ResponseData<SanPham> getChiTietSanPhamSua(int maSP);
	public  ResponseData<List<SanPham>> getDuongDa();
	public  ResponseData<List<SanPham>> getDuyetSanPham(int tinhTrang);
	public  ResponseData<Boolean> getDuyetSanPhamDang(int maSP);
	public  ResponseData<Boolean> getXoaSanPhamDang(int maSP);
	public  ResponseData<Set<SanPham>> getSanPhamTheoNhomSP(int maNSP);
	public  ResponseData<List<SanPhamYeuThichNhom>> getSanPhamYeuThich(int maND);
	public  ResponseData<List<Hang>> getHangYeuThich(int maND);
	public  ResponseData<Set<SanPham>> locSanPham(String chuoiMN);




}
