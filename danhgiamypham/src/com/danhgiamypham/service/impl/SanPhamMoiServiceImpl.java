package com.danhgiamypham.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.danhgiamypham.Utilities.PathRsIMG;
import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dao.SanPhamMoiDao;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.HinhAnhSanPham;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.PathImage;
import com.danhgiamypham.model.SanPham;
import com.danhgiamypham.model.SanPhamMoi;
import com.danhgiamypham.service.SanPhamMoiService;

@Service
public class SanPhamMoiServiceImpl implements SanPhamMoiService {

	@Autowired
	private SanPhamMoiDao sanPhamMoiDao;

	@Override
	public ResponseData<List<Hang>> getHang() {
		return sanPhamMoiDao.getHang();
	}

	@Override
	public ResponseData<List<NhomSanPham>> getNhomSanPhamTheoDanhMuc(
			int MaDanhMuc) {
		return sanPhamMoiDao.getNhomSanPhamTheoDanhMuc(MaDanhMuc);
	}

	@Override
	public ResponseData<List<NhomSanPham>> getNhomSPTheoSP(String link,
			int MaDanhMuc) {
		ResponseData<List<NhomSanPham>> response = new ResponseData<List<NhomSanPham>>();

		ResponseData<List<NhomSanPham>> nsptheoSP = sanPhamMoiDao
				.getNhomSanPhamTheoSP(link, MaDanhMuc);
		ResponseData<List<NhomSanPham>> nsptheoDanhMuc = sanPhamMoiDao
				.getNhomSanPhamTheoDanhMuc(MaDanhMuc);
		List<NhomSanPham> nsptheoSPnew = nsptheoSP.getData();
		List<NhomSanPham> nsptheoDanhMucnew = nsptheoDanhMuc.getData();

		for (int i = 0; i < nsptheoSPnew.size(); i++) {
			for (int j = 0; j < nsptheoDanhMucnew.size(); j++) {
				if (nsptheoSPnew.get(i).getMaNhomSanPham() == nsptheoDanhMucnew
						.get(j).getMaNhomSanPham()) {
					nsptheoDanhMucnew.get(j).setValueCheck(true);
				}
			}
		}
		response.setData(nsptheoDanhMucnew);
		return response;
	}

	@Override
	public ResponseData<Boolean> them(SanPhamMoi spm,
			List<MultipartFile> multiFile) {

		PathImage sanPhamImg = new PathImage();
		String location = sanPhamImg.getSanPhamIMG();
		
		
		//them link
		String link = ResourceUtils.unAccent(spm.getTenSanPham());
		spm.setLink(link);
		
		// them san pham moi
		sanPhamMoiDao.themSanPham(spm);

		// Lay ma san pham tu du lieu moi tao
		int maSP = spm.getMaSanPham();

		// them nhom cho san pham
		if (spm.getListMaNhomSP() != null) {
			String[] chuoiNhoms = spm.getListMaNhomSP();
			for (String maNhomSP : chuoiNhoms) {
				int maNhom = Integer.parseInt(maNhomSP);
				sanPhamMoiDao.themNhomSanPhamMoi(maSP, maNhom);
			}
		}

		// Them hinh anh
		HinhAnhSanPham hasp = new HinhAnhSanPham();
		hasp.setMaSanPham(maSP);
		for (int i = 0; i < multiFile.size(); i++) {
			String pathHinh = PathRsIMG.ghiFile(multiFile.get(i), location);
			if (i == 0) {
				hasp.setHinhAnhChinh(pathHinh);
			} else if (i == 1) {
				hasp.setHinh1(pathHinh);
			} else if (i == 2) {
				hasp.setHinh2(pathHinh);
			} else if (i == 3) {
				hasp.setHinh3(pathHinh);
			} else if (i == 4) {
				hasp.setHinh4(pathHinh);
			}
		}
		return sanPhamMoiDao.themHinhAnhMoi(hasp);
	}

	@Override
	public ResponseData<Boolean> capNhat(SanPham spm,
			List<MultipartFile> multiFile) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();

		PathImage sanPhamImg = new PathImage();
		String location = sanPhamImg.getSanPhamIMG();

		int maSP = spm.getMaSanPham();

		// cap nhat san pham moi
		sanPhamMoiDao.capNhatSanPham(spm);

		// xoa nhom san pham theo ma san pham
		sanPhamMoiDao.xoaNhomSanPham(maSP);

		// cap nhat nhom cho san pham
		if (spm.getListMaNhomSPham() != null) {
			String[] chuoiNhoms = spm.getListMaNhomSPham();
			for (String maNhomSP : chuoiNhoms) {
				int maNhom = Integer.parseInt(maNhomSP);
				sanPhamMoiDao.capNhatNhomSanPham(maSP, maNhom);
			}
		}

		if (multiFile.size() > 0) {
			// xoa hinh anh trong mysql
			sanPhamMoiDao.xoaHinhAnhSanPham(maSP);

			// Xoa hinh anh trong server:
			xoaHinhAnhSanPham(spm, location);

			// them hinh anh trong mysql va server
			HinhAnhSanPham hasp = new HinhAnhSanPham();
			hasp.setMaSanPham(maSP);
			for (int i = 0; i < multiFile.size(); i++) {
				String pathHinh = PathRsIMG.ghiFile(multiFile.get(i), location);
				if (i == 0) {
					hasp.setHinhAnhChinh(pathHinh);
				} else if (i == 1) {
					hasp.setHinh1(pathHinh);
				} else if (i == 2) {
					hasp.setHinh2(pathHinh);
				} else if (i == 3) {
					hasp.setHinh3(pathHinh);
				} else if (i == 4) {
					hasp.setHinh4(pathHinh);
				}
			}
			response = sanPhamMoiDao.capNhatHinhAnh(maSP, hasp);
		}
		return response;
	}

	public boolean xoaHinhAnhSanPham(SanPham sanPham, String location) {
		List<String> tenHinh = new ArrayList<String>();
		tenHinh.add(sanPham.getHinh1());
		tenHinh.add(sanPham.getHinh2());
		tenHinh.add(sanPham.getHinh3());
		tenHinh.add(sanPham.getHinh4());
		tenHinh.add(sanPham.getHinhAnhChinh());

		for (String hinhAnh : tenHinh) {

			String duongdan = PathRsIMG.pathHinh(location) + hinhAnh;

			try {
				File file = new File(duongdan);
				file.delete();

				if (file.delete()) {
					System.out.println(file.getName() + " is deleted!");
				} else {
					System.out.println("Delete operation is failed.");
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return true;
	}

}
