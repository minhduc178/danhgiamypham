package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.BinhLuanDao;
import com.danhgiamypham.dao.ThongTinWebDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.BinhLuan;
import com.danhgiamypham.model.SoLuongDang;
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
	
	@Override
	public List<SoLuongDang> soLuongDangSP(String thang, String ngay) {
		List<SoLuongDang> sources = new ArrayList<SoLuongDang>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getSoSanPhamDang(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, thang);
			st.setString(2, ngay);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				SoLuongDang spt = new SoLuongDang();
				spt.setMaNguoiDang(rs.getInt("MaNguoiDang"));
				spt.setSoLuongTrongNgay(rs.getInt("SoLuotNgay"));
				spt.setSoLuongTrongThang(rs.getInt("SoLuotThang"));
				spt.setTenDienDan(rs.getString("TenDienDan"));
				sources.add(spt);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sources;
	}
}
