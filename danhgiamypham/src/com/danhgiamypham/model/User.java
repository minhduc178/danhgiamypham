package com.danhgiamypham.model;

public class User {

	private String tenDangNhap;
	private String matKhau;
	private int maNguoiDung;
	private String email;

	public User() {
	}

	public User(int maNguoiDung, String email) {

		this.maNguoiDung = maNguoiDung;
		this.email = email;
	}

	public User(String tenDangNhap, String matKhau, String email) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.email = email;
	}
	
	public User(String tenDangNhap, String matKhau, String email, int maNguoiDung) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.email = email;
		this.maNguoiDung = maNguoiDung;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}


	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
