package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.BinhLuanDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.model.BinhLuan;

@Component
public class BinhLuanDaoImpl implements BinhLuanDao {

	// Thay vi tao moi dbProvider thi khai bao trong danhgiamypham-servlet:
	// id.....
	@Autowired
	private DBProvider dbProvider;

	@Override
	public boolean themBinhLuan(BinhLuan bl) {
		boolean ketQua = false;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themBinhLuanMoi(?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, bl.getMaNguoiDung());
			st.setInt(2, bl.getMaSanPham());
			st.setInt(3, bl.getDiemDanhGia());
			st.setString(4, bl.getBinhLuan());
			st.setString(5, bl.getHinhAnh());
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
	public boolean themLike(int maDanhGia, int soLuotLike, String addClass, String tinhTrangLike){
		boolean result = false;
		try {
			Connection cnn =  dbProvider.getConnection();
			String sql = "{call updateDanhGia(?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, maDanhGia);
			st.setInt(2, soLuotLike);
			st.setString(3, addClass);
			st.setString(4, tinhTrangLike);
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
	public boolean kiemTraBinhLuan(int mnd, int msp){
		boolean result = false;
		int k = 0;
		try {
			Connection cnn =  dbProvider.getConnection();
			String sql = "{call kiemTraBinhLuan(?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setInt(1, mnd);
			st.setInt(2, msp);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				k++;
			}
			if(k != 0){
				result = true;
			} 
			System.out.print(k);
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	
}
