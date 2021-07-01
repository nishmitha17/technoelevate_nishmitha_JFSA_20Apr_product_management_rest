package com.te.productmanagementrest.DAO;

import java.util.List;

import com.te.productmanagementrest.beans.ProductBean;



public interface ProductDAO {

	public boolean deleteProductData(int id);

	public boolean addProduct(ProductBean productInfoBean);

	public boolean updateRecord(ProductBean productInfoBean);

	public List<ProductBean> getAllProduct();

}
