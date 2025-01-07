package com.tap.servlets;
import java.io.IOException;

import com.foodapp.model.User;

import com.foodapp.DaoImpl.UserDAOImplts;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String un= req.getParameter("username");
		String pwd= req.getParameter("pswd");
		String Cpwd= req.getParameter("Cpswd");
		String emails= req.getParameter("email");
		String addr= req.getParameter("address");
		if(pwd.equals(Cpwd)) {
			User usr=new User(un,pwd,emails,addr);
			UserDAOImplts udi=new UserDAOImplts();
			if(udi.insert(usr)==1){
				resp.sendRedirect("success.html");
			}
			else {
				resp.sendRedirect("failure.html");
			}
		}
		else {
			resp.sendRedirect("PwdMisMatch.html");
		}
	}
}
