package com.danhgiamypham.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.dto.UserDTO;
import com.danhgiamypham.model.User;
import com.danhgiamypham.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
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
	public ResponseData<UserDTO> themTaiKhoan(@RequestBody UserDTO tkDTO) {
		/*
		 * User tk = tkDTO.bind(); tk = userService.themTaiKhoan(tk);
		 * tkDTO.unbind(tk);
		 * 
		 * return tkDTO;
		 */
		ResponseData<UserDTO> result = new ResponseData<UserDTO>();
		User tk = tkDTO.bind();

		ResponseData<User> response = userService.themTaiKhoan(tk);
		if(response.getErrorMessage().length() == 0){
			tkDTO.unbind(response.getData());
			result.setData(tkDTO);
		} else {
			result.setErrorMessage(response.getErrorMessage());
		}
		return result;
	}

}
