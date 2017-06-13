package com.danhgiamypham.model;

public class SoSanPhamThem {
	private int tongSoSanPham;
	private int soThemTrongNgay;

	public SoSanPhamThem() {
	}

	public SoSanPhamThem(int tongSoSanPham, int soThemTrongNgay) {
		this.tongSoSanPham = tongSoSanPham;
		this.soThemTrongNgay = soThemTrongNgay;
	}

	public int getTongSoSanPham() {
		return tongSoSanPham;
	}

	public void setTongSoSanPham(int tongSoSanPham) {
		this.tongSoSanPham = tongSoSanPham;
	}

	public int getSoThemTrongNgay() {
		return soThemTrongNgay;
	}

	public void setSoThemTrongNgay(int soThemTrongNgay) {
		this.soThemTrongNgay = soThemTrongNgay;
	}

}
