package com.skillassure.wastebox.repository.biowaste.biodetails;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillassure.wastebox.model.biowaste.biodetails.BioDetails;

public interface BioRepository  extends JpaRepository<BioDetails, Long>{

}
