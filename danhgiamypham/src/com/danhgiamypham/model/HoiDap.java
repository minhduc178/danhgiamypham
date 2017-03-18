package com.danhgiamypham.model;

import java.util.Date;


public class HoiDap {
	private int maHoiDap;
	private String cauHoi;
	private String noiDung;
	private String tenMucDang;
	private String tenNguoiDung;
	private Date ngayDang;
	private int soLuotTraLoi;
	private int soLuotThich;
	private int tinhTrang;
	
	public HoiDap() {
	}
	
	public HoiDap(int maHoiDap, String cauHoi, String noiDung,
			String tenMucDang, String tenNguoiDung, Date ngayDang,
			int soLuotTraLoi, int soLuotThich, int tinhTrang) {
		this.maHoiDap = maHoiDap;
		this.cauHoi = cauHoi;
		this.noiDung = noiDung;
		this.tenMucDang = tenMucDang;
		this.tenNguoiDung = tenNguoiDung;
		this.ngayDang = ngayDang;
		this.soLuotTraLoi = soLuotTraLoi;
		this.soLuotThich = soLuotThich;
		this.tinhTrang = tinhTrang;
	}
	public int getMaHoiDap() {
		return maHoiDap;
	}
	public void setMaHoiDap(int maHoiDap) {
		this.maHoiDap = maHoiDap;
	}
	public String getCauHoi() {
		return cauHoi;
	}
	public void setCauHoi(String cauHoi) {
		this.cauHoi = cauHoi;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getTenMucDang() {
		return tenMucDang;
	}
	public void setTenMucDang(String tenMucDang) {
		this.tenMucDang = tenMucDang;
	}
	public String getTenNguoiDung() {
		return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}
	public Date getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}
	public int getSoLuotTraLoi() {
		return soLuotTraLoi;
	}
	public void setSoLuotTraLoi(int soLuotTraLoi) {
		this.soLuotTraLoi = soLuotTraLoi;
	}
	public int getSoLuotThich() {
		return soLuotThich;
	}
	public void setSoLuotThich(int soLuotThich) {
		this.soLuotThich = soLuotThich;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
	
}
