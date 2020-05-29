/**
 * 
 */
package com.skillassure.wastebox.businesslayer.ewaste.qualitycheck;

import java.util.List;

import org.springframework.stereotype.Component;

import com.skillassure.wastebox.businesslayer.ewaste.exception.QualityCheckNotFoundException;
import com.skillassure.wastebox.model.ewaste.qualitycheck.QualityCheck;


/**
 * @author Raghavendra
 *
 */

@Component
public interface IQualityCheckService {
	/**
	 * @return get all QualityChecks
	 */
	public List<QualityCheck> getAllQualityChecks();
	
	/**
	 * 
	 * @param id
	 * @return QualityCheck by ID
	 * @throws QualityCheckNotFoundException
	 */
	public QualityCheck getQualityCheckById(long id) throws QualityCheckNotFoundException;

	/**
	 * 
	 * @param QualityCheck
	 * saves QualityCheck into repository
	 */
	public QualityCheck saveQualityCheck(QualityCheck qualityCheck);

	/**
	 * deletes QualityCheck from repository
	 * @param QualityCheck
	 */
	public void delete(QualityCheck qualityCheck);

	/**
	 * 
	 * @param id
	 * @param QualityCheck
	 * @return updated QualityCheck
	 * @throws QualityCheckNotFoundException
	 */
	public QualityCheck updateQualityCheck(Long id, QualityCheck qualityCheck) throws QualityCheckNotFoundException;

}
