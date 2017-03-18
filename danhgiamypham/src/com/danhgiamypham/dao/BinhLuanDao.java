package com.danhgiamypham.dao;

import com.danhgiamypham.model.BinhLuan;


public interface BinhLuanDao {
	public boolean themBinhLuan(BinhLuan bl);
	public boolean themLike(int maDanhGia, int soLuotLike, String aClass, String tTrangLike);
	public boolean kiemTraBinhLuan(int mnd, int msp);
}
