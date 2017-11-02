package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.Utilities.ResourceUtils;
import com.danhgiamypham.dao.SanPhamDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.SanPham;
import com.danhgiamypham.model.SanPhamMoi;

@Component
public class SanPhamDaoImpl implements SanPhamDao {

	// Thay vi tao moi dbProvider thi khai bao trong danhgiamypham-servlet:
	// id.....
	@Autowired
	private DBProvider dbProvider;

	@Override
	public ResponseData<Set<SanPham>> getTenSanPham() {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		Set<SanPham> sanPhams = new HashSet<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getTenSanPham()}";
			PreparedStatement st = cnn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");

				SanPham sp = new SanPham(maSP, tenSP);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTenSanPham bi loi");
		}
		return response;

	}
	
	@Override
	public ResponseData<Set<SanPham>> getSanPham(int trangHienTai,
			int soLuongTrongTrang) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		Set<SanPham> sanPhams = new HashSet<SanPham>();
		List<SanPham> sanPhamds = new ArrayList<SanPham>(); 
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPham(?, ?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, trangHienTai);
			st.setInt(2, soLuongTrongTrang);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				Date ngayD = rs.getDate("NgayDang");
	//			ngayD = ResourceUtils.convertDate(ngayD);
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, ngayD, diemDG,
						soLDG, hinhAC,link);
				sanPhams.add(sp);
				sanPhamds.add(sp);
				System.out.println(sp.getMaSanPham());
			}
			for(SanPham spn: sanPhamds){
				System.out.println(spn.getMaSanPham());
			}
			
			System.out.print("AAAAAAAAA");
			
			for(SanPham spn: sanPhams){
				System.out.println(spn.getMaSanPham());
			}
			
			response.setData(sanPhams);
	
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getSanPham bi loi");
		}
		
	
		return response;

	}

	@Override
	public ResponseData<Set<SanPham>> getSanPhamTheoNhomSP(int maNhomSanPham) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		Set<SanPham> sanPhams = new HashSet<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamTheoNhomSP(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNhomSanPham);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, ngayD, diemDG,
						soLDG, hinhAC, link);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getSanPhamTheoNhomSP bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Integer> getTongSanPham() {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int tongSanPham = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoSanPham()}";
			PreparedStatement st = cnn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("tongsanpham");
			}
			response.setData(tongSanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTongSanPham bi loi");
		}
		return response;
	}

	@Override
	public int getTongSanPhamTheoNhom(int maNhom) {
		int tongSanPham = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoSanPhamTheoNhom(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNhom);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("tongsanpham");
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tongSanPham;
	}

	// getSanPhamTheoDanhMuc-controller
	@Override
	public ResponseData<Set<SanPham>> getSanPhamTheoDanhMuc(int trangHienTai,
			int soLuongTrongTrang, int maDM) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		Set<SanPham> sanPhams = new HashSet<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamTheoDanhMuc(?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, trangHienTai);
			st.setInt(2, soLuongTrongTrang);
			st.setInt(3, maDM);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, ngayD, diemDG,
						soLDG, hinhAC, link);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getSanPhamTheoDanhMuc bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Set<SanPham>> getSanPhamTheoDanhMucMaChuoi(int maDM,
			int nhomChuoi) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		Set<SanPham> sanPhams = new HashSet<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamTheoDanhMucMaChuoi(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDM);
			st.setInt(2, nhomChuoi);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, ngayD, diemDG,
						soLDG, hinhAC,link);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getSanPhamTheoDanhMucMaChuoi bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaDanhMuc(int maDanhMuc) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int tongSanPham = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoLuongMaDanhMuc(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDanhMuc);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("SoLuongTheoDanhMuc");
			}
			response.setData(tongSanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTongSoSanPhamMaDanhMuc bi loi");
		}
		return response;
	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaDanhMuc(int maDanhMuc,
			int maNhom) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int tongSanPham = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoLuongMaDanhMucMaNhom(?, ?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDanhMuc);
			st.setInt(2, maNhom);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("SoLuongTheoDanhMuc");
			}
			response.setData(tongSanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTongSoSanPhamMaDanhMuc bi loi");
		}
		return response;
	}

	// sanphamtheomahang
	@Override
	public List<SanPham> getSanPhamTheoHang(int trangHienTai,
			int soLuongTrongTrang, String linkHang) {
		List<SanPham> sanPhams = new ArrayList<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamTheoHang(?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, trangHienTai);
			st.setInt(2, soLuongTrongTrang);
			st.setString(3, linkHang);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, ngayD, diemDG,
						soLDG, hinhAC,link);
				sanPhams.add(sp);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
//			e.setErrorMessage("getSanPhamTheoHang bi loi");
		}
		return sanPhams;

	}

	@Override
	public ResponseData<Set<SanPham>> getSanPhamTheoHangMaChuoi(String linkHang,
			int nhomChuoi) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		Set<SanPham> sanPhams = new HashSet<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamTheoHangMaChuoi(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, linkHang);
			st.setInt(2, nhomChuoi);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, ngayD, diemDG,
						soLDG, hinhAC, link);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getSanPhamTheoHangMaChuoi bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaHang(String link) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int tongSanPham = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoLuongMaHang(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, link);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("SoLuongTheoHang");
			}
			response.setData(tongSanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTongSoSanPhamMaHang bi loi");
		}
		return response;
	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaHang(String link, int maNhom) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int tongSanPham = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoLuongMaHangMaNhom(?, ?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, link);
			st.setInt(2, maNhom);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("SoLuongTheoHang");
			}
			response.setData(tongSanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTongSoSanPhamMaHang bi loi");
		}
		return response;
	}

	@Override
	public ResponseData<Set<SanPham>> getSanPhamTheoNhomSPham(int trangHienTai,
			int soLuongTrongTrang, int maNhomSanPham) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		Set<SanPham> sanPhams = new HashSet<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamTheoNhomSPham(?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, trangHienTai);
			st.setInt(2, soLuongTrongTrang);
			st.setInt(3, maNhomSanPham);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, ngayD, diemDG,
						soLDG, hinhAC, link);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getSanPhamTheoNhomSPham bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Set<SanPham>> getSanPhamMaNhomSPMaChuoi(
			int maNhomSanPham, int nhomChuoi) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		Set<SanPham> sanPhams = new HashSet<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamMaNhomSPMaChuoi(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNhomSanPham);
			st.setInt(2, nhomChuoi);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, ngayD, diemDG,
						soLDG, hinhAC, link);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getSanPhamMaNhomSPMaChuoi bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaNhomSP(int maNhomSP) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int tongSanPham = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getTongSoSanPhamMaNhomSP(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNhomSP);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("SoLuongTheoNhomSanPham");
			}
			response.setData(tongSanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTongSoSanPhamMaNhomSP bi loi");
		}
		return response;
	}

	@Override
	public ResponseData<Integer> getTongSoSanPhamMaNhomSPChuoiNhom(
			int maNhomSP, int nhomChuoi) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int tongSanPham = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getTongSoSanPhamMaNhomSPChuoiNhom(?, ?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNhomSP);
			st.setInt(2, nhomChuoi);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("SoLuongTheoNhomSanPham");
			}
			response.setData(tongSanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTongSoSanPhamMaNhomSPChuoiNhom bi loi");
		}
		return response;
	}

	@Override
	public ResponseData<Set<SanPham>> getSanPhamTimKiem(int trangHienTai,
			int soLuongTrongTrang, String timKiem) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		Set<SanPham> sanPhams = new HashSet<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamTimKiem(?, ?, ?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, trangHienTai);
			st.setInt(2, soLuongTrongTrang);
			st.setString(3, timKiem);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				int tinhT = rs.getInt("TinhTrang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, tinhT, ngayD,
						diemDG, soLDG, hinhAC, link);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getSanPhamTimKiem bi loi");
		}
		return response;

	}
	
	@Override
	public ResponseData<Set<SanPham>> getSanPhamTimKiemMaChuoi(String timKiem,
			int nhomChuoi) {
		ResponseData<Set<SanPham>> response = new ResponseData<Set<SanPham>>();
		Set<SanPham> sanPhams = new HashSet<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamTimKiemMaChuoi(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, timKiem);
			st.setInt(2, nhomChuoi);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, ngayD, diemDG,
						soLDG, hinhAC, link);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getSanPhamTheoHangMaChuoi bi loi");
		}
		return response;

	}


	@Override
	public ResponseData<Integer> getTongSanPhamTimKiem(String timKiem) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int tongSanPham = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoLuongTimKiem(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, timKiem);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("SoLuongTimKiem");
			}
			response.setData(tongSanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTongSanPhamTimKiem bi loi");
		}
		return response;
	}
	
	@Override
	public ResponseData<Integer> getTongSoSanPhamTimKiemTheoChuoi(String timKiem,int chuoiNhom) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int tongSanPham = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoLuongTimKiemTheoChuoi(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, timKiem);
			st.setInt(2, chuoiNhom);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("SoLuongTimKiem");
			}
			response.setData(tongSanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTongSoSanPhamTimKiemTheoChuoi bi loi");
		}
		return response;
	}

	@Override
	public ResponseData<SanPham> getChiTietSanpham(String link) {
		ResponseData<SanPham> response = new ResponseData<SanPham>();
		SanPham sanPham = null;

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getChiTietSanPham(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, link);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				int maH = rs.getInt("MaHang");
				int maNH = rs.getInt("MaNhomHang");
				String gioiT = rs.getString("GioiThieu");
				String congD = rs.getString("CongDung");
				String cachSD = rs.getString("CachSuDung");
				String thanhP = rs.getString("ThanhPhan");
				String tenND = rs.getString("TenDangNhap");
				int tinhT = rs.getInt("TinhTrang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String hinh1 = rs.getString("Hinh1");
				String hinh2 = rs.getString("Hinh2");
				String hinh3 = rs.getString("Hinh3");
				String hinh4 = rs.getString("Hinh4");
				link = rs.getString("Link");
				int luotBinhLuan = rs.getInt("SoLuotDanhGia");
				int luotThich = rs.getInt("LuotThich");
				String linkH = rs.getString("LinkHang");

				sanPham = new SanPham(maSP, tenSP, tenH, maH, maNH, gioiT, congD, cachSD,
						thanhP, tenND, tinhT, ngayD, diemDG, hinhAC, hinh1,
						hinh2, hinh3, hinh4, link, luotBinhLuan, luotThich, linkH);
			}
			response.setData(sanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getChiTietSanpham bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<List<SanPham>> getSanPhamYeuThich(int maNguoiDung) {
		ResponseData<List<SanPham>> response = new ResponseData<List<SanPham>>();
		List<SanPham> sanPhamYeuThichs = new ArrayList<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamYeuThich(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNguoiDung);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maND = rs.getInt("MaNguoiDung");
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				int diemDG = rs.getInt("DiemDanhGia");
				String ghiC = rs.getString("GhiChu");
				int maH = rs.getInt("MaHang");
				String link = rs.getString("Link");

				SanPham spyt = new SanPham(maND, maSP, tenSP, tenH, diemDG, ghiC, maH, link);
				sanPhamYeuThichs.add(spyt);
			}
			response.setData(sanPhamYeuThichs);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getSanPhamYeuThich bi loi");
		}
		return response;

	}
	

	@Override
	public Boolean themSanPhamYeuThich(int maND, int maSP) {
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themSanPhamYeuThich(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maND);
			st.setInt(2, maSP);

			int rs  = st.executeUpdate();
				
			if(rs==1){
				return true;
			} 
			st.close();
			cnn.close();
		} catch (SQLException e) {
			
		}
		return false;
	}

	@Override
	public Boolean xoaSanPhamYeuThich(int maND, int maSP) {
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call xoaSanPhamYeuThich(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maND);
			st.setInt(2, maSP);
			int rs = st.executeUpdate();
			if (rs == 1) {
				return true;
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			
		}
		return false;

	}
	
	@Override
	public Boolean themGhiChuYeuThich(int maNguoiDung,int maSanPham,String ghiChu){
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themGhiChuYeuThich(?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNguoiDung);
			st.setInt(2, maSanPham);
			st.setString(3, ghiChu);
			int rs  = st.executeUpdate();
			if(rs==1){
				return true;
			} 
			
			st.close();
			cnn.close();
		} catch (SQLException e) {
			

		}
		return false;

	}

	
	@Override
	public ResponseData<List<Hang>> getHangYeuThich(int maNguoiDung) {
		ResponseData<List<Hang>> response = new ResponseData<List<Hang>>();
		List<Hang> hangYeuThichs = new ArrayList<Hang>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getHangYeuThich(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNguoiDung);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {

				String tenH = rs.getString("TenHang");
				int maH = rs.getInt("MaHang");

				Hang spyt = new Hang(maH, tenH);
				hangYeuThichs.add(spyt);
			}
			response.setData(hangYeuThichs);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getHangYeuThich bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<List<SanPham>> getDuyetSanPham(int tinhTrang) {
		ResponseData<List<SanPham>> response = new ResponseData<List<SanPham>>();
		List<SanPham> sanPhams = new ArrayList<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getDuyetSanPham(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, tinhTrang);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				int tinhT = rs.getInt("TinhTrang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, tinhT, ngayD,
						diemDG, soLDG, hinhAC, link);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getDuyetSanPham bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Boolean> getDuyetSanPhamDang(int masanPham) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getDuyetSanPhamDang(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, masanPham);
			int rs = st.executeUpdate();
			if (rs == 1) {
				response.setData(true);
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getDuyetSanPhamDang bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Boolean> getXoaSanPhamDang(int masanPham) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getXoaSanPhamDang(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, masanPham);
			int rs = st.executeUpdate();
			if (rs == 1) {
				response.setData(true);
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getXoaSanPhamDang bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Integer> getTimMaDanhMuc(String link) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int maDanhMuc = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call timMaDanhMuc(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, link);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				maDanhMuc = rs.getInt("MaDanhMuc");
			}
			response.setData(maDanhMuc);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getTimMaDanhMuc bi loi");
		}
		return response;
	}

	@Override
	public ResponseData<List<SanPham>> getDuongDa() {
		ResponseData<List<SanPham>> response = new ResponseData<List<SanPham>>();
		List<SanPham> sanPhams = new ArrayList<SanPham>();

		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getDuongDa()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String link = rs.getString("Link");

				SanPham sp = new SanPham(maSP, tenSP, tenH, ngayD, diemDG,
						soLDG, hinhAC, link);
				sanPhams.add(sp);
			}
			response.setData(sanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getDuongDa bi loi");
		}
		return response;

	}
	
	@Override
	public ResponseData<Integer> getNhomSanPhamTheoBoPhan(String link) {
		ResponseData<Integer> response = new ResponseData<Integer>();
		int maNhomBoPhan = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getNhomSanPhamTheoBoPhan(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, link);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				maNhomBoPhan = rs.getInt("MaNhomSanPham");
			}
			response.setData(maNhomBoPhan);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getNhomSanPhamTheoBoPhan bi loi");
		}
		return response;
	}
	
	@Override
	public ResponseData<List<Integer>> listMaNhomSanPham(String link) {
		ResponseData<List<Integer>> response = new ResponseData<List<Integer>>();
		List<Integer> listNhomSanPham = new ArrayList<Integer>();
		int maNhom = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getlistMaNhomSanPham(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, link);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				maNhom = rs.getInt("MaNhomSanPham");
				listNhomSanPham.add(maNhom);
			}
			response.setData(listNhomSanPham);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getlistMaNhomSanPham bi loi");
		}
		return response;
	}

}