package com.skillassure.wastebox.businesslayer.biowaste.biodetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillassure.wastebox.model.biowaste.biodetails.BioDetails;
import com.skillassure.wastebox.repository.biowaste.biodetails.BioRepository;

@Service
public class BioDetailsService {

	@Autowired
	private BioRepository bioRepository;
	
	public BioDetails addbag(BioDetails bioDetails) {
		return bioRepository.save(bioDetails);
	}

	public Optional<BioDetails> getBagById(long id) {
		return bioRepository.findById(id);
	}

	public List<BioDetails> getAllBags() {
		return bioRepository.findAll();
	}
}