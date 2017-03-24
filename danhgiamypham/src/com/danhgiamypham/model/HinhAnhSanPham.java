package com.danhgiamypham.model;

public class HinhAnhSanPham {
	private int maSanPham;
	private String hinhAnhChinh;
	private String hinh1;
	private String hinh2;
	private String hinh3;
	private String hinh4;
	
	public HinhAnhSanPham() {
		super();
	}
	
	public HinhAnhSanPham(int maSanPham, String hinh1, String hinh2,
			String hinh3, String hinh4, String hinhAnhChinh) {
		super();
		this.maSanPham = maSanPham;
		this.hinh1 = hinh1;
		this.hinh2 = hinh2;
		this.hinh3 = hinh3;
		this.hinh4 = hinh4;
		this.hinhAnhChinh = hinhAnhChinh;
	}
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getHinh1() {
		return hinh1;
	}
	public void setHinh1(String hinh1) {
		this.hinh1 = hinh1;
	}
	public String getHinh2() {
		return hinh2;
	}
	public void setHinh2(String hinh2) {
		this.hinh2 = hinh2;
	}
	public String getHinh3() {
		return hinh3;
	}
	public void setHinh3(String hinh3) {
		this.hinh3 = hinh3;
	}
	public String getHinh4() {
		return hinh4;
	}
	public void setHinh4(String hinh4) {
		this.hinh4 = hinh4;
	}

	public String getHinhAnhChinh() {
		return hinhAnhChinh;
	}

	public void setHinhAnhChinh(String hinhAnhChinh) {
		this.hinhAnhChinh = hinhAnhChinh;
	}
	
	
	
	
	
	
}



