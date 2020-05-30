package com.skillassure.wastebox.restapi.plasticwaste.plasticdetails;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.skillassure.wastebox.businesslayer.plasticwaste.plasticdetails.PlasticDetailsForRequestService;
import com.skillassure.wastebox.exception.RecordNotFoundException;
import com.skillassure.wastebox.model.plasticwaste.plasticdetails.PlasticDetailsForRequest;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/plastic")
@PropertySource(ignoreResourceNotFound = true, value = "classpath:errormessage.properties")
public class PlasticDetailsForRequestController {
	private static final Logger logger = LoggerFactory.getLogger(PlasticDetailsForRequest.class);

	@Value("${NoRequestIsThere}")
	 private String errorMessage;
// calling the service of PlasticRequestServiceImpl
	@Autowired
	PlasticDetailsForRequestService service;
		
	  /*
	   * Add New Request After the Submit Button
	   */
// getting all the PlasticReq Details (Uncomment This Part)
	@RequestMapping(value = "/plasticReq")
	public ResponseEntity<List<PlasticDetailsForRequest>> getRequests() throws Exception {
//		logger.debug("request received for get all products");
		List<PlasticDetailsForRequest> requests= service.getAllPlasticRequest();
		if(requests.isEmpty())
		{
			throw new RecordNotFoundException(errorMessage);
			//return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
//			System.out.println("No Request Found");
		}
		return new ResponseEntity<List<PlasticDetailsForRequest>>(requests, HttpStatus.OK);
	}
	
	// Adding the request to the database (Uncomment This Part)
	
	@RequestMapping(value = "/plasticReq", method = RequestMethod.POST)
	public  ResponseEntity<PlasticDetailsForRequest> addPlasticRequest(@RequestBody PlasticDetailsForRequest plasticDetailsForRequest) {
//		logger.debug("Request received for get all Request");
		System.out.println("Request: "+ plasticDetailsForRequest.getCity());
		PlasticDetailsForRequest addRequest = service.addPlasticRequest(plasticDetailsForRequest);
		return new ResponseEntity<PlasticDetailsForRequest>(addRequest, HttpStatus.CREATED);
	}	
	
	
	@RequestMapping(value = "/plasticReq/{id}")
	public long getAmountOfPlastic(@PathVariable(value = "id") long reqId) {
		return service.getAmountOfPlastic(reqId);
	}
	
	

//	// fetching the amount of plastic from the database
//	@RequestMapping(value = "/plasticReq/{id}")
//	public long getAmountOfPlastic(@PathVariable(value = "id") long reqId) {
//		return service.getAmountOfPlastic(reqId);
//	}
//	
//	//getting all the PlasticReq Details
//	@RequestMapping(value = "/plasticReq")
//	public List<PlasticDetailsForRequest> getPlasticReq() {
//		return service.getAllPlasticRequest();
//	}
//		
//	//Adding the request to the database
//	@RequestMapping(value = "/plasticReq", method = RequestMethod.POST)
//	public PlasticDetailsForRequest addRequest(@Valid @RequestBody PlasticDetailsForRequest requestDetailForPlastic){
//		return service.addPlasticRequest(requestDetailForPlastic);
//	}
		
}