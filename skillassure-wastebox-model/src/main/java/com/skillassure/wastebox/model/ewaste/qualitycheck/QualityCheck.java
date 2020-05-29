/**
 * 
 */
package com.skillassure.wastebox.model.ewaste.qualitycheck;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.skillassure.wastebox.model.ewaste.product.Product;

/**
 * @author Raghavendra
 *
 */

@Entity
@Table(name = "productqualitycheck")
public class QualityCheck {

	// Instance Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String category;
	private String productName;
	private String modelYear;
	private boolean refurnished;
	
	@Column(name="isincondition")
	private boolean condition;
	
	private boolean damaged;
	private int productRating;
	private int overallRating;
	private boolean productFunction;
	private String description;

	// Mapping with product
	@OneToOne
	private Product product;

	// Default Constructor
	public QualityCheck() {
	}
	
	// Parameterized Constructor
	/**
	 * @param id
	 * @param category
	 * @param productName
	 * @param modelYear
	 * @param refurnished
	 * @param condition
	 * @param damaged
	 * @param productRating
	 * @param overallRating
	 * @param productFunction
	 * @param description
	 */
	public QualityCheck(long id, String category, String productName, String modelYear, boolean refurnished,
			boolean condition, boolean damaged, int productRating, int overallRating, boolean productFunction,
			String description) {
		super();
		this.id = id;
		this.category = category;
		this.productName = productName;
		this.modelYear = modelYear;
		this.refurnished = refurnished;
		this.condition = condition;
		this.damaged = damaged;
		this.productRating = productRating;
		this.overallRating = overallRating;
		this.productFunction = productFunction;
		this.description = description;
	}

	// Getter and Setter Methods                                                                     
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
	 * @return the modelYear
	 */
	public String getModelYear() {
		return modelYear;
	}

	/**
	 * @param modelYear the modelYear to set
	 */
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	/**
	 * @return the refurnished
	 */
	public boolean isRefurnished() {
		return refurnished;
	}

	/**
	 * @param refurnished the refurnished to set
	 */
	public void setRefurnished(boolean refurnished) {
		this.refurnished = refurnished;
	}

	/**
	 * @return the condition
	 */
	public boolean isCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	/**
	 * @return the damaged
	 */
	public boolean isDamaged() {
		return damaged;
	}

	/**
	 * @param damaged the damaged to set
	 */
	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

	/**
	 * @return the productRating
	 */
	public int getProductRating() {
		return productRating;
	}

	/**
	 * @param productRating the productRating to set
	 */
	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}

	/**
	 * @return the overallRating
	 */
	public int getOverallRating() {
		return overallRating;
	}

	/**
	 * @param overallRating the overallRating to set
	 */
	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	/**
	 * @return the productFunction
	 */
	public boolean isProductFunction() {
		return productFunction;
	}

	/**
	 * @param productFunction the productFunction to set
	 */
	public void setProductFunction(boolean productFunction) {
		this.productFunction = productFunction;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}