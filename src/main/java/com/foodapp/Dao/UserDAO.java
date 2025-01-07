package com.foodapp.Dao;

import java.util.List;

import com.foodapp.model.User;

public interface UserDAO {
	int insert(User u);
	User fetch(String email);
}
