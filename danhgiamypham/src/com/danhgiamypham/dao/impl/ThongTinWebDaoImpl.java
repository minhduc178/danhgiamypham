package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.BinhLuanDao;
import com.danhgiamypham.dao.ThongTinWebDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.BinhLuan;
import com.danhgiamypham.model.SoSanPhamThem;

@Component
public class ThongTinWebDaoImpl implements ThongTinWebDao {

	// Thay vi tao moi dbProvider thi khai bao trong danhgiamypham-servlet:
	// id.....
	@Autowired
	private DBProvider dbProvider;

	@Override
	public SoSanPhamThem soSanPham() {
		SoSanPhamThem spt = new SoSanPhamThem();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoSanPhamThemTrongNgay()}";
			PreparedStatement st = cnn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				spt.setSoThemTrongNgay(rs.getInt("sanPhamThemTrongNgay"));
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getTongSoSanPhamThem()}";
			PreparedStatement st = cnn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				spt.setTongSoSanPham(rs.getInt("tongSoSanPhamThem"));
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return spt;
	}

}
