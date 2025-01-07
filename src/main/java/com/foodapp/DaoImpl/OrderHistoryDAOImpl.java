package com.foodapp.DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.foodapp.Dao.OrderHistoryDAO;
import com.foodapp.model.OrderHistory;
import com.tap.connection.Connect;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {
	private ArrayList<OrderHistory> orderHistories = new ArrayList<>();
    private static final String INSERT_QUERY = "INSERT INTO order_history(orderHistoryId, ordersId, userId, totalAmount, status) VALUES(?,?,?,?,?)";
    private static final String FETCH_ALL = "SELECT * FROM order_history";
    private static final String FETCH_ONE = "SELECT * FROM order_history WHERE orderHistoryId=?";
    private static final String UPDATE = "UPDATE order_history SET status=? WHERE orderHistoryId=?";
    private static final String DELETE = "DELETE FROM order_history WHERE orderHistoryId=?";
    private static Connection con;

    static {
        con = Connect.connect();
    }

    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet resultSet;

    @Override
    public int insert(OrderHistory orderHistory) {
        try {
            pstmt = con.prepareStatement(INSERT_QUERY);
            pstmt.setInt(1, orderHistory.getOrderHistoryId());
            pstmt.setInt(2, orderHistory.getOrdersId());
            pstmt.setInt(3, orderHistory.getUserId());
            pstmt.setDouble(4, orderHistory.getTotalAmount());
            pstmt.setString(5, orderHistory.getStatus());
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<OrderHistory> fetchAll() {
        try {
            stmt = con.createStatement();
            resultSet = stmt.executeQuery(FETCH_ALL);
            while (resultSet.next()) {
                orderHistories.add(new OrderHistory(
                        resultSet.getInt("orderHistoryId"),
                        resultSet.getInt("ordersId"),
                        resultSet.getInt("userId"),
                        resultSet.getInt("totalAmount"),
                        resultSet.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistories;
    }

    @Override
    public OrderHistory fetchOne(int orderHistoryId) {
        try {
            pstmt = con.prepareStatement(FETCH_ONE);
            pstmt.setInt(1, orderHistoryId);
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                return new OrderHistory(
                        resultSet.getInt("orderHistoryId"),
                        resultSet.getInt("ordersId"),
                        resultSet.getInt("userId"),
                        resultSet.getInt("totalAmount"),
                        resultSet.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(int orderHistoryId, String status) {
        try {
            pstmt = con.prepareStatement(UPDATE);
            pstmt.setString(1, status);
            pstmt.setInt(2, orderHistoryId);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int orderHistoryId) {
        try {
            pstmt = con.prepareStatement(DELETE);
            pstmt.setInt(1, orderHistoryId);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
