///**
// * 
// */
//package org.skillassure.wastebox.unittest.ewaste.product;
//
///**
// * @author Raghavendra
// *
// */
//import java.util.ArrayList;
//import java.util.List;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.skillassure.wastebox.unittest.ApplicationTestConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.skillassure.wastebox.businesslayer.ewaste.productimpl.ProductService;
//import com.skillassure.wastebox.model.ewaste.product.Product;
//import com.skillassure.wastebox.restapi.ewaste.product.ProductController;
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ApplicationTestConfig.class)
//@WebAppConfiguration
//public class ProductContollerTest {
//
//	@Autowired
//	private ProductController productController;
//
//	@MockBean
//	private ProductService productService;
//
//	private MockMvc mockMvc;
//
//	private List<Product> products;
//	
//	/**
//	 * Befor test adding Mock data
//	 */
//	@Before
//	public void initProducts(){
//		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
//		products= new ArrayList<Product>();
//		Product product1= new Product(1,"Mobile","samsung","2013","IM987","8GB",1);
//		Product product2= new Product(2,"Mobile","iphone","2017","IM987","4GB",2);
//		products.add(product1);
//		products.add(product2);	
//	}
//	
//	/**
//	 * Checks whether getting all products from service or not.
//	 * testMethodName
//	 */
//	@Test
//	public void testGetProducts() throws Exception{
//		given(this.productService.getAllProducts()).willReturn(products);
//		this.mockMvc.perform(get("/api/ewaste/products"))
//		 .andExpect(status().isOk())
//         .andExpect(content().contentType("application/json"))
//         .andExpect(jsonPath("$.[0].productName").value("samsung"))
//         .andExpect(jsonPath("$.[0].productModel").value("2013"))
//         .andExpect(jsonPath("$.[1].productName").value("iphone"))
//         .andExpect(jsonPath("$.[1].productModel").value("2017"));
//	}
//	
//	/**
//	 * checks whether not found exception will return or not if product list empty.
//	 */
//	
//	@Test
//	public void testGetProductsNotFound() throws Exception{
//		products.clear();
//    	given(this.productService.getAllProducts()).willReturn(products);
//        this.mockMvc.perform(get("/api/ewaste/products/")
//        	.accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNotFound());
//	}
//	
//	/**
//	 *Checks whether product is added successfully or not.
//	 */
//	@Test
//	public void testAddProduct() throws Exception{
//		Product newProduct = products.get(0);
//    	newProduct.setId(3);
//    	newProduct.setProductName("nokia");
//    	System.out.println("Product object is:"+newProduct);
//    	ObjectMapper mapper = new ObjectMapper();
//    	String newProductAsJSON = mapper.writeValueAsString(newProduct);
//    	System.out.println("Product json  is:"+newProductAsJSON);
//    	this.mockMvc.perform(post("/api/ewaste/products")
//    		.content(newProductAsJSON).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
//    		.andExpect(status().isOk());
//    	for (Product product : products) {
//    		System.out.println(product);
//		}
//	}
//}