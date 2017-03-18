package com.danhgiamypham.model;

import java.util.Date;

public class DanhGiaSanPham {
	private int maDanhGia;
	private int diemDanhGia;
	private String binhLuan;
	private int soLuotLike;
	private int tinhTrang;
	private Date ngayGiaNhap;
	private String addClass;
	private String tinhTrangLike;

	public DanhGiaSanPham() {

	}

	public DanhGiaSanPham(int maDanhGia, int diemDanhGia, String binhLuan,
			int soLuotLike, int tinhTrang, Date ngayGiaNhap, String addClass, String tinhTrangLike) {
		super();
		this.maDanhGia = maDanhGia;
		this.diemDanhGia = diemDanhGia;
		this.binhLuan = binhLuan;
		this.soLuotLike = soLuotLike;
		this.tinhTrang = tinhTrang;
		this.ngayGiaNhap = ngayGiaNhap;
		this.addClass = addClass;
		this.tinhTrangLike =  tinhTrangLike;

	}
	
	

	public String getTinhTrangLike() {
		return tinhTrangLike;
	}

	public void setTinhTrangLike(String tinhTrangLike) {
		this.tinhTrangLike = tinhTrangLike;
	}

	public String getAddClass() {
		return addClass;
	}

	public void setAddClass(String addClass) {
		this.addClass = addClass;
	}

	public int getMaDanhGia() {
		return maDanhGia;
	}

	public void setMaDanhGia(int maDanhGia) {
		this.maDanhGia = maDanhGia;
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

	public Date getNgayGiaNhap() {
		return ngayGiaNhap;
	}

	public void setNgayGiaNhap(Date ngayGiaNhap) {
		this.ngayGiaNhap = ngayGiaNhap;
	}

}
