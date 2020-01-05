package com.testclmsvc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testclmsvc.dao.TestClmDao;
import com.testclmsvc.model.TestClmModel;

@Service
public class TestClmSvcImpl implements TestClmSvc {

	private static final Logger LOGGER = LogManager.getLogger(TestClmSvcImpl.class);

	@Autowired
	TestClmDao dao;

	@Override
	public boolean insertClaimRecs(List<TestClmModel> testClaimList) {
		try {
			dao.saveAll(testClaimList);
			LOGGER.log(Level.INFO, "Record inserted successfully!");
			return true;
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, "Error in inserting record!");
			return false;
		}
	}

	@Override
	public List<TestClmModel> fetchAllClaimRecs() {
		List<TestClmModel> testClmList = new ArrayList<TestClmModel>();
		try {
			testClmList = dao.findAll();
			LOGGER.log(Level.INFO, testClmList.size() + " record(s) fetched!");
			return testClmList;
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, "Error in fetching records!", e);
			return testClmList;
		}
	}

	@Override
	public TestClmModel fetchClaimRecsById(Long id) {
		TestClmModel testClm = new TestClmModel();
		try {
			testClm = dao.findByClmId(id);
			LOGGER.log(Level.INFO, "Record successfully fetched!");
			return testClm;
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, "Error in fetching record!", e);
			return testClm;
		}
	}

	@Override
	public boolean deleteAllClaims() {
		try {
			dao.deleteAll();
			LOGGER.log(Level.INFO, "All records deleted successfully!");
			return true;
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, "Error in deleting records!", e);
			return false;
		}
	}

	@Override
	public boolean deleteClaimsByIds(String clmIds) {
		try {
			List<Long> clmIdList = Arrays.asList(clmIds.split(",")).stream().map(x -> Long.parseLong(x))
					.collect(Collectors.toList());
			dao.deleteByClaimIds(clmIdList);
			LOGGER.log(Level.INFO, "Delete query executed successfully for the claim ID(s): "+clmIds+" !");
			return true;
		} catch (Exception e) {
			LOGGER.log(Level.ERROR, "Error in deleting record(s)!", e);
			return false;
		}
	}

}
