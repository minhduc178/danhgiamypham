package com.danhgiamypham.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.User;

public interface UserService {
	public ResponseData<User> login(User user);
	public ResponseData<User> themTaiKhoan(User tk, List<MultipartFile> request);
}
