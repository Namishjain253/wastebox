package com.skillassure.wastebox.restapi.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillassure.wastebox.authentication.response.JwtResponse;
import com.skillassure.wastebox.authentication.response.MessageResponse;
import com.skillassure.wastebox.authentication.security.jwt.JwtUtils;
import com.skillassure.wastebox.authentication.services.UserDetailsImpl;
import com.skillassure.wastebox.dto.user.Login;
import com.skillassure.wastebox.dto.user.SignupRequest;
import com.skillassure.wastebox.model.user.User;
import com.skillassure.wastebox.model.user.UserRole;
import com.skillassure.wastebox.repository.user.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository service;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody Login loginRequest) throws Exception {

		Authentication authentication;

		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		return ResponseEntity
				.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (service.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Username is already taken!"));
		}

		if (service.existsByEmail(signUpRequest.getEmail())) {	
			return ResponseEntity.badRequest().body(new MessageResponse("Email is already in use!"));
		}
		
		long mobile = 0;
		String profileimage = "";
		String status = "Active";		
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String systemDate = dateFormat.format(date);
		Date registereddate = null;
		
		try {
			registereddate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(systemDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		signUpRequest.setMobile(mobile);
		signUpRequest.setProfileimage(profileimage);
		signUpRequest.setRegistereddate(registereddate);
		signUpRequest.setStatus(status);
		
		for (UserRole role : UserRole.values()) {
			if (role.name().equalsIgnoreCase("ROLE_CUSTOMER")) {
				signUpRequest.setRole(role.name());
			}
		}
			
		User user =  new User(0L, signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getFullname(), signUpRequest.getMobile(), signUpRequest.getRole(), signUpRequest.getRegistereddate(),
				signUpRequest.getProfileimage(), signUpRequest.getStatus());
		service.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
