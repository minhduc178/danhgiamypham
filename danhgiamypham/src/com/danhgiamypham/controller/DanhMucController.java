package com.danhgiamypham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dto.DanhMucNhom;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.model.SanPhamMoi;
import com.danhgiamypham.service.DanhMucService;

@CrossOrigin("*")
@Controller
@RequestMapping("/danhmuc/")
public class DanhMucController {

	@Autowired
	private DanhMucService danhMucService;
	
	
	@RequestMapping(value="get-all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<List<DanhMuc>> getAll(){
		return danhMucService.getAll();
	}
	
	@RequestMapping(value="get-danhmucnhom", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<List<DanhMucNhom>> getDanhMucNhom(){
		return danhMucService.getDanhMucNhom();
	}

	
	@RequestMapping(value = "them-nhomsanphamtheodanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Boolean> themNhomSanPham(@RequestParam("madanhmuc") int MaDanhMuc,
								   @RequestParam("tennhomsanpham") String TenNhomSanPham) {
		return danhMucService.themNhomSanPham(MaDanhMuc, TenNhomSanPham);
	}
	
	@RequestMapping(value = "get-hang-nhom", method = RequestMethod.GET)
	@ResponseBody
	public List<NhomHang> getNhomHang() {
		return danhMucService.getNhomHang();
	}
	
	
	@RequestMapping(value = "them-hang", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData<Boolean> them(MultipartHttpServletRequest request) {
		String tenH = null;
		String maND=null;
		try {
			maND = request.getParameter("manguoidung");
			tenH = ResourceUtils.readUTF8(request.getParameter("tenhang"));
		} catch(Exception e){
		}
		
		int maNDnew = Integer.valueOf(maND);
		return danhMucService.themHang(tenH, maNDnew);
	}
	
	@RequestMapping(value = "get-hang-theo-nhom", method = RequestMethod.GET)
	@ResponseBody
	public List<Hang> getHangTheoNhom(@RequestParam("manhomhang") int maNhomHang) {
		return danhMucService.getHangTheoNhom(maNhomHang);
	}
	
	@RequestMapping(value = "get-hang-da-them", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<List<Hang>> getHangDaThem() {
		return danhMucService.getHangDaThem();
	}
	

	
}
