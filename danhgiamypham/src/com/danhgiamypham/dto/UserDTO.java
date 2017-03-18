package com.danhgiamypham.dto;

import com.danhgiamypham.model.User;

public class UserDTO {

	private int maNguoiDung;
	private String tenDangNhap;
	private String matKhau;
	private String email;

	public UserDTO() {
	}

	public UserDTO(String tenDangNhap, String matKhau, String email) {
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.email = email;
	}

	public User bind() {
		User tk = new User();
		tk.setTenDangNhap(tenDangNhap);
		tk.setMatKhau(matKhau);
		tk.setEmail(email);

		return tk;
	}

	public void unbind(User user) {
		this.email = user.getEmail();
		this.tenDangNhap = user.getTenDangNhap();
		this.matKhau = null;
		this.maNguoiDung = user.getMaNguoiDung();
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
