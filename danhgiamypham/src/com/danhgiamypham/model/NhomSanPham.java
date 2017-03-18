package com.danhgiamypham.model;

public class NhomSanPham {
	private int maNhomSanPham;
	private String tenNhom;
	private int maDanhMuc;
	private boolean valueCheck = false;

		
	public NhomSanPham() {

	}


	public NhomSanPham(int maNhomSanPham, String tenNhom, int maDanhMuc) {
		this.maNhomSanPham = maNhomSanPham;
		this.tenNhom = tenNhom;
		this.maDanhMuc = maDanhMuc;
	}
	

	public NhomSanPham(int maNhomSanPham, String tenNhom, int maDanhMuc, boolean valueCheck) {
		this.maNhomSanPham = maNhomSanPham;
		this.tenNhom = tenNhom;
		this.valueCheck = valueCheck;
		this.maDanhMuc = maDanhMuc;
	}
	
	
	public NhomSanPham(int maNhomSanPham, String tenNhom) {
		this.maNhomSanPham = maNhomSanPham;
		this.tenNhom = tenNhom;
	}


	public int getMaNhomSanPham() {
		return maNhomSanPham;
	}


	public void setMaNhomSanPham(int maNhomSanPham) {
		this.maNhomSanPham = maNhomSanPham;
	}


	public String getTenNhom() {
		return tenNhom;
	}


	public void setTenNhom(String tenNhom) {
		this.tenNhom = tenNhom;
	}


	public int getMaDanhMuc() {
		return maDanhMuc;
	}


	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}


	public boolean isValueCheck() {
		return valueCheck;
	}


	public void setValueCheck(boolean valueCheck) {
		this.valueCheck = valueCheck;
	}
	
	
	
	
	
}
