package com.danhgiamypham.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dao.BinhLuanDao;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.BinhLuan;
import com.danhgiamypham.model.User;
import com.danhgiamypham.service.BinhLuanService;

@Service
public class BinhLuanServiceImpl implements BinhLuanService {

	@Autowired
	private BinhLuanDao binhLuanDao;

	@Override
	public ResponseData<Boolean> themBinhLuan(BinhLuan bl, List<MultipartFile> multiFile) {

		ResponseData<Boolean> response =  binhLuanDao.themBinhLuan(bl);
		return response;
	}


	@Override
	public ResponseData<Boolean> themLike(int mdg, int slt, String aClass) {
		String tTrangLike;
		if(aClass.equals("thich")){
			tTrangLike="Thích";
		} else {
			tTrangLike="Không Thích";
		}
		ResponseData<Boolean> response =  binhLuanDao.themLike(mdg, slt, aClass, tTrangLike);
		return response;
	}
	
	public ResponseData<Boolean> kiemTraBinhLuan(int mnd, int msp){
		ResponseData<Boolean> response =  binhLuanDao.kiemTraBinhLuan(mnd, msp);
		return response;
	}

}
