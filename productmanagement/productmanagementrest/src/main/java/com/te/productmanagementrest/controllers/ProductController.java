package com.te.productmanagementrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.productmanagementrest.beans.ProductBean;
import com.te.productmanagementrest.beans.ProductResponse;
import com.te.productmanagementrest.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired(required = false)
	private ProductService service;
	
	@PostMapping(path = "/addProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ProductResponse addProduct(@RequestBody ProductBean infoBean) {
		ProductResponse response = new ProductResponse();
		
		System.out.println("hello");
		if (service.addProduct(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data inserted Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Could not be inserted");
		}
		return response;
	}

	@PutMapping(path = "/updateProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ProductResponse updateProduct(@RequestBody ProductBean infoBean) {
		ProductResponse response = new ProductResponse();

		if (service.updateRecord(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Updated Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Could not be updated");
		}
		return response;
	}

	@DeleteMapping(path = "/deleteRecord/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ProductResponse deleteRecord(@PathVariable int id) {
		ProductResponse response = new ProductResponse();

		if (service.deleteProductData(id)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Delete Sucessfully");
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Not Exist");
		}
		return response;

	}//

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ProductResponse getAllRecord() {
		ProductResponse response = new ProductResponse();
		List<ProductBean> productBeans = service.getAllProduct();
		if (productBeans != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Found Sucessfully");
			response.setProductBeans(productBeans);
		} else {
			response.setStatusCode(500);
			response.setMsg("failure");
			response.setDescription("Data Not Exist");
		}
		return response;
	}

}
