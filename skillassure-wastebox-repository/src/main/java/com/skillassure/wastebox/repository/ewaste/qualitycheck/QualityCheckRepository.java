/**
 * 
 */
package com.skillassure.wastebox.repository.ewaste.qualitycheck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillassure.wastebox.model.ewaste.qualitycheck.QualityCheck;

/**
 * @author Raghavendra
 *
 */


/**
 * QualityCheckRepository for fetching all QualityCheck details.
 */
@Repository
public interface QualityCheckRepository extends JpaRepository<QualityCheck, Long> {

}
