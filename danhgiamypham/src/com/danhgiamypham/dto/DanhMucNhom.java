package com.danhgiamypham.dto;

import java.util.List;

import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.NhomSanPham;


public class DanhMucNhom {

	private DanhMuc danhMuc;
	private List<NhomSanPham> nhomSanPham;	
	
	
	public DanhMuc getDanhMuc() {
		return danhMuc;
	}
	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}
	public List<NhomSanPham> getNhomSanPham() {
		return nhomSanPham;
	}
	public void setNhomSanPham(List<NhomSanPham> nhomSanPham) {
		this.nhomSanPham = nhomSanPham;
	}
	
	
}
