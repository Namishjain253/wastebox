/**
 * 
 */
package com.skillassure.wastebox.restapi.ewaste.qualitycheck;

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

import com.skillassure.wastebox.businesslayer.ewaste.exception.QualityCheckNotFoundException;
import com.skillassure.wastebox.businesslayer.ewaste.qualitycheckimpl.QualityCheckService;
import com.skillassure.wastebox.model.ewaste.qualitycheck.QualityCheck;


/**
 * @author Raghavendra
 *
 */
@RestController
@RequestMapping("/api/ewaste")
@CrossOrigin
@PropertySource(ignoreResourceNotFound = true, value = "classpath:errormessage.properties")
public class QualityCheckController {

	@Value("${QualityChecksNotFound}")
	private String errorMessage1;
	
	@Value("${QualityCheckNotFound}")
	private String errorMessage2;
	
	@Autowired
	QualityCheckService service;

	/**
	 * Requesting to getAllQualityChecks from service
	 * @return All QualityCheck
	 * @throws QualityCheckNotFoundException 
	 */
	@RequestMapping(value = "/qualitycheck")
	public ResponseEntity<List<QualityCheck>> getAllQualityChecks() throws QualityCheckNotFoundException {
		List<QualityCheck> qualityChecks= service.getAllQualityChecks();
		if(qualityChecks.isEmpty())
		{
			throw new QualityCheckNotFoundException(errorMessage1);
		}
		return new ResponseEntity<List<QualityCheck>>(qualityChecks, HttpStatus.OK);
	}

	/**
	 * Requesting to delete the QualityCheck based on the id from service
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/qualitycheck/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteQualityCheck(@PathVariable("id") long id) throws Exception {
		QualityCheck qualityCheck = service.getQualityCheckById(id);
		service.delete(qualityCheck);
		return new ResponseEntity<>("Quality Check is deleted successsfully", HttpStatus.OK);
	}

	/**
	 * Requesting to get QualityCheck by id from service
	 * @param id
	 * @return QualityCheck
	 * @throws QualityCheckNotFoundException
	 */
	@RequestMapping(value = "/qualitycheck/{id}")
	public ResponseEntity<QualityCheck> getQualityCheckById(@PathVariable(value = "id") long id) throws QualityCheckNotFoundException {
		if (id < 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		QualityCheck qualityCheck = null;
		qualityCheck = service.getQualityCheckById(id);
		if (qualityCheck == null) {
			throw new QualityCheckNotFoundException(errorMessage2);
		}
		return ResponseEntity.ok().body(qualityCheck);
	}

	/**
	 * Requesting to create QualityCheck in database through service
	 * @param QualityCheck
	 * saves QualityCheck in repository
	 */
	@RequestMapping(value = "/qualitycheck", method = RequestMethod.POST)
	public ResponseEntity<QualityCheck> createQualityCheck(@Valid @RequestBody QualityCheck qualityCheck) {
		QualityCheck addedQualityCheck = service.saveQualityCheck(qualityCheck);
		return new ResponseEntity<QualityCheck>(addedQualityCheck, HttpStatus.CREATED);
	}

	/**
	 * Requesting to update QualityCheck in database through service
	 * @param id
	 * @param QualityCheck details for updating
	 * @return update QualityCheck
	 * @throws QualityCheckNotFoundException
	 */
	@RequestMapping(value = "/qualitycheck/{id}", method = RequestMethod.PUT)
	public ResponseEntity<QualityCheck> updateQualityCheck(@PathVariable(value = "id") Long id, @Valid @RequestBody QualityCheck qualityCheck)
			throws QualityCheckNotFoundException {
		QualityCheck updatedQualityCheck = service.updateQualityCheck(id, qualityCheck);
		return new ResponseEntity<QualityCheck>(updatedQualityCheck, HttpStatus.OK);
	}
}
