package com.danhgiamypham.model;

import java.util.Date;


public class BinhLuan {
	private int maNguoiDung;
	private int maSanPham;
	private int diemDanhGia;
	private String binhLuan;
	private int soLuotLike;
	private int tinhTrang;
	private Date ngayBinhLuan;
	private String hinhAnh;
	
	public BinhLuan() {
	}
	
	
	public BinhLuan(int maNguoiDung, int maSanPham, int diemDanhGia,
			String binhLuan, int soLuotLike, int tinhTrang, Date ngayBinhLuan, String hinhAnh) {
		this.maNguoiDung = maNguoiDung;
		this.maSanPham = maSanPham;
		this.diemDanhGia = diemDanhGia;
		this.binhLuan = binhLuan;
		this.soLuotLike = soLuotLike;
		this.tinhTrang = tinhTrang;
		this.ngayBinhLuan = ngayBinhLuan;
		this.hinhAnh = hinhAnh;
	}


	public String getHinhAnh() {
		return hinhAnh;
	}


	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}


	public int getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public int getDiemDanhGia() {
		return diemDanhGia;
	}
	public void setDiemDanhGia(int diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}
	public String getBinhLuan() {
		return binhLuan;
	}
	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}
	public int getSoLuotLike() {
		return soLuotLike;
	}
	public void setSoLuotLike(int soLuotLike) {
		this.soLuotLike = soLuotLike;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public Date getNgayBinhLuan() {
		return ngayBinhLuan;
	}
	public void setNgayBinhLuan(Date ngayBinhLuan) {
		this.ngayBinhLuan = ngayBinhLuan;
	}

}



