package com.skillassure.wastebox.model.plasticwaste.plasticdetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pickUpPersonDetails")
public class PickUpPersonDetails {
	
	//Instance variables
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String emailId;
	private int age;
	private String language;
	private long phoneNumber;
	
	//One to one mapping with RequestDetailForPlastic
	@OneToOne(cascade = CascadeType.ALL)
	private PlasticDetailsForRequest requestDetailForPlastic;
	
	//default constructor
	public PickUpPersonDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//parametrized constructor
	public PickUpPersonDetails(long pickupPersonId, String name, String emailId, int age, String language,
			long phoneNumber) {
		super();
		this.id = pickupPersonId;
		this.name = name;
		this.emailId = emailId;
		this.age = age;
		this.language = language;
		this.phoneNumber = phoneNumber;
	}
	
	//setter and getters
	public String getName() {
		return name;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PlasticDetailsForRequest getRequestDetailForPlastic() {
		return requestDetailForPlastic;
	}

	public void setRequestDetailForPlastic(PlasticDetailsForRequest requestDetailForPlastic) {
		this.requestDetailForPlastic = requestDetailForPlastic;
	}
}