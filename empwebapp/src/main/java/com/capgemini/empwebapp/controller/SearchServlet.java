package com.capgemini.empwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dto.EmployeeBean;
import com.capgemini.empwebapp.factory.EmployeeDAOFactory;

@WebServlet("/search")
public class SearchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if(session==null) {
			req.getRequestDispatcher("login.html").forward(req, resp);
		}else {
		
			String name=req.getParameter("name");
			if(name!=null) {
				EmployeeDAO dao=EmployeeDAOFactory.getEmployeeDAO();
				List<EmployeeBean> beans=dao.search(name);
				req.setAttribute("beans", beans);
				req.setAttribute("name", name);
		
			req.getRequestDispatcher("search.jsp").forward(req, resp);

		}
	}
}
