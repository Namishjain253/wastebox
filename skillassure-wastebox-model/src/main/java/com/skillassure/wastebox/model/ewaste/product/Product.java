package com.skillassure.wastebox.model.ewaste.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "productdetails")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String type;
	private String brand;
	private String model;
	private String imeino;
	private String description;
	private String picture;
	private boolean damages;

	// Default Constructor
	public Product() {
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param id the id
	 * @param type the type
	 * @param brand the brand
	 * @param model the model
	 * @param imeino the imeino
	 * @param description the description
	 * @param picture the picture
	 * @param damages the damages
	 */
	// Parameterized Constructor
	public Product(long id, String type, String brand, String model, String imeino, String description, String picture,
			boolean damages) {
		super();
		this.id = id;
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.imeino = imeino;
		this.description = description;
		this.picture = picture;
		this.damages = damages;
	}

	// Getter and Setter Methods
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getImeino() {
		return imeino;
	}

	public void setImeino(String imeino) {
		this.imeino = imeino;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public boolean isDamages() {
		return damages;
	}

	public void setDamages(boolean damages) {
		this.damages = damages;
	}

}
