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
									@RequestParam("soluongtrongtrang") int soLuongTrongTrang,
									@RequestParam("chuoinhom") String[] chuoiNhom ) {
		return sanPhamService.getSanPham(trangHienTai, soLuongTrongTrang, chuoiNhom);
	}
	

	
	@RequestMapping(value = "get-sanphamtheonhomsp", method = RequestMethod.GET)
	@ResponseBody
	public Set<SanPham> getSanPhamTheoNhomSanPham(@RequestParam("tranghientai") int trangHienTai,
												@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
												@RequestParam("manhomsanpham") int maNhomSanPham,
												@RequestParam("chuoinhom") String[] chuoiNhom) {
		return sanPhamService.getSanPhamTheoNhomSanPham(trangHienTai,soLuongTrongTrang, maNhomSanPham, chuoiNhom);
	}


	@RequestMapping(value = "tim-kiem", method = RequestMethod.GET)
	@ResponseBody
	public List<SanPham> getSanPhamTimKiem(@RequestParam("tranghientai") int trangHienTai,
									@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
									@RequestParam("timkiem")  String timKiem) {
		
		return sanPhamService.getSanPhamTimKiem(trangHienTai, soLuongTrongTrang, timKiem );
	}

//	lay tong san pham cho trang get san pham o home
	@RequestMapping(value = "get-tongsosanpham", method = RequestMethod.GET)
	@ResponseBody
	public int getTongSoSanPham() {
		return sanPhamService.getTongSoSanPham();
	}
	
	@RequestMapping(value = "get-tongsosanphamtheonhom", method = RequestMethod.GET)
	@ResponseBody
	public int getTongSoSanPhamTheoNhom(@RequestParam("nhomsanphams") String[] nhomsanphams) {
		return sanPhamService.getTongSoSanPhamTheoNhom(nhomsanphams);
	}
	
	//sanphamtheodanhmuc-controller lay tong san pham cho trang get san pham theo danh muc
	@RequestMapping(value = "get-tongsosanphammadanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public int getTongSoSanPhamMaDanhMuc(@RequestParam("madanhmuc")  int maDanhMuc) {
		return sanPhamService.getTongSoSanPhamMaDanhMuc(maDanhMuc);
	}
	
	@RequestMapping(value = "get-tongsosanphammadanhmucchuoinhom", method = RequestMethod.GET)
	@ResponseBody
	public int getTongSoSanPhamMaDanhMuc(@RequestParam("madanhmuc")  int maDanhMuc,
										@RequestParam("nhomsanphams") String[] chuoiNhom) {
		return sanPhamService.getTongSoSanPhamMaDanhMucChuoiNhom(maDanhMuc, chuoiNhom);
	}
	
	@RequestMapping(value = "get-sanphamtheodanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public Set<SanPham> getSanPhamTheoDanhMuc(@RequestParam("tranghientai") int trangHienTai,
												@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
												@RequestParam("madanhmuc") int maDanhMuc,
												@RequestParam("chuoinhom") String[] chuoiNhom) {
		return sanPhamService.getSanPhamTheoDanhMuc(trangHienTai,soLuongTrongTrang, maDanhMuc, chuoiNhom);
	}
	
	//sanphamtheohang-controller lay tong san pham cho trang get san pham theo hang
		@RequestMapping(value = "get-tongsosanphammahang", method = RequestMethod.GET)
		@ResponseBody
		public int getTongSoSanPhamMaHang(@RequestParam("mahang")  int maHang) {
			return sanPhamService.getTongSoSanPhamMaHang(maHang);
		}
		
		@RequestMapping(value = "get-tongsosanphammahangchuoinhom", method = RequestMethod.GET)
		@ResponseBody
		public int getTongSoSanPhamMaHang(@RequestParam("mahang")  int maHang,
											@RequestParam("nhomsanphams") String[] chuoiNhom) {
			return sanPhamService.getTongSoSanPhamMaHangChuoiNhom(maHang, chuoiNhom);
		}
		
		@RequestMapping(value = "get-sanphamtheohang", method = RequestMethod.GET)
		@ResponseBody
		public Set<SanPham> getSanPhamTheoHang(@RequestParam("tranghientai") int trangHienTai,
													@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
													@RequestParam("mahang") int maHang,
													@RequestParam("chuoinhom") String[] chuoiNhom) {
			return sanPhamService.getSanPhamTheoHang(trangHienTai,soLuongTrongTrang, maHang, chuoiNhom);
		}
	
//	lay tong san pham cho trang get san pham theo nhom san pham
		@RequestMapping(value = "get-tongsosanphammanhomsanpham", method = RequestMethod.GET)
		@ResponseBody
		public int getTongSoSanPhamMaNhomSP(@RequestParam("manhomsanpham")  int maNhomSP) {
			return sanPhamService.getTongSoSanPhamMaNhomSP(maNhomSP);
		}
		
		@RequestMapping(value = "tongsosanphammanhomsanphamchuoinhom", method = RequestMethod.GET)
		@ResponseBody
		public int getTongSoSanPhamMaNhomSP(@RequestParam("manhomsanpham")  int maNhomSP,
											@RequestParam("chuoinhomsanphams") String[] chuoiNhom) {
			return sanPhamService.getTongSoSanPhamMaNhomSPChuoiNhom(maNhomSP, chuoiNhom);
		}

	
	//lay tong san pham cho trang get san pham theo tim kiem
	@RequestMapping(value = "get-tongsosanphamtimkiem", method = RequestMethod.GET)
	@ResponseBody
	public int getTongSoSanPhamTimKiem(@RequestParam("timkiem")  String timKiem) {
		return sanPhamService.getTongSoSanPhamTimKiem(timKiem);
	}
	
//	@RequestMapping(value = "get-tongsosanphamtimkiem", method = RequestMethod.GET)
//	@ResponseBody
//	public int getTongSoSanPhamTimKiem(@RequestParam("timkiem")  String timKiem,
//										@RequestParam("chuoinhom") String[] chuoiNhom) {
//		return sanPhamService.getTongSoSanPhamTimKiem(timKiem, chuoiNhom);
//	}
	
	
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
	
	@RequestMapping(value = "get-sanphamtheonhom", method = RequestMethod.GET)
	@ResponseBody
	public Set<SanPham> getSanPhamTheoNhom(@RequestParam("manhomsanpham") int MaNhomSanPham) {
		return sanPhamService.getSanPhamTheoNhomSP(MaNhomSanPham);
	}
	
	@RequestMapping(value="get-duongda", method = RequestMethod.GET)
	@ResponseBody
	public List<SanPham> getDuongDa(){
		return sanPhamService.getDuongDa();
	}

}
