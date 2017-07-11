package com.danhgiamypham.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.Utilities.PathRsIMG;
import com.danhgiamypham.dao.BinhLuanDao;
import com.danhgiamypham.dao.DanhGiaSanPhamDao;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.BinhLuan;
import com.danhgiamypham.model.PathImage;
import com.danhgiamypham.service.BinhLuanService;

@Service
public class BinhLuanServiceImpl implements BinhLuanService {

	@Autowired
	private BinhLuanDao binhLuanDao;

	@Autowired
	private DanhGiaSanPhamDao danhGiaSanPhamDao;

	@Override
	public ResponseData<Boolean> themBinhLuan(BinhLuan bl,
			List<MultipartFile> multiFile) {
		ResponseData<Boolean> response = null;

		
		if(bl.getMaDanhGia() == 0){
			//them danh gia
			PathImage binhLuanImg = new PathImage();
			String location = binhLuanImg.getBinhLuanIMG();
	
			// them danh gia moi
			response = binhLuanDao.themBinhLuan(bl);
	
			// Lay ma danh gia tu du lieu moi tao
			int maDG = bl.getMaDanhGia();
	
			
			// Them hinh anh
			for (int i = 0; i < multiFile.size(); i++) {
				String pathHinh = PathRsIMG.ghiFile(multiFile.get(i), location);
				binhLuanDao.themHinhAnhBinhLuan(maDG, pathHinh);
			}
	
			return response;
		} else {
			//sua danh gia
			response = binhLuanDao.updateBinhLuan(bl);

			
			//update danh gia
			
			//xoa hinh anh
			
			//them hinh anh moi
			return response;
		}
	}

	@Override
	public ResponseData<Boolean> themLike(int mdg, int slt, String aClass, int maND, int maNDG) {
		int dLike;
		int like;
		// khong thich thi cot la 1, thich cot la 0
		if (aClass.equals("thich")) {
			dLike = 0;
			like = 1;
		} else {
			dLike = 1;
			like = -1;
		}
		
		ResponseData<Boolean> response = binhLuanDao.themLike(mdg, slt, dLike, maND, maNDG);

		return response;
	}

	public ResponseData<Boolean> kiemTraBinhLuan(int mnd, int msp) {
		ResponseData<Boolean> response = binhLuanDao.kiemTraBinhLuan(mnd, msp);
		return response;
	}



}
