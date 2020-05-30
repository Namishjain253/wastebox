package com.skillassure.wastebox.model.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

//	@NotBlank
	@Size(max = 20)
	private String fullname;

	private long mobile;

//	@NotBlank
//	@Size(max = 10)
	private String role;

	@Temporal(TemporalType.DATE)
	private Date registereddate;

//	@NotBlank
	@Size(max = 120)
	private String profileimage;

//	@NotBlank
	@Size(max = 10)
	private String status;

	public User() {
	}

	/**
	 * @param username
	 * @param email
	 * @param password
	 */
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	/**
	 * @param id
	 * @param username
	 * @param email
	 * @param password
	 * @param fullname
	 * @param mobile
	 * @param type
	 * @param registereddate
	 * @param profileimage
	 * @param status
	 */
	public User(Long id, String username, String email, String password, String fullname, long mobile, String role,
			Date registereddate, String profileimage, String status) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.mobile = mobile;
		this.role = role;
		this.registereddate = registereddate;
		this.profileimage = profileimage;
		this.status = status;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getType() {
		return role;
	}

	public void setType(String type) {
		this.role = type;
	}

	public Date getRegistereddate() {
		return registereddate;
	}

	public void setRegistereddate(Date registereddate) {
		this.registereddate = registereddate;
	}

	public String getProfileimage() {
		return profileimage;
	}

	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}