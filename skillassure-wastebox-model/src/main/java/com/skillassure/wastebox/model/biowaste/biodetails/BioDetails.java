package com.skillassure.wastebox.model.biowaste.biodetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bagdetails")
public class BioDetails {
/*
 * Declaration Of variables
 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long hospitalid;
	private String hospitalname;
	private long redbag;
	private long bluebag;
	private long whitebag;
	private long yellowbag;

//	@ManyToOne
//	private User user;
/*
 *  Default Constructor
 */
	public BioDetails() {
		super();
	}
/*
 * Parameterized Constructor
 */
	public BioDetails(long id, long hospitalid, String hospitalname,long redbag, long bluebag, long whitebag, long yellowbag) {
	
		this.id = id;
		this.hospitalid = hospitalid;
		this.redbag = redbag;
		this.bluebag = bluebag;
		this.whitebag = whitebag;
		this.yellowbag = yellowbag;
		this.hospitalname=hospitalname;
		//this.user = user;
	}
/*
 * Getter and Setter Methods
 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(long hospitalid) {
		this.hospitalid = hospitalid;
	}

	public long getRedbag() {
		return redbag;
	}

	public void setRedbag(long redbag) {
		this.redbag = redbag;
	}

	public long getBluebag() {
		return bluebag;
	}

	public void setBluebag(long bluebag) {
		this.bluebag = bluebag;
	}

	public long getWhitebag() {
		return whitebag;
	}

	public void setWhitebag(long whitebag) {
		this.whitebag = whitebag;
	}

	public long getYellowbag() {
		return yellowbag;
	}

	public void setYellowbag(long yellowbag) {
		this.yellowbag = yellowbag;
	}

	public String getHospitalname() {
		return hospitalname;
	}

	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
}
