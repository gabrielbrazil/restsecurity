package com.microservicos.gabriel.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservicos.gabriel.model.ProductDetail;
import com.microservicos.gabriel.repository.ProductDetailRepository;
import com.microservicos.gabriel.validators.ProductDetailValidator;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductDetailRepository repository;
	private final ProductDetailValidator validator;
	
	@Autowired
	public ProductController(ProductDetailRepository repository,ProductDetailValidator validator) {
		this.repository = repository;
		this.validator = validator;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		binder.addValidators(validator);
	} 
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ProductDetail> findAll(){
		ProductDetail productDetail = new ProductDetail();
		productDetail.setProductId("1");
		 productDetail.setInventoryId("1");
		 productDetail.setLongDescription("Item");
		 productDetail.setProductName("livro");
		return Arrays.asList(new ProductDetail[]{productDetail});
//		return repository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProductDetail create(@RequestBody @Valid ProductDetail detail){
		return repository.save(detail);
	}
	
}
