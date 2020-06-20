package com.capgemini.empwebapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dto.EmployeeBean;
import com.capgemini.empwebapp.factory.EmployeeDAOFactory;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");

		EmployeeBean bean=new EmployeeBean();
		bean.setName(name);
		bean.setEmail(email);
		bean.setPassword(password);

		EmployeeDAO dao=EmployeeDAOFactory.getEmployeeDAO();
		boolean check=dao.register(bean);

		if(check) {
			req.getRequestDispatcher("login.html").forward(req, resp);

		}else {
			req.getRequestDispatcher("register.html").forward(req, resp);
		}
	}
}
