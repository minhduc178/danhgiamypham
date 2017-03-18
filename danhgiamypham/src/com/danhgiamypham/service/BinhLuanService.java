package com.danhgiamypham.service;

import org.springframework.web.multipart.MultipartFile;
import com.danhgiamypham.model.BinhLuan;

public interface BinhLuanService {
	public boolean themBinhLuan(BinhLuan bl, MultipartFile multiFile);
	public boolean themLike(int mdg, int slt, String aClass);
	public boolean kiemTraBinhLuan(int mnd, int msp);
}



