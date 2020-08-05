package com.skillassure.wastebox.repository.plasticwaste.plasticdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillassure.wastebox.model.plasticwaste.plasticdetails.PickUpPersonDetails;

//This repository for PickUpPerson
@Repository("pickupPersonRepository")
public interface PickUpPersonDetailsRepository extends JpaRepository<PickUpPersonDetails, Long>{

}
