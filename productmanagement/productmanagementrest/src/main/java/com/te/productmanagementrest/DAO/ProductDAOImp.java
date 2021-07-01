package com.te.productmanagementrest.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.productmanagementrest.beans.ProductBean;

@Repository
public class ProductDAOImp implements ProductDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPeristenceUnit");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	@Override
	public boolean deleteProductData(int id) {
		boolean isDeleted = false;
		try {
			et.begin();
			ProductBean bean = em.find(ProductBean.class, id);
			em.remove(bean);
			et.commit();
			isDeleted = true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}

		return isDeleted;
	}

	@Override
	public boolean addProduct(ProductBean productInfoBean) {
		boolean isInserted = false;
		try {
			et.begin();
			em.persist(productInfoBean);
			et.commit();
			isInserted=true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return isInserted;
	}

	@Override
	public boolean updateRecord(ProductBean productInfoBean) {
		boolean isUpdated = false;
		try {
			et.begin();
			ProductBean actualInfo = em.find(ProductBean.class, productInfoBean.getPid());

			if (productInfoBean.getPname() != null && productInfoBean.getPname() != "") {
				actualInfo.setPname(productInfoBean.getPname());
			}
			if (productInfoBean.getMfg() != null) {
				actualInfo.setMfg(productInfoBean.getMfg());

			}
			if (productInfoBean.getExp() != null) {
				actualInfo.setExp(productInfoBean.getExp());
			}
			if (productInfoBean.getPrice() > 0) {
				actualInfo.setPrice(productInfoBean.getPrice());
			}
			if (productInfoBean.getQunatity() > 0) {
				actualInfo.setQunatity(productInfoBean.getQunatity());
			}

			et.commit();
			isUpdated = true;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public List<ProductBean> getAllProduct() {
		Query query=em.createQuery("from ProductBean");
		ArrayList<ProductBean> list=new ArrayList<ProductBean>();
		try {
			list=(ArrayList<ProductBean>) query.getResultList();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			list=null;
		}
		return list;
	}

}
