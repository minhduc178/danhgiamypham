package com.danhgiamypham.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.Utilities.Pagination;
import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.controller.DanhMucController;
import com.danhgiamypham.dao.DanhGiaSanPhamDao;
import com.danhgiamypham.dao.DanhMucDao;
import com.danhgiamypham.dao.LoaiDaDao;
import com.danhgiamypham.dao.SanPhamDao;
import com.danhgiamypham.dto.DanhMucNhom;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.dto.SanPhamYeuThichNhom;
import com.danhgiamypham.model.DanhGiaSanPham;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.LoaiDa;
import com.danhgiamypham.model.LuotLike;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;
import com.danhgiamypham.model.SanPhamMoi;
import com.danhgiamypham.service.DanhMucService;
import com.danhgiamypham.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	private SanPhamDao sanPhamDao;

	@Autowired
	private DanhMucDao danhMucDao;

	@Autowired
	private LoaiDaDao loaiDaDao;

	@Autowired
	private DanhGiaSanPhamDao danhGiaSanPhamDao;
	
	@Autowired
	private DanhMucService danhMucService;
	
	@Override
	public ResponseData<Set<SanPham>> getTenSanPham() {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
			ResponseData<Set<SanPham>> sanphams = sanPhamDao.getTenSanPham();
			Set<SanPham> sanphamsnew = sanphams.getData();
			response.setData(sanphamsnew);
			return response;
	}

	@Override
	public ResponseData<Set<SanPham>> getSanPham(int trangHienTai,
			int soLuongTrongTrang, String[] chuoiNhom) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();

		if (chuoiNhom.length == 0) {
			trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai,
					soLuongTrongTrang);
			ResponseData<Set<SanPham>> sanphams = sanPhamDao.getSanPham(
					trangHienTai, soLuongTrongTrang);
			Set<SanPham> sanphamsnew = sanphams.getData();

			for (SanPham sp : sanphamsnew) {
				float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
				sp.setDiemDanhGia(ddg);
			}

			return sanphams;
		} else {
			Set<SanPham> sanPhamNhom = new HashSet<SanPham>();
			List<SanPham> kt = new ArrayList<SanPham>();
			for (String r : chuoiNhom) {
				int maNhom = Integer.parseInt(r);
				ResponseData<Set<SanPham>> rs = new ResponseData<Set<SanPham>>();
				rs = sanPhamDao.getSanPhamTheoNhomSP(maNhom);
				kt.addAll(rs.getData());
			}
			List<SanPham> sanPhamPhanTrang = new ArrayList<SanPham>();

			ResponseData<Integer> t = getTongSoSanPhamTheoNhom(chuoiNhom);
			int tnew = t.getData();
			sanPhamPhanTrang = Pagination.PhanTrang(trangHienTai,
					soLuongTrongTrang, tnew, kt);
			sanPhamNhom.addAll(sanPhamPhanTrang);
			response.setData(sanPhamNhom);
			return response;
		}

	}

	@Override
	public ResponseData<Set<SanPham>> locSanPham(String chuoiMN) {
		ResponseData<Set<SanPham>> SanPhamNhom = new ResponseData<Set<SanPham>>();
		String result[] = chuoiMN.split(" ");
		for (String r : result) {
			int k = Integer.parseInt(r);
			SanPhamNhom = sanPhamDao.getSanPhamTheoNhomSP(k);
		}
		return SanPhamNhom;
	}

	@Override
	public ResponseData<Integer> getTongSoSanPham() {
		return sanPhamDao.getTongSanPham();
	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamTheoNhom(String[] nhomsanphams) {
		ResponseData<Integer> response = new ResponseData<Integer>();

		int n = 0;
		for (String r : nhomsanphams) {
			int maNhom = Integer.parseInt(r);
			int m = sanPhamDao.getTongSanPhamTheoNhom(maNhom);
			n = n + m;
		}
		response.setData(n);
		return response;
	}

	// sanphamtheodanhmuc-service
	@Override
	public ResponseData<Set<SanPham>> getSanPhamTheoDanhMuc(int trangHienTai,
			int soLuongTrongTrang, int maDM, String[] chuoiNhom) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();

		if (chuoiNhom.length == 0) {
			ResponseData<Set<SanPham>> sanp = new ResponseData<Set<SanPham>>();

			trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai,
					soLuongTrongTrang);
			sanp = sanPhamDao.getSanPhamTheoDanhMuc(trangHienTai,
					soLuongTrongTrang, maDM);
			Set<SanPham> sanpnew = sanp.getData();

			for (SanPham sp : sanpnew) {
				float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
				sp.setDiemDanhGia(ddg);
			}
			response.setData(sanpnew);
			return response;

		} else {
			Set<SanPham> sanPhamNhom = new HashSet<SanPham>();
			List<SanPham> kt = new ArrayList<SanPham>();
			for (String r : chuoiNhom) {
				int maNhom = Integer.parseInt(r);
				ResponseData<Set<SanPham>> rs = new ResponseData<Set<SanPham>>();
				rs = sanPhamDao.getSanPhamTheoDanhMucMaChuoi(maDM, maNhom);
				Set<SanPham> rsnew = rs.getData();
				kt.addAll(rsnew);
			}
			List<SanPham> sanPhamPhanTrang = new ArrayList<SanPham>();

			ResponseData<Integer> t = getTongSoSanPhamMaDanhMucChuoiNhom(maDM,
					chuoiNhom);
			int tnew = t.getData();
			sanPhamPhanTrang = Pagination.PhanTrang(trangHienTai,
					soLuongTrongTrang, tnew, kt);
			sanPhamNhom.addAll(sanPhamPhanTrang);
			response.setData(sanPhamNhom);
			return response;
		}
	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaDanhMuc(int maDanhMuc) {
		return sanPhamDao.getTongSoSanPhamMaDanhMuc(maDanhMuc);
	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaDanhMucChuoiNhom(
			int maDanhMuc, String[] chuoiNhom) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int n = 0;
		for (String r : chuoiNhom) {
			int maNhom = Integer.parseInt(r);
			ResponseData<Integer> m = sanPhamDao.getTongSoSanPhamMaDanhMuc(
					maDanhMuc, maNhom);
			int mnew = m.getData();
			n = n + mnew;
		}
		response.setData(n);
		return response;
	}

	// sanphamtheohang-service

	@Override
	public List<SanPham> getSanPhamTheoHang(int trangHienTai,
			int soLuongTrongTrang, String link, String[] chuoiNhomNew) {
		int k = link.indexOf(" ");
		if (k<0){
			int maH = Integer.valueOf(link);
			List<SanPham> sanp = new ArrayList<SanPham>();

			trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai,
					soLuongTrongTrang);
			sanp = sanPhamDao.getSanPhamTheoHang(trangHienTai,
					soLuongTrongTrang, maH);

			for (SanPham sp : sanp) {
				float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
				sp.setDiemDanhGia(ddg);
			}

			return sanp;

		} else {
			String linkSP = link.substring(0, link.indexOf(" "));
			int maH = Integer.valueOf(linkSP);
			
			String m=link.substring(link.indexOf(" ")+1);
			String[] chuoiNhom = m.split(" ");
			
			List<SanPham> sanPhamNhom = new ArrayList<SanPham>();
			for (String r : chuoiNhom) {
				int maNhom = Integer.parseInt(r);
				ResponseData<Set<SanPham>> rs = new ResponseData<Set<SanPham>>();

				rs = sanPhamDao.getSanPhamTheoHangMaChuoi(maH, maNhom);
				Set<SanPham> rsnew = rs.getData();
				sanPhamNhom.addAll(rsnew);
			}
			List<SanPham> sanPhamPhanTrang = new ArrayList<SanPham>();

			ResponseData<Integer> t = getTongSoSanPhamMaHang(link);
			int tnew = t.getData();
			sanPhamPhanTrang = Pagination.PhanTrang(trangHienTai,
					soLuongTrongTrang, tnew, sanPhamNhom);
			sanPhamNhom.addAll(sanPhamPhanTrang);
			
			return sanPhamNhom;
		}
	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaHang(String link) {
		int h = link.indexOf(" ");
		if (h <0){
			int t = Integer.valueOf(link);
			return sanPhamDao.getTongSoSanPhamMaHang(t);
		} else {
			ResponseData<Integer> response = new ResponseData<Integer>();
			String linkSP = link.substring(0, link.indexOf(" "));
			int maH = Integer.valueOf(linkSP);
			
			String m=link.substring(link.indexOf(" ")+1);
			String[] chuoiNhom = m.split(" ");
			
			int n = 0;
			for (String r : chuoiNhom) {
				int maNhom = Integer.parseInt(r);
				ResponseData<Integer> k = sanPhamDao.getTongSoSanPhamMaHang(maH,
						maNhom);
				int mnew = k.getData();
				n = n + mnew;
			}
			response.setData(n);
			return response;
		}
	}

//	@Override
//	public ResponseData<Integer> getTongSoSanPhamMaHangChuoiNhom(String link) {
//		int h = link.indexOf(" ");
//		if (h <0){
//			int t = Integer.valueOf(link);
//			return sanPhamDao.getTongSoSanPhamMaHang(t);
//		} else {
//			ResponseData<Integer> response = new ResponseData<Integer>();
//			String linkSP = link.substring(0, link.indexOf(" "));
//			int maH = Integer.valueOf(linkSP);
//			
//			String m=link.substring(link.indexOf(" ")+1);
//			String[] chuoiNhom = m.split(" ");
//			
//			int n = 0;
//			for (String r : chuoiNhom) {
//				int maNhom = Integer.parseInt(r);
//				ResponseData<Integer> k = sanPhamDao.getTongSoSanPhamMaHang(maH,
//						maNhom);
//				int mnew = k.getData();
//				n = n + mnew;
//			}
//			response.setData(n);
//			return response;
//		}
//	}

	@Override
	public ResponseData<Set<SanPham>> getSanPhamTheoNhomSanPham(
			int trangHienTai, int soLuongTrongTrang, int maNhomSP,
			String[] chuoiNhom) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		if (chuoiNhom.length == 0) {
			Set<SanPham> sanpnew = response.getData();
			trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai,
					soLuongTrongTrang);
			response = sanPhamDao.getSanPhamTheoNhomSPham(trangHienTai,
					soLuongTrongTrang, maNhomSP);

			for (SanPham sp : sanpnew) {
				float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
				sp.setDiemDanhGia(ddg);
			}

			return response;

		} else {
			Set<SanPham> sanPhamNhom = new HashSet<SanPham>();
			List<SanPham> kt = new ArrayList<SanPham>();
			for (String r : chuoiNhom) {
				int maNhom = Integer.parseInt(r);
				ResponseData<Set<SanPham>> rs = new ResponseData<Set<SanPham>>();
				rs = sanPhamDao.getSanPhamMaNhomSPMaChuoi(maNhomSP, maNhom);
				Set<SanPham> rsnew = rs.getData();
				kt.addAll(rsnew);
			}
			List<SanPham> sanPhamPhanTrang = new ArrayList<SanPham>();

			ResponseData<Integer> t = getTongSoSanPhamMaNhomSPChuoiNhom(
					maNhomSP, chuoiNhom);
			int tnew = t.getData();
			sanPhamPhanTrang = Pagination.PhanTrang(trangHienTai,
					soLuongTrongTrang, tnew, kt);
			sanPhamNhom.addAll(sanPhamPhanTrang);
			response.setData(sanPhamNhom);
			return response;
		}
	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaNhomSP(int maNhomSP) {
		return sanPhamDao.getTongSoSanPhamMaNhomSP(maNhomSP);
	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaNhomSPChuoiNhom(
			int maNhomSP, String[] chuoiNhom) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int n = 0;
		for (String r : chuoiNhom) {
			int maNhom = Integer.parseInt(r);
			ResponseData<Integer> m = sanPhamDao
					.getTongSoSanPhamMaNhomSPChuoiNhom(maNhomSP, maNhom);
			int mnew = m.getData();
			n = n + mnew;
		}
		response.setData(n);
		return response;
	}

	@Override
	public ResponseData<Set<SanPham>> getSanPhamTimKiem(int trangHienTai,
			int soLuongTrongTrang,String timKiem, String[] chuoiNhom) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		
		if (chuoiNhom != null && chuoiNhom.length > 0) {
			Set<SanPham> sanPhamNhom = new HashSet<SanPham>();
			List<SanPham> kt = new ArrayList<SanPham>();
			for (String r : chuoiNhom) {
				int maNhom = Integer.parseInt(r);
				ResponseData<Set<SanPham>> rs = new ResponseData<Set<SanPham>>();
				rs = sanPhamDao.getSanPhamTimKiemMaChuoi(timKiem, maNhom);
				Set<SanPham> rsnew = rs.getData();
				kt.addAll(rsnew);
			}
			List<SanPham> sanPhamPhanTrang = new ArrayList<SanPham>();

			ResponseData<Integer> t = getTongSoSanPhamTimKiemTheoChuoi(timKiem, chuoiNhom);
			int tnew = t.getData();
			sanPhamPhanTrang = Pagination.PhanTrang(trangHienTai,
					soLuongTrongTrang, tnew, kt);
			sanPhamNhom.addAll(sanPhamPhanTrang);
			response.setData(sanPhamNhom);
			return response;
		} else {
			ResponseData<Set<SanPham>> sanphams = new ResponseData<Set<SanPham>>();

			trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai,
					soLuongTrongTrang);
			sanphams = sanPhamDao.getSanPhamTimKiem(trangHienTai,
					soLuongTrongTrang, timKiem);
			Set<SanPham> sanphamsnew = sanphams.getData();


			for (SanPham sp : sanphamsnew) {
				float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
				sp.setDiemDanhGia(ddg);
			}

			return sanphams;
		}

	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamTimKiem(String timKiem) {
		return sanPhamDao.getTongSanPhamTimKiem(timKiem);
	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamTimKiemTheoChuoi(String timKiem, String[] chuoiNhom) {
		
		ResponseData<Integer> response = new ResponseData<Integer>();
		int n = 0;
		for (String r : chuoiNhom) {
			int maNhom = Integer.parseInt(r);
			ResponseData<Integer> m = sanPhamDao
					.getTongSoSanPhamTimKiemTheoChuoi(timKiem, maNhom);
			int mnew = m.getData();
			n = n + mnew;
		}
		response.setData(n);
		return response;

	}

	@Override
	public ResponseData<SanPham> getChiTietSanPham(String link, int maND) {
		// Load san pham
		ResponseData<SanPham> sp = sanPhamDao.getChiTietSanpham(link);
		SanPham spnew = sp.getData();	
		
		// load danh gia san pham
		ResponseData<List<DanhGiaSanPham>> blsp = getDanhGiaTheoSP(link, maND);
		List<DanhGiaSanPham> blspnew = blsp.getData();
		spnew.setDanhGiaSanPhams(blspnew);
		
		// load loai da
		ResponseData<List<LoaiDa>> ld = loaiDaDao.getLoaiDa(link);
		spnew.setLoaiDas(ld.getData());

		float ddg = ResourceUtils.quyTron(spnew.getDiemDanhGia());
		spnew.setDiemDanhGia(ddg);

		ResponseData<Integer> maDanhMuc = sanPhamDao.getTimMaDanhMuc(link);
		int maDanhMucnew = maDanhMuc.getData();
		spnew.setMaDanhMuc(maDanhMucnew);

		if (spnew.getCachSuDung()==null || spnew.getCachSuDung().equals("undefined")) {
			spnew.setCachSuDung(null);
		}
		if (spnew.getCachSuDung()==null || spnew.getGioiThieu().equals("undefined")) {
			spnew.setGioiThieu(null);
		}
		if (spnew.getCachSuDung()==null || spnew.getThanhPhan().equals("undefined")) {
			spnew.setThanhPhan(null);
		}
		if (spnew.getCachSuDung()==null || spnew.getCongDung().equals("undefined")) {
			spnew.setCongDung(null);
		}
		sp.setData(spnew);

		return sp;

	}

	public ResponseData<List<DanhGiaSanPham>> getDanhGiaTheoSP(String link, int maND) {
		ResponseData<List<DanhGiaSanPham>> response = new ResponseData<List<DanhGiaSanPham>>();
		List<DanhGiaSanPham> listDG = new ArrayList<DanhGiaSanPham>();

		//get toan bo danh gia
		ResponseData<List<DanhGiaSanPham>> dgspList = danhGiaSanPhamDao
				.getDanhGiaSanPham(link);
		List<DanhGiaSanPham> danhGiaSanPhams = dgspList.getData();
		
		//get toan bo bang luotlike

		if(danhGiaSanPhams.size()>0){
			for (DanhGiaSanPham dgsp : danhGiaSanPhams) {
				if(dgsp.getMaNguoiDanhGia() == maND){
					dgsp.setSuaDanhGia("Sửa Đánh Giá");
				}
				
				ResponseData<LuotLike> luotLike = danhGiaSanPhamDao.getLuotLike(dgsp.getMaDanhGia(), maND);
				LuotLike luotL = luotLike.getData();
				
				if (luotL == null){
					dgsp.setAddClass("thich");
					dgsp.setTinhTrangLike("Thích");
				} else {
					dgsp.setAddClass("khongthich");
					dgsp.setTinhTrangLike("Không Thích");
					
				}
				
				
				//them hinh anh
				ResponseData<List<String>> hinhAnhListData = danhGiaSanPhamDao
						.getHinhAnhBinhLuan(dgsp.getMaDanhGia());
				List<String> hinhAnhList = hinhAnhListData.getData();
				dgsp.setHinhAnh(hinhAnhList);
				listDG.add(dgsp);
			}
		}
		response.setData(listDG);
		return response;
	}

	@Override
	public ResponseData<SanPham> getChiTietSanPhamSua(String link) {
		ResponseData<SanPham> sp = sanPhamDao.getChiTietSanpham(link);
		SanPham spnew = sp.getData();

		int maNhomHang = spnew.getMaNhomHang();
		ResponseData<List<LoaiDa>> ld = loaiDaDao.getLoaiDa(link);
		ResponseData<List<DanhGiaSanPham>> blsp = danhGiaSanPhamDao
				.getDanhGiaSanPham(link);
		ResponseData<List<Hang>> hangTheoNhom = danhMucDao
				.getHangTheoNhom(maNhomHang);
		ResponseData<Integer> maNhomSanPhamBoPhan = sanPhamDao
				.getNhomSanPhamTheoBoPhan(link);
		ResponseData<List<Integer>> listMaNhomSanPham = sanPhamDao
				.listMaNhomSanPham(link);

		List<Hang> hangTheoNhomnew = hangTheoNhom.getData();
		List<DanhGiaSanPham> blspnew = blsp.getData();
		int maNhomSanPhamBoPhannew = maNhomSanPhamBoPhan.getData();

		spnew.setLoaiDas(ld.getData());
		spnew.setDanhGiaSanPhams(blspnew);
		spnew.setHangs(hangTheoNhomnew);
		spnew.setMaNhomSanPhamBoPhan(maNhomSanPhamBoPhannew);
		spnew.setMaNhomSanPhams(listMaNhomSanPham.getData());

		ResponseData<Integer> maDanhMuc = sanPhamDao.getTimMaDanhMuc(link);
		int maDanhMucnew = maDanhMuc.getData();
		spnew.setMaDanhMuc(maDanhMucnew);
		
		if (spnew.getCachSuDung()==null || spnew.getCachSuDung().equals("undefined")) {
			spnew.setCachSuDung(null);
		}
		if (spnew.getCachSuDung()==null || spnew.getGioiThieu().equals("undefined")) {
			spnew.setGioiThieu(null);
		}
		if (spnew.getCachSuDung()==null || spnew.getThanhPhan().equals("undefined")) {
			spnew.setThanhPhan(null);
		}
		if (spnew.getCachSuDung()==null || spnew.getCongDung().equals("undefined")) {
			spnew.setCongDung(null);
		}

		float ddg = ResourceUtils.quyTron(spnew.getDiemDanhGia());
		spnew.setDiemDanhGia(ddg);
		sp.setData(spnew);
		
		
		return sp;
	}

	@Override
	public ResponseData<List<SanPham>> getDuongDa() {
		return sanPhamDao.getDuongDa();
	}

	@Override
	public ResponseData<List<SanPham>> getDuyetSanPham(int tinhTrang) {
		// int maDanhMuc = sanPhamDao.getTimMaDanhMuc(maSP);
		// sp.setMaDanhMuc(maDanhMuc);
		return sanPhamDao.getDuyetSanPham(tinhTrang);
	}

	@Override
	public ResponseData<Boolean> getDuyetSanPhamDang(int maSP) {
		return sanPhamDao.getDuyetSanPhamDang(maSP);
	}

	@Override
	public ResponseData<Boolean> getXoaSanPhamDang(int maSP) {
		return sanPhamDao.getXoaSanPhamDang(maSP);
	}

	@Override
	public ResponseData<List<Hang>> getHangYeuThich(int maND) {
		return sanPhamDao.getHangYeuThich(maND);
	}

	@Override
	public ResponseData<List<SanPhamYeuThichNhom>> getSanPhamYeuThich(int maND) {
		ResponseData<List<SanPhamYeuThichNhom>> response = new ResponseData<List<SanPhamYeuThichNhom>>();

		List<SanPhamYeuThichNhom> spytNhom = new ArrayList<SanPhamYeuThichNhom>();
		ResponseData<List<Hang>> hangs = sanPhamDao.getHangYeuThich(maND);
		List<Hang> hangsnew = hangs.getData();
		ResponseData<List<SanPham>> sanPhams = sanPhamDao
				.getSanPhamYeuThich(maND);
		List<SanPham> sanPhamsnew = sanPhams.getData();

		for (Hang ha : hangsnew) {
			List<SanPham> sanPhamCungHang = sanPhamTheoH(ha.getMaHang(),
					sanPhamsnew);
			SanPhamYeuThichNhom spyt = new SanPhamYeuThichNhom();
			spyt.setHang(ha);
			spyt.setSanPhamList(sanPhamCungHang);
			spytNhom.add(spyt);
		}
		response.setData(spytNhom);
		return response;
	}
	
	
	@Override
	public Boolean themSanPhamYeuThich(int maNguoiDung, int maSanPham) {
		return sanPhamDao.themSanPhamYeuThich(maNguoiDung, maSanPham);
	}
	
	@Override
	public Boolean xoaSanPhamYeuThich(int maNguoiDung, int maSanPham) {
		return sanPhamDao.xoaSanPhamYeuThich(maNguoiDung, maSanPham);
	}
	
	@Override
	public Boolean themGhiChuYeuThich(int maNguoiDung,int maSanPham,String ghiChu){
		return sanPhamDao.themGhiChuYeuThich(maNguoiDung, maSanPham, ghiChu);

	}

	private List<SanPham> sanPhamTheoH(int maH, List<SanPham> sanPhams) {
		List<SanPham> sPh = new ArrayList<SanPham>();
		for (SanPham sp : sanPhams) {
			if (sp.getMaHang() == maH) {
				sPh.add(sp);
			}
		}
		return sPh;
	}

	@Override
	public ResponseData<Set<SanPham>> getSanPhamTheoNhomSP(int maNSP) {
		ResponseData<Set<SanPham>> sanp = new ResponseData<Set<SanPham>>();
		sanp = sanPhamDao.getSanPhamTheoNhomSP(maNSP);
		Set<SanPham> sanpnew = sanp.getData();

		for (SanPham sp : sanpnew) {
			float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
			sp.setDiemDanhGia(ddg);
		}
		return sanp;
	}


}
