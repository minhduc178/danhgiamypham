package com.danhgiamypham.model;

public class SoLuongDang {
	private int maNguoiDang;
	private String tenDienDan;
	private int soLuongTrongThang;
	private int soLuongTrongNgay;
	
	public SoLuongDang() {
	}
	public SoLuongDang(int maNguoiDang, String tenDienDan,
			int soLuongTrongThang, int soLuongTrongNgay) {
		this.maNguoiDang = maNguoiDang;
		this.tenDienDan = tenDienDan;
		this.soLuongTrongThang = soLuongTrongThang;
		this.soLuongTrongNgay = soLuongTrongNgay;
	}
	
	public int getMaNguoiDang() {
		return maNguoiDang;
	}
	public void setMaNguoiDang(int maNguoiDang) {
		this.maNguoiDang = maNguoiDang;
	}
	public String getTenDienDan() {
		return tenDienDan;
	}
	public void setTenDienDan(String tenDienDan) {
		this.tenDienDan = tenDienDan;
	}
	public int getSoLuongTrongThang() {
		return soLuongTrongThang;
	}
	public void setSoLuongTrongThang(int soLuongTrongThang) {
		this.soLuongTrongThang = soLuongTrongThang;
	}
	public int getSoLuongTrongNgay() {
		return soLuongTrongNgay;
	}
	public void setSoLuongTrongNgay(int soLuongTrongNgay) {
		this.soLuongTrongNgay = soLuongTrongNgay;
	}
	
	
}
