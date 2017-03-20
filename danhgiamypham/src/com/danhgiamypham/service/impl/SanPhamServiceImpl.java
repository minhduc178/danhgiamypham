package com.danhgiamypham.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Set<SanPham> getSanPham(int trangHienTai, int soLuongTrongTrang) {
		
		trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai, soLuongTrongTrang);
		Set<SanPham> sanphams = sanPhamDao.getSanPham(trangHienTai, soLuongTrongTrang);
		

		for (SanPham sp : sanphams) {
			float ddg = quyTron(sp.getDiemDanhGia());
			sp.setDiemDanhGia(ddg);
		}

		return sanphams;

	}

	public static float quyTron(float n) {
		int a = (int) n;
		float x = n - a;
		if (x < 0.29) {
			float l = Math.round(n);
			n = l;
		} else if (x < 0.49) {
			float m = Math.round(n) + 0.5f;
			n = m;
		} else if (x < 0.69) {
			float t = Math.round(n) - 0.5f;
			n = t;
		} else if (x < 1) {
			float z = Math.round(n);
			n = z;
		}
		return n;
	}
	
	
	@Override
	public List<SanPham> getSanPhamTimKiem(int trangHienTai, int soLuongTrongTrang, String timKiem){
		
		trangHienTai = ResourceUtils.tinhTrangHienTai(trangHienTai, soLuongTrongTrang);
		List<SanPham> sanphams = sanPhamDao.getSanPhamTimKiem(trangHienTai, soLuongTrongTrang, timKiem);		

		for (SanPham sp : sanphams) {
			float ddg = quyTron(sp.getDiemDanhGia());
			sp.setDiemDanhGia(ddg);
		}

		return sanphams;

	}

	
	@Override
	public int getTongSoSanPham(){
		return  sanPhamDao.getTongSanPham();
	}
	
	@Override
	public int getTongSoSanPhamTimKiem(String timKiem){
		return  sanPhamDao.getTongSanPhamTimKiem(timKiem);
	}
	
	@Override
	public int getTongSoSanPhamMaDanhMuc(int maDanhMuc){
		return  sanPhamDao.getTongSoSanPhamMaDanhMuc(maDanhMuc);
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
		

		float ddg = quyTron(sp.getDiemDanhGia());
		sp.setDiemDanhGia(ddg);

		return sp;

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
	public Set<SanPham> locSanPham(String chuoiMN) {
		Set<SanPham> SanPhamNhom = new HashSet<SanPham>();
		String result[] = chuoiMN.split(" ");
		for (String r : result) {
			int k = Integer.parseInt(r);
			SanPhamNhom = danhMucDao.getSanPhamTheoNhomSP(k);
		}
		return SanPhamNhom;

	}

	@Override
	public Set<SanPham> locSanPhamTheoNhom(String[] chuoiMN) {
		int indexPage = 0;
		int maxItem = 0;
		Set<SanPham> sanPhamNhom = new HashSet<SanPham>();
		//String result[] = chuoiMN.split(" ");
		
		if (chuoiMN.length == 0) {	
			sanPhamNhom = sanPhamDao.getSanPham(indexPage, maxItem);
		} else
		for (String r : chuoiMN) {
			int k = Integer.parseInt(r);

			Set<SanPham> rs = new HashSet<SanPham>();
			rs = danhMucDao.getSanPhamTheoNhomSP(k);
			sanPhamNhom.addAll(rs);
		}

		return sanPhamNhom;
	}
	
	@Override
	public List<SanPham> getDuyetSanPham(int tinhTrang){
//		int maDanhMuc = sanPhamDao.getTimMaDanhMuc(maSP);
//		sp.setMaDanhMuc(maDanhMuc);
		return sanPhamDao.getDuyetSanPham(tinhTrang);	
	}
	

	@Override
	public boolean getDuyetSanPhamDang(int maSP){
		return sanPhamDao.getDuyetSanPhamDang(maSP);	
	}
	
	@Override
	public boolean getXoaSanPhamDang(int maSP){
		return sanPhamDao.getXoaSanPhamDang(maSP);	
	}


}
