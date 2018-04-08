package com.microservicos.gabriel.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservicos.gabriel.model.ProductDetail;

@Repository
public interface ProductDetailRepository extends CrudRepository<ProductDetail, Serializable> {

}
