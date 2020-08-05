package com.skillassure.wastebox.restapi.ewaste.product;

/**
 * @author Raghavendra
 *
 */

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skillassure.wastebox.businesslayer.ewaste.exception.ProductNotFoundException;
import com.skillassure.wastebox.businesslayer.ewaste.productimpl.ProductService;
import com.skillassure.wastebox.model.ewaste.product.Product;

@RestController
@RequestMapping("/api/ewaste")
@CrossOrigin
@PropertySource(ignoreResourceNotFound = true, value = "classpath:errormessage.properties")
public class ProductController {
	
	@Value("${ProductsNotFound}")
	private String errorMessage1;
	
	@Value("${ProductNotFound}")
	private String errorMessage2;
	
	@Autowired
	ProductService service;

	/**
	 * Requesting to getProducts from service
	 * @return All products
	 * @throws ProductNotFoundException 
	 */
	@RequestMapping(value = "/products")
	public ResponseEntity<List<Product>> getProducts() throws ProductNotFoundException {
		List<Product> products= service.getAllProducts();
		if(products.isEmpty())
		{
			throw new ProductNotFoundException(errorMessage1);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	/**
	 * Requesting to delete the product based on the id from service
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") long id) throws Exception {
		Product product = service.getProductById(id);
		service.delete(product);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	/**
	 * Requesting to get product by id from service
	 * @param id
	 * @return product
	 * @throws ProductNotFoundException
	 */
	@RequestMapping(value = "/products/{id}")
	public ResponseEntity<Product> getProductsById(@PathVariable(value = "id") long id) throws ProductNotFoundException {
		if (id < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Product product = null;
		product = service.getProductById(id);
		if (product == null) {
			throw new ProductNotFoundException(errorMessage2);
		}
		return ResponseEntity.ok().body(product);
	}

	/**
	 * Requesting to create product in database through service
	 * @param product
	 * saves product in repository
	 */
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
		Product addedproduct = service.saveProduct(product);
		return new ResponseEntity<Product>(addedproduct, HttpStatus.CREATED);
	}

	/**
	 * Requesting to update product in database through service
	 * @param id
	 * @param product details for updating
	 * @return update product
	 * @throws ProductNotFoundException
	 */
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long id, @Valid @RequestBody Product product)
			throws ProductNotFoundException {
		Product updatedProduct = service.updateProduct(id, product);
		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
	}
}
