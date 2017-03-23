package com.danhgiamypham.model;

public class SanPhamMoi {
	private String tenSanPham;
	private int maHang;
	private String maNhom;
	private int maboPhan;
	private String gioiThieu;
	private String congDung;
	private String cachSuDung;
	private String thanhPhan;
	private int maNguoiDung;
	private int maSanPham;
	
	private String[] listMaNhomSP;
	
	public SanPhamMoi(String tenSanPham, int maHang, String maNhom,
			int maboPhan, String gioiThieu, String congDung, String cachSuDung,
			String thanhPhan, int maNguoiDung, int maSanPham,
			String[] listMaNhomSP) {
		super();
		this.tenSanPham = tenSanPham;
		this.maHang = maHang;
		this.maNhom = maNhom;
		this.maboPhan = maboPhan;
		this.gioiThieu = gioiThieu;
		this.congDung = congDung;
		this.cachSuDung = cachSuDung;
		this.thanhPhan = thanhPhan;
		this.maNguoiDung = maNguoiDung;
		this.maSanPham = maSanPham;
		this.listMaNhomSP = listMaNhomSP;
	}



	public SanPhamMoi() {
		super();
	}
	
	
	
	public String[] getListMaNhomSP() {
		return listMaNhomSP;
	}
	public void setListMaNhomSP(String[] listMaNhomSp) {
		this.listMaNhomSP = listMaNhomSp;
	}
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public int getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public int getMaHang() {
		return maHang;
	}
	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}
	public String getMaNhom() {
		return maNhom;
	}
	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}
	public int getMaboPhan() {
		return maboPhan;
	}
	public void setMaboPhan(int maboPhan) {
		this.maboPhan = maboPhan;
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
	
	

}



