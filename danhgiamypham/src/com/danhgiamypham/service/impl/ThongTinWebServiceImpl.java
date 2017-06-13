package com.danhgiamypham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhgiamypham.dao.ThongTinWebDao;
import com.danhgiamypham.model.SoSanPhamThem;
import com.danhgiamypham.service.ThongTinWebService;

@Service
public class ThongTinWebServiceImpl implements ThongTinWebService {

	@Autowired
	private ThongTinWebDao thongTinWebDao;

	@Override
	public SoSanPhamThem soSanPham() {
		SoSanPhamThem spt = thongTinWebDao.soSanPham();
		return spt;
	}

	


}
