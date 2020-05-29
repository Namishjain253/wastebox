package com.skillassure.wastebox.businesslayer.plasticwaste.plasticdetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillassure.wastebox.model.plasticwaste.plasticdetails.PickUpPersonDetails;
import com.skillassure.wastebox.repository.plasticwaste.plasticdetails.PickUpPersonDetailsRepository;



@Service
public class PickUpPersonDetailsService {

	// Calling the PickUpPersonDetails Repository
	@Autowired
	private PickUpPersonDetailsRepository pickUpPersonDetailsRepository;

	//Getting the PickUpPersonDetails by using ID
	public Optional<PickUpPersonDetails> getPickUpPersonById(long id) {
		return pickUpPersonDetailsRepository.findById(id);
	}

	//getting the list of Request by using PickUpPersonDetails repository
	public List<PickUpPersonDetails> getAllPickUpPerson() {
		return pickUpPersonDetailsRepository.findAll();
	}
}