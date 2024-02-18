package com.micro.microboot.CitizenService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.microboot.CitizenService.Entity.Citizen;
import com.micro.microboot.CitizenService.Repositories.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	private CitizenRepo repo;
	
	@RequestMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}

	@RequestMapping(path="/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id){
		
		List<Citizen> listCitizen = repo.findByVaccinationCenterId(id);
		
		return new ResponseEntity<>(listCitizen, HttpStatus.OK);
	}
	
	
	@PostMapping(path="/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){
		System.out.print(newCitizen);
		Citizen citizen = repo.save(newCitizen);
		
		return new ResponseEntity<>(citizen, HttpStatus.OK);
	}
	
}
