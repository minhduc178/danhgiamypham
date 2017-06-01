package com.danhgiamypham.dao;

import java.util.List;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.LoaiDa;

public interface LoaiDaDao {
	public ResponseData<List<LoaiDa>> getLoaiDa(String link);
}
