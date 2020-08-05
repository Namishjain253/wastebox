/**
 * 
 */
package com.skillassure.wastebox.businesslayer.ewaste.pickuppersondetailsimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillassure.wastebox.businesslayer.ewaste.exception.PickUpPersonDetailsNotFoundException;
import com.skillassure.wastebox.businesslayer.ewaste.pickuppersondetails.IEPickUpPersonDetailsService;
import com.skillassure.wastebox.model.ewaste.pickuppersondetails.EPickUpPersonDetails;
import com.skillassure.wastebox.repository.ewaste.pickuppersondetails.EPickUpPersonDetailsRepository;

/**
 * @author Raghavendra
 *
 */
@Service
public class EPickUpPersonDetailsService implements IEPickUpPersonDetailsService {
	
	@Autowired
	private EPickUpPersonDetailsRepository repository;

	/**
	 * getAllPickUpPersonDetails method will return all the EPickUpPersonDetails from repository.
	 */
	@Override
	public List<EPickUpPersonDetails> getAllPickUpPersonDetails() {
		return repository.findAll();
	}

	/**
	 * getPickUpPersonDetailsById method will return all the EPickUpPersonDetails based on ID from repository.
	 */
	@Override
	public EPickUpPersonDetails getPickUpPersonDetailsById(long id) throws PickUpPersonDetailsNotFoundException {
		return repository.findById(id).orElseThrow(() -> new PickUpPersonDetailsNotFoundException("Pick Up Person Details not found on :: " + id));
	}

	/**
	 * savePickUpPersonDetails method will save EPickUpPersonDetails into repository.
	 */
	@Override
	public EPickUpPersonDetails savePickUpPersonDetails(EPickUpPersonDetails pickUpPersonDetails) {
		return repository.save(pickUpPersonDetails);
	}

	/**
	 * delete method will delete the EPickUpPersonDetails from repository.
	 */
	@Override
	public void delete(EPickUpPersonDetails pickUpPersonDetails) {
		repository.delete(pickUpPersonDetails);
	}
	
	/**
	 * updatePickUpPersonDetails method will update the EPickUpPersonDetails bsed on ID in repository.
	 */
	@Override
	public EPickUpPersonDetails updatePickUpPersonDetails(Long id, EPickUpPersonDetails pickUpPersonDetails)
			throws PickUpPersonDetailsNotFoundException {
		EPickUpPersonDetails details = repository.findById(id)
				.orElseThrow(() -> new PickUpPersonDetailsNotFoundException(
						"Pick Up Person Details not found on :: " + id));

		details.setFirstName(pickUpPersonDetails.getFirstName());
		details.setLastName(pickUpPersonDetails.getLastName());
		details.setEmailId(pickUpPersonDetails.getEmailId());
		details.setAge(pickUpPersonDetails.getAge());
		details.setLanguages(pickUpPersonDetails.getLanguages());
		details.setPhoneNo(pickUpPersonDetails.getPhoneNo());
		details.setDescription(pickUpPersonDetails.getDescription());

		final EPickUpPersonDetails updatedPickUpPersonDetails = repository.save(details);
		return updatedPickUpPersonDetails;
	}

}
