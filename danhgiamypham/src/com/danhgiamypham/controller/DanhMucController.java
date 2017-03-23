package com.danhgiamypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danhgiamypham.dto.DanhMucNhom;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.service.DanhMucService;

@Controller
@RequestMapping("/danhmuc/")
public class DanhMucController {

	@Autowired
	private DanhMucService danhMucService;
	
	
	@RequestMapping(value="get-all", method = RequestMethod.GET)
	@ResponseBody
	public List<DanhMuc> getAll(){
		return danhMucService.getAll();
	}
	
	@RequestMapping(value="get-danhmucnhom", method = RequestMethod.GET)
	@ResponseBody
	public List<DanhMucNhom> getDanhMucNhom(){
		return danhMucService.getDanhMucNhom();
	}

	
	@RequestMapping(value = "them-nhomsanphamtheodanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public boolean themNhomSanPham(@RequestParam("madanhmuc") int MaDanhMuc,
								   @RequestParam("tennhomsanpham") String TenNhomSanPham) {
		return danhMucService.themNhomSanPham(MaDanhMuc, TenNhomSanPham);
	}
	
	@RequestMapping(value = "get-hang-nhom", method = RequestMethod.GET)
	@ResponseBody
	public List<NhomHang> getNhomHang() {
		return danhMucService.getNhomHang();
	}
	
	
	@RequestMapping(value = "them-hang", method = RequestMethod.GET)
	@ResponseBody
	public boolean themHang(@RequestParam("tenhang") String tenHang) {
		return danhMucService.themHang(tenHang);
	}
	
	@RequestMapping(value = "get-hang-theo-nhom", method = RequestMethod.GET)
	@ResponseBody
	public List<Hang> getHangTheoNhom(@RequestParam("manhomhang") int maNhomHang) {
		return danhMucService.getHangTheoNhom(maNhomHang);
	}
	

	
}
