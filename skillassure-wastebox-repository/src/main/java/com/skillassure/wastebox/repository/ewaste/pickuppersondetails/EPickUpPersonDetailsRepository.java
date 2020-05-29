package com.skillassure.wastebox.repository.ewaste.pickuppersondetails;

/**
 * @author Raghavendra
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillassure.wastebox.model.ewaste.pickuppersondetails.EPickUpPersonDetails;


/**
 * EPickUpPersonDetailsRepository for fetching all EPickUpPersonDetails details.
 */
@Repository
public interface EPickUpPersonDetailsRepository extends JpaRepository<EPickUpPersonDetails, Long>{


}
