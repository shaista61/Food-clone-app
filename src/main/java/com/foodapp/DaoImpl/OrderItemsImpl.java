package com.foodapp.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.Dao.OrderItemsDAO;
import com.foodapp.model.OrderItems;
import com.tap.connection.Connect;


public class OrderItemsImpl implements OrderItemsDAO {
	 ArrayList<OrderItems> oal = new ArrayList<>();
	    private final static String InsertQuery = "INSERT INTO orders_item(ordersId, menuId, quantity, totalItem) VALUES (?, ?, ?, ?)";
	    private final static String FetchAll = "SELECT * FROM orders_item";
	    private final static String FetchOne = "SELECT * FROM orders_item WHERE ordersItemId = ?";
	    private final static String UpdateQuery = "UPDATE orders_item SET quantity = ? WHERE ordersItemId = ?";
	    private final static String DeleteQuery = "DELETE FROM orders_item WHERE ordersItemId = ?";
	    private static Connection con;

	    static {
	        con = Connect.connect();
	    }
	    private PreparedStatement pstmt;
	    private Statement stmt;
	    private ResultSet resultSet;

	    @Override
	    public int insert(OrderItems oi) {
	        try {
	            pstmt = con.prepareStatement(InsertQuery);
	            pstmt.setInt(1, oi.getOrdersId());
	            pstmt.setInt(2, oi.getMenuId());
	            pstmt.setInt(3, oi.getQuantity());
	            pstmt.setInt(4, oi.getTotalItem());
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	    @Override
	    public ArrayList<OrderItems> fetchAll() {
	        try {
	            stmt = con.createStatement();
	            resultSet = stmt.executeQuery(FetchAll);
	            while (resultSet.next()) {
	                oal.add(new OrderItems(resultSet.getInt("ordersItemId"), resultSet.getInt("ordersId"),
	                        resultSet.getInt("menuId"), resultSet.getInt("quantity"), resultSet.getInt("totalItem")));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return oal;
	    }

	    @Override
	    public OrderItems fetchOne(int id) {
	        OrderItems oi = null;
	        try {
	            pstmt = con.prepareStatement(FetchOne);
	            pstmt.setInt(1, id);
	            resultSet = pstmt.executeQuery();
	            if (resultSet.next()) {
	                oi = new OrderItems(resultSet.getInt("ordersItemId"), resultSet.getInt("ordersId"),
	                        resultSet.getInt("menuId"), resultSet.getInt("quantity"), resultSet.getInt("totalItem"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return oi;
	    }

	    @Override
	    public int updateQuantity(int id, int quantity) {
	        try {
	            pstmt = con.prepareStatement(UpdateQuery);
	            pstmt.setInt(1, quantity);
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
	            pstmt = con.prepareStatement(DeleteQuery);
	            pstmt.setInt(1, id);
	            return pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

}
