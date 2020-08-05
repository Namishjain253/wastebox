package com.skillassure.wastebox.dto.user;

import java.util.Date;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Range;
 
public class SignupRequest {
   
    @Size(min = 3, max = 20)
    private String username;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 40)
    private String password;
  
 
	@Size(max = 20)
	private String fullname;

	private Long mobile;

	
//	@Size(max = 10)
	private String role;

	private Date registereddate;

	
	@Size(max = 120)
	private String profileimage;

	@Size(max = 10)
	private String status;
    
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
    
    public String getRole() {
      return this.role;
    }
    
    public void setRole(String role) {
      this.role = role;
    }
}
