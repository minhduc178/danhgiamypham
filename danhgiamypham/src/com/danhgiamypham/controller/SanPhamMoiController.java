package com.danhgiamypham.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPhamMoi;
import com.danhgiamypham.service.SanPhamMoiService;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
@RequestMapping("/san-pham-moi/")
public class SanPhamMoiController {
	@Autowired
	private SanPhamMoiService sanPhamMoiService;

	@RequestMapping(value = "get-hang", method = RequestMethod.GET)
	@ResponseBody
	public List<Hang> getHang() {
		return sanPhamMoiService.getHang();
	}

	@RequestMapping(value = "get-nhomsanphamtheodanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public List<NhomSanPham> getNhomSanPhamTheoDanhMuc(@RequestParam("madanhmuc") int MaDanhMuc
			) {
		return sanPhamMoiService.getNhomSanPhamTheoDanhMuc(MaDanhMuc);
	}
	
	@RequestMapping(value = "get-nhom-sp-theo-sp", method = RequestMethod.GET)
	@ResponseBody
	public List<NhomSanPham> getNhomSPTheoSP(@RequestParam("masanpham") int MaSanPham,
											@RequestParam("madanhmuc") int MaDanhMuc								
			) {
		return sanPhamMoiService.getNhomSPTheoSP(MaSanPham, MaDanhMuc );
	}
	
	@RequestMapping(value = "them", method = RequestMethod.POST)
	@ResponseBody
	public boolean them(MultipartHttpServletRequest request) {
		String fileName = request.getParameter("fileName");
		String tenSP = request.getParameter("tenSP");
		String maH = request.getParameter("maH");
		String maN = request.getParameter("maN");
		String boP = request.getParameter("boP");
		String gioiT = request.getParameter("gioiT");
		String congD = request.getParameter("congD");
		String cachSD = request.getParameter("cachSD");
		String thanhP = request.getParameter("thanhP");
		String maND = request.getParameter("maND");
	
		MultipartFile multiFile = request.getFile("file");
		StringBuilder rs = new StringBuilder();
		
		List<String> result = new ArrayList<String>();
		
		SanPhamMoi spm = new SanPhamMoi();
		spm.setTenSanPham(tenSP);
		spm.setMaHang(Integer.parseInt(maH));
		spm.setMaNhom(maN);
		spm.setMaboPhan(Integer.parseInt(boP));
		spm.setGioiThieu(gioiT);
		spm.setCongDung(congD);
		spm.setCachSuDung(cachSD);
		spm.setThanhPhan(thanhP);
		spm.setMaNguoiDung(Integer.parseInt(maND));
				
		return sanPhamMoiService.them(spm, fileName, multiFile);
	}
	
	@RequestMapping(value = "cap-nhat", method = RequestMethod.POST)
	@ResponseBody
	public boolean capnhat(MultipartHttpServletRequest request) {
//		String fileName = request.getParameter("fileName");
		int maSP = Integer.parseInt(request.getParameter("maSP"));
		String tenSP = request.getParameter("tenSP");
		String maH = request.getParameter("maH");
		String maN = request.getParameter("maN");
		String boP = request.getParameter("boP");
		String gioiT = request.getParameter("gioiT");
		String congD = request.getParameter("congD");
		String cachSD = request.getParameter("cachSD");
		String thanhP = request.getParameter("thanhP");
		String maND = request.getParameter("maND");
	
		MultipartFile multiFile = request.getFile("file");
		StringBuilder rs = new StringBuilder();
		
		List<String> result = new ArrayList<String>();
		
		SanPhamMoi spm = new SanPhamMoi();
		spm.setMaSanPham(maSP);
		spm.setTenSanPham(tenSP);
		spm.setMaHang(Integer.parseInt(maH));
		spm.setMaNhom(maN);
		spm.setMaboPhan(Integer.parseInt(boP));
		spm.setGioiThieu(gioiT);
		spm.setCongDung(congD);
		spm.setCachSuDung(cachSD);
		spm.setThanhPhan(thanhP);
		spm.setMaNguoiDung(Integer.parseInt(maND));
		
		sanPhamMoiService.capnhat(spm, multiFile);

		return true;
	}
	
	
}
