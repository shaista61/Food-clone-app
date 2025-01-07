package com.tap.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.Dao.RestaurantDAO;
import com.foodapp.DaoImpl.RestaurantDAOImp;
import com.foodapp.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/GetAllRestaurant")
public class GetAllRestaurant extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		RestaurantDAO rdi=new RestaurantDAOImp();
		List<Restaurant> rList=rdi.fetchAll();
		session.setAttribute("RestaurantList", rList);
		req.getRequestDispatcher("Home.jsp").forward(req, resp);
	}
}
