package com.foodapp.DaoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.Dao.RestaurantDAO;
import com.foodapp.model.Restaurant;
import com.tap.connection.Connect;

public class RestaurantDAOImp implements RestaurantDAO {
	    private final static String InsertQuery = "INSERT INTO restaurants (restaurantId, name, cuisineType, deliveryType, address, ratings, isActive, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    private final static String FetchAll = "SELECT * FROM restaurants";
	    private final static String FetchOne = "SELECT * FROM restaurants WHERE restaurantId=?";
	    private final static String Update = "UPDATE restaurants SET address=? WHERE restaurantId=?";
	    private final static String Delete = "DELETE FROM restaurants WHERE restaurantId=?";
	    private static Connection con;

	    static {
	        con = Connect.connect();
	    }

	    private PreparedStatement pstmt;
	    private Statement stmt;
	    private ResultSet resultSet;
	    private ArrayList<Restaurant> restaurantList = new ArrayList<>();
	    private Restaurant restaurant;

	    @Override
	    public int insert(Restaurant r) {
	        try {
	            pstmt = con.prepareStatement(InsertQuery);
	            pstmt.setInt(1, r.getRestaurantId());
	            pstmt.setString(2, r.getName());
	            pstmt.setString(3, r.getCuisineType());
	            pstmt.setInt(4, r.getDeliveryType());
	            pstmt.setString(5, r.getAddress());
	            pstmt.setFloat(6, r.getRatings());
	            pstmt.setInt(7, r.getIsActive());
	            pstmt.setString(8, r.getImagePath());
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	    @Override
	    public ArrayList<Restaurant> fetchAll() {
	        try {
	            stmt = con.createStatement();
	            resultSet = stmt.executeQuery(FetchAll);
	            while (resultSet.next()) {
	                restaurantList.add(new Restaurant(
	                        resultSet.getInt("restaurantId"),
	                        resultSet.getString("name"),
	                        resultSet.getString("cuisineType"),
	                        resultSet.getInt("deliveryType"),
	                        resultSet.getString("address"),
	                        resultSet.getFloat("ratings"),
	                        resultSet.getInt("isActive"),
	                        resultSet.getString("imagePath")
	                ));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return restaurantList;
	    }

	    @Override
	    public Restaurant fetchOne(int id) {
	        try {
	            pstmt = con.prepareStatement(FetchOne);
	            pstmt.setInt(1, id);
	            resultSet = pstmt.executeQuery();
	            if (resultSet.next()) {
	                return new Restaurant(
	                        resultSet.getInt("restaurantId"),
	                        resultSet.getString("name"),
	                        resultSet.getString("cuisineType"),
	                        resultSet.getInt("deliveryType"),
	                        resultSet.getString("address"),
	                        resultSet.getFloat("ratings"),
	                        resultSet.getInt("isActive"),
	                        resultSet.getString("imagePath")
	                );
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public int update(int id, String address) {
	        try {
	            pstmt = con.prepareStatement(Update);
	            pstmt.setString(1, address);
	            pstmt.setInt(2, id);
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	    @Override
	    public int delete(int id) {
	        try {
	            pstmt = con.prepareStatement(Delete);
	            pstmt.setInt(1, id);
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
	}

