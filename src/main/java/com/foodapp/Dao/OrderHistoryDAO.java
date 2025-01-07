package com.foodapp.Dao;
import java.util.ArrayList;
import com.foodapp.model.OrderHistory;

public interface OrderHistoryDAO {
	int insert(OrderHistory orderHistory);
    ArrayList<OrderHistory> fetchAll();
    OrderHistory fetchOne(int orderHistoryId);
    int update(int orderHistoryId, String status);
    int delete(int orderHistoryId);

}
