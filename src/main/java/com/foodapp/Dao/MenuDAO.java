package com.foodapp.Dao;
import com.foodapp.model.Menu;
import java.util.ArrayList;
import java.util.List;

public interface MenuDAO {
	int insert(Menu menuItem);
    ArrayList<Menu> fetchAll();
    Menu fetchOne(int menuId);
    int updateAvailability(int menuId, int isAvailable);
    int delete(int menuId);
    List<Menu> fetchAllDetailsBasedOnRid(int restaurant_Id);
}
