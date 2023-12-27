package com.neosoft.service;

import java.util.List;

import com.neosoft.model.Product;

public interface IService {
	
	public Product saveProduct(Product prod);
	public List<Product> fetchAllProduct();
	public Product fetchProductById(Integer id);
	public Product fullUpdate(Product prod);
	public Product partialUpdate(Double price,Integer id);
	public String deleteProduct(Integer id);

}
