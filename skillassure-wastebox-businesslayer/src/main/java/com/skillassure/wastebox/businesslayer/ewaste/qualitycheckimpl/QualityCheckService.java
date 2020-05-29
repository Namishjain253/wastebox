/**
 * 
 */
package com.skillassure.wastebox.businesslayer.ewaste.qualitycheckimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillassure.wastebox.businesslayer.ewaste.exception.QualityCheckNotFoundException;
import com.skillassure.wastebox.businesslayer.ewaste.qualitycheck.IQualityCheckService;
import com.skillassure.wastebox.model.ewaste.qualitycheck.QualityCheck;
import com.skillassure.wastebox.repository.ewaste.qualitycheck.QualityCheckRepository;

/**
 * @author Raghavendra
 *
 */

@Service
public class QualityCheckService implements IQualityCheckService {
	
	@Autowired
	private QualityCheckRepository repository;

	/**
	 * getAllQualityChecks method will return all the QualityCheck from repository.
	 */
	@Override
	public List<QualityCheck> getAllQualityChecks() {
		return repository.findAll();	}

	/**
	 * getQualityCheckById method will return all the QualityCheck based on ID from repository.
	 */
	@Override
	public QualityCheck getQualityCheckById(long id) throws QualityCheckNotFoundException {
		return repository.findById(id).orElseThrow(() -> new QualityCheckNotFoundException("Quality Check not found on :: " + id));
	}

	/**
	 * saveQualityCheck method will QualityCheck product into repository.
	 */
	@Override
	public QualityCheck saveQualityCheck(QualityCheck qualityCheck) {
		return repository.save(qualityCheck);
	}

	/**
	 * delete method will delete the QualityCheck from repository.
	 */
	@Override
	public void delete(QualityCheck qualityCheck) {
		repository.delete(qualityCheck);
	}

	/**
	 * updateQualityCheck method will update the QualityCheck based on ID in repository.
	 */
	@Override
	public QualityCheck updateQualityCheck(Long id, QualityCheck qualityCheckDetails) throws QualityCheckNotFoundException {
		QualityCheck qualityCheck = repository.findById(id).orElseThrow(() -> new QualityCheckNotFoundException("Quality Check not found on :: " + id));
		
		qualityCheck.setCategory(qualityCheckDetails.getCategory());
		qualityCheck.setProductName(qualityCheckDetails.getProductName());
		qualityCheck.setDamaged(qualityCheckDetails.isDamaged());
		qualityCheck.setDescription(qualityCheckDetails.getDescription());
		qualityCheck.setModelYear(qualityCheckDetails.getModelYear());
		qualityCheck.setOverallRating(qualityCheckDetails.getOverallRating());
		qualityCheck.setProductRating(qualityCheckDetails.getProductRating());
		qualityCheck.setRefurnished(qualityCheckDetails.isRefurnished());
		qualityCheck.setCondition(qualityCheckDetails.isCondition());
		qualityCheck.setProductFunction(qualityCheckDetails.isProductFunction());
		
		qualityCheck.setProduct(qualityCheckDetails.getProduct());
		
		final QualityCheck updatedQualityCheck = repository.save(qualityCheck);
	return updatedQualityCheck;
	}

}
