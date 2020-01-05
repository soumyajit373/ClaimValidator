package com.testclmsvc.service;

import java.util.List;

import com.testclmsvc.model.TestClmModel;

public interface TestClmSvc {

	public boolean insertClaimRecs(List<TestClmModel> testClaimList);
	public TestClmModel fetchClaimRecsById(Long id);
	public List<TestClmModel> fetchAllClaimRecs();
	public boolean deleteAllClaims();
	public boolean deleteClaimsByIds(String clmIds);
}
