package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.DanhMucDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.model.BinhLuan;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPham;

@Component
public class DanhMucDaoImpl implements DanhMucDao {

	@Autowired
	private DBProvider dbProvider;

	@Override
	public List<DanhMuc> getAll() {
		List<DanhMuc> danhMucs = new ArrayList<DanhMuc>();
		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getAll()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maDM = rs.getInt("MaDanhMuc");
				String tenDM = rs.getString("TenDanhMuc");
				String link = rs.getString("Link");
				DanhMuc dm = new DanhMuc(maDM, tenDM, link);
				danhMucs.add(dm);

			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return danhMucs;

	}

	@Override
	public List<NhomSanPham> getNhomSanPham() {
		List<NhomSanPham> nhomSanPhams = new ArrayList<NhomSanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getNhomSanPham()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maNSP = rs.getInt("MaNhomSanPham");
				String tenNSP = rs.getString("TenNhom");
				int maDM = rs.getInt("MaDanhMuc");
				NhomSanPham nsp = new NhomSanPham(maNSP, tenNSP, maDM);
				nhomSanPhams.add(nsp);

			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhomSanPhams;

	}

	@Override
	public Set<SanPham> getSanPhamTheoNhomSP(int maNhomSanPham) {
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
				String gioiT = rs.getString("GioiThieu");
				String congD = rs.getString("CongDung");
				String cachSD = rs.getString("CachSuDung");
				String thanhP = rs.getString("ThanhPhan");
				String tenND = rs.getString("TenDangNhap");
				int tinhT = rs.getInt("TinhTrang");
				Date ngayD = rs.getDate("NgayDang");
				String nuoc = rs.getString("Nuoc");
				String tenN = rs.getString("TenNhom");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				int soLBL = rs.getInt("SoLuotBinhLuan");
				String hinhAC = rs.getString("HinhAnhChinh");
				int maNSP = rs.getInt("MaNhomSanPham");

				SanPham sp = new SanPham(maSP, tenSP, tenH, gioiT, congD,
						cachSD, thanhP, tenND, tinhT, ngayD, nuoc, tenN,
						diemDG, soLDG, soLBL, hinhAC, maNSP);
				sanPhams.add(sp);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sanPhams;

	}
	

	@Override
	public List<SanPham> getSanPhamTheoDanhMuc(int maDM) {
		List<SanPham> sanPhams = new ArrayList<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamTheoDanhMuc(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDM);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maSP = rs.getInt("MaSanPham");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				String gioiT = rs.getString("GioiThieu");
				String congD = rs.getString("CongDung");
				String cachSD = rs.getString("CachSuDung");
				String thanhP = rs.getString("ThanhPhan");
				String tenND = rs.getString("TenDangNhap");
				int tinhT = rs.getInt("TinhTrang");
				Date ngayD = rs.getDate("NgayDang");
				String nuoc = rs.getString("Nuoc");
				String tenN = rs.getString("TenNhom");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				int soLBL = rs.getInt("SoLuotBinhLuan");
				String hinhAC = rs.getString("HinhAnhChinh");
				int maNSP = rs.getInt("MaNhomSanPham");

				SanPham sp = new SanPham(maSP, tenSP, tenH, gioiT, congD,
						cachSD, thanhP, tenND, tinhT, ngayD, nuoc, tenN,
						diemDG, soLDG, soLBL, hinhAC, maNSP);
				sanPhams.add(sp);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sanPhams;

	}
	
	
	@Override
	public List<SanPham> getDuongDa() {
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
				String gioiT = rs.getString("GioiThieu");
				String congD = rs.getString("CongDung");
				String cachSD = rs.getString("CachSuDung");
				String thanhP = rs.getString("ThanhPhan");
				String tenND = rs.getString("TenDangNhap");
				int tinhT = rs.getInt("TinhTrang");
				Date ngayD = rs.getDate("NgayDang");
				String nuoc = rs.getString("Nuoc");
				String tenN = rs.getString("TenNhom");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				int soLBL = rs.getInt("SoLuotBinhLuan");
				String hinhAC = rs.getString("HinhAnhChinh");
				int maNSP = rs.getInt("MaNhomSanPham");

				SanPham sp = new SanPham(maSP, tenSP, tenH, gioiT, congD,
						cachSD, thanhP, tenND, tinhT, ngayD, nuoc, tenN,
						diemDG, soLDG, soLBL, hinhAC, maNSP);
				sanPhams.add(sp);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sanPhams;

	}
	
	@Override
	public boolean themNhomSanPham(int maDanhMuc, String tenNhomSanPham){
		boolean ketQua = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themNhomSanPham(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDanhMuc);
			st.setString(2, tenNhomSanPham);
			
			int rs  = st.executeUpdate();
			
			if(rs==1){
				ketQua  = true;
			} 
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;

	}

}
