package com.danhgiamypham.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.dao.HangDao;
import com.danhgiamypham.dto.HangNhom;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.service.HangService;

@Service
public class HangServiceImpl implements HangService {

	@Autowired
	private HangDao hangDao;

	@Override
	public List<Hang> getHang() {
		return hangDao.getHang();
	}

	@Override
	public List<NhomHang> getNhomHang() {
		return hangDao.getNhomHang();
	}

	@Override
	public List<HangNhom> getHangNhom() {
		List<HangNhom> hangNhom = new ArrayList<HangNhom>();
		List<NhomHang> nhomHangs = hangDao.getNhomHang();
		List<Hang> hangs = hangDao.getHang();

		for (NhomHang ha : nhomHangs) {
			List<Hang> hangCungDanhMuc = hangTheoDM(ha.getMaNhomHang(), hangs);
			HangNhom hn = new HangNhom();
			hn.setNhomHang(ha);
			hn.setHang(hangCungDanhMuc);
			hangNhom.add(hn);

		}
		return hangNhom;
	}

	private List<Hang> hangTheoDM(int maNH, List<Hang> hangs) {
		List<Hang> hang = new ArrayList<Hang>();
		for (Hang ha : hangs) {
			if (ha.getMaNhomHang() == maNH) {
				hang.add(ha);
			}
		}
		return hang;
	}

}
