package com.skillassure.wastebox.businesslayer.ewaste.productimpl;

/**
 * @author Raghavendra
 *
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillassure.wastebox.businesslayer.ewaste.exception.ProductNotFoundException;
import com.skillassure.wastebox.businesslayer.ewaste.product.IProductService;
import com.skillassure.wastebox.model.ewaste.product.Product;
import com.skillassure.wastebox.repository.ewaste.products.ProductRepository;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;

	/**
	 * getAllProducts method will return all the products from repository.
	 */
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	/**
	 * getAllProductByID method will return all the product based on ID from repository.
	 */
	@Override
	public Product getProductById(long id) throws ProductNotFoundException {
		return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found on :: " + id));
	}

	/**
	 * saveProduct method will save product into repository.
	 */
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	/**
	 * deleteProduct method will delete the product from repository.
	 */
	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	/**
	 * updateProduct method will update the product based on ID in repository.
	 */
	@Override
	public Product updateProduct(Long id, Product productDetails) throws ProductNotFoundException {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found on :: " + id));

		product.setCategory(productDetails.getCategory());
		product.setProductName(productDetails.getProductName());
		product.setProductModel(productDetails.getProductModel());
		product.setImei(productDetails.getImei());
		product.setRam_ltrs_kgs(productDetails.getRam_ltrs_kgs());
		product.setQuantity(productDetails.getQuantity());

		final Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}
}
