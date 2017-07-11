package com.danhgiamypham.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.BinhLuan;

public interface BinhLuanService {
	public ResponseData<Boolean> themBinhLuan(BinhLuan bl, List<MultipartFile> multiFile);
	public ResponseData<Boolean> themLike(int mdg, int slt, String aClass, int maND, int maNDG);
	public ResponseData<Boolean> kiemTraBinhLuan(int mnd, int msp);
}



