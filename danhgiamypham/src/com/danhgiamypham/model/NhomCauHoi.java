package com.danhgiamypham.model;

public class NhomCauHoi {
	private int maNhomCauHoi;
	private String tenNhomCauHoi;

	public NhomCauHoi() {
		super();
	}

	public NhomCauHoi(int maNhomCauHoi, String tenNhomCauHoi) {
		super();
		this.maNhomCauHoi = maNhomCauHoi;
		this.tenNhomCauHoi = tenNhomCauHoi;
	}

	public int getMaNhomCauHoi() {
		return maNhomCauHoi;
	}

	public void setMaNhomCauHoi(int maNhomCauHoi) {
		this.maNhomCauHoi = maNhomCauHoi;
	}

	public String getTenNhomCauHoi() {
		return tenNhomCauHoi;
	}

	public void setTenNhomCauHoi(String tenNhomCauHoi) {
		this.tenNhomCauHoi = tenNhomCauHoi;
	}

}
