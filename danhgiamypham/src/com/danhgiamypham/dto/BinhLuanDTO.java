package com.danhgiamypham.dto;

import java.util.Date;
import java.util.List;

import com.danhgiamypham.model.BinhLuan;

public class BinhLuanDTO {
	private int maNguoiDung;
	private int maSanPham;
	private int diemDanhGia;
	private String binhLuan;
	private List<String> hinhAnh;

	public BinhLuanDTO() {
	}

	public BinhLuanDTO(int maNguoiDung, int maSanPham, int diemDanhGia,
			String binhLuan, int soLuotLike, int tinhTrang, Date ngayBinhLuan, List<String> hinhAnh) {
		this.maNguoiDung = maNguoiDung;
		this.maSanPham = maSanPham;
		this.diemDanhGia = diemDanhGia;
		this.binhLuan = binhLuan;
		this.hinhAnh = hinhAnh;
	}

	public BinhLuan unbind() {
		BinhLuan bl = new BinhLuan();
		bl.setMaNguoiDung(maNguoiDung);
		bl.setMaSanPham(maSanPham);
		bl.setDiemDanhGia(diemDanhGia);
		bl.setBinhLuan(binhLuan);
		bl.setHinhAnh(hinhAnh);
		return bl;

	}

	public void bind(BinhLuan bl) {
		this.maNguoiDung = bl.getMaNguoiDung();
		this.maSanPham = bl.getMaSanPham();
		this.diemDanhGia = bl.getDiemDanhGia();
		this.binhLuan = bl.getBinhLuan();
		this.hinhAnh= bl.getHinhAnh();
	}
	


	public List<String> getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(List<String> hinhAnh) {
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

}
