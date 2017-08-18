package com.danhgiamypham.dao;

import java.util.List;
import java.util.Set;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.SanPham;

public interface SanPhamDao {
	public ResponseData<Set<SanPham>> getTenSanPham();

	public ResponseData<Set<SanPham>> getSanPham(int trangHienTai, int soLuongTrongTrang);
	public ResponseData<Set<SanPham>> getSanPhamTheoNhomSP(int maNhom);
	public ResponseData<Integer> getTongSanPham();
	public int getTongSanPhamTheoNhom(int maNhom);
	
	public ResponseData<Set<SanPham>> getSanPhamTheoDanhMuc(int trangHienTai, int soLuongTrongTrang, int maDM);
	public ResponseData<Set<SanPham>> getSanPhamTheoDanhMucMaChuoi(int maDM, int nhomChuoi);
	public ResponseData<Integer> getTongSoSanPhamMaDanhMuc(int maDanhMuc);
	public ResponseData<Integer> getTongSoSanPhamMaDanhMuc(int maDanhMuc, int maNhom);
	
	public ResponseData<Set<SanPham>> getSanPhamTheoHang(int trangHienTai, int soLuongTrongTrang, int maH);
	public ResponseData<Set<SanPham>> getSanPhamTheoHangMaChuoi(int maDM, int nhomChuoi);
	public ResponseData<Integer> getTongSoSanPhamMaHang(int maHang);
	public ResponseData<Integer> getTongSoSanPhamMaHang(int maHang, int maNhom);
	
	public ResponseData<Set<SanPham>> getSanPhamTheoNhomSPham(int trangHienTai, int soLuongTrongTrang, int maNhom);
	public ResponseData<Set<SanPham>> getSanPhamMaNhomSPMaChuoi(int maNhomSP, int nhomChuoi);
	public ResponseData<Integer> getTongSoSanPhamMaNhomSP(int maNhomSP);
	public ResponseData<Integer> getTongSoSanPhamMaNhomSPChuoiNhom(int maNhomSP, int nhomChuoi);

	public ResponseData<Set<SanPham>> getSanPhamTimKiem(int trangHienTai, int soLuongTrongTrang, String timKiem);
	public ResponseData<Set<SanPham>> getSanPhamTimKiemMaChuoi(String timKiem,int maNhom);
	public ResponseData<Integer> getTongSanPhamTimKiem(String timKiem);
	public ResponseData<Integer>getTongSoSanPhamTimKiemTheoChuoi(String timKiem,int chuoiNhom);
	
	public ResponseData<List<SanPham>> getSanPhamYeuThich(int id);
	public ResponseData<List<Hang>> getHangYeuThich(int id);
	
	public ResponseData<SanPham> getChiTietSanpham(String link);
	public ResponseData<List<SanPham>> getDuyetSanPham(int tinhTrang);	
	public ResponseData<Integer> getNhomSanPhamTheoBoPhan(String link);
	public ResponseData<List<Integer>> listMaNhomSanPham(String link);
	public ResponseData<Boolean> getDuyetSanPhamDang(int maSP);	
	public ResponseData<Boolean> getXoaSanPhamDang(int maSP);
	public ResponseData<Integer> getTimMaDanhMuc(String link);
	public ResponseData<List<SanPham>> getDuongDa();
}
