package com.danhgiamypham.model;

import java.util.Date;

public class CauHoi {
	private int maCauHoi;
	private int maNguoiDung;
	private int maNhomCauHoi;
	private String tieuDe;
	private String noiDung;
	private Date ngayDang;
	private int soLuotClick;
	private int soLuotLike;
	private String tenDangNhap;

	public CauHoi() {
	}

	public CauHoi(int maCauHoi, int maNguoiDung, int maNhomCauHoi,
			String tieuDe, String noiDung, Date ngayDang, int soLuotClick,
			int soLuotLike) {
		this.maCauHoi = maCauHoi;
		this.maNguoiDung = maNguoiDung;
		this.maNhomCauHoi = maNhomCauHoi;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.ngayDang = ngayDang;
		this.soLuotClick = soLuotClick;
		this.soLuotLike = soLuotLike;
	}

	public CauHoi(int maCauHoi, String tenDangNhap,  int maNhomCauHoi,
			String tieuDe, String noiDung, Date ngayDang, int soLuotClick,
			int soLuotLike) {
		this.maCauHoi = maCauHoi;
		this.maNhomCauHoi = maNhomCauHoi;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.ngayDang = ngayDang;
		this.soLuotClick = soLuotClick;
		this.soLuotLike = soLuotLike;
		this.tenDangNhap = tenDangNhap;
	}

	public int getMaCauHoi() {
		return maCauHoi;
	}

	public void setMaCauHoi(int maCauHoi) {
		this.maCauHoi = maCauHoi;
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public int getMaNhomCauHoi() {
		return maNhomCauHoi;
	}

	public void setMaNhomCauHoi(int maNhomCauHoi) {
		this.maNhomCauHoi = maNhomCauHoi;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}

	public int getSoLuotClick() {
		return soLuotClick;
	}

	public void setSoLuotClick(int soLuotClick) {
		this.soLuotClick = soLuotClick;
	}

	public int getSoLuotLike() {
		return soLuotLike;
	}

	public void setSoLuotLike(int soLuotLike) {
		this.soLuotLike = soLuotLike;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	
	

}
