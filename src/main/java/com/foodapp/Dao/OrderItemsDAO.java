package com.foodapp.Dao;
import java.util.ArrayList;
import com.foodapp.model.OrderItems;


public interface OrderItemsDAO {
	 int insert(OrderItems oi);
	    ArrayList<OrderItems> fetchAll();
	    OrderItems fetchOne(int id);
	    int updateQuantity(int id, int quantity);
	    int delete(int id);

}
