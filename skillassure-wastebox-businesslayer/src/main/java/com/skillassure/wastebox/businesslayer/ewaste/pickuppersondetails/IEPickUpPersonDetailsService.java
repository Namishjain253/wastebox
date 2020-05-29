/**
 * 
 */
package com.skillassure.wastebox.businesslayer.ewaste.pickuppersondetails;

import java.util.List;

import org.springframework.stereotype.Component;

import com.skillassure.wastebox.businesslayer.ewaste.exception.PickUpPersonDetailsNotFoundException;
import com.skillassure.wastebox.model.ewaste.pickuppersondetails.EPickUpPersonDetails;


/**
 * @author Raghavendra
 *
 */

@Component
public interface IEPickUpPersonDetailsService {

	/**
	 * @return get all EPickUpPersonDetails
	 */
	public List<EPickUpPersonDetails> getAllPickUpPersonDetails();
	
	/**
	 * 
	 * @param id
	 * @return EPickUpPersonDetails by ID
	 * @throws PickUpPersonDetailsNotFoundException
	 */
	public EPickUpPersonDetails getPickUpPersonDetailsById(long id) throws PickUpPersonDetailsNotFoundException;

	/**
	 * 
	 * @param EPickUpPersonDetails
	 * saves EPickUpPersonDetails into repository
	 */
	public EPickUpPersonDetails savePickUpPersonDetails(EPickUpPersonDetails pickUpPersonDetails);

	/**
	 * deletes EPickUpPersonDetails from repository
	 * @param EPickUpPersonDetails
	 */
	public void delete(EPickUpPersonDetails pickUpPersonDetails);

	/**
	 * 
	 * @param id
	 * @param EPickUpPersonDetails
	 * @return updated EPickUpPersonDetails
	 * @throws PickUpPersonDetailsNotFoundException
	 */
	public EPickUpPersonDetails updatePickUpPersonDetails(Long id, EPickUpPersonDetails pickUpPersonDetails) throws PickUpPersonDetailsNotFoundException;
}
