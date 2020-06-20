package com.capgemini.empwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.empwebapp.dto.EmployeeBean;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
	
	HttpSession session=req.getSession(false);
	if(session==null) {
		req.getRequestDispatcher("login.html").forward(req, resp);
	}else {
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
