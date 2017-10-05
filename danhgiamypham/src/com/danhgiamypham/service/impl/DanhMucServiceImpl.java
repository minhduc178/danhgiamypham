package com.danhgiamypham.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dao.DanhMucDao;
import com.danhgiamypham.dto.DanhMucNhom;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.service.DanhMucService;

@Service
public class DanhMucServiceImpl implements DanhMucService {

	Logger logger = Logger.getLogger(DanhMucServiceImpl.class.getName());
	
	@Autowired
	private DanhMucDao danhMucDao;

	@Override
	public ResponseData<List<DanhMuc>> getAll() {
		return danhMucDao.getAll();
	}

	@Override
	public ResponseData<List<NhomSanPham>> getNhomSanPham() {
		return danhMucDao.getNhomSanPham();
	}

	@Override
	public ResponseData<Boolean> themNhomSanPham(int MaDanhMuc, String TenNhomSanPham) {
		return danhMucDao.themNhomSanPham(MaDanhMuc, TenNhomSanPham);
	}

	@Override
	public ResponseData<List<Hang>> getHang() {
		return danhMucDao.getHang();
	}

	@Override
	public ResponseData<List<NhomHang>> getNhomHang() {
		return danhMucDao.getNhomHang();
	}

	@Override
	public ResponseData<Boolean> themHang(String tenHang, int maND) {
		int maNhomSanPham = timMaNhomHang(tenHang);
		//them link
		String link = ResourceUtils.unAccent(tenHang);

		return danhMucDao.themHang(tenHang, maNhomSanPham, link, maND);
	}

	@Override
	public ResponseData<List<Hang>> getHangTheoNhom(int maNhomHang) {
		return danhMucDao.getHangTheoNhom(maNhomHang);
	}
	

	@Override
	public ResponseData<List<DanhMucNhom>> getDanhMucNhom() {
		ResponseData<List<DanhMucNhom>> response = new ResponseData<List<DanhMucNhom>>();
		
		List<DanhMucNhom> danhMucNhom = new ArrayList<DanhMucNhom>();
		
		ResponseData<List<DanhMuc>> danhMucs = danhMucDao.getAll();
		ResponseData<List<NhomSanPham>> nhomSanPhamList = danhMucDao.getNhomSanPham();
		List<NhomSanPham> nhomSanPhams = nhomSanPhamList.getData();
		
		for (int i = 0; i < 4; i++) {
			DanhMuc dm = danhMucs.getData().get(i);
			List<NhomSanPham> sanPhamCungDanhMuc = nhomSanPhamTheoDM(dm.getMaDanhMuc(), nhomSanPhams);

			DanhMucNhom dmn = new DanhMucNhom();
			dmn.setDanhMuc(dm);
			dmn.setNhomSanPham(sanPhamCungDanhMuc);
			danhMucNhom.add(dmn);
		}
		response.setData(danhMucNhom);
		return response;
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
		System.out.print(tenHang);
		ResponseData<List<NhomHang>> nhomHangs = danhMucDao.getNhomHang();
		List<NhomHang> nhomHangList = nhomHangs.getData();
		String kyTu = Character.toString(tenHang.charAt(0));
		kyTu = kyTu.toUpperCase();
		for (NhomHang nh : nhomHangList) {
			if (kyTu.equals(nh.getTenNhomHang())) {
				return nh.getMaNhomHang();
			} 
		}
		return 91;
	}
	
	public ResponseData<List<Hang>> getHangDaThem(){
		return danhMucDao.getHangDaThem();
	}


}
