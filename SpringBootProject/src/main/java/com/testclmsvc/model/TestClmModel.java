package com.testclmsvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "rpatesttbl", schema = "mydb")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class TestClmModel {

	@Id
	@Column(name = "SL_NO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
	Long slNo;
    @Column(name="CLAIM_ID", unique = true)
	Long clmId;
    @Column(name="MBR_ID")
    Long mbrId;
    @Column(name = "MBR_NAME")
    String mbrName;
    @Column(name="AMT_TO_BE_PAID")
    Double amtToBePaid;
    @Column(name="AMT_REM")
    Double amtRem;
    @Column(name="TOT_AMT")
    Double totAmt;
    @Column(name="EMAIL")
    String email;
    @Column(name="DUE_DT")
    Date dueDt;
    @Column(name="CLAIM_SUSP_FLAG")
    Boolean claimSuspFlag;
    
	public Long getSlNo() {
		return slNo;
	}
	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}
	public Long getClmId() {
		return clmId;
	}
	public void setClmId(Long clmId) {
		this.clmId = clmId;
	}
	public Long getMbrId() {
		return mbrId;
	}
	public void setMbrId(Long mbrId) {
		this.mbrId = mbrId;
	}
	public String getMbrName() {
		return mbrName;
	}
	public void setMbrName(String mbrName) {
		this.mbrName = mbrName;
	}
	public Double getAmtToBePaid() {
		return amtToBePaid;
	}
	public void setAmtToBePaid(Double amtToBePaid) {
		this.amtToBePaid = amtToBePaid;
	}
	public Double getAmtRem() {
		return amtRem;
	}
	public void setAmtRem(Double amtRem) {
		this.amtRem = amtRem;
	}
	public Double getTotAmt() {
		return totAmt;
	}
	public void setTotAmt(Double totAmt) {
		this.totAmt = totAmt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDueDt() {
		return dueDt;
	}
	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}
	public Boolean getClaimSuspFlag() {
		return claimSuspFlag;
	}
	public void setClaimSuspFlag(Boolean claimSuspFlag) {
		this.claimSuspFlag = claimSuspFlag;
	}
	
	@Override
	public String toString() {
		return "Claim ID: "+clmId;
	}
    
}
