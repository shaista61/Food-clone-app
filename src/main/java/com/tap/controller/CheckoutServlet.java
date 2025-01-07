package com.tap.controller;

import java.io.IOException;

import java.sql.Timestamp;
import java.util.Enumeration;

import com.foodapp.Dao.OrderHistoryDAO;
import com.foodapp.DaoImpl.OrderItemsImpl;
import com.foodapp.DaoImpl.OrdersDAOImpl;
import com.foodapp.model.CartItem;
import com.foodapp.model.OrderHistory;
import com.foodapp.model.OrderItems;
import com.foodapp.model.Orders;
import com.foodapp.model.User;

import com.foodapp.DaoImpl.OrderHistoryDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("CheckoutServlet invoked");
		HttpSession session=req.getSession();
//		Enumeration<String> attributeNames = session.getAttributeNames();
//
//		System.out.println("Attributes in session:");
//		while (attributeNames.hasMoreElements()) {
//		    String attributeName = attributeNames.nextElement();
//		    Object attributeValue = session.getAttribute(attributeName);
//		    System.out.println(attributeName + " = " + attributeValue);
//		}
		Cart cart=(Cart)session.getAttribute("cart");
		if (cart == null) {
		    System.out.println("Cart is null. Redirecting to Cart.jsp");
		    resp.sendRedirect("Cart.jsp");
		    return;
		}
		User user=(User)session.getAttribute("loggedUser");
		if (user == null) {
		    System.out.println("User is null. Redirecting to login page");
		    resp.sendRedirect("Login.jsp");
		    return;
		}
	    Object restaurantIdObj = session.getAttribute("restaurant_id");
        int restaurantId = 0;
        if (restaurantIdObj != null) {
            restaurantId = Integer.parseInt(restaurantIdObj.toString());
        }
        //orders
		if(cart!=null && user!=null && !cart.getCartItems().isEmpty()) {
			int uid=user.getUid();
			System.out.println("Valid cart and user found");
			String paymentmethod=req.getParameter("paymentMethod");
			Orders order=new Orders();
			order.setUserId(uid);
			order.setRestaurantId(restaurantId);
			order.setPaymentMode(paymentmethod);
			order.setStatus("pending");
			order.setOrderDate(new Timestamp(0));
			
			double totalAmount=0;
			for(CartItem item:cart.getCartItems().values()){
				totalAmount+=item.getPrice() * item.getQuantity();
			}
			order.setTotalAmount(totalAmount);
			OrdersDAOImpl orderDAO=new OrdersDAOImpl();
			if(orderDAO.insert(order)==-1) {
				resp.sendRedirect("Checkout.jsp");
				return;
				}
			////orderItems
			int orderId=orderDAO.fetchOne(restaurantId).getOrdersId();
			for (CartItem item : cart.getCartItems().values()) {
				OrderItems orderItem = new OrderItems(); 
				orderItem.setMenuId(item.getItemId());
				orderItem.setQuantity(item.getQuantity());
				orderItem.setTotalItem(item.getPrice() * item.getQuantity());
				OrderItemsImpl orderItemsDAO=new OrderItemsImpl();
				orderItemsDAO.insert(orderItem);
			}
			//orderHistory
			String status="Delivered";
			OrderHistory orderHistory=new OrderHistory(orderId, uid, totalAmount, status);
			
			OrderHistoryDAO orderHistoryDaoImpl=new OrderHistoryDAOImpl();
			orderHistoryDaoImpl.insert(orderHistory);
			
			cart.clearCart();
			
			session.removeAttribute("cart");
			System.out.println("Order processed successfully");
			resp.sendRedirect("OrderConfirmation.jsp"); 
		}
		else {
			System.out.println("Cart is null or empty, or user is null");
			resp.sendRedirect("Cart.jsp");
		}
	}
}


