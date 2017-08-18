package com.danhgiamypham.model;

public class LuotLike {
	private int maNguoiDung;
	private int maDanhGia;
	private int daLike;

	public LuotLike() {
	}

	public LuotLike(int maNguoiDung, int maDanhGia, int daLike) {
		this.maNguoiDung = maNguoiDung;
		this.maDanhGia = maDanhGia;
		this.daLike = daLike;
	}
	
	public LuotLike( int daLike) {
		this.daLike = daLike;
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public int getMaDanhGia() {
		return maDanhGia;
	}

	public void setMaDanhGia(int maDanhGia) {
		this.maDanhGia = maDanhGia;
	}

	public int getDaLike() {
		return daLike;
	}

	public void setDaLike(int daLike) {
		this.daLike = daLike;
	}

}
