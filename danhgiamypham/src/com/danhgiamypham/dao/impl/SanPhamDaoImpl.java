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

import com.danhgiamypham.dao.SanPhamDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.SanPham;
import com.mysql.jdbc.CallableStatement;

@Component
public class SanPhamDaoImpl implements SanPhamDao {

	// Thay vi tao moi dbProvider thi khai bao trong danhgiamypham-servlet:
	// id.....
	@Autowired
	private DBProvider dbProvider;

	@Override
	public Set<SanPham> getSanPham(int trangHienTai, int soLuongTrongTrang) {
		Set<SanPham> sanPhams = new HashSet<SanPham>();
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
				int tinhT = rs.getInt("TinhTrang");
				Date ngayD = rs.getDate("NgayDang");
				float diemDG = rs.getFloat("DiemDanhGia");
				int soLDG = rs.getInt("SoLuotDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");

				SanPham sp = new SanPham(maSP, tenSP, tenH, tinhT, ngayD,
						diemDG, soLDG, hinhAC);
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
	public List<SanPham> getSanPhamTimKiem(int trangHienTai, int soLuongTrongTrang, String timKiem) {
		List<SanPham> sanPhams = new ArrayList<SanPham>();
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

				SanPham sp = new SanPham(maSP, tenSP, tenH, tinhT, ngayD,
						diemDG, soLDG, hinhAC);
				System.out.print(sp.getTenSanPham());
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
	public int getTongSanPhamTimKiem(String timKiem) {
		 int tongSanPham=0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoLuongTimKiem(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, timKiem);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("SoLuongTimKiem");
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tongSanPham;
	}
	
	@Override
	public int getTongSoSanPhamMaDanhMuc(int maDanhMuc) {
		 int tongSanPham=0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoLuongMaDanhMuc(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDanhMuc);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				tongSanPham = rs.getInt("SoLuongTheoDanhMuc");
				
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tongSanPham;
	}
	
	@Override
	public int getTongSanPham() {
		int tongSanPham=0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoSanPham()}";
			PreparedStatement st = cnn.prepareStatement(sql);
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

	@Override
	public SanPham getChiTietSanpham(int maSP) {
		SanPham sanPham = null;

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getChiTietSanPham(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				maSP = rs.getInt("MaSanPham");
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
				float diemDG = rs.getFloat("DiemDanhGia");
				String hinhAC = rs.getString("HinhAnhChinh");
				String hinh1 = rs.getString("Hinh1");
				String hinh2 = rs.getString("Hinh2");
				String hinh3 = rs.getString("Hinh3");
				String hinh4 = rs.getString("Hinh4");

				sanPham = new SanPham(maSP, tenSP, tenH, gioiT, congD, cachSD,
						thanhP, tenND, tinhT, ngayD, nuoc, diemDG, hinhAC,
						hinh1, hinh2, hinh3, hinh4);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sanPham;

	}
	
	@Override
	public List<SanPham> getSanPhamYeuThich(int maNguoiDung) {
		List<SanPham> sanPhamYeuThichs = new ArrayList<SanPham>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSanPhamYeuThich(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNguoiDung);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maND = rs.getInt("MaNguoiDung");
				String tenSP = rs.getString("TenSanPham");
				String tenH = rs.getString("TenHang");
				int diemDG = rs.getInt("DiemDanhGia");
				String ghiC = rs.getString("GhiChu");
				int maH = rs.getInt("MaHang");

				SanPham spyt = new SanPham(maND, tenSP, tenH, diemDG, ghiC, maH);
				sanPhamYeuThichs.add(spyt);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sanPhamYeuThichs;

	}
	
	@Override
	public List<Hang> getHangYeuThich(int maNguoiDung) {
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
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hangYeuThichs;

	}
	
	@Override
	public List<SanPham> getDuyetSanPham(int tinhTrang) {
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

				SanPham sp = new SanPham(maSP, tenSP, tenH, tinhT, ngayD,
						diemDG, soLDG, hinhAC);
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
	public boolean getDuyetSanPhamDang(int masanPham) {
		boolean result = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getDuyetSanPhamDang(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, masanPham);
			int rs = st.executeUpdate();
			if(rs == 1){
				result = true;
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;

	}
	
	@Override
	public boolean getXoaSanPhamDang(int masanPham) {
		boolean result = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getXoaSanPhamDang(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, masanPham);
			int rs = st.executeUpdate();
			if(rs == 1){
				result = true;
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;

	}
	
	@Override
	public int getTimMaDanhMuc(int maSP){
		 int maDanhMuc=0;
			try {
				Connection cnn = dbProvider.getConnection();
				String sql = "{call timMaDanhMuc(?)}";
				PreparedStatement st = cnn.prepareStatement(sql);
				st.setInt(1, maSP);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					maDanhMuc = rs.getInt("MaDanhMuc");
				}
				rs.close();
				st.close();
				cnn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return maDanhMuc;
	}


}