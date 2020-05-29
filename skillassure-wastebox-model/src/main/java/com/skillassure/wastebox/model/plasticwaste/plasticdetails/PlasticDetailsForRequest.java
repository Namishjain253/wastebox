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
@Table(name = "requestformdetails")
public class PlasticDetailsForRequest {
	// Instance Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reqId;
	private String firstName;
	private String lastName;
	private String emailId;
	private long amountOfPlastic;
	private String description;
	private String streetName;
	private String city;
	private String state;
	private long pincode;

//	 Many to One Mapping with PickUpPersonDetails
	@ManyToOne(cascade = CascadeType.ALL)
	private PickUpPersonDetails pickUpPersonDetails;

//	 One to One Mapping with coins
	@OneToOne(cascade = CascadeType.ALL)
	private Coins coin;

	// default constructor
	public PlasticDetailsForRequest() {
		super();
	}

	// Parameterized constructor
	public PlasticDetailsForRequest(long reqId, String firstName, String lastName, String emailId, long amountOfPlastic,
			String description, String streetName, String city, String state, long pincode , PickUpPersonDetails pickUpPersonDetails, Coins coin
			) {
		super();
		this.reqId = reqId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.amountOfPlastic = amountOfPlastic;
		this.description = description;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.pickUpPersonDetails = pickUpPersonDetails;
		this.coin = coin;
	}

	// setter and getters
	public long getReqId() {
		return reqId;
	}

	public void setReqId(long reqId) {
		this.reqId = reqId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getAmountOfPlastic() {
		return amountOfPlastic;
	}

	public void setAmountOfPlastic(long amountOfPlastic) {
		this.amountOfPlastic = amountOfPlastic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public PickUpPersonDetails getPickUpPersonDetails() {
		return pickUpPersonDetails;
	}

	public void setPickUpPersonDetails(PickUpPersonDetails pickUpPersonDetails) {
		this.pickUpPersonDetails = pickUpPersonDetails;
	}

	public Coins getCoin() {
		return coin;
	}

	public void setCoin(Coins coin) {
		this.coin = coin;
	}

	// To String Method
	@Override
	public String toString() {
		return "RequestDetailForPlastic [reqId=" + reqId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", amountOfPlastic=" + amountOfPlastic + ", description=" + description
				+ ", streetName=" + streetName + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", pickUpPersonDetails=" + pickUpPersonDetails + ", coin=" + coin + "]";
	}
}
