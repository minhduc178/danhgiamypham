package com.danhgiamypham.dto;

import java.math.BigInteger;

import com.danhgiamypham.model.User;

public class UserDTO {

	private BigInteger maNguoiDung;
	private String tenDangNhap;
	private String matKhau;
	private String email;
	private String tenDienDan;
	private String hinhAnh;

	public UserDTO() {
	}

	public UserDTO(String tenDangNhap, String matKhau, String email,String tenDienDan, String hinhAnh) {
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.email = email;
		this.tenDienDan = tenDienDan;
		this.hinhAnh = hinhAnh;
	}

	public User bind() {
		User tk = new User();
		tk.setTenDangNhap(tenDangNhap);
		tk.setMatKhau(matKhau);
		tk.setEmail(email);
		tk.setTenDienDan(tenDienDan);
		tk.setHinhAnh(hinhAnh);

		return tk;
	}

	public void unbind(User user) {
		this.email = user.getEmail();
		this.tenDangNhap = user.getTenDangNhap();
		this.matKhau = null;
		this.maNguoiDung = user.getMaNguoiDung();
		this.tenDienDan=user.getTenDienDan();
		this.hinhAnh = user.getHinhAnh();
	}

	public BigInteger getMaNguoiDung() {
		return maNguoiDung;
	}
	
	

	public String getTenDienDan() {
		return tenDienDan;
	}

	public void setTenDienDan(String tenDienDan) {
		this.tenDienDan = tenDienDan;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public void setMaNguoiDung(BigInteger maNguoiDung) {
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
