package com.danhgiamypham.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPhamMoi;

public interface SanPhamMoiService {
	public List<Hang> getHang();
	public List<NhomSanPham> getNhomSanPhamTheoDanhMuc(int mdm);
	public boolean them(SanPhamMoi spm, String fileName, MultipartFile multiFile);
	public boolean capnhat(SanPhamMoi spm, MultipartFile multiFile);
	public List<NhomSanPham> getNhomSPTheoSP(int maSP, int mdm);

}
