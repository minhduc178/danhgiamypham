package com.danhgiamypham.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danhgiamypham.dto.DanhMucNhom;
import com.danhgiamypham.dto.SanPhamYeuThichNhom;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;
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
	
	@RequestMapping(value = "get-sanphamtheonhom", method = RequestMethod.GET)
	@ResponseBody
	public Set<SanPham> getSanPhamTheoNhom(@RequestParam("manhomsanpham") int MaNhomSanPham) {
		return danhMucService.getSanPhamTheoNhomSP(MaNhomSanPham);
	}
	
	
	@RequestMapping(value = "get-sanphamtheodanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public List<SanPham> getSanPhamTheoDanhMuc(@RequestParam("tranghientai") int trangHienTai,
												@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
												@RequestParam("madanhmuc") int maDanhMuc) {
		return danhMucService.getSanPhamTheoDanhMuc(trangHienTai,soLuongTrongTrang, maDanhMuc);
	}
	
	@RequestMapping(value="get-duongda", method = RequestMethod.GET)
	@ResponseBody
	public List<SanPham> getDuongDa(){
		return danhMucService.getDuongDa();
	}
	
	@RequestMapping(value = "them-nhomsanphamtheodanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public boolean themNhomSanPham(@RequestParam("madanhmuc") int MaDanhMuc,
								   @RequestParam("tennhomsanpham") String TenNhomSanPham) {
		return danhMucService.themNhomSanPham(MaDanhMuc, TenNhomSanPham);
	}
	
	

	
}
