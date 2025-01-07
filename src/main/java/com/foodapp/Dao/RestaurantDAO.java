package com.foodapp.Dao;

import java.util.ArrayList;
import com.foodapp.model.Restaurant;

public interface RestaurantDAO {
	    int insert(Restaurant r);
	    ArrayList<Restaurant> fetchAll();
	    Restaurant fetchOne(int id);
	    int update(int id, String address);
	    int delete(int id);
	}

