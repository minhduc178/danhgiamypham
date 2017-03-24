package com.danhgiamypham.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.model.BinhLuan;

public interface BinhLuanService {
	public boolean themBinhLuan(BinhLuan bl, List<MultipartFile> multiFile);
	public boolean themLike(int mdg, int slt, String aClass);
	public boolean kiemTraBinhLuan(int mnd, int msp);
}



