package com.danhgiamypham.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.Utilities.Pagination;
import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dao.DanhGiaSanPhamDao;
import com.danhgiamypham.dao.DanhMucDao;
import com.danhgiamypham.dao.LoaiDaDao;
import com.danhgiamypham.dao.SanPhamDao;
import com.danhgiamypham.dto.SanPhamYeuThichNhom;
import com.danhgiamypham.model.DanhGiaSanPham;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.LoaiDa;
import com.danhgiamypham.model.SanPham;
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

	@Override
	public Set<SanPham> getSanPham(int trangHienTai, int soLuongTrongTrang,
			String[] chuoiNhom) {

		if (chuoiNhom.length == 0) {
			trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai,
					soLuongTrongTrang);
			Set<SanPham> sanphams = sanPhamDao.getSanPham(trangHienTai,
					soLuongTrongTrang);

			for (SanPham sp : sanphams) {
				float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
				sp.setDiemDanhGia(ddg);
			}

			return sanphams;
		} else {
			Set<SanPham> sanPhamNhom = new HashSet<SanPham>();
			List<SanPham> kt = new ArrayList<SanPham>();
			for (String r : chuoiNhom) {
				int maNhom = Integer.parseInt(r);
				Set<SanPham> rs = new HashSet<SanPham>();
				rs = sanPhamDao.getSanPhamTheoNhomSP(maNhom);
				kt.addAll(rs);
			}
			List<SanPham> sanPhamPhanTrang = new ArrayList<SanPham>();

			int t = getTongSoSanPhamTheoNhom(chuoiNhom);
			sanPhamPhanTrang = Pagination.PhanTrang(trangHienTai,
					soLuongTrongTrang, t, kt);
			sanPhamNhom.addAll(sanPhamPhanTrang);
			return sanPhamNhom;
		}

	}
	
	@Override
	public Set<SanPham> locSanPham(String chuoiMN) {
		Set<SanPham> SanPhamNhom = new HashSet<SanPham>();
		String result[] = chuoiMN.split(" ");
		for (String r : result) {
			int k = Integer.parseInt(r);
			SanPhamNhom = sanPhamDao.getSanPhamTheoNhomSP(k);
		}
		return SanPhamNhom;

	}
	
	@Override
	public int getTongSoSanPham() {
		return sanPhamDao.getTongSanPham();
	}

	@Override
	public int getTongSoSanPhamTheoNhom(String[] nhomsanphams) {
		int n = 0;
		for (String r : nhomsanphams) {
			int maNhom = Integer.parseInt(r);
			int m = sanPhamDao.getTongSanPhamTheoNhom(maNhom);
			n = n + m;
		}
		return n;
	}
	
	

	@Override
	public Set<SanPham> getSanPhamTheoDanhMuc(int trangHienTai,
			int soLuongTrongTrang, int maDM, String[] chuoiNhom) {

		if (chuoiNhom.length == 0) {
			Set<SanPham> sanp = new HashSet<SanPham>();

			trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai,
					soLuongTrongTrang);
			sanp = sanPhamDao.getSanPhamTheoDanhMuc(trangHienTai,
					soLuongTrongTrang, maDM);

			for (SanPham sp : sanp) {
				float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
				sp.setDiemDanhGia(ddg);
			}

			return sanp;
			
		} else {
			Set<SanPham> sanPhamNhom = new HashSet<SanPham>();
			List<SanPham> kt = new ArrayList<SanPham>();
			for (String r : chuoiNhom) {
				int maNhom = Integer.parseInt(r);
				Set<SanPham> rs = new HashSet<SanPham>();
				rs = sanPhamDao.getSanPhamTheoDanhMucMaChuoi(maDM, maNhom);
				kt.addAll(rs);
			}
			List<SanPham> sanPhamPhanTrang = new ArrayList<SanPham>();

			int t = getTongSoSanPhamMaDanhMucChuoiNhom(maDM, chuoiNhom);
			sanPhamPhanTrang = Pagination.PhanTrang(trangHienTai,
					soLuongTrongTrang, t, kt);
			sanPhamNhom.addAll(sanPhamPhanTrang);
			return sanPhamNhom;
		}
	}
	
	@Override
	public int getTongSoSanPhamMaDanhMuc(int maDanhMuc) {
		return sanPhamDao.getTongSoSanPhamMaDanhMuc(maDanhMuc);
	}

	@Override
	public int getTongSoSanPhamMaDanhMucChuoiNhom(int maDanhMuc, String[] chuoiNhom) {
		int n = 0;
		for (String r : chuoiNhom) {
			int maNhom = Integer.parseInt(r);
			int m = sanPhamDao.getTongSoSanPhamMaDanhMuc(maDanhMuc, maNhom);
			n = n + m;
		}
		return n;
	}
	
	@Override
	public Set<SanPham> getSanPhamTheoNhomSanPham(int trangHienTai,
			int soLuongTrongTrang, int maNhomSP, String[] chuoiNhom) {

		if (chuoiNhom.length == 0) {
			Set<SanPham> sanp = new HashSet<SanPham>();

			trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai,
					soLuongTrongTrang);
			sanp = sanPhamDao.getSanPhamTheoNhomSPham(trangHienTai,
					soLuongTrongTrang, maNhomSP);

			for (SanPham sp : sanp) {
				float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
				sp.setDiemDanhGia(ddg);
			}

			return sanp;
			
		} else {
			Set<SanPham> sanPhamNhom = new HashSet<SanPham>();
			List<SanPham> kt = new ArrayList<SanPham>();
			for (String r : chuoiNhom) {
				int maNhom = Integer.parseInt(r);
				Set<SanPham> rs = new HashSet<SanPham>();
				rs = sanPhamDao.getSanPhamMaNhomSPMaChuoi(maNhomSP, maNhom);
				kt.addAll(rs);
			}
			List<SanPham> sanPhamPhanTrang = new ArrayList<SanPham>();

			int t = getTongSoSanPhamMaNhomSPChuoiNhom(maNhomSP, chuoiNhom);
			sanPhamPhanTrang = Pagination.PhanTrang(trangHienTai,
					soLuongTrongTrang, t, kt);
			sanPhamNhom.addAll(sanPhamPhanTrang);
			return sanPhamNhom;
		}
	}
	
	
	@Override
	public int getTongSoSanPhamMaNhomSP(int maNhomSP) {
		return sanPhamDao.getTongSoSanPhamMaNhomSP(maNhomSP);
	}

	@Override
	public int getTongSoSanPhamMaNhomSPChuoiNhom(int maNhomSP,String[] chuoiNhom) {
		int n = 0;
		for (String r : chuoiNhom) {
			int maNhom = Integer.parseInt(r);
			int m = sanPhamDao.getTongSoSanPhamMaNhomSPChuoiNhom(maNhomSP, maNhom);
			n = n + m;
		}
		return n;
	}
	

	@Override
	public List<SanPham> getSanPhamTimKiem(int trangHienTai,
			int soLuongTrongTrang, String timKiem) {

		trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai,
				soLuongTrongTrang);
		List<SanPham> sanphams = sanPhamDao.getSanPhamTimKiem(trangHienTai,
				soLuongTrongTrang, timKiem);

		for (SanPham sp : sanphams) {
			float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
			sp.setDiemDanhGia(ddg);
		}

		return sanphams;

	}
	

	@Override
	public int getTongSoSanPhamTimKiem(String timKiem) {
		return sanPhamDao.getTongSanPhamTimKiem(timKiem);
	}
	


	@Override
	public SanPham getChiTietSanPham(int maSP) {
		SanPham sp = sanPhamDao.getChiTietSanpham(maSP);
		List<LoaiDa> ld = loaiDaDao.getLoaiDa(maSP);
		List<DanhGiaSanPham> blsp = danhGiaSanPhamDao.getDanhGiaSanPham(maSP);
		sp.setLoaiDas(ld);
		sp.setDanhGiaSanPhams(blsp);

		int maDanhMuc = sanPhamDao.getTimMaDanhMuc(maSP);
		sp.setMaDanhMuc(maDanhMuc);

		float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
		sp.setDiemDanhGia(ddg);

		return sp;

	}
	
	@Override
	public List<SanPham> getDuongDa() {
		return sanPhamDao.getDuongDa();
	}
	
	@Override
	public List<SanPham> getDuyetSanPham(int tinhTrang) {
		// int maDanhMuc = sanPhamDao.getTimMaDanhMuc(maSP);
		// sp.setMaDanhMuc(maDanhMuc);
		return sanPhamDao.getDuyetSanPham(tinhTrang);
	}
	
	@Override
	public boolean getDuyetSanPhamDang(int maSP) {
		return sanPhamDao.getDuyetSanPhamDang(maSP);
	}
	
	@Override
	public boolean getXoaSanPhamDang(int maSP) {
		return sanPhamDao.getXoaSanPhamDang(maSP);
	}
	

	
	@Override
	public List<Hang> getHangYeuThich(int maND) {
		return sanPhamDao.getHangYeuThich(maND);
	}

	@Override
	public List<SanPhamYeuThichNhom> getSanPhamYeuThich(int maND) {
		List<SanPhamYeuThichNhom> spytNhom = new ArrayList<SanPhamYeuThichNhom>();
		List<Hang> hangs = sanPhamDao.getHangYeuThich(maND);
		List<SanPham> sanPhams = sanPhamDao.getSanPhamYeuThich(maND);

		for (Hang ha : hangs) {
			List<SanPham> sanPhamCungHang = sanPhamTheoH(ha.getMaHang(),
					sanPhams);
			SanPhamYeuThichNhom spyt = new SanPhamYeuThichNhom();
			spyt.setHang(ha);
			spyt.setSanPhamList(sanPhamCungHang);
			spytNhom.add(spyt);
		}

		return spytNhom;
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
	public Set<SanPham> getSanPhamTheoNhomSP(int maNSP){
		Set<SanPham> sanp = new HashSet<SanPham>();
		sanp = sanPhamDao.getSanPhamTheoNhomSP(maNSP);
		
		for (SanPham sp : sanp) {
			float ddg = ResourceUtils.quyTron(sp.getDiemDanhGia());
			sp.setDiemDanhGia(ddg);
		}
		return sanp;
	}
	
	
	

	

	
	
	

}
