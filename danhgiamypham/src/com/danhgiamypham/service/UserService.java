package com.danhgiamypham.service;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.User;

public interface UserService {
	public ResponseData<User> login(User user);
	public ResponseData<User> themTaiKhoan(User tk);
}
