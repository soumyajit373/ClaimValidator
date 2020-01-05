package com.testclmsvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testclmsvc.model.TestClmModel;
import com.testclmsvc.service.TestClmSvc;

@RestController("/")
public class TestClmController {

	@Autowired
	TestClmSvc service;
	
	@PostMapping(path="/insertrec")
	public boolean insertClaimRec(@RequestBody List<TestClmModel> testClaimList) {
		return service.insertClaimRecs(testClaimList);
		
	}
	
	@GetMapping(path="/fetchclaim")
	public List<TestClmModel> fetchClaim() {
		return service.fetchAllClaimRecs();
		
	}
	
	@GetMapping(path="/fetchclaim/{id}")
	public TestClmModel fetchClaimById(@PathVariable Long id) {
		return service.fetchClaimRecsById(id);
		
	}
	
	@DeleteMapping(path="/deleteclaims")
	public boolean deleteAllClaims() {
		return service.deleteAllClaims();
		
	}
	
	@DeleteMapping(path="/deleteclaims/{ids}")
	public boolean deleteClaimsByIds(@PathVariable String ids) {
		return service.deleteClaimsByIds(ids);
		
	}
	
}
