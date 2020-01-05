package com.testclmsvc.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.testclmsvc.model.TestClmModel;

@Repository
public interface TestClmDao extends JpaRepository<TestClmModel, Long> {
	
	public TestClmModel findByClmId(Long clmId);
	@Modifying
	@Query("DELETE FROM TestClmModel t where t.clmId IN (:clmIds) ")
	@Transactional
	public int deleteByClaimIds(@Param("clmIds") List<Long> clmIds);
}
