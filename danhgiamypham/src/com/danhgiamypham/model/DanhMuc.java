package com.danhgiamypham.model;

public class DanhMuc {

	private int maDanhMuc;
	private String tenDanhMuc;
	private String link;

	public DanhMuc(){
		
	}
	
	

	public DanhMuc(int maDanhMuc, String tenDanhMuc, String link) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
		this.link = link;
	}



	public int getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	

}
