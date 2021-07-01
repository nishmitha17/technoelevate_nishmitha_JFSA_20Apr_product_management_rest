package com.te.productmanagementrest.service;

import java.util.List;

import com.te.productmanagementrest.beans.ProductBean;

public interface ProductService {
	
	public boolean deleteProductData(int id);

	public boolean addProduct(ProductBean productInfoBean);

	public boolean updateRecord(ProductBean productInfoBean);

	public List<ProductBean> getAllProduct();

}
