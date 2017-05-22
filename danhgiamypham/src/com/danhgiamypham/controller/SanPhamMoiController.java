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

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;
import com.danhgiamypham.model.SanPhamMoi;
import com.danhgiamypham.service.SanPhamMoiService;

@Controller
@RequestMapping("/san-pham-moi/")
public class SanPhamMoiController {
	@Autowired
	private SanPhamMoiService sanPhamMoiService;

	@RequestMapping(value = "get-hang", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<List<Hang>> getHang() {
		return sanPhamMoiService.getHang();
	}

	@RequestMapping(value = "get-nhomsanphamtheodanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<List<NhomSanPham>> getNhomSanPhamTheoDanhMuc(@RequestParam("madanhmuc") int MaDanhMuc
			) {
		return sanPhamMoiService.getNhomSanPhamTheoDanhMuc(MaDanhMuc);
	}
	
	@RequestMapping(value = "get-nhom-sp-theo-sp", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<List<NhomSanPham>> getNhomSPTheoSP(@RequestParam("masanpham") int MaSanPham,
											@RequestParam("madanhmuc") int MaDanhMuc								
			) {
		return sanPhamMoiService.getNhomSPTheoSP(MaSanPham, MaDanhMuc );
	}
	
	@RequestMapping(value = "them", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData<Boolean> them(MultipartHttpServletRequest request) {
		SanPhamMoi spm = new SanPhamMoi();
		List<MultipartFile> multiFile = request.getFiles("danhSachHinh");

		try {
		String maND = request.getParameter("maNguoiDung");
		String tenSP = ResourceUtils.readUTF8(request.getParameter("tenSanPham"));
		String gioiT = ResourceUtils.readUTF8(request.getParameter("gioiThieu"));
		String congD = ResourceUtils.readUTF8(request.getParameter("congDung"));
		String cachSD = ResourceUtils.readUTF8(request.getParameter("cachSuDung"));
		String thanhP = ResourceUtils.readUTF8(request.getParameter("thanhPhan"));
		String maH = request.getParameter("maHang");
		String[] chuoiN = request.getParameterValues("chuoiNhom");	
	
		spm.setMaNguoiDung(Integer.parseInt(maND));
		spm.setTenSanPham(tenSP);
		spm.setMaHang(Integer.parseInt(maH));
		spm.setGioiThieu(gioiT);
		spm.setCongDung(congD);
		spm.setCachSuDung(cachSD);
		spm.setThanhPhan(thanhP);
		spm.setListMaNhomSP(chuoiN);
		
		} catch(Exception e){
		}
		
		return sanPhamMoiService.them(spm, multiFile);
	}
	
	@RequestMapping(value = "cap-nhat", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData<Boolean> capNhat(MultipartHttpServletRequest request)   {
		ResponseData<Boolean> result = new ResponseData<Boolean>();

		SanPham spm = new SanPham();
		List<MultipartFile> multiFile = request.getFiles("danhSachHinh");

		try {
			String maND = request.getParameter("maNguoiDung");
			String maSP = request.getParameter("maSanPham");
			String tenSP = ResourceUtils.readUTF8(request.getParameter("tenSanPham"));
			String gioiT = ResourceUtils.readUTF8(request.getParameter("gioiThieu"));
			String congD = ResourceUtils.readUTF8(request.getParameter("congDung"));
			String cachSD = ResourceUtils.readUTF8(request.getParameter("cachSuDung"));
			String thanhP = ResourceUtils.readUTF8(request.getParameter("thanhPhan"));
			String maH = request.getParameter("maHang");
			String[] chuoiN = request.getParameterValues("chuoiNhom");	
			

			spm.setMaNguoiDung(Integer.parseInt(maND));
			spm.setMaSanPham(Integer.parseInt(maSP));
			spm.setTenSanPham(tenSP);
			spm.setMaHang(Integer.parseInt(maH));
			spm.setGioiThieu(gioiT);
			spm.setCongDung(congD);
			spm.setCachSuDung(cachSD);
			spm.setThanhPhan(thanhP);
			spm.setListMaNhomSPham(chuoiN);
			
		} catch(Exception e){
			result.setErrorMessage("capNhat bi loi");
		}
		result =  sanPhamMoiService.capNhat(spm, multiFile);
		return result;
	}
		
	
}
