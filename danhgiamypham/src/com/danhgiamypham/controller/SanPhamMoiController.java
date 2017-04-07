package com.danhgiamypham.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPhamMoi;
import com.danhgiamypham.service.SanPhamMoiService;

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
		String maND = request.getParameter("maNguoiDung");
		String tenSP = ResourceUtils.readUTF8(request.getParameter("tenSanPham"));
		String gioiT = ResourceUtils.readUTF8(request.getParameter("gioiThieu"));
		String congD = ResourceUtils.readUTF8(request.getParameter("congDung"));
		String cachSD = ResourceUtils.readUTF8(request.getParameter("cachSuDung"));
		String thanhP = ResourceUtils.readUTF8(request.getParameter("thanhPhan"));
		String maH = request.getParameter("maHang");
		String[] chuoiN = request.getParameterValues("chuoiNhom");	
		List<MultipartFile> multiFile = request.getFiles("danhSachHinh");
		
		SanPhamMoi spm = new SanPhamMoi();
		spm.setMaNguoiDung(Integer.parseInt(maND));
		spm.setTenSanPham(tenSP);
		spm.setMaHang(Integer.parseInt(maH));
		spm.setGioiThieu(gioiT);
		spm.setCongDung(congD);
		spm.setCachSuDung(cachSD);
		spm.setThanhPhan(thanhP);
		spm.setListMaNhomSP(chuoiN);
		
		return sanPhamMoiService.them(spm, multiFile);
	}
	
	@RequestMapping(value = "cap-nhat", method = RequestMethod.POST)
	@ResponseBody
	public boolean capnhat(MultipartHttpServletRequest request) {
//		String fileName = request.getParameter("fileName");
		int maSP = Integer.parseInt(request.getParameter("maSP"));
		String tenSP = request.getParameter("tenSP");
		String maH = ResourceUtils.readUTF8(request.getParameter("maH"));
		String maN = request.getParameter("maN");
		String boP = request.getParameter("boP");
		String gioiT = ResourceUtils.readUTF8(request.getParameter("gioiT"));
		String congD = ResourceUtils.readUTF8(request.getParameter("congD"));
		String cachSD = ResourceUtils.readUTF8(request.getParameter("cachSD"));
		String thanhP = ResourceUtils.readUTF8(request.getParameter("thanhP"));
		String maND = request.getParameter("maND");
	
		MultipartFile multiFile = request.getFile("file");
	
		
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
		
	//	sanPhamMoiService.capnhat(spm, multiFile);

		return true;
	}
	
	@RequestMapping(value = "test-data", method = RequestMethod.GET)
	@ResponseBody
	public String testData(@RequestParam("name") String name) {
		try{
			byte[] b = name.getBytes("ISO-8859-15");
			String s = new String(b, "UTF-8");
			System.out.print(s);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return name;
	}
	
}
