package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Product;
import com.neosoft.service.IService;

@RestController
@RequestMapping("/test01")
public class TestController {
	
	@Autowired
	private IService service;
	
	@GetMapping("/msg")
	public ResponseEntity<String> getMessage(){
		return new ResponseEntity<>("Chandan",HttpStatus.OK);
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product prod){
		Product product1=service.saveProduct(prod);
		return new ResponseEntity<Product>(product1,HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllProduct(){
		List<Product> li=service.fetchAllProduct();
		
		return new ResponseEntity<List<Product>>(li,HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id){
		
		return new ResponseEntity<Product>(service.fetchProductById(id),HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateFull")
	public ResponseEntity<?> updateFullProduct(@RequestBody Product prod){
		service.fullUpdate(prod);
		return new ResponseEntity<String> (prod.getId()+ "successfully updated",HttpStatus.OK);
	}
	@PatchMapping("/updatePartial/{price}/{id}")
	public ResponseEntity<?> updatePartialProduct(@PathVariable Double price,@PathVariable Integer id){
		service.partialUpdate(price, id);
		return new ResponseEntity<String> (id+ "successfully updated",HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteByIdProduct(@PathVariable Integer id){
		String msg=service.deleteProduct(id);
		return new ResponseEntity<String> (msg,HttpStatus.OK);
	}
 	

}
