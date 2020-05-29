/**
 * 
 */
package com.skillassure.wastebox.model.ewaste.product;

/**
 * @author Raghavendra
 *
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productdetails")
public class Product {

	// Instance Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String category;
	private String productName;
	private String productModel;
	private String imei;
	private String ram_ltrs_kgs;
	private int quantity;

	// Default Constructor
	public Product() {	}

	// Parameterized Constructor
	/*
	 * @param id
	 * @param category
	 * @param productName
	 * @param productModel
	 * @param iMEI
	 * @param rAM_ltrs_kgs
	 * @param quantity
	 */
	public Product(long id, String category, String productName, String productModel, String imei, String ram_ltrs_kgs ,
			int quantity) {
		super();
		this.id = id;
		this.category = category;
		this.productName = productName;
		this.productModel = productModel;
		this.imei = imei;
		this.ram_ltrs_kgs = ram_ltrs_kgs;
		this.quantity = quantity;
	}

	
	//Getter and Setter Methods
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productModel
	 */
	public String getProductModel() {
		return productModel;
	}

	/**
	 * @param productModel the productModel to set
	 */
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * @return the ram_ltrs_kgs
	 */
	public String getRam_ltrs_kgs() {
		return ram_ltrs_kgs;
	}

	/**
	 * @param ram_ltrs_kgs the ram_ltrs_kgs to set
	 */
	public void setRam_ltrs_kgs(String ram_ltrs_kgs) {
		this.ram_ltrs_kgs = ram_ltrs_kgs;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}