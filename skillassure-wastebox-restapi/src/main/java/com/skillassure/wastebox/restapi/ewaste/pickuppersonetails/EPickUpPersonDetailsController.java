/**
 * 
 */
package com.skillassure.wastebox.restapi.ewaste.pickuppersonetails;

import java.util.List;

import javax.validation.Valid;

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

import com.skillassure.wastebox.businesslayer.ewaste.exception.PickUpPersonDetailsNotFoundException;
import com.skillassure.wastebox.businesslayer.ewaste.pickuppersondetailsimpl.EPickUpPersonDetailsService;
import com.skillassure.wastebox.model.ewaste.pickuppersondetails.EPickUpPersonDetails;

/**
 * @author Raghavendra
 *
 */

@RestController
@RequestMapping("/api/ewaste")
@CrossOrigin
@PropertySource(ignoreResourceNotFound = true, value = "classpath:errormessage.properties")
public class EPickUpPersonDetailsController {
	
	@Value("${PickUpPersonDetailsNotFound}")
	private String errorMessage1;
	
	@Value("${PickUpPersonDetailNotFound}")
	private String errorMessage2;
	
	@Autowired
	EPickUpPersonDetailsService service;
	
	/**
	 * Requesting to getPickUpPersonDetails from service
	 * @return All PickUpPersonDetails
	 * @throws PickUpPersonDetailsNotFoundException 
	 */
	@RequestMapping(value = "/pickuppersondetails")
	public ResponseEntity<List<EPickUpPersonDetails>> getPickUpPersonDetails() throws PickUpPersonDetailsNotFoundException {
		List<EPickUpPersonDetails> pickUpPersonDetails= service.getAllPickUpPersonDetails();
		if(pickUpPersonDetails.isEmpty())
		{
			throw new PickUpPersonDetailsNotFoundException(errorMessage1);
		}
		return new ResponseEntity<List<EPickUpPersonDetails>>(pickUpPersonDetails, HttpStatus.OK);
	}

	/**
	 * Requesting to delete the PickUpPersonDetails based on the id from service
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/pickuppersondetails/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePickUpPersonDetails(@PathVariable("id") long id) throws Exception {
		EPickUpPersonDetails pickUpPersonDetails = service.getPickUpPersonDetailsById(id);
		service.delete(pickUpPersonDetails);
		return new ResponseEntity<>("Pick Up Person Details are deleted successsfully", HttpStatus.OK);
	}

	/**
	 * Requesting to get PickUpPersonDetails by id from service
	 * @param id
	 * @return PickUpPersonDetails
	 * @throws PickUpPersonDetailsNotFoundException
	 */
	@RequestMapping(value = "/pickuppersondetails/{id}")
	public ResponseEntity<EPickUpPersonDetails> getPickUpPersonDetailsById(@PathVariable(value = "id") long id) throws PickUpPersonDetailsNotFoundException {
		if (id < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		EPickUpPersonDetails pickUpPersonDetails = null;
		pickUpPersonDetails = service.getPickUpPersonDetailsById(id);
		if (pickUpPersonDetails == null) {
			throw new PickUpPersonDetailsNotFoundException(errorMessage2);
		}
		return ResponseEntity.ok().body(pickUpPersonDetails);
	}

	/**
	 * Requesting to create PickUpPersonDetails in database through service
	 * @param PickUpPersonDetails
	 * saves PickUpPersonDetails in repository
	 */
	@RequestMapping(value = "/pickuppersondetails", method = RequestMethod.POST)
	public ResponseEntity<EPickUpPersonDetails> createPickUpPersonDetails(@Valid @RequestBody EPickUpPersonDetails pickUpPersonDetails) {
		EPickUpPersonDetails addedPickUpPersonDetails = service.savePickUpPersonDetails(pickUpPersonDetails);
		return new ResponseEntity<EPickUpPersonDetails>(addedPickUpPersonDetails, HttpStatus.CREATED);
	}

	/**
	 * Requesting to update PickUpPersonDetails in database through service
	 * @param id
	 * @param PickUpPersonDetails details for updating
	 * @return update PickUpPersonDetails
	 * @throws PickUpPersonDetailsNotFoundException
	 */
	@RequestMapping(value = "/pickuppersondetails/{id}", method = RequestMethod.PUT)
	public ResponseEntity<EPickUpPersonDetails> updatePickUpPersonDetails(@PathVariable(value = "id") Long id, @Valid @RequestBody EPickUpPersonDetails pickUpPersonDetails)
			throws PickUpPersonDetailsNotFoundException {
		EPickUpPersonDetails updatedPickUpPersonDetails = service.updatePickUpPersonDetails(id, pickUpPersonDetails);
		return new ResponseEntity<EPickUpPersonDetails>(updatedPickUpPersonDetails, HttpStatus.OK);
	}
}
