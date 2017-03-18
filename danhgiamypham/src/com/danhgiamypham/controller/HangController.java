package com.danhgiamypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danhgiamypham.dto.HangNhom;
import com.danhgiamypham.service.HangService;

@Controller
@RequestMapping("/danhmuc/")
public class HangController {

	@Autowired
	private HangService hangService;

	@RequestMapping(value = "get-hangnhom", method = RequestMethod.GET)
	@ResponseBody
	public List<HangNhom> getHangNhom() {
		return hangService.getHangNhom();
	}

}
