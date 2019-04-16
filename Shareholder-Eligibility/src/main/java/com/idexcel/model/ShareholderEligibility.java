package com.idexcel.model;

public class ShareholderEligibility {
	
	private int FicoScore;
	private String anyDelinquencies;
	private String anyDelinquenciesIn24months;
	private String personalBankruptcy;
	private String anyPersonalLiens;
	private String anyCriminalCharges;
	private String anyOFACCheck;
	private int riskScore;
	
	
	public int getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(int riskScore) {
		this.riskScore += riskScore;
	}
	public int getFicoScore() {
		return FicoScore;
	}
	public void setFicoScore(int ficoScore) {
		FicoScore = ficoScore;
	}
	public String getAnyDelinquencies() {
		return anyDelinquencies;
	}
	public void setAnyDelinquencies(String anyDelinquencies) {
		this.anyDelinquencies = anyDelinquencies;
	}
	public String getAnyDelinquenciesIn24months() {
		return anyDelinquenciesIn24months;
	}
	public void setAnyDelinquenciesIn24months(String anyDelinquenciesIn24months) {
		this.anyDelinquenciesIn24months = anyDelinquenciesIn24months;
	}
	public String getPersonalBankruptcy() {
		return personalBankruptcy;
	}
	public void setPersonalBankruptcy(String personalBankruptcy) {
		this.personalBankruptcy = personalBankruptcy;
	}
	public String getAnyPersonalLiens() {
		return anyPersonalLiens;
	}
	public void setAnyPersonalLiens(String anyPersonalLiens) {
		this.anyPersonalLiens = anyPersonalLiens;
	}
	public String getAnyCriminalCharges() {
		return anyCriminalCharges;
	}
	public void setAnyCriminalCharges(String anyCriminalCharges) {
		this.anyCriminalCharges = anyCriminalCharges;
	}
	public String getAnyOFACCheck() {
		return anyOFACCheck;
	}
	public void setAnyOFACCheck(String anyOFACCheck) {
		this.anyOFACCheck = anyOFACCheck;
	}
	
	public ShareholderEligibility(int ficoScore, String anyDelinquencies, String anyDelinquenciesIn24months,
			String personalBankruptcy, String anyPersonalLiens, String anyCriminalCharges, String anyOFACCheck) {
		super();
		FicoScore = ficoScore;
		this.anyDelinquencies = anyDelinquencies;
		this.anyDelinquenciesIn24months = anyDelinquenciesIn24months;
		this.personalBankruptcy = personalBankruptcy;
		this.anyPersonalLiens = anyPersonalLiens;
		this.anyCriminalCharges = anyCriminalCharges;
		this.anyOFACCheck = anyOFACCheck;
	}
	public ShareholderEligibility() {
	
	}
	
}
