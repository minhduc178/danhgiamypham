package com.danhgiamypham.dto;

import java.util.List;

import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;


public class HangNhom {

	private NhomHang nhomHang;
	private List<Hang> hang;
	
	
	public NhomHang getNhomHang() {
		return nhomHang;
	}
	public void setNhomHang(NhomHang nhomHang) {
		this.nhomHang = nhomHang;
	}
	public List<Hang> getHang() {
		return hang;
	}
	public void setHang(List<Hang> hang) {
		this.hang = hang;
	}

}
