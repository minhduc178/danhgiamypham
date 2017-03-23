package com.danhgiamypham.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.dao.DanhMucDao;
import com.danhgiamypham.dto.DanhMucNhom;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.model.NhomSanPham;
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
	public boolean themNhomSanPham(int MaDanhMuc, String TenNhomSanPham) {
		return danhMucDao.themNhomSanPham(MaDanhMuc, TenNhomSanPham);
	}

	@Override
	public List<Hang> getHang() {
		return danhMucDao.getHang();
	}

	@Override
	public List<NhomHang> getNhomHang() {
		return danhMucDao.getNhomHang();
	}

	@Override
	public boolean themHang(String tenHang) {
		int maNhomSanPham = timMaNhomHang(tenHang);
		return danhMucDao.themHang(tenHang, maNhomSanPham);
	}

	@Override
	public List<Hang> getHangTheoNhom(int maNhomHang) {
		return danhMucDao.getHangTheoNhom(maNhomHang);
	}

	@Override
	public List<DanhMucNhom> getDanhMucNhom() {
		List<DanhMucNhom> danhMucNhom = new ArrayList<DanhMucNhom>();
		List<DanhMuc> danhMucs = danhMucDao.getAll();
		List<NhomSanPham> nhomSanPhams = danhMucDao.getNhomSanPham();

		for (int i = 0; i < 4; i++) {
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

	private int timMaNhomHang(String tenHang) {
		List<NhomHang> nhomHangs = danhMucDao.getNhomHang();
		String kyTu = Character.toString(tenHang.charAt(0));
		kyTu = kyTu.toUpperCase();
		for (NhomHang nh : nhomHangs) {
			if (kyTu.equals(nh.getTenNhomHang())) {
				return nh.getMaNhomHang();
			}
		}
		return -1;
	}

}
