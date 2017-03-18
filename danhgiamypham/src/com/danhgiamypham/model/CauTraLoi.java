package com.danhgiamypham.model;

import java.util.Date;

public class CauTraLoi {
	private int maCauHoi;
	private String noiDung;
	private int soLuotThich;
	private String tenDangNhap;
	private Date ngayDang;
	
	
	public CauTraLoi() {
		super();
	}

	public CauTraLoi(int maCauHoi, String noiDung, int soLuotThich,
			String tenDangNhap, Date ngayDang) {
		super();
		this.maCauHoi = maCauHoi;
		this.noiDung = noiDung;
		this.soLuotThich = soLuotThich;
		this.tenDangNhap = tenDangNhap;
		this.ngayDang = ngayDang;
	}
	
	public int getMaCauHoi() {
		return maCauHoi;
	}
	public void setMaCauHoi(int maCauHoi) {
		this.maCauHoi = maCauHoi;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public int getSoLuotThich() {
		return soLuotThich;
	}
	public void setSoLuotThich(int soLuotThich) {
		this.soLuotThich = soLuotThich;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public Date getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}
	
	

}
