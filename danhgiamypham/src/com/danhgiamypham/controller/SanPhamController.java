package com.danhgiamypham.controller;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danhgiamypham.dto.SanPhamYeuThichNhom;
import com.danhgiamypham.model.SanPham;
import com.danhgiamypham.service.SanPhamService;

@Controller
@RequestMapping("/sanpham/")
public class SanPhamController {

	@Autowired
	private SanPhamService sanPhamService;

	@RequestMapping(value = "get-all", method = RequestMethod.GET)
	@ResponseBody
	public Set<SanPham> getSanPham(@RequestParam("tranghientai") int trangHienTai,
									@RequestParam("soluongtrongtrang") int soLuongTrongTrang) {
		return sanPhamService.getSanPham(trangHienTai, soLuongTrongTrang);
	}
	
	@RequestMapping(value = "tim-kiem", method = RequestMethod.GET)
	@ResponseBody
	public List<SanPham> getSanPhamTimKiem(@RequestParam("tranghientai") int trangHienTai,
									@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
									@RequestParam("timkiem")  String timKiem) {
		
		return sanPhamService.getSanPhamTimKiem(trangHienTai, soLuongTrongTrang, timKiem );
	}

	@RequestMapping(value = "get-tongsosanpham", method = RequestMethod.GET)
	@ResponseBody
	public int getTongSoSanPham() {
		return sanPhamService.getTongSoSanPham();
	}

	@RequestMapping(value = "get-tongsosanphamtimkiem", method = RequestMethod.GET)
	@ResponseBody
	public int getTongSoSanPhamTimKiem(@RequestParam("timkiem")  String timKiem) {
		return sanPhamService.getTongSoSanPhamTimKiem(timKiem);
	}
	
	@RequestMapping(value = "get-tongsosanphammadanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public int getTongSoSanPhamMaDanhMuc(@RequestParam("madanhmuc")  int maDanhMuc) {
		return sanPhamService.getTongSoSanPhamMaDanhMuc(maDanhMuc);
	}

	

	@RequestMapping(value = "get-chi-tiet-san-pham", method = RequestMethod.GET)
	@ResponseBody
	public SanPham getChiTietSanPham(@RequestParam("masanpham") int MaSanPham) {
		String rootPath = System.getProperty("catalina.home");
		File dir = new File(rootPath + File.separator + "webapps" + File.separator + "IMG");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return sanPhamService.getChiTietSanPham(MaSanPham);
	}
	
	
	
	@RequestMapping(value = "san-pham-yeu-thich", method = RequestMethod.GET)
	@ResponseBody
	public List<SanPhamYeuThichNhom> getSanPhamYeuThich(@RequestParam("manguoidung") int MaNguoiDung) {
		return sanPhamService.getSanPhamYeuThich(MaNguoiDung);
	}
	
	@RequestMapping(value = "loc-san-pham", method = RequestMethod.GET)
	@ResponseBody
	public Set<SanPham> getSanPham(@RequestParam("tranghientai") int trangHienTai,
									@RequestParam("soluongtrongtrang") int soLuongTrongTrang,
									@RequestParam("param") String[] param) {
		return sanPhamService.locSanPhamTheoNhom(trangHienTai,soLuongTrongTrang,param);
	}
	
	@RequestMapping(value = "get-duyetsanpham", method = RequestMethod.GET)
	@ResponseBody
	public List<SanPham> getDuyetSanPham(@RequestParam("tinhtrang") int tinhTrang) {
		return sanPhamService.getDuyetSanPham(tinhTrang);
	}
	
	@RequestMapping(value = "get-duyetsanphamdang", method = RequestMethod.GET)
	@ResponseBody
	public boolean getDuyetSanPhamDang(@RequestParam("masp") int maSP) {
		return sanPhamService.getDuyetSanPhamDang(maSP);
	}
	
	
	@RequestMapping(value = "get-xoasanphamdang", method = RequestMethod.GET)
	@ResponseBody
	public boolean getXoaSanPham(@RequestParam("masp") int maSP) {
		return sanPhamService.getXoaSanPhamDang(maSP);
	}

}
