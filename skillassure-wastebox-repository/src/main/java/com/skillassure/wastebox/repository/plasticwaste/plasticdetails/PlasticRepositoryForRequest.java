package com.skillassure.wastebox.repository.plasticwaste.plasticdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skillassure.wastebox.model.plasticwaste.plasticdetails.PlasticDetailsForRequest;

//This repository for PlasticRequest
public interface PlasticRepositoryForRequest extends JpaRepository<PlasticDetailsForRequest, Long> {

	// This query is for getting the amount Of plastic by using "reqId"
	@Query(value = "select amount_of_plastic from requestformdetails where req_id = :reqId", nativeQuery = true)
	long getAmountOfPlastic(@Param("reqId") long reqId);

}
