package com.skillassure.wastebox.restapi.biowaste.biodeatils;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skillassure.wastebox.authentication.response.MessageResponse;
import com.skillassure.wastebox.businesslayer.biowaste.biodetails.BioDetailsService;
import com.skillassure.wastebox.exception.BagNotFoundException;
import com.skillassure.wastebox.model.biowaste.biodetails.BioDetails;
/*
 * Creation of Controller for Bio Details
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bio")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:errormessage.properties")
public class BioDetailsController {

	@Value("${BagNotFound}")
	 private String errorMessage;
	@Autowired
	public BioDetailsService service;
	/*
	 * Method to add bag details
	 */
	@RequestMapping(value = "/addBag", method = RequestMethod.POST)
	public ResponseEntity<?> createBag(@RequestBody BioDetails bioDetails) {
		service.addbag(bioDetails);
		return ResponseEntity.ok(new MessageResponse("Bag Details Added successfully!"));
	}
	/*
	 * Method to get the details of bag by id
	 */
	@RequestMapping(value = "/getBagDetails/{id}")
 	public ResponseEntity<Optional<BioDetails>> getBagById(@PathVariable(value = "id")long id){
 		Optional<BioDetails> bioDetails = service.getBagById(id);
 		return ResponseEntity.ok().body(bioDetails);
 	}
	/*
	 * method to get list of all bags
	 */
	@RequestMapping(value = "/getAllBags")
	public ResponseEntity<List<BioDetails>> getbags() throws BagNotFoundException {
		List<BioDetails> bags= service.getAllBags();
		if(bags.isEmpty())
		{
			throw new BagNotFoundException(errorMessage);
			//return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<BioDetails>>(bags, HttpStatus.OK);
	
	}
}
