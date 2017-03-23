package com.danhgiamypham.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danhgiamypham.dao.UserDao;
import com.danhgiamypham.database.DBProvider;
import com.danhgiamypham.dto.ResponseData;
import com.danhgiamypham.model.User;
import com.mysql.jdbc.Statement;

@Component
public class UserDaoImpl implements UserDao {

	// Thay vi tao moi dbProvider thi khai bao trong danhgiamypham-servlet:
	// id.....
	@Autowired
	private DBProvider dbProvider;

	// @Autowired
	// private ResponseData responseData;

	@Override
	public ResponseData<User> login(User user) {
		ResponseData<User> response = new ResponseData<User>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call login(?, ?)}";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, user.getTenDangNhap());
			st.setString(2, user.getMatKhau());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				// String tenND = rs.getString("TenNguoiDung");
				int maND = rs.getInt("MaNguoiDung");
				String email = rs.getString("Email");

				user = new User(maND, email);
				response.setData(user);
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage(e.getMessage());
		}
		return response;

	}

	@Override
	public ResponseData<User> themTaiKhoan(User tk) {
		ResponseData<User> response = new ResponseData<User>();
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call themTaiKhoan(?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, tk.getTenDangNhap());
			st.setString(2, tk.getMatKhau());
			st.setString(3, tk.getEmail());
			int affectedRows = st.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException(
						"Creating user failed, no rows affected.");
			}

			int id = getMaxMaNguoiDung();
			tk.setMaNguoiDung(id);
			response.setData(tk);

			st.close();
			cnn.close();
		} catch (SQLException e) {
			response.setErrorMessage(e.getMessage());

		} catch (Exception a) {
			response.setErrorMessage(a.getMessage());
		}
		return response;

	}

	public int getMaxMaNguoiDung() {
		int id = 0;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getMaxMaNguoiDung()}";
			PreparedStatement st = cnn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				id = rs.getInt("MaxMaNguoiDung");
			}
			rs.close();
			st.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
}