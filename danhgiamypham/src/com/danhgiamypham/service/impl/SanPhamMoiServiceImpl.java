package com.danhgiamypham.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dao.SanPhamMoiDao;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPhamMoi;
import com.danhgiamypham.service.SanPhamMoiService;

@Service
public class SanPhamMoiServiceImpl implements SanPhamMoiService {

	@Autowired
	private SanPhamMoiDao sanPhamMoiDao;

	@Override
	public List<Hang> getHang() {
		return sanPhamMoiDao.getHang();
	}
	
	@Override
	public List<NhomSanPham> getNhomSanPhamTheoDanhMuc(int MaDanhMuc){
		return sanPhamMoiDao.getNhomSanPhamTheoDanhMuc(MaDanhMuc);
	}
	
	@Override
	public List<NhomSanPham> getNhomSPTheoSP(int maSP, int MaDanhMuc ){
		List<NhomSanPham> nsptheoSP = sanPhamMoiDao.getNhomSanPhamTheoSP(maSP, MaDanhMuc);
		List<NhomSanPham> nsptheoDanhMuc = sanPhamMoiDao.getNhomSanPhamTheoDanhMuc(MaDanhMuc);
			
			for(int i=0; i<nsptheoSP.size(); i++){
				for(int j=0; j<nsptheoDanhMuc.size(); j++){
					if(nsptheoSP.get(i).getMaNhomSanPham() == nsptheoDanhMuc.get(j).getMaNhomSanPham()){
						nsptheoDanhMuc.get(j).setValueCheck(true);
					} 
					
				}
			}
		
		return nsptheoDanhMuc;
	}
	
	
	@Override
	public boolean them(SanPhamMoi spm, List<MultipartFile> multiFile){
		int maSP = spm.getMaSanPham();
		
		//them san pham moi
		sanPhamMoiDao.themSanPham(spm);
		
		//them nhom cho san pham
		String[] chuoiNhoms = spm.getListMaNhomSP();
		for(String maNhomSP: chuoiNhoms){
			int maNhom = Integer.parseInt(maNhomSP);
			sanPhamMoiDao.themNhomSanPhamMoi(maSP, maNhom);
		}

		//them ten hinh anh vao mysql
//		for(int i=0; i<spm.getListMaNhomSP.; i++){
//			
//		}
		
		//them hinh anh vao server
		for(MultipartFile file:multiFile){
			ResourceUtils.ghiFile(file);
		}
	
		
		return true;
	}
	
	@Override
	public boolean capnhat(SanPhamMoi spm, MultipartFile multiFile){
//		ResourceUtils ut = new ResourceUtils();
//		String filePath = ut.ghiFile(multiFile) ;
//		sanPhamMoiDao.capnhatSanPham(spm);
//		
//		int maSP = spm.getMaSanPham();
		
//	String path = "sanpham";
//		sanPhamMoiDao.capnhatHinhAnh(maSP, path + File.separator );
//		ResourceUtils.ghiFile(path, hinhAnhChinh, multiFile);
		
		return true;
	}
	
	
	
	
	
	
}
