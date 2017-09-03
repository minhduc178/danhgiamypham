package com.danhgiamypham.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.Utilities.MaHoaMD5;
import com.danhgiamypham.Utilities.PathRsIMG;
import com.danhgiamypham.dao.UserDao;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.HinhAnhSanPham;
import com.danhgiamypham.model.PathImage;
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
	public ResponseData<User> themTaiKhoan(User tk,
			List<MultipartFile> multiFile) {
		// Them hinh anh
		PathImage anhDaiDien = new PathImage();
		String location = anhDaiDien.getHinhDaiDien();

		for (int i = 0; i < 1; i++) {
			if (multiFile.size() == 0) {
				tk.setHinhAnh("20171506ava.png");
			} else {
				String pathHinh = PathRsIMG.ghiFile(multiFile.get(i), location, tk.getTenDangNhap());
				tk.setHinhAnh(pathHinh);
			}

		}

		// them tai khoan
		String mhtk = MaHoaMD5.mahoa(tk.getMatKhau());
		tk.setMatKhau(mhtk);
		ResponseData<User> response = userDao.themTaiKhoan(tk);

		return response;
	}
}
