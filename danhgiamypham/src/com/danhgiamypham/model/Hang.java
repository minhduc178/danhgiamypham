package com.danhgiamypham.model;

public class Hang {
	private int maHang;
	private String tenHang;
	private int maNhomHang;
	private String linkHang;
	
	private int maNguoiDung;
	private String tenNguoiDung;
	
	public Hang() {

	}


	public Hang(int maHang, String tenHang, int maNhomHang, String linkHang,
			int maNguoiDung, String tenNguoiDung) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.maNhomHang = maNhomHang;
		this.linkHang = linkHang;
		this.maNguoiDung = maNguoiDung;
		this.tenNguoiDung = tenNguoiDung;
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

	public Hang(int maHang, String tenHang, int maNhomHang, String linkHang) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.maNhomHang = maNhomHang;
		this.linkHang = linkHang;
	}
	
	

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getLinkHang() {
		return linkHang;
	}

	public void setLinkHang(String linkHang) {
		this.linkHang = linkHang;
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
