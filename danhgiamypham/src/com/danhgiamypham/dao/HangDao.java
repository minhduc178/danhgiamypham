package com.danhgiamypham.dao;

import java.util.List;

import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;

public interface HangDao {
	public List<Hang> getHang();
	public List<NhomHang> getNhomHang();
}
