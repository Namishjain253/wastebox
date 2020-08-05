package com.skillassure.wastebox.model.plasticwaste.plasticdetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coins")
public class Coins {

	//Instance variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long coins;
	
	//Default variables
	public Coins() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Parametrized variables
	public Coins(long id, long coins) {
		super();
		this.id = id;
		this.coins = coins;
	}
	
	//Setters and getters 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCoins() {
		return coins;
	}
	public void setCoins(long coins) {
		this.coins = coins;
	}
	
	//To string methods
	@Override
	public String toString() {
		return "Coins [id=" + id + ", coins=" + coins + "]";
	}
	
	

}
