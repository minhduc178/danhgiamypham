package com.danhgiamypham.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;
import com.danhgiamypham.model.SanPhamMoi;

public interface SanPhamMoiService {
	public  ResponseData<List<Hang>> getHang();
	public  ResponseData<List<NhomSanPham>> getNhomSanPhamTheoDanhMuc(int mdm);
	public  ResponseData<List<NhomSanPham>> getNhomSPTheoSP(String link, int mdm);
	public  ResponseData<Boolean> them(SanPhamMoi spm, List<MultipartFile> multiFile);
	public  ResponseData<Boolean> capNhat(SanPham spm, List<MultipartFile> multiFile);

}
