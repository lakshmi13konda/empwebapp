package com.capgemini.empwebapp.dao;

import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBean;

public interface EmployeeDAO {
	boolean register(EmployeeBean bean);
	List<EmployeeBean> search(String name);
	boolean changePassword(int id,String password);
	EmployeeBean auth(String email,String password);

}
