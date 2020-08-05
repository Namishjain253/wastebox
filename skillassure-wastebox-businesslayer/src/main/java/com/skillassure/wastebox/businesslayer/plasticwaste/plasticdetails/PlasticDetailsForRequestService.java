package com.skillassure.wastebox.businesslayer.plasticwaste.plasticdetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillassure.wastebox.model.plasticwaste.plasticdetails.PlasticDetailsForRequest;
import com.skillassure.wastebox.repository.plasticwaste.plasticdetails.PlasticRepositoryForRequest;



@Service
@Transactional
public class PlasticDetailsForRequestService {

	// Calling the PlasticRequest Repository
	@Autowired
	private PlasticRepositoryForRequest plasticRepository;

	//getting the list of Request by using PlasticRequest repository
	public List<PlasticDetailsForRequest> getAllPlasticRequest() {
		return plasticRepository.findAll();
	}

	//Adding the request by using Plastic request repository
	public PlasticDetailsForRequest addPlasticRequest(PlasticDetailsForRequest plasticDetailsForRequest) {
		return plasticRepository.save(plasticDetailsForRequest);
	}
	
	//getting only amount of plastic by the help of ID
	public long getAmountOfPlastic(long reqId){
		return plasticRepository.getAmountOfPlastic(reqId);
	}
}
