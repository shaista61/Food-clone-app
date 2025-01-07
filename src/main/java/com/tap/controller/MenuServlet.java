package com.tap.controller;

import java.io.IOException;
import java.util.List;

import com.foodapp.Dao.MenuDAO;
import com.foodapp.DaoImpl.MenuDAOImpl;
import com.foodapp.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String restaurantId = req.getParameter("id");
		HttpSession session = req.getSession();
		if (restaurantId != null && restaurantId.matches("\\d+")) {
		    int restaurantIdInt = Integer.parseInt(restaurantId);
		    session.setAttribute("restaurant_id", restaurantIdInt);
		    MenuDAO md = new MenuDAOImpl();
		    List<Menu> menuList=md.fetchAllDetailsBasedOnRid(restaurantIdInt);
		    //String restaurantName = md.fetchOne(restaurantIdInt);

		    if (menuList != null && !menuList.isEmpty()) {
		        
//		        HttpSession session = req.getSession();
		        //session.setAttribute("name", restaurantName);
		        session.setAttribute("menu", menuList);
		        // Redirect or forward to a page where the session data will be used
		        req.getRequestDispatcher("Menu.jsp").forward(req, resp);
		    } else {
		        // Handle case where no menu is found for the given ID
		        resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Menu not found for the given restaurant ID");
		    }
		} else {
		    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid restaurant ID");
		}
	}
}
