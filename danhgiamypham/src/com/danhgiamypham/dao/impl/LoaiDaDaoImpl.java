package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.LoaiDaDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.model.LoaiDa;

@Component
public class LoaiDaDaoImpl implements LoaiDaDao {

	@Autowired
	private DBProvider dbProvider;

	@Override
	public List<LoaiDa> getLoaiDa(int maSP) {
		List<LoaiDa> loaiDas = new ArrayList<LoaiDa>();

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getLoaiDa(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String tenLD = rs.getString("TenNhom");

				LoaiDa ld = new LoaiDa(tenLD);
				loaiDas.add(ld);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loaiDas;

	}

}