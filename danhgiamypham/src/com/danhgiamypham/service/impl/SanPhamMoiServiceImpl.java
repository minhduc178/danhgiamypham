package com.danhgiamypham.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

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
	public boolean them(SanPhamMoi spm, String fileName, MultipartFile multiFile){
		sanPhamMoiDao.themSanPham(spm);
		
		int maSP = spm.getMaSanPham();
		
		String path = "sanpham";
		String hinhAnhChinh = maSP + "_" + fileName;
		sanPhamMoiDao.themHinhAnh(maSP, path + File.separator + hinhAnhChinh);
		ResourceUtils.ghiFileHA(path, hinhAnhChinh, multiFile);
		
		int maNhomBoPhan = spm.getMaboPhan();
		sanPhamMoiDao.themSanPhamNhomSanPham(maSP, maNhomBoPhan);
		
		String maNhom = spm.getMaNhom();
		String result[] = maNhom.split("\\+");
		System.out.println(result.length);
		if(result.length>1){
			for (int r=1; r< result.length;r++){
				int k = Integer.parseInt(result[r]);
				sanPhamMoiDao.themSanPhamNhomSanPham(maSP, k);
			}	
		}
		return true;
	}
	
	@Override
	public boolean capnhat(SanPhamMoi spm, MultipartFile multiFile){
		ResourceUtils ut = new ResourceUtils();
		String filePath = ut.ghiFile(multiFile) ;
//		sanPhamMoiDao.capnhatSanPham(spm);
//		
//		int maSP = spm.getMaSanPham();
//		
//		String path = "sanpham";
//		sanPhamMoiDao.capnhatHinhAnh(maSP, path + File.separator + hinhAnhChinh);
//		ResourceUtils.ghiFile(path, hinhAnhChinh, multiFile);
//		
//		int maNhomBoPhan = spm.getMaboPhan();
//		//sanPhamMoiDao.capnhatSanPhamNhomSanPham(maSP, maNhomBoPhan);
//		
//		String maNhom = spm.getMaNhom();
//		String result[] = maNhom.split("\\+");
//		System.out.println(result.length);
//		if(result.length>1){
//			for (int r=1; r< result.length;r++){
//				int k = Integer.parseInt(result[r]);
//				System.out.println(k);
//		//		sanPhamMoiDao.capnhatSanPhamNhomSanPham(maSP, k);
//			}	
//		}
		return true;
	}
	
	
	
	
	
	
}
