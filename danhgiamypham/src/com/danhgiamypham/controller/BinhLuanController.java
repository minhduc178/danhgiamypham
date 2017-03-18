package com.danhgiamypham.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.danhgiamypham.dto.BinhLuanDTO;
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

//	@RequestMapping(value = "them", method = RequestMethod.POST)
//	@ResponseBody
//	public boolean binhLuan(@RequestBody BinhLuanDTO blDTO) {
//		BinhLuan bl = blDTO.unbind();
//		return binhLuanService.themBinhLuan(bl);
//	}
	
	@RequestMapping(value = "them", method = RequestMethod.POST)
	@ResponseBody
	public boolean binhLuan(MultipartHttpServletRequest request) {
	//	String fileName = request.getParameter("fileName");
		String maNguoiDung = request.getParameter("maNguoiDung");
		String maSanPham = request.getParameter("maSanPham");
		String diemDanhGia = request.getParameter("diemDanhGia");
		String binhLuan = request.getParameter("binhLuan");

		MultipartFile multiFile = request.getFile("file");
		StringBuilder rs = new StringBuilder();
			
		BinhLuan bl= new BinhLuan(); 
		bl.setBinhLuan(binhLuan);
		bl.setDiemDanhGia(Integer.parseInt(diemDanhGia));
		bl.setMaNguoiDung(Integer.parseInt(maNguoiDung));
		bl.setMaSanPham(Integer.parseInt(maSanPham));
					
		binhLuanService.themBinhLuan(bl, multiFile);
		return true;
	}
	
	@RequestMapping(value = "themLike", method = RequestMethod.GET)
	@ResponseBody
	public boolean themLike(@RequestParam("madanhgia") int MaDanhGia, @RequestParam("soluotthich") int SoLuotThich,
			@RequestParam("addClass") String AddClass) {
		return binhLuanService.themLike(MaDanhGia, SoLuotThich, AddClass);
	}
	
	@RequestMapping(value = "kiem-tra-binh-luan", method = RequestMethod.GET)
	@ResponseBody
	public boolean kiemTraBinhLuan(@RequestParam("manguoidung") int mnd, 
							@RequestParam("masanpham") int msp) {
		return binhLuanService.kiemTraBinhLuan(mnd, msp);
	}

}
