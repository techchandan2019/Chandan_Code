package com.neosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Product;
import com.neosoft.respository.IProductRepo;

@Service
public class TestService implements IService{
	
	@Autowired
	private IProductRepo repo;
	
	@Override
	public Product saveProduct(Product prod) {
		Product product1 = repo.save(prod);
		return product1;
	}
	@Override
	public List<Product> fetchAllProduct() {
		List<Product> li=(List<Product>) repo.findAll();
		return li;
	}
	@Override
	public Product fetchProductById(Integer id) {
		
		Optional<Product> prodOpt = repo.findById(id);
		
		return prodOpt.get();
	}
	@Override
	public Product fullUpdate(Product prod) {
		Optional<Product> OptProd = repo.findById(prod.getId());
		Product updatedProd =null;
		if(OptProd.isPresent()) {
			
			updatedProd = repo.save(prod);
		}
		return updatedProd;
	}
	@Override
	public Product partialUpdate(Double price,Integer id) {
		Optional<Product> optProd=repo.findById(id);
		Product updatedProd=null;
		if(optProd.isPresent()) {
			Product prod=optProd.get();
			prod.setPrice(price);
			updatedProd=repo.save(prod);
		}
		return updatedProd;
	}
	@Override
	public String deleteProduct(Integer id) {
		repo.deleteById(id);
		return id+" successfully deleted";
	}

}
