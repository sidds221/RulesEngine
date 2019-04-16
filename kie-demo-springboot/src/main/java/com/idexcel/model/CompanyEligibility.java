package com.idexcel.model;

public class CompanyEligibility {

	private String bankruptcy;
	private int riskScore;
	private int yearsInBusiness;
	
	public String getBankruptcy() {
		return bankruptcy;
	}
	public void setBankruptcy(String bankruptcy) {
		this.bankruptcy = bankruptcy;
	}
	public int getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(int riskScore) {
		this.riskScore = this.riskScore + riskScore;
	}
	public int getYearsInBusiness() {
		return yearsInBusiness;
	}
	public void setYearsInBusiness(int yearsInBusiness) {
		this.yearsInBusiness = yearsInBusiness;
	}


}