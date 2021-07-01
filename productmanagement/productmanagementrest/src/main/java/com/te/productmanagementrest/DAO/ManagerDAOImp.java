package com.te.productmanagementrest.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.productmanagementrest.beans.ManagerBean;
import com.te.productmanagementrest.customexception.AtrangiException;


public class ManagerDAOImp implements ManagerDAO {

	@Override
	public ManagerBean varification(int id, String Password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
		EntityManager em = emf.createEntityManager();
		ManagerBean bean = em.find(ManagerBean.class, id);

		if (bean != null) {
			if (bean.getPassword().equals(Password)) {
				return bean;
			} else {
				throw new AtrangiException("password is worng");
			}
		}else {
			throw new AtrangiException("id is wrong");
		}
	}

}
