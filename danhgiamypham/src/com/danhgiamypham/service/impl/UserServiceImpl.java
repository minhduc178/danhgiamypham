package com.danhgiamypham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.Utilities.MaHoaMD5;
import com.danhgiamypham.dao.UserDao;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.User;
import com.danhgiamypham.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public ResponseData<User> login(User user) {
		String mhtk = MaHoaMD5.mahoa(user.getMatKhau());
		user.setMatKhau(mhtk);
		ResponseData<User> response = userDao.login(user);
		if (response.getData() == null) {
			response.setErrorMessage("Tên hoặc mật khẩu đăng nhập không chính xác!");
		} else {
			response.getData().setTenDangNhap(user.getTenDangNhap());
		}
		return response;
	}

	@Override
	public ResponseData<User> themTaiKhoan(User tk) {
		String mhtk = MaHoaMD5.mahoa(tk.getMatKhau());
		tk.setMatKhau(mhtk);
		ResponseData<User> response = userDao.themTaiKhoan(tk);
		return response;
	}
}
