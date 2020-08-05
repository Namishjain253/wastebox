package com.skillassure.wastebox.restapi.plasticwaste.plasticdetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillassure.wastebox.businesslayer.plasticwaste.plasticdetails.PickUpPersonDetailsService;
import com.skillassure.wastebox.model.plasticwaste.plasticdetails.PickUpPersonDetails;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class PickUpPersonDetailsController 
{
	//calling the service of PickUpPersonDetailsServiceImpl
	@Autowired
	PickUpPersonDetailsService service ;
	
	//feching the pickup details by using id
	@RequestMapping(value = "/pickupdetails/{id}")
	public ResponseEntity<Optional<PickUpPersonDetails>> getPickUpDetailsById(@PathVariable(value = "id") long id){
		Optional<PickUpPersonDetails> pickupdetails = service.getPickUpPersonById(id);
		return ResponseEntity.ok().body(pickupdetails);
	}
	
	//getting all the pickUpPesons Details
	@RequestMapping(value = "/pickupdetails")
	public List<PickUpPersonDetails> getProducts() {
		return service.getAllPickUpPerson();
	}
}
