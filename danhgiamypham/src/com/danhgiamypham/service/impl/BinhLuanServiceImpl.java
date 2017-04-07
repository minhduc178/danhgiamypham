package com.danhgiamypham.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dao.BinhLuanDao;
import com.danhgiamypham.model.BinhLuan;
import com.danhgiamypham.service.BinhLuanService;

@Service
public class BinhLuanServiceImpl implements BinhLuanService {

	@Autowired
	private BinhLuanDao binhLuanDao;

	@Override
	public boolean themBinhLuan(BinhLuan bl, List<MultipartFile> multiFile) {
		//save image;
//		ResourceUtils ut =  new ResourceUtils();
//		for(MultipartFile file:multiFile ){
//			List<String> huhu = 
			//String hinhAnh = ut.ghiFile(file);
		//	System.out.print(file);
			
	//	}
//		if (!hinhAnh.equals("")) {
//			bl.setHinhAnh(hinhAnh);
//		}
		
		//successed;
		//
		return binhLuanDao.themBinhLuan(bl);
	}


	@Override
	public boolean themLike(int mdg, int slt, String aClass) {
		String tTrangLike;
		if(aClass.equals("thich")){
			tTrangLike="Thích";
		} else {
			tTrangLike="Không Thích";
		}
		return binhLuanDao.themLike(mdg, slt, aClass, tTrangLike);
	}
	
	public boolean kiemTraBinhLuan(int mnd, int msp){
		return binhLuanDao.kiemTraBinhLuan(mnd, msp);
	}

}
