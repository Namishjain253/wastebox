package com.skillassure.wastebox.repository.plasticwaste.plasticdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillassure.wastebox.model.plasticwaste.plasticdetails.Coins;

//This repository for Coins
@Repository
public interface CoinsRepository extends JpaRepository<Coins, Long> {

}
