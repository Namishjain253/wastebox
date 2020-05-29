package com.skillassure.wastebox.businesslayer.plasticwaste.plasticdetails;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillassure.wastebox.model.plasticwaste.plasticdetails.Coins;
import com.skillassure.wastebox.repository.plasticwaste.plasticdetails.CoinsRepository;



@Service
public class CoinsService {

	// Calling the Coins Repository
	@Autowired
	private CoinsRepository coinsRepository;

	//getting the list of coins by using Coins repository
	public List<Coins> getAllCoins() {
		return coinsRepository.findAll();
	}

	//Adding the coins by using Coins repository
	public Coins addCoins(@Valid Coins coins) {
		return coinsRepository.save(coins);
	}
}