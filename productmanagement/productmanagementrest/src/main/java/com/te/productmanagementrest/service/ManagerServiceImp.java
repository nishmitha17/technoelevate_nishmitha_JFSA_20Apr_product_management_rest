package com.te.productmanagementrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.productmanagementrest.DAO.ManagerDAO;
import com.te.productmanagementrest.beans.ManagerBean;


public class ManagerServiceImp implements ManagerService {
	
	@Autowired(required = false)
	ManagerDAO dao;
	
	@Override
	public ManagerBean varification(int id, String password) {
		if (id <= 0) {
			return null;
		}
		return dao.varification(id,password);
	}

}
