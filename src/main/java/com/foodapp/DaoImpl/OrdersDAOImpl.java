package com.foodapp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.Dao.OrdersDAO;
import com.foodapp.model.Orders;
import com.tap.connection.Connect;

public class OrdersDAOImpl implements OrdersDAO {
	 private static final String InsertQuery = "INSERT INTO orders (userId, restaurantId, totalAmount, status, paymentMode) VALUES (?, ?, ?, ?, ?)";
	    private static final String FetchAll = "SELECT * FROM orders";
	    private static final String FetchOne = "SELECT * FROM orders WHERE restaurantId = ?";
	    private static final String Update = "UPDATE orders SET status = ? WHERE ordersId = ?";
	    private static final String Delete = "DELETE FROM orders WHERE ordersId = ?";
	    private static Connection con;
	    private PreparedStatement pstmt;
	    private Statement stmt;
	    private ResultSet resultSet;

	    static {
	        con = Connect.connect();
	    }
	    @Override
	    public int insert(Orders order) {
	        try {
	            pstmt = con.prepareStatement(InsertQuery,Statement.RETURN_GENERATED_KEYS);
	            pstmt.setInt(1, order.getUserId());
	            pstmt.setInt(2, order.getRestaurantId());
	            pstmt.setDouble(3, order.getTotalAmount());
	            pstmt.setString(4, order.getStatus());
	            pstmt.setString(5, order.getPaymentMode());
	            int affectedRow= pstmt.executeUpdate();
	            
	            if(affectedRow==0) {
	            	throw new SQLException("Failed");
	            }
	            ResultSet res=pstmt.getGeneratedKeys();
	            int orderId = 0;
	            while(res.next()) {
	            	orderId=res.getInt(1);
	            }
	            return orderId;
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	    @Override
	    public ArrayList<Orders> fetchAll() {
	        ArrayList<Orders> ordersList = new ArrayList<>();
	        try {
	            stmt = con.createStatement();
	            resultSet = stmt.executeQuery(FetchAll);
	            while (resultSet.next()) {
	                ordersList.add(new Orders(
	                    resultSet.getInt("restaurantId"),
	                    resultSet.getInt("ordersId"),
	                    resultSet.getTimestamp("orderDate"),
	                    resultSet.getInt("userId"),
	                    resultSet.getInt("totalAmount"),
	                    resultSet.getString("status"),
	                    resultSet.getString("paymentMode")
	                ));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ordersList;
	    }

	    @Override
	    public Orders fetchOne(int restaurantId) {
	        Orders order = null;
	        try {
	            pstmt = con.prepareStatement(FetchOne);
	            pstmt.setInt(1, restaurantId);
	            resultSet = pstmt.executeQuery();
	            if (resultSet.next()) {
	                order = new Orders(
	                    resultSet.getInt("restaurantId"),
	                    resultSet.getInt("ordersId"),
	                    resultSet.getTimestamp("orderDate"),
	                    resultSet.getInt("userId"),
	                    resultSet.getInt("totalAmount"),
	                    resultSet.getString("status"),
	                    resultSet.getString("paymentMode")
	                );
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return order;
	    }

	    @Override
	    public int update(int ordersId, String status) {
	        try {
	            pstmt = con.prepareStatement(Update);
	            pstmt.setString(1, status);
	            pstmt.setInt(2, ordersId);
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	    @Override
	    public int delete(int ordersId) {
	        try {
	            pstmt = con.prepareStatement(Delete);
	            pstmt.setInt(1, ordersId);
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

}
