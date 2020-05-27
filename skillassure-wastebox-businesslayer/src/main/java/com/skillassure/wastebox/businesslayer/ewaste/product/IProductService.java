package com.skillassure.wastebox.businesslayer.ewaste.product;

import java.util.List;

import org.springframework.stereotype.Component;

import com.skillassure.wastebox.model.ewaste.product.Product;


@Component
public interface IProductService {

	public List<Product> getAllProducts() ;
}
