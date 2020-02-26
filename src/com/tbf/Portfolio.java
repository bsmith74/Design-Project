package com.tbf;

public abstract class Portfolio {
	private String portfolioCode;
	private Customer owner;
	private Customer manager;
	//beneficiary code is optional
	private Customer beneficiary;
	private Asset asset;
	public String getPortfolioCode() {
		return portfolioCode;
	}
	
	public Customer getOwner() {
		return owner;
	}

	public Customer getManager() {
		return manager;
	}

	public Customer getBeneficiary() {
		return beneficiary;
	}

	public Asset getAsset() {
		return asset;
	}

	public Portfolio(String portfolioCode, Customer owner, Customer manager, Customer beneficiary, Asset asset) {
		super();
		this.portfolioCode = portfolioCode;
		this.owner = owner;
		this.manager = manager;
		this.beneficiary = beneficiary;
		this.asset = asset;
	}



	
}
