package com.danhgiamypham.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.dao.DanhMucDao;
import com.danhgiamypham.dto.DanhMucNhom;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;
import com.danhgiamypham.service.DanhMucService;

@Service
public class DanhMucServiceImpl implements DanhMucService {

	@Autowired
	private DanhMucDao danhMucDao;

	@Override
	public List<DanhMuc> getAll() {
		return danhMucDao.getAll();
	}

	@Override
	public List<NhomSanPham> getNhomSanPham() {
		return danhMucDao.getNhomSanPham();
	}

	@Override
	public List<DanhMucNhom> getDanhMucNhom() {
		List<DanhMucNhom> danhMucNhom = new ArrayList<DanhMucNhom>();
		List<DanhMuc> danhMucs = danhMucDao.getAll();
		List<NhomSanPham> nhomSanPhams = danhMucDao.getNhomSanPham();

		for (int i=0; i<4; i++) {
			DanhMuc dm = danhMucs.get(i);
			List<NhomSanPham> sanPhamCungDanhMuc = nhomSanPhamTheoDM(
					dm.getMaDanhMuc(), nhomSanPhams);

			DanhMucNhom dmn = new DanhMucNhom();
			dmn.setDanhMuc(dm);
			dmn.setNhomSanPham(sanPhamCungDanhMuc);
			danhMucNhom.add(dmn);
		}

		return danhMucNhom;
	}

	private List<NhomSanPham> nhomSanPhamTheoDM(int maDM,
			List<NhomSanPham> nhomSanPhams) {
		List<NhomSanPham> nhomSP = new ArrayList<NhomSanPham>();
		for (NhomSanPham nsp : nhomSanPhams) {
			if (nsp.getMaDanhMuc() == maDM) {
				nhomSP.add(nsp);
			}
		}
		return nhomSP;
	}
	
	@Override
	public Set<SanPham> getSanPhamTheoNhomSP(int maNSP){
		Set<SanPham> sanp = new HashSet<SanPham>();
		sanp = danhMucDao.getSanPhamTheoNhomSP(maNSP);
		
		for (SanPham sp : sanp) {
			float ddg = SanPhamServiceImpl.quyTron(sp.getDiemDanhGia());
			sp.setDiemDanhGia(ddg);
		}
		
		return sanp;
	}
	
	@Override
	public List<SanPham> getSanPhamTheoDanhMuc(int maDM){
		List<SanPham> sanp = new ArrayList<SanPham>();
		sanp = danhMucDao.getSanPhamTheoDanhMuc(maDM);
		
		for (SanPham sp : sanp) {
			float ddg = SanPhamServiceImpl.quyTron(sp.getDiemDanhGia());
			sp.setDiemDanhGia(ddg);
		}
		
		return sanp;
	}
	
	@Override
	public List<SanPham> getDuongDa() {
		return danhMucDao.getDuongDa();
	}

	@Override 
	public boolean  themNhomSanPham(int MaDanhMuc, String TenNhomSanPham){
		return danhMucDao.themNhomSanPham(MaDanhMuc, TenNhomSanPham);
	}


}
