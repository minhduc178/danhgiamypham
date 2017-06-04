package com.danhgiamypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.danhgiamypham.Utilities.ConstantURL;
import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.dto.UserDTO;
import com.danhgiamypham.model.User;
import com.danhgiamypham.service.UserService;

@Controller
@RequestMapping(value = ConstantURL.USER_URL)
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = ConstantURL.USER_LOGIN_URL, method = RequestMethod.POST)
	@ResponseBody
	public ResponseData<UserDTO> login(
			@RequestParam("tendangnhap") String userName,
			@RequestParam("matkhau") String passWord) {
		ResponseData<UserDTO> result = new ResponseData<UserDTO>();

		User user = new User();
		user.setTenDangNhap(userName);
		user.setMatKhau(passWord);

		ResponseData<User> response = userService.login(user);

		if (response.getErrorMessage().length() == 0) {

			UserDTO userDto = new UserDTO();
			userDto.unbind(response.getData());
			result.setData(userDto);
		} else {
			result.setErrorMessage(response.getErrorMessage());
		}

		return result;

	}

	@RequestMapping(value = "them", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData<User> themTaiKhoan(
			MultipartHttpServletRequest request) {
		List<MultipartFile> multiFile = request.getFiles("hinhDaiDien");
		User user = new User();

		try {
			String email = request.getParameter("email");
			String tenDangNhap = request
					.getParameter("tenDangNhap");
			String matKhau = request
					.getParameter("matKhau");
			String tenDienDan = ResourceUtils.readUTF8(request
					.getParameter("tenDienDan"));

			user.setEmail(email);
			user.setMatKhau(matKhau);
			user.setTenDangNhap(tenDangNhap);
			user.setTenDienDan(tenDienDan);

		} catch (Exception e) {
		}

		return userService.themTaiKhoan(user, multiFile);

	}

	// @RequestMapping(value = "them", method = RequestMethod.POST)
	// @ResponseBody
	// public ResponseData<UserDTO> themTaiKhoan(@RequestBody UserDTO tkDTO) {
	// /*
	// * User tk = tkDTO.bind(); tk = userService.themTaiKhoan(tk);
	// * tkDTO.unbind(tk);
	// *
	// * return tkDTO;
	// */
	// ResponseData<UserDTO> result = new ResponseData<UserDTO>();
	// User tk = tkDTO.bind();
	//
	// ResponseData<User> response = userService.themTaiKhoan(tk);
	// if(response.getErrorMessage().length() == 0){
	// tkDTO.unbind(response.getData());
	// result.setData(tkDTO);
	// } else {
	// result.setErrorMessage(response.getErrorMessage());
	// }
	// return result;
	// }

}
