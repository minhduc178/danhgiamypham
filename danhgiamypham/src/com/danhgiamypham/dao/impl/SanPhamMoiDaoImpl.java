package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.SanPhamMoiDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.HinhAnhSanPham;
import com.danhgiamypham.model.NhomSanPham;
import com.danhgiamypham.model.SanPhamMoi;

@Component
public class SanPhamMoiDaoImpl implements SanPhamMoiDao {

	@Autowired
	private DBProvider dbProvider;

	@Override
	public List<Hang> getHang() {
		List<Hang> hangs = new ArrayList<Hang>();
		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getHang()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maH = rs.getInt("MaHang");
				String tenH = rs.getString("TenHang");
				int maNH = rs.getInt("MaNhomHang");

				Hang nh = new Hang(maH, tenH, maNH);
				hangs.add(nh);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hangs;

	}
	
	
	@Override
	public List<NhomSanPham> getNhomSanPhamTheoDanhMuc(int maDanhMuc) {
		List<NhomSanPham> nhomSanPhams = new ArrayList<NhomSanPham>();

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getNhomSanPhamTheoDanhMuc(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDanhMuc);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maNSP = rs.getInt("MaNhomSanPham");
				String tenN = rs.getString("TenNhom");

				NhomSanPham nh = new NhomSanPham(maNSP, tenN);
				nhomSanPhams.add(nh);
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
	public List<NhomSanPham> getNhomSanPhamTheoSP(int maSP, int MaDanhMuc) {
		List<NhomSanPham> nhomSanPhams = new ArrayList<NhomSanPham>();

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getNhomSanPhamTheoSanPham(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			st.setInt(2, MaDanhMuc);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maNSP = rs.getInt("MaNhomSanPham");
				String tenN = rs.getString("TenNhom");

				NhomSanPham nh = new NhomSanPham(maNSP, tenN);
				nhomSanPhams.add(nh);
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
	public boolean themSanPham(SanPhamMoi spm) {
		boolean ketQua = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themSanPham(?,?,?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, spm.getTenSanPham());
			st.setInt(2, spm.getMaHang());
			st.setString(3, spm.getGioiThieu());
			st.setString(4, spm.getCongDung());
			st.setString(5, spm.getCachSuDung());
			st.setString(6, spm.getThanhPhan());
			st.setInt(7, spm.getMaNguoiDung());

			int rs  = st.executeUpdate();
			
			if(rs==1){
				ketQua  = true;
			} 
			int id = getMaxMaSanPham();
			spm.setMaSanPham(id);
			
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;

	}
	
	public int getMaxMaSanPham() {
		int id = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getMaxMaSanPham()}";
			PreparedStatement st = cnn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				id = rs.getInt("MaxMaSanPham");
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	@Override
	public boolean themHinhAnh(int maSP,String fileName) {
		boolean ketQua = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themHinhAnh(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			st.setString(2, fileName);

			int rs = st.executeUpdate();

			if (rs == 1) {
				ketQua = true;
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	@Override
	public boolean themSanPhamNhomSanPham(int maSP, int k) {
		boolean ketQua = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themSanPhamNhomSanPham(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			st.setInt(2, k);

			int rs = st.executeUpdate();

			if (rs == 1) {
				ketQua = true;
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	@Override
	public boolean themNhomSanPhamMoi(int maSP, int maNhom) {
		boolean ketQua = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themSanPhamNhomSanPham(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			st.setInt(2,maNhom);
			int rs = st.executeUpdate();

			if (rs == 1) {
				ketQua = true;
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	
	@Override
	public boolean capnhatSanPham(SanPhamMoi spm) {
		boolean ketQua = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call capnhatSanPham(?,?,?,?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, spm.getMaSanPham());
			st.setString(2, spm.getTenSanPham());
			st.setInt(3, spm.getMaHang());
			st.setString(4, spm.getGioiThieu());
			st.setString(5, spm.getCongDung());
			st.setString(6, spm.getCachSuDung());
			st.setString(7, spm.getThanhPhan());
			st.setInt(8, spm.getMaNguoiDung());

			int rs  = st.executeUpdate();
			
			if(rs==1){
				ketQua  = true;
			} 
			int id = getMaxMaSanPham();
			spm.setMaSanPham(id);
			
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;

	}
	

	@Override
	public boolean capnhatHinhAnh(int maSP,String fileName) {
		boolean ketQua = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call capnhatHinhAnh(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			st.setString(2, fileName);

			int rs = st.executeUpdate();

			if (rs == 1) {
				ketQua = true;
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public boolean themHinhAnhMoi(HinhAnhSanPham hasp){
		boolean ketQua = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themHinhAnhSanPhamMoi(?,?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, hasp.getMaSanPham()); 
			st.setString(2, hasp.getHinhAnhChinh());
			st.setString(3, hasp.getHinh1());
			st.setString(4, hasp.getHinh2());
			st.setString(5, hasp.getHinh3());
			st.setString(6, hasp.getHinh4());
		
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