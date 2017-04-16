package com.danhgiamypham.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.BinhLuan;
import com.danhgiamypham.service.BinhLuanService;
import com.danhgiamypham.service.impl.BinhLuanServiceImpl;

@Controller
@RequestMapping("/binhluan/")
public class BinhLuanController {

	@Autowired
	private BinhLuanService binhLuanService;
	
	@Autowired
	private BinhLuanServiceImpl binhLuanServiceImpl;
	
	@RequestMapping(value = "them", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData<Boolean> binhLuan(MultipartHttpServletRequest request) {
		BinhLuan bl= new BinhLuan();
		bl.bindFromMultipart(request);
		List<MultipartFile> multiFile = request.getFiles("file");
		return binhLuanService.themBinhLuan(bl, multiFile);
	}
	
	@RequestMapping(value = "themLike", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Boolean> themLike(@RequestParam("madanhgia") int MaDanhGia, @RequestParam("soluotthich") int SoLuotThich,
			@RequestParam("addClass") String AddClass) {
		return  binhLuanService.themLike(MaDanhGia, SoLuotThich, AddClass);
	}
	
	@RequestMapping(value = "kiem-tra-binh-luan", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Boolean> kiemTraBinhLuan(@RequestParam("manguoidung") int mnd, 
							@RequestParam("masanpham") int msp) {
		return binhLuanService.kiemTraBinhLuan(mnd, msp);
	}

}
