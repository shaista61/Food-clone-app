package com.tap.controller;

import java.io.IOException;

import java.util.List;

import com.foodapp.Dao.UserDAO;
import com.foodapp.DaoImpl.UserDAOImplts;
import com.foodapp.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String email=Secure.encrypt(req.getParameter("email"));
		String pswd=Secure.encrypt(req.getParameter("password"));
		UserDAO udo=new UserDAOImplts();
		User ul=udo.fetch(email);
		if(ul!=null) {
			if(email.equals(ul.getEmail())&&pswd.equals(ul.getPswd())) {
				session.setAttribute("userName",Secure.decrypt(ul.getName()));
	            session.setAttribute("userEmail",Secure.decrypt( ul.getEmail()));
	            session.setAttribute("userAddress", Secure.decrypt(ul.getAddress()));
	            User loggedUser = new User(ul.getUid(), Secure.decrypt(ul.getName()), pswd, Secure.decrypt( ul.getEmail()), Secure.decrypt(ul.getAddress()));
                session.setAttribute("loggedUser", loggedUser);
	            resp.sendRedirect("GetAllRestaurant");
			}
			else 
			{
				resp.sendRedirect("failure.jsp");
			}
		}
		
		else {
			resp.getWriter().println("NO USER");
		}
		
	}
	}