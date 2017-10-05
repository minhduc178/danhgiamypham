package com.danhgiamypham.controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.dto.SanPhamYeuThichNhom;
import com.danhgiamypham.model.SanPham;
import com.danhgiamypham.model.SanPhamMoi;
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
	
	@RequestMapping(value = "get-ten-san-pham", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Set<SanPham>> getTenSanPham() {
		return sanPhamService.getTenSanPham();
	}
	
	
	@RequestMapping(value = "get-sanphamtheonhomsp", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<Set<SanPham>> getSanPhamTheoNhomSanPham(@RequestParam("tranghientai") int trangHienTai,
												@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
												@RequestParam("manhomsanpham") int maNhomSanPham,
												@RequestParam("chuoinhom") String[] chuoiNhom) {
		return sanPhamService.getSanPhamTheoNhomSanPham(trangHienTai,soLuongTrongTrang, maNhomSanPham, chuoiNhom);
	}


	@RequestMapping(value = "tim-kiem", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData<Set<SanPham>> getSanPhamTimKiem(MultipartHttpServletRequest request){
	String ht = request.getParameter("tranghientai");
	String sltt = request.getParameter("soluongtrongtrang");
	String[] chuoiN = request.getParameterValues("chuoiNhom");	
	
	String timKiem = null;
	try {
		timKiem = ResourceUtils.readUTF8(request.getParameter("dulieu"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		int trangHienTai = Integer.parseInt(ht);
		int soLuongTrongTrang = Integer.parseInt(sltt);
		
		return sanPhamService.getSanPhamTimKiem(trangHienTai, soLuongTrongTrang, timKiem, chuoiN);
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
		public ResponseData<Integer> getTongSoSanPhamMaHang(@RequestParam("mahang")  String link) {
			return sanPhamService.getTongSoSanPhamMaHang(link);
		}
		
//		@RequestMapping(value = "get-tongsosanphammahangchuoinhom", method = RequestMethod.GET)
//		@ResponseBody
//		public ResponseData<Integer> getTongSoSanPhamMaHangChuoiNhom(@RequestParam("mahang")  String link) {
//			return sanPhamService.getTongSoSanPhamMaHangChuoiNhom(link);
//		}
		
		@RequestMapping(value = "get-sanphamtheohang", method = RequestMethod.GET)
		@ResponseBody
		public List<SanPham> getSanPhamTheoHang(@RequestParam("tranghientai") int trangHienTai,
													@RequestParam("soluongtrongtrang") int soLuongTrongTrang, 
													@RequestParam("mahang") String link,
													@RequestParam("chuoinhom") String[] chuoiNhom) {
			List<SanPham> spList =  sanPhamService.getSanPhamTheoHang(trangHienTai,soLuongTrongTrang, link, chuoiNhom);
			return spList;
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
	@RequestMapping(value = "get-tongsosanphamtimkiem", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData<Integer> getTongSoSanPhamTimKiem(MultipartHttpServletRequest request) {
		
		String k = "";
		try {
			k =  ResourceUtils.readUTF8(request.getParameter("dulieu"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanPhamService.getTongSoSanPhamTimKiem(k);
	}
	
	@RequestMapping(value = "get-tongsosanphamtimkiemtheochuoi", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData<Integer> getTongSoSanPhamTimKiemTheoChuoi(MultipartHttpServletRequest request) {
		SanPhamMoi sptk = new SanPhamMoi();
		String timKiem="";
		String[] chuoiNhom=null;
		try {			
			timKiem =  ResourceUtils.readUTF8(request.getParameter("dulieu"));
			chuoiNhom = request.getParameterValues("chuoiNhom");
			
		} catch(Exception e){
		}

		return sanPhamService.getTongSoSanPhamTimKiemTheoChuoi(timKiem, chuoiNhom);
	}
	
	
	@RequestMapping(value = "get-chi-tiet-san-pham", method = RequestMethod.GET)
	@ResponseBody
	public ResponseData<SanPham> getChiTietSanPham(
			@RequestParam("link") String link,
			@RequestParam("manguoidung") int maND) {
		return sanPhamService.getChiTietSanPham(link, maND);
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
	
	@RequestMapping(value = "them-yeu-thich", method = RequestMethod.GET)
	@ResponseBody
	public Boolean themSanPhamYeuThich(@RequestParam("manguoidung") int maNguoiDung,
										@RequestParam("masanpham") int maSanPham) {
		return sanPhamService.themSanPhamYeuThich(maNguoiDung, maSanPham);
	}
	
	@RequestMapping(value = "xoa-yeu-thich", method = RequestMethod.GET)
	@ResponseBody
	public Boolean xoaSanPhamYeuThich(@RequestParam("manguoidung") int maNguoiDung,
										@RequestParam("masanpham") int maSanPham) {
		return sanPhamService.xoaSanPhamYeuThich(maNguoiDung, maSanPham);
	}
	
	@RequestMapping(value = "them-ghi-chu", method = RequestMethod.POST)
	@ResponseBody
	public Boolean themGhiChuYeuThich(MultipartHttpServletRequest request) throws Exception{
		String maNguoiDung = request.getParameter("manguoidung");
		String maSanPham = request.getParameter("masanpham");
		String ghiChu = ResourceUtils.readUTF8(request.getParameter("ghichu"));
		
		int maND = Integer.parseInt(maNguoiDung);
		int maSP = Integer.parseInt(maSanPham);
		return sanPhamService.themGhiChuYeuThich(maND, maSP, ghiChu);
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
