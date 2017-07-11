package com.danhgiamypham.dao;

import java.util.List;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.DanhGiaSanPham;
import com.danhgiamypham.model.LuotLike;

public interface DanhGiaSanPhamDao {
	public ResponseData<List<DanhGiaSanPham>> getDanhGiaSanPham(String link);
	public ResponseData<List<String>> getHinhAnhBinhLuan(int maDG);
	public ResponseData<LuotLike> getLuotLike(int maDanhGia, int maND);
}
