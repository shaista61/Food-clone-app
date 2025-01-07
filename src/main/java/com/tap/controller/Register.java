package com.tap.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.foodapp.DaoImpl.UserDAOImplts;
import com.foodapp.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Cpwd= req.getParameter("Cpswd");
		if(req.getParameter("pswd").equals(Cpwd)) {
			String un= Secure.encrypt(req.getParameter("username"));
			String emails= Secure.encrypt(req.getParameter("email"));
			String addr=  Secure.encrypt(req.getParameter("address"));
			String pwd= Secure.encrypt(req.getParameter("pswd"));
			User usr=new User(un,pwd,emails,addr);
			UserDAOImplts udi=new UserDAOImplts();
			if(udi.insert(usr)==1){
				resp.sendRedirect("success.jsp");
			}
			else {
				resp.sendRedirect("failure.jsp");
			}
		}
		else {
			resp.sendRedirect("PwdMisMatch.jsp");
		}
	}
}
