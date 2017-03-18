package com.danhgiamypham.dto;

import java.util.Date;

public class SanPhamDTO {
	private int maSanPham;
	private String tenSanPham;
	private String tenHang;
	private String gioiThieu;
	private String congDung;
	private String cachSuDung;
	private String thanhPhan;
	private String tenNguoiDang;
	private int tinhTrang;
	private Date ngayDang;
	private String nuoc;
	private float diemDanhGia;
	private String hinhAnhChinh;
	private String hinh1;
	private String hinh2;
	private String hinh3;
	private String hinh4;

	public SanPhamDTO() {
		super();
	}

	public SanPhamDTO(int maSanPham, String tenSanPham, String tenHang,
			String gioiThieu, String congDung, String cachSuDung,
			String thanhPhan, String tenNguoiDang, int tinhTrang,
			Date ngayDang, String nuoc, float diemDanhGia, String hinhAnhChinh,
			String hinh1, String hinh2, String hinh3, String hinh4) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.tenHang = tenHang;
		this.gioiThieu = gioiThieu;
		this.congDung = congDung;
		this.cachSuDung = cachSuDung;
		this.thanhPhan = thanhPhan;
		this.tenNguoiDang = tenNguoiDang;
		this.tinhTrang = tinhTrang;
		this.ngayDang = ngayDang;
		this.nuoc = nuoc;
		this.diemDanhGia = diemDanhGia;
		this.hinhAnhChinh = hinhAnhChinh;
		this.hinh1 = hinh1;
		this.hinh2 = hinh2;
		this.hinh3 = hinh3;
		this.hinh4 = hinh4;
	}

	public SanPhamDTO(String tenSanPham, String gioiThieu, String congDung,
			String cachSuDung, String thanhPhan, int tinhTrang, Date ngayDang,
			String nuoc, float diemDanhGia, String hinhAnhChinh, String hinh1,
			String hinh2, String hinh3, String hinh4) {
		this.tenSanPham = tenSanPham;
		this.gioiThieu = gioiThieu;
		this.congDung = congDung;
		this.cachSuDung = cachSuDung;
		this.thanhPhan = thanhPhan;
		this.tinhTrang = tinhTrang;
		this.ngayDang = ngayDang;
		this.nuoc = nuoc;
		this.hinhAnhChinh = hinhAnhChinh;
		this.hinh1 = hinh1;
		this.hinh2 = hinh2;
		this.hinh3 = hinh3;
		this.hinh4 = hinh4;
	}
	
	

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public String getGioiThieu() {
		return gioiThieu;
	}

	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}

	public String getCongDung() {
		return congDung;
	}

	public void setCongDung(String congDung) {
		this.congDung = congDung;
	}

	public String getCachSuDung() {
		return cachSuDung;
	}

	public void setCachSuDung(String cachSuDung) {
		this.cachSuDung = cachSuDung;
	}

	public String getThanhPhan() {
		return thanhPhan;
	}

	public void setThanhPhan(String thanhPhan) {
		this.thanhPhan = thanhPhan;
	}

	public String getTenNguoiDang() {
		return tenNguoiDang;
	}

	public void setTenNguoiDang(String tenNguoiDang) {
		this.tenNguoiDang = tenNguoiDang;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Date getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}

	public String getNuoc() {
		return nuoc;
	}

	public void setNuoc(String nuoc) {
		this.nuoc = nuoc;
	}

	public float getDiemDanhGia() {
		return diemDanhGia;
	}

	public void setDiemDanhGia(float diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}

	public String getHinhAnhChinh() {
		return hinhAnhChinh;
	}

	public void setHinhAnhChinh(String hinhAnhChinh) {
		this.hinhAnhChinh = hinhAnhChinh;
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

}
