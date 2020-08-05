package com.skillassure.wastebox.businesslayer.ewaste.product;

/**
 * @author Raghavendra
 *
 */

import java.util.List;

import org.springframework.stereotype.Component;

import com.skillassure.wastebox.businesslayer.ewaste.exception.ProductNotFoundException;
import com.skillassure.wastebox.model.ewaste.product.Product;


@Component
public interface IProductService {

	/**
	 * @return get all products
	 */
	public List<Product> getAllProducts();
	
	/**
	 * 
	 * @param id
	 * @return product by ID
	 * @throws ProductNotFoundException
	 */
	public Product getProductById(long id) throws ProductNotFoundException;

	/**
	 * 
	 * @param product
	 * saves product into repository
	 */
	public Product saveProduct(Product product);

	/**
	 * deletes product from repository
	 * @param product
	 */
	public void delete(Product product);

	/**
	 * 
	 * @param id
	 * @param product
	 * @return updated product
	 * @throws ProductNotFoundException
	 */
	public Product updateProduct(Long id, Product product) throws ProductNotFoundException;
}
