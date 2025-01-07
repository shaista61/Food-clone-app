package com.tap.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.foodapp.Dao.MenuDAO;
import com.foodapp.model.CartItem;
import com.foodapp.model.Menu;
import com.foodapp.DaoImpl.MenuDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession();
	    Cart cart = (Cart) session.getAttribute("cart");
	    if (cart == null) {
	        cart = new Cart();
	        session.setAttribute("cart", cart);
	    }

	    String action = req.getParameter("action");
	    int menuId = Integer.parseInt(req.getParameter("menuId"));
	    
	    MenuDAO mdi=new MenuDAOImpl();

	    if ("add".equals(action)) {
	        int quantity = Integer.parseInt(req.getParameter("quantity"));
	        Menu menuItem = mdi.fetchOne(menuId);
	        if (menuItem != null) {
	            CartItem cartItem = new CartItem(menuItem.getName(),menuItem.getMenuId(), menuItem.getRestaurantId(), menuItem.getPrice(), quantity,menuItem.getImagePath());
	            cart.addToCart(cartItem);
	        }
	    }
	    else if("update".equals(action)) {
	    	int quantity=Integer.parseInt(req.getParameter("quantity"));
	    	cart.updateCart(menuId, quantity);
	    }
	    else if("remove".equals(action)) {
	    	cart.removeFromCart(menuId);
	    }

	    resp.sendRedirect("Cart.jsp");
	}

}
