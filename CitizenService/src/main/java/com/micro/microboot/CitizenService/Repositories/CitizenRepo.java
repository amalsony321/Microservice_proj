package com.micro.microboot.CitizenService.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.microboot.CitizenService.Entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {
	
	public List<Citizen> findByVaccinationCenterId(Integer id);

}
