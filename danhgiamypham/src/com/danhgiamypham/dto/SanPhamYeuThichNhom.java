package com.danhgiamypham.dto;

import java.util.List;

import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.SanPham;

public class SanPhamYeuThichNhom {
	private Hang hang;
	private List<SanPham> sanPhamList;

	public SanPhamYeuThichNhom() {
		super();
	}

	public SanPhamYeuThichNhom(Hang hang, List<SanPham> sanPhamList) {
		super();
		this.hang = hang;
		this.sanPhamList = sanPhamList;
	}

	public Hang getHang() {
		return hang;
	}

	public void setHang(Hang hang) {
		this.hang = hang;
	}

	public List<SanPham> getSanPhamList() {
		return sanPhamList;
	}

	public void setSanPhamList(List<SanPham> sanPhamList) {
		this.sanPhamList = sanPhamList;
	}

}
