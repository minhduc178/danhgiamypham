package com.danhgiamypham.dao.impl;

import java.math.BigInteger;
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

	@Autowired
	private DBProvider dbProvider;

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
				BigInteger maND = BigInteger.valueOf(rs.getLong("MaNguoiDung"));
				String email = rs.getString("Email");
				String tenDienDan =  rs.getString("TenDienDan");
				String hinhAnh = rs.getString("HinhAnh");
				
				user = new User(maND, email, tenDienDan, hinhAnh);
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
			String sql = "{call themTaiKhoan(?,?,?,?,?)}";
			PreparedStatement st = cnn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, tk.getTenDangNhap());
			st.setString(2, tk.getMatKhau());
			st.setString(3, tk.getEmail());
			st.setString(4, tk.getTenDienDan());
			st.setString(5, tk.getHinhAnh());
			int affectedRows = st.executeUpdate();

			if (affectedRows == 0) {
				response.setErrorMessage("Vui long thu lai sau");
			}

			BigInteger id = getMaxMaNguoiDung();
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

	public BigInteger getMaxMaNguoiDung() {
		BigInteger id = null;
		try {
			Connection cnn = dbProvider.getConnection();
			String sql = "{call getMaxMaNguoiDung()}";
			PreparedStatement st = cnn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				id = BigInteger.valueOf(rs.getLong("MaxMaNguoiDung"));
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