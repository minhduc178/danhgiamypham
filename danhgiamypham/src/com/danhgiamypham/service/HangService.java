package com.danhgiamypham.service;

import java.util.List;

import com.danhgiamypham.dto.HangNhom;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;

public interface HangService {
	public List<Hang> getHang();
	public List<NhomHang> getNhomHang();
	public List<HangNhom> getHangNhom();
}
