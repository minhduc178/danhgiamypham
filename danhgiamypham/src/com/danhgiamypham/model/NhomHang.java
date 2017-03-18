package com.danhgiamypham.model;

public class NhomHang {
	private String tenNhomHang;
	private int maNhomHang;

	public NhomHang() {

	}

	public NhomHang(int maNhomHang, String tenNhomHang) {
		super();
		this.tenNhomHang = tenNhomHang;
		this.maNhomHang = maNhomHang;
	}


	public String getTenNhomHang() {
		return tenNhomHang;
	}

	public void setTenNhomHang(String tenNhomHang) {
		this.tenNhomHang = tenNhomHang;
	}

	public int getMaNhomHang() {
		return maNhomHang;
	}

	public void setMaNhomHang(int maNhomHang) {
		this.maNhomHang = maNhomHang;
	}

}
