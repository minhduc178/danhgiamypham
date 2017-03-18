package com.danhgiamypham.model;

import java.util.Date;
import java.util.List;

public class SanPham {
	private int maSanPham;
	private String tenSanPham;
	private String tenHang;
	private String gioiThieu;
	private String congDung;
	private String cachSuDung;
	private String thanhPhan;
	private String tenNguoiDung;
	private int tinhTrang;
	private Date ngayDang;
	private String nuoc;
	private String tenNhom;
	private float diemDanhGia;
	private int soLuotDanhGia;
	private int soLuotBinhLuan;
	private String hinhAnhChinh;
	private String hinh1;
	private String hinh2;
	private String hinh3;
	private String hinh4;
	private String ghiChu;
	private int maNguoiDung;
	private int maHang;
	private int maNhomSanPham;
	private int maDanhMuc;

	private List<LoaiDa> loaiDas;
	private List<DanhGiaSanPham> danhGiaSanPhams;
	private List<Hang> hangs;
	private List<NhomHang> nhomHangs;
	private List<SanPham> sanPhams;
	
	
	
	
	public List<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}

	public List<Hang> getHangs() {
		return hangs;
	}

	public void setHangs(List<Hang> hangs) {
		this.hangs = hangs;
	}

	public List<NhomHang> getNhomHangs() {
		return nhomHangs;
	}

	public void setNhomHangs(List<NhomHang> nhomHangs) {
		this.nhomHangs = nhomHangs;
	}

	public List<DanhGiaSanPham> getDanhGiaSanPhams() {
		return danhGiaSanPhams;
	}

	public void setDanhGiaSanPhams(List<DanhGiaSanPham> danhGiaSanPhams) {
		this.danhGiaSanPhams = danhGiaSanPhams;
	}

	public List<LoaiDa> getLoaiDas() {
		return loaiDas;
	}

	public void setLoaiDas(List<LoaiDa> loaiDas) {
		this.loaiDas = loaiDas;
	}

	
	public SanPham() {
	}

	public SanPham(int maSanPham, String tenSanPham, String tenHang, int tinhTrang,
			Date ngayDang, float diemDanhGia, int soLuotDanhGia,  String hinhAnhChinh) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.tenHang = tenHang;
		this.tinhTrang = tinhTrang;
		this.ngayDang = ngayDang;
		this.diemDanhGia = diemDanhGia;
		this.soLuotDanhGia = soLuotDanhGia;
		this.hinhAnhChinh = hinhAnhChinh;

	}
	
	public SanPham(int maSanPham, String tenSanPham, String tenHang,
			String gioiThieu, String congDung, String cachSuDung,
			String thanhPhan, String tenNguoiDung, int tinhTrang,
			Date ngayDang, String nuoc, String tenNhom, float diemDanhGia,
			int soLuotDanhGia, int soLuotBinhLuan, String hinhAnhChinh, int maNhomSanPham) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.tenHang = tenHang;
		this.gioiThieu = gioiThieu;
		this.congDung = congDung;
		this.cachSuDung = cachSuDung;
		this.thanhPhan = thanhPhan;
		this.tenNguoiDung = tenNguoiDung;
		this.tinhTrang = tinhTrang;
		this.ngayDang = ngayDang;
		this.nuoc = nuoc;
		this.tenNhom = tenNhom;
		this.diemDanhGia = diemDanhGia;
		this.soLuotDanhGia = soLuotDanhGia;
		this.soLuotBinhLuan = soLuotBinhLuan;
		this.hinhAnhChinh = hinhAnhChinh;
		this.maNhomSanPham = maNhomSanPham;

	}
	
	public SanPham(int maSP,String tenSP, String tenH,String gioiT,
			String congD,String cachSD,String thanhP,String tenND,
			int tinhT,Date ngayD,String nuoc,float diemDG,String hinhAC,String hinh1,
			String hinh2, String hinh3,String hinh4 ){
		this.maSanPham = maSP;
		this.tenSanPham = tenSP;
		this.tenHang = tenH;
		this.gioiThieu = gioiT;
		this.congDung = congD;
		this.cachSuDung  = cachSD;
		this.thanhPhan = thanhP;
		this.tenNguoiDung = tenND;
		this.tinhTrang = tinhT;
		this.ngayDang = ngayD;
		this.tinhTrang = tinhT;
		this.nuoc = nuoc;
		this.diemDanhGia = diemDG;
		this.hinhAnhChinh = hinhAC;
		this.hinh1 = hinh1;
		this.hinh2 = hinh2;
		this.hinh3 = hinh3;
		this.hinh4 = hinh4;
	}
	
	
	
	public SanPham(int maNguoiDung, String tenSanPham, String tenHang,
			int diemDanhGia, String ghiChu, int maHang) {
		this.maNguoiDung = maNguoiDung;
		this.tenSanPham = tenSanPham;
		this.tenHang = tenHang;
		this.diemDanhGia = diemDanhGia;
		this.ghiChu = ghiChu;
		this.maHang =  maHang;
		
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

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
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

	public String getTenNhom() {
		return tenNhom;
	}

	public void setTenNhom(String tenNhom) {
		this.tenNhom = tenNhom;
	}

	public float getDiemDanhGia() {
		return diemDanhGia;
	}

	public void setDiemDanhGia(float diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}

	public int getSoLuotDanhGia() {
		return soLuotDanhGia;
	}

	public void setSoLuotDanhGia(int soLuotDanhGia) {
		this.soLuotDanhGia = soLuotDanhGia;
	}

	public int getSoLuotBinhLuan() {
		return soLuotBinhLuan;
	}

	public void setSoLuotBinhLuan(int soLuotBinhLuan) {
		this.soLuotBinhLuan = soLuotBinhLuan;
	}

	public String getHinhAnhChinh() {
		return hinhAnhChinh;
	}

	public void setHinhAnhChinh(String hinhAnhChinh) {
		this.hinhAnhChinh = hinhAnhChinh;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public int getMaHang() {
		return maHang;
	}

	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}

	public int getMaNhomSanPham() {
		return maNhomSanPham;
	}

	public void setMaNhomSanPham(int maNhomSanPham) {
		this.maNhomSanPham = maNhomSanPham;
	}

	public int getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	
	
	

}



