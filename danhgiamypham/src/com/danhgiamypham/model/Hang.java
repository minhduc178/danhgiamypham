package com.danhgiamypham.model;

public class Hang {
	private int maHang;
	private String tenHang;
	private int maNhomHang;

	public Hang() {

	}

	public Hang(int maHang, String tenHang, int maNhomHang) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.maNhomHang = maNhomHang;
	}
	
	public Hang(int maHang, String tenHang) {
		this.maHang = maHang;
		this.tenHang = tenHang;
		
	}

	public int getMaHang() {
		return maHang;
	}

	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public int getMaNhomHang() {
		return maNhomHang;
	}

	public void setMaNhomHang(int maNhomHang) {
		this.maNhomHang = maNhomHang;
	}

}
