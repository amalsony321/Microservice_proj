package com.micro.microboot.VaccinationCenter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.microboot.VaccinationCenter.Entity.VaccinationCenter;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer>{

}
