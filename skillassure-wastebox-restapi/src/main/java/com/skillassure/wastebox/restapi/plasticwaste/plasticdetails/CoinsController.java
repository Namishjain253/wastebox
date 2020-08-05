package com.skillassure.wastebox.restapi.plasticwaste.plasticdetails;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skillassure.wastebox.businesslayer.plasticwaste.plasticdetails.CoinsService;
import com.skillassure.wastebox.model.plasticwaste.plasticdetails.Coins;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CoinsController {

	//calling the service of CoinsServiceImpl
	@Autowired
	CoinsService service;
	
	//Getting List Of All Coins
	@RequestMapping(value = "/coins")
	public List<Coins> getAllCoins() {
		return service.getAllCoins();
	}
	
	//For Adding the Coins
	@RequestMapping(value = "/coins", method = RequestMethod.POST)
	public Coins createUser(@Valid @RequestBody Coins coins) {
		return service.addCoins(coins);
	}	
}
