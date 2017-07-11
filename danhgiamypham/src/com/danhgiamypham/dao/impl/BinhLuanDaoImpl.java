package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.BinhLuanDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.BinhLuan;

@Component
public class BinhLuanDaoImpl implements BinhLuanDao {

	// Thay vi tao moi dbProvider thi khai bao trong danhgiamypham-servlet:
	// id.....
	@Autowired
	private DBProvider dbProvider;

	@Override
	public ResponseData<Boolean> themBinhLuan(BinhLuan bl) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themBinhLuanMoi(?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			String n = String.valueOf(bl.getMaNguoiDung());
			st.setLong(1, Long.parseLong(String.valueOf(bl.getMaNguoiDung())));
			st.setInt(2, bl.getMaSanPham());
			st.setInt(3, bl.getDiemDanhGia());
			st.setString(4, bl.getBinhLuan());

			int rs = st.executeUpdate();

			if (rs == 1) {
				response.setData(true);
			}
			int id = getMaxMaDanhGia();
			bl.setMaDanhGia(id);

			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("themBinhLuan bi loi");
		}
		return response;

	}

	@Override
	public ResponseData<Boolean> updateBinhLuan(BinhLuan bl) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call updateBinhLuan(?,?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setLong(1, Long.parseLong(String.valueOf(bl.getMaNguoiDung())));
			st.setInt(2, bl.getMaSanPham());
			st.setInt(3, bl.getDiemDanhGia());
			st.setInt(4, bl.getDiemDanhGiaCu());
			st.setString(5, bl.getBinhLuan());
			st.setInt(6, bl.getMaDanhGia());

			int rs = st.executeUpdate();

			if (rs == 1) {
				response.setData(true);
			}

			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("updateBinhLuan bi loi");
		}
		return response;

	}

	public int getMaxMaDanhGia() {
		int id = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getMaxMaDanhGia()}";
			PreparedStatement st = cnn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				id = rs.getInt("MaxMaDanhGia");
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
	public ResponseData<Boolean> themLike(int maDanhGia, int soLuotLike,
			int daLike, int maND, int maNDG) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call updateDanhGia(?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDanhGia);
			st.setInt(2, soLuotLike);
			st.setInt(3, daLike);
			st.setInt(4, maND);
			st.setInt(5, maNDG);
			int rs = st.executeUpdate();
			if (rs == 1) {
				response.setData(true);
			}
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("themLike bi loi");
		}
		return response;
	}

	@Override
	public ResponseData<Boolean> kiemTraBinhLuan(int mnd, int msp) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		int k = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call kiemTraBinhLuan(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, mnd);
			st.setInt(2, msp);
			ResultSet rs = st.executeQuery();
			if (k != 0) {
				response.setData(true);
				;
			}
			System.out.print(k);
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("kiemTraBinhLuan bi loi");
		}
		return response;
	}

	@Override
	public ResponseData<Boolean> themHinhAnhBinhLuan(int maDG, String habl) {
		ResponseData<Boolean> response = new ResponseData<Boolean>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themHinhAnhBinhLuan(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDG);
			st.setString(2, habl);

			int rs = st.executeUpdate();
			if (rs == 1) {
				response.setData(true);
			}

			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("themHinhAnhBinhLuan bi loi");
		}
		return response;

	}

}
