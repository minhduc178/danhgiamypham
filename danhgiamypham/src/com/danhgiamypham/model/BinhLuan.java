package com.danhgiamypham.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public class BinhLuan {
	private BigInteger maNguoiDung;
	private int maSanPham;
	private int diemDanhGia;
	private int maDanhGia;
	private String binhLuan;
	private int soLuotLike;
	private int tinhTrang;
	private Date ngayBinhLuan;
	private List<String> hinhAnh;
	private int diemDanhGiaCu;

	public BinhLuan() {
	}
	
	

	public BinhLuan(BigInteger maNguoiDung, int maSanPham, int diemDanhGia,
			int maDanhGia, String binhLuan, int soLuotLike, int tinhTrang,
			Date ngayBinhLuan, List<String> hinhAnh, int diemDanhGiaCu) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maSanPham = maSanPham;
		this.diemDanhGia = diemDanhGia;
		this.maDanhGia = maDanhGia;
		this.binhLuan = binhLuan;
		this.soLuotLike = soLuotLike;
		this.tinhTrang = tinhTrang;
		this.ngayBinhLuan = ngayBinhLuan;
		this.hinhAnh = hinhAnh;
		this.diemDanhGiaCu = diemDanhGiaCu;
	}



	public BinhLuan(BigInteger maNguoiDung, int maSanPham, int diemDanhGia,
			int maDanhGia, String binhLuan, int soLuotLike, int tinhTrang,
			Date ngayBinhLuan, List<String> hinhAnh) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maSanPham = maSanPham;
		this.diemDanhGia = diemDanhGia;
		this.maDanhGia = maDanhGia;
		this.binhLuan = binhLuan;
		this.soLuotLike = soLuotLike;
		this.tinhTrang = tinhTrang;
		this.ngayBinhLuan = ngayBinhLuan;
		this.hinhAnh = hinhAnh;
	}

	public void bindFromMultipart(MultipartHttpServletRequest request) {
		String maNguoiDung = request.getParameter("maNguoiDung");
		String maSanPham = request.getParameter("maSanPham");
		String diemDanhGia = request.getParameter("diemDanhGia");
		String binhLuan = request.getParameter("binhLuan");

		this.setBinhLuan(binhLuan);
		this.setDiemDanhGia(Integer.parseInt(diemDanhGia));
		this.setMaNguoiDung(BigInteger.valueOf(Long.parseLong(maNguoiDung)));
		this.setMaSanPham(Integer.parseInt(maSanPham));

	}
	
	

	public int getDiemDanhGiaCu() {
		return diemDanhGiaCu;
	}

	public void setDiemDanhGiaCu(int diemDanhGiaCu) {
		this.diemDanhGiaCu = diemDanhGiaCu;
	}

	public List<String> getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(List<String> hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getMaDanhGia() {
		return maDanhGia;
	}

	public void setMaDanhGia(int maDanhGia) {
		this.maDanhGia = maDanhGia;
	}

	public BigInteger getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(BigInteger maNguoiDung) {
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
