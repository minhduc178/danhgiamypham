package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.HangDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.model.Hang;
import com.danhgiamypham.model.NhomHang;

@Component
public class HangDaoImpl implements HangDao {

	@Autowired
	private DBProvider dbProvider;
	

	@Override
	public List<NhomHang> getNhomHang() {
		List<NhomHang> nhomHangs = new ArrayList<NhomHang>();
		try {
			Connection cnn = dbProvider.getConnection();
			Statement st = cnn.createStatement();
			String sql = "{call getNhomHang()}";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int maNH = rs.getInt("MaNhomHang");
				String tenNH = rs.getString("TenNhomHang");

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

}
