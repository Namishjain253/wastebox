package com.skillassure.wastebox.businesslayer.ewaste.productimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.skillassure.wastebox.businesslayer.ewaste.product.IProductService;
import com.skillassure.wastebox.model.ewaste.product.Product;
import com.skillassure.wastebox.repository.ewaste.products.ProductRepository;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;

	/**
	 * getAllProducts menthod will return all the products from repository.
	 */
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	

}
