package com.te.productmanagementrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.productmanagementrest.DAO.ProductDAO;
import com.te.productmanagementrest.beans.ProductBean;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired(required = false)
	ProductDAO dao;

	@Override
	public boolean deleteProductData(int id) {
		return dao.deleteProductData(id);
	}

	@Override
	public boolean addProduct(ProductBean productInfoBean) {
		return dao.addProduct(productInfoBean);
	}

	@Override
	public boolean updateRecord(ProductBean productInfoBean) {
		return dao.updateRecord(productInfoBean);
	}

	@Override
	public List<ProductBean> getAllProduct() {
		return dao.getAllProduct();
	}
}
