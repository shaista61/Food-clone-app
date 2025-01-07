package com.foodapp.Dao;

import java.util.ArrayList;
import com.foodapp.model.Orders;

public interface OrdersDAO {
	int insert(Orders order);
    ArrayList<Orders> fetchAll();
    Orders fetchOne(int ordersId);
    int update(int ordersId, String status);
    int delete(int ordersId);

}
