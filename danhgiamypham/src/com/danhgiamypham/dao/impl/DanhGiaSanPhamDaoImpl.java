package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.DanhGiaSanPhamDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.DanhGiaSanPham;

@Component
public class DanhGiaSanPhamDaoImpl implements DanhGiaSanPhamDao {

	@Autowired
	private DBProvider dbProvider;

	@Override
	public ResponseData<List<DanhGiaSanPham>> getDanhGiaSanPham(int maSP) {
		ResponseData<List<DanhGiaSanPham>> response = new ResponseData<List<DanhGiaSanPham>>();
		List<DanhGiaSanPham> danhGiaSanPhams = new ArrayList<DanhGiaSanPham>();

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getDanhGia(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maSP);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int maDG  = rs.getInt("MaDanhGia");
				int diemDG = rs.getInt("DiemDanhGia");
				String binhL = rs.getString("BinhLuan");
				int soLL = rs.getInt("SoLuotLike");
				int tinhT = rs.getInt("TinhTrang");
				Date ngayGN = rs.getDate("NgayGiaNhap");
				String addC = rs.getString("AddClass");
				String tinhTL = rs.getString("TinhTrangLike");
				
				DanhGiaSanPham blsp = new DanhGiaSanPham(maDG, diemDG, binhL, soLL, tinhT,ngayGN, addC, tinhTL);
				danhGiaSanPhams.add(blsp);			
			}
			response.setData(danhGiaSanPhams);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getDanhGiaSanPham bi loi");
		}
		return response;

	}
	
	@Override
	public ResponseData<List<String>> getHinhAnhBinhLuan(int maDG) {
		ResponseData<List<String>> response = new ResponseData<List<String>>();
		List<String> hinhAnhList = new ArrayList<String>();

		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getHinhAnhBinhLuan(?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDG);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String hinhAnh = rs.getString("HinhAnh");
				hinhAnhList.add(hinhAnh);			
			}
			response.setData(hinhAnhList);
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage("getHinhAnhBinhLuan bi loi");
		}
		return response;
	}

}