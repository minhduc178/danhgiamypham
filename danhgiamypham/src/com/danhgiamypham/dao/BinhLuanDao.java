package com.danhgiamypham.dao;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.BinhLuan;


public interface BinhLuanDao {
	public ResponseData<Boolean> themBinhLuan(BinhLuan bl);
	public ResponseData<Boolean> themLike(int maDanhGia, int soLuotLike, String aClass, String tTrangLike);
	public ResponseData<Boolean> kiemTraBinhLuan(int mnd, int msp);
	public ResponseData<Boolean> themHinhAnhBinhLuan(int maDG, String habl);
}
