package com.danhgiamypham.dao;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.BinhLuan;
import com.danhgiamypham.model.User;

public interface UserDao {
	public ResponseData<User> login(User user);
	public ResponseData<User> themTaiKhoan(User tk);
}
