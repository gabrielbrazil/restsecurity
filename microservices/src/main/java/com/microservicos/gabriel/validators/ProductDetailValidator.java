package com.microservicos.gabriel.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.microservicos.gabriel.model.ProductDetail;
import com.microservicos.gabriel.repository.ProductDetailRepository;

@Component
public class ProductDetailValidator implements Validator {

	private final ProductDetailRepository repository;
	
	@Autowired
	public ProductDetailValidator(ProductDetailRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ProductDetail.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		ProductDetail productDetail = (ProductDetail) target;
		if(productDetail.getInventoryId() == null){
			error.rejectValue("inventoryid","inventory.id.invalid", "ID de Estoque inválido");
		}
		
	}

}
