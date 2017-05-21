package com.danhgiamypham.dao;

import java.util.List;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.DanhGiaSanPham;

public interface DanhGiaSanPhamDao {
	public ResponseData<List<DanhGiaSanPham>> getDanhGiaSanPham(int id);
	public ResponseData<List<String>> getHinhAnhBinhLuan(int maDG);
}
