package com.danhgiamypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danhgiamypham.model.SoLuongDang;
import com.danhgiamypham.model.SoSanPhamThem;
import com.danhgiamypham.service.ThongTinWebService;

@Controller
@RequestMapping("/thongtinweb/")
public class ThongTinWebController {

	@Autowired
	private ThongTinWebService thongTinWebService;

	@RequestMapping(value = "sosanphamthem", method = RequestMethod.GET)
	@ResponseBody
	public SoSanPhamThem soSanPhamDaThem() {
		SoSanPhamThem k = thongTinWebService.soSanPham();
		return k;
	}
	

	@RequestMapping(value = "get-soluongdang", method = RequestMethod.GET)
	@ResponseBody
	public List<SoLuongDang> soLuongDangSP() {
		List<SoLuongDang> k = thongTinWebService.soLuongDangSP();
		return k;
	}
	
	@RequestMapping(value = "get-soluongbinhluan", method = RequestMethod.GET)
	@ResponseBody
	public List<SoLuongDang> soLuongBinhLuan() {
		List<SoLuongDang> k = thongTinWebService.soLuongBinhLuan();
		return k;
	}

}
