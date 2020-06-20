package com.capgemini.empwebapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dto.EmployeeBean;
import com.capgemini.empwebapp.factory.EmployeeDAOFactory;

@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session==null) {
			req.getRequestDispatcher("login.html").forward(req, resp);
		}else {
			Object object=session.getAttribute("bean");
			EmployeeBean bean=(EmployeeBean)object;
			
			String password=req.getParameter("password");

			EmployeeDAO dao=EmployeeDAOFactory.getEmployeeDAO();
			dao.changePassword(bean.getId(), password);
			req.getRequestDispatcher("home").forward(req, resp);
		}
	}
}
