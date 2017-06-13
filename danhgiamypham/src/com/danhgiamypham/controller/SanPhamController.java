package com.danhgiamypham.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dto.ResponseData;
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
	public ResponseData<Set<SanPham>> getSanPham(@RequestParam("tranghientai") int trangHienTai,
									@RequestParam("soluongtrongtrang") int soLuongTrongTrang,
									@RequestParam("chuoinhom") String[] chuoiNhom ) {
		return sanPhamService.getSanPham(trangHienTai, soLuongTrongTrang, chuoiNhom);
	}
	

	
	@RequestMapping(value = "get-sanphamtheonhomsp", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Set<SanPham>> getSanPhamTheoNhomSanPham(@RequestParam("tranghientai") int trangHienTai,
												@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
												@RequestParam("manhomsanpham") int maNhomSanPham,
												@RequestParam("chuoinhom") String[] chuoiNhom) {
		return sanPhamService.getSanPhamTheoNhomSanPham(trangHienTai,soLuongTrongTrang, maNhomSanPham, chuoiNhom);
	}


	@RequestMapping(value = "tim-kiem", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<List<SanPham>> getSanPhamTimKiem(
									@RequestParam("tranghientai") int trangHienTai,
									@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
									@RequestParam("timkiem")  String timKiem) {
		
		return sanPhamService.getSanPhamTimKiem(trangHienTai, soLuongTrongTrang, timKiem );
	}
	
	

//	lay tong san pham cho trang get san pham o home
	@RequestMapping(value = "get-tongsosanpham", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Integer> getTongSoSanPham() {
		return sanPhamService.getTongSoSanPham();
	}
	
	@RequestMapping(value = "get-tongsosanphamtheonhom", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Integer> getTongSoSanPhamTheoNhom(@RequestParam("nhomsanphams") String[] nhomsanphams) {
		return sanPhamService.getTongSoSanPhamTheoNhom(nhomsanphams);
	}
	
	//sanphamtheodanhmuc-controller lay tong san pham cho trang get san pham theo danh muc
	@RequestMapping(value = "get-tongsosanphammadanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Integer> getTongSoSanPhamMaDanhMuc(@RequestParam("madanhmuc")  int maDanhMuc) {
		return sanPhamService.getTongSoSanPhamMaDanhMuc(maDanhMuc);
	}
	
	@RequestMapping(value = "get-tongsosanphammadanhmucchuoinhom", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Integer> getTongSoSanPhamMaDanhMuc(@RequestParam("madanhmuc")  int maDanhMuc,
										@RequestParam("nhomsanphams") String[] chuoiNhom) {
		return sanPhamService.getTongSoSanPhamMaDanhMucChuoiNhom(maDanhMuc, chuoiNhom);
	}
	
	@RequestMapping(value = "get-sanphamtheodanhmuc", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Set<SanPham>> getSanPhamTheoDanhMuc(@RequestParam("tranghientai") int trangHienTai,
												@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
												@RequestParam("madanhmuc") int maDanhMuc,
												@RequestParam("chuoinhom") String[] chuoiNhom) {
		return sanPhamService.getSanPhamTheoDanhMuc(trangHienTai,soLuongTrongTrang, maDanhMuc, chuoiNhom);
	}
	
	//sanphamtheohang-controller lay tong san pham cho trang get san pham theo hang
		@RequestMapping(value = "get-tongsosanphammahang", method = RequestMethod.GET)
		@ResponseBody
		public ResponseData<Integer> getTongSoSanPhamMaHang(@RequestParam("mahang")  int maHang) {
			return sanPhamService.getTongSoSanPhamMaHang(maHang);
		}
		
		@RequestMapping(value = "get-tongsosanphammahangchuoinhom", method = RequestMethod.GET)
		@ResponseBody
		public ResponseData<Integer> getTongSoSanPhamMaHang(@RequestParam("mahang")  int maHang,
											@RequestParam("nhomsanphams") String[] chuoiNhom) {
			return sanPhamService.getTongSoSanPhamMaHangChuoiNhom(maHang, chuoiNhom);
		}
		
		@RequestMapping(value = "get-sanphamtheohang", method = RequestMethod.GET)
		@ResponseBody
		public ResponseData<Set<SanPham>> getSanPhamTheoHang(@RequestParam("tranghientai") int trangHienTai,
													@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
													@RequestParam("mahang") int maHang,
													@RequestParam("chuoinhom") String[] chuoiNhom) {
			return sanPhamService.getSanPhamTheoHang(trangHienTai,soLuongTrongTrang, maHang, chuoiNhom);
		}
	
//	lay tong san pham cho trang get san pham theo nhom san pham
		@RequestMapping(value = "get-tongsosanphammanhomsanpham", method = RequestMethod.GET)
		@ResponseBody
		public ResponseData<Integer> getTongSoSanPhamMaNhomSP(@RequestParam("manhomsanpham")  int maNhomSP) {
			return sanPhamService.getTongSoSanPhamMaNhomSP(maNhomSP);
		}
		
		@RequestMapping(value = "tongsosanphammanhomsanphamchuoinhom", method = RequestMethod.GET)
		@ResponseBody
		public ResponseData<Integer> getTongSoSanPhamMaNhomSP(@RequestParam("manhomsanpham")  int maNhomSP,
											@RequestParam("chuoinhomsanphams") String[] chuoiNhom) {
			return sanPhamService.getTongSoSanPhamMaNhomSPChuoiNhom(maNhomSP, chuoiNhom);
		}

	
	//lay tong san pham cho trang get san pham theo tim kiem
	@RequestMapping(value = "get-tongsosanphamtimkiem", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Integer> getTongSoSanPhamTimKiem(@RequestParam("timkiem")  String timKiem) {
		return sanPhamService.getTongSoSanPhamTimKiem(timKiem);
	}
	
	@RequestMapping(value = "get-tongsosanphamtimkiemtheochuoi", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Integer> getTongSoSanPhamTimKiem(@RequestParam("timkiem")  String timKiem,
										@RequestParam("chuoinhom") String[] chuoiNhom) {
		return sanPhamService.getTongSoSanPhamTimKiemTheoChuoi(timKiem, chuoiNhom);
	}
	
	
	@RequestMapping(value = "get-chi-tiet-san-pham", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<SanPham> getChiTietSanPham(@RequestParam("link") String link) {
		return sanPhamService.getChiTietSanPham(link);
	}
	
	@RequestMapping(value = "get-chi-tiet-san-pham-sua", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<SanPham> getChiTietSanPhamSua(@RequestParam("link") String link) {
		return sanPhamService.getChiTietSanPhamSua(link);
	}
	
	@RequestMapping(value = "san-pham-yeu-thich", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<List<SanPhamYeuThichNhom>> getSanPhamYeuThich(@RequestParam("manguoidung") int MaNguoiDung) {
		return sanPhamService.getSanPhamYeuThich(MaNguoiDung);
	}

	@RequestMapping(value = "get-duyetsanpham", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<List<SanPham>> getDuyetSanPham(@RequestParam("tinhtrang") int tinhTrang) {
		return sanPhamService.getDuyetSanPham(tinhTrang);
	}
	
	@RequestMapping(value = "get-duyetsanphamdang", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Boolean> getDuyetSanPhamDang(@RequestParam("masp") int maSP) {
		return sanPhamService.getDuyetSanPhamDang(maSP);
	}
	
	@RequestMapping(value = "get-xoasanphamdang", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Boolean> getXoaSanPham(@RequestParam("masp") int maSP) {
		return sanPhamService.getXoaSanPhamDang(maSP);
	}
	
	@RequestMapping(value = "get-sanphamtheonhom", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Set<SanPham>> getSanPhamTheoNhom(@RequestParam("manhomsanpham") int MaNhomSanPham) {
		return sanPhamService.getSanPhamTheoNhomSP(MaNhomSanPham);
	}
	
	@RequestMapping(value="get-duongda", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<List<SanPham>> getDuongDa(){
		return sanPhamService.getDuongDa();
	}

}
