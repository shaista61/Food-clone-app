package com.foodapp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.foodapp.Dao.UserDAO;
import com.foodapp.model.User;
import com.tap.connection.Connect;

public class UserDAOImplts implements UserDAO {
	ArrayList<User> ual=new ArrayList<User>();
	private final static String InsertQuery="insert into users(uname,pswd,email,address)values(?,?,?,?)";
	private final static String FetchDetails="select * from users where email=?";
	private static Connection con;
	static {
		con=Connect.connect();
	}
	private PreparedStatement pstmt;
	private ResultSet resultset;
	@Override
	public int insert(User u) {
		try {
			con=Connect.connect();
			pstmt=con.prepareStatement(InsertQuery);
			pstmt.setString(1,u.getName());
			pstmt.setString(2,u.getPswd());
			pstmt.setString(3,u.getEmail());
			pstmt.setString(4,u.getAddress());
			return pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public User fetch(String email) {
		User usr=null;
		try {
			pstmt=con.prepareStatement(FetchDetails);
			pstmt.setString(1, email);
			resultset=pstmt.executeQuery();
			while(resultset.next()) {
				 usr=new User(
						resultset.getInt("uid"),
						resultset.getString("uname"),
						resultset.getString("pswd"),
						resultset.getString("email"),
						resultset.getString("address")
						);	
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return usr;
		}
	}
