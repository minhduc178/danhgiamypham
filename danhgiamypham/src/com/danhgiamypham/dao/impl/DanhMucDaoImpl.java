package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.DanhMucDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.model.DanhMuc;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;
import com.danhgiamypham.model.NhomSanPham;

@Component
public class DanhMucDaoImpl implements DanhMucDao {

	Logger logger = Logger.getLogger("DanhMucDaoImpl");
	@Autowired
	private DBProvider dbProvider;

	@Override
	public List<DanhMuc> getAll() {
		List<DanhMuc> danhMucs = new ArrayList<DanhMuc>();
		try {
			logger.log(Level.INFO, "db provider is null: " + (dbProvider == null));
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
			logger.log(Level.INFO,"error", e);
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
	
	@Override
	public List<NhomHang> getNhomHang() {
		List<NhomHang> nhomHangs = new ArrayList<NhomHang>();
		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getNhomHang()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maNH = rs.getInt("MaNhomSanPham");
				String tenNH = rs.getString("TenNhom");

				NhomHang nh = new NhomHang(maNH, tenNH);
				nhomHangs.add(nh);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhomHangs;

	}
	
	
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
	public boolean themHang(String tenHang, int maNhomSanPham) {
		boolean ketQua = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themHang(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, tenHang);
			st.setInt(2, maNhomSanPham);

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
	public List<Hang> getHangTheoNhom(int maNhomHang) {
		List<Hang> hangs = new ArrayList<Hang>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getHangTheoNhom(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maNhomHang);
			ResultSet rs = st.executeQuery();
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

}
