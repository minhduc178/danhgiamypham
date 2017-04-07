package com.danhgiamypham.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dao.SanPhamMoiDao;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.HinhAnhSanPham;
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
	public  boolean them(SanPhamMoi spm, List<MultipartFile> multiFile){
		//them san pham moi
		sanPhamMoiDao.themSanPham(spm);
		
		//Lay ma san pham tu du lieu moi tao
		int maSP = spm.getMaSanPham();

		//them nhom cho san pham
		if(spm.getListMaNhomSP() != null){
			String[] chuoiNhoms = spm.getListMaNhomSP();
			for(String maNhomSP: chuoiNhoms){
				int maNhom = Integer.parseInt(maNhomSP);
				sanPhamMoiDao.themNhomSanPhamMoi(maSP, maNhom);
			}
		}
				
		//Them hinh anh 
		HinhAnhSanPham hasp = new HinhAnhSanPham();
		hasp.setMaSanPham(maSP);
		for(int i=0; i<multiFile.size(); i++){
			String pathHinh = ResourceUtils.ghiFile(multiFile.get(i));
			if(i == 0){
				hasp.setHinhAnhChinh(pathHinh);
			} else if(i == 1){
				hasp.setHinh1(pathHinh);	
			}else if(i == 2){
				hasp.setHinh2(pathHinh);	
			} else if(i == 3){
				hasp.setHinh3(pathHinh);	
			} else if(i == 4){
				hasp.setHinh4(pathHinh);	
			}
			
			
		}
		
		return sanPhamMoiDao.themHinhAnhMoi(hasp);
	}
	
	@Override
	public boolean capnhat(SanPhamMoi spm, List<MultipartFile> multiFile){
//		ResourceUtils ut = new ResourceUtils();
//		String filePath = ut.ghiFile(multiFile) ;
//		sanPhamMoiDao.capnhatSanPham(spm);
//		
//		int maSP = spm.getMaSanPham();
		
//	String path = "sanpham";
//		sanPhamMoiDao.capnhatHinhAnh(maSP, path + File.separator );
//		ResourceUtils.ghiFile(path, hinhAnhChinh, multiFile);
//		
//		//them san pham moi
//		sanPhamMoiDao.themSanPham(spm);
//		
//		//Lay ma san pham tu du lieu moi tao
//		int maSP = spm.getMaSanPham();
//
//		//them nhom cho san pham
//		String[] chuoiNhoms = spm.getListMaNhomSP();
//		for(String maNhomSP: chuoiNhoms){
//			int maNhom = Integer.parseInt(maNhomSP);
//			sanPhamMoiDao.themNhomSanPhamMoi(maSP, maNhom);
//		}
//				
//		//Them hinh anh 
//		HinhAnhSanPham hasp = new HinhAnhSanPham();
//		hasp.setMaSanPham(maSP);
//		for(int i=0; i<multiFile.size(); i++){
//			String pathHinh = ResourceUtils.ghiFile(multiFile.get(i));
//			if(i == 0){
//				hasp.setHinhAnhChinh(pathHinh);
//			} else if(i == 1){
//				hasp.setHinh1(pathHinh);	
//			}else if(i == 2){
//				hasp.setHinh2(pathHinh);	
//			} else if(i == 3){
//				hasp.setHinh3(pathHinh);	
//			} else if(i == 4){
//				hasp.setHinh4(pathHinh);	
//			}
//		}
//		
//		return sanPhamMoiDao.themHinhAnhMoi(hasp);
		
		
		return true;
	}
	
	
	
	
	
	
}
