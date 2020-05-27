package com.skillassure.wastebox.restapi.ewaste.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillassure.wastebox.businesslayer.ewaste.productimpl.ProductService;
import com.skillassure.wastebox.model.ewaste.product.Product;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	
	@Autowired
	ProductService service ;

	/**
	 * 
	 * getProducts method will return list of products from service 
	 */
	@RequestMapping(value = "/products")
	public List<Product> getProducts() {
		logger.debug("request received for get all products");
		return service.getAllProducts();
	}
	


}
