package com.danhgiamypham.dao;

import java.util.List;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.HoiDap;

public interface HoiDapDao {
	public ResponseData<List<HoiDap>> getHoiDap();
}
