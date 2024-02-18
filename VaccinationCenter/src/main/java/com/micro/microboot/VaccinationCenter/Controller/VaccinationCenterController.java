package com.micro.microboot.VaccinationCenter.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.micro.microboot.VaccinationCenter.Entity.VaccinationCenter;
import com.micro.microboot.VaccinationCenter.Model.Citizen;
import com.micro.microboot.VaccinationCenter.Model.RequiredResponse;
import com.micro.microboot.VaccinationCenter.Repository.CenterRepo;



@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

	
	@Autowired
	private CenterRepo centerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path="/add")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter){
		System.out.print(vaccinationCenter);
		VaccinationCenter vaccinationCenterAdded = centerRepo.save(vaccinationCenter);
		
		return new ResponseEntity<>(vaccinationCenterAdded, HttpStatus.OK);
	}
	
	@GetMapping(path="/id/{id}")
	public ResponseEntity<RequiredResponse>  getAllDataBasedonCenterId(@PathVariable Integer id){
		
		RequiredResponse requiredResponse = new RequiredResponse();
		
		//get vaccination center details
		VaccinationCenter center= centerRepo.findById(id).get();
		
		requiredResponse.setCenter(center);

		//get all citizens registered to vaccination center
		List<Citizen> listOfCitizens =restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
		requiredResponse.setCitizens(listOfCitizens);
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
		
	}
	
	
	
}
