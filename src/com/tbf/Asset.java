/*
 *Asset is parent class to store subclasses deposit, investment, and stock 
 */
package com.tbf;

public abstract class Asset {
	private String code;
	private String label;

	public String getCode() {
		return code;
	}

	public abstract String getType();

	public String getLabel() {
		return label;
	}

	public Asset(String code, String label) {
		super();
		this.code = code;
		this.label = label;
	}
	//function to return string in JSON format
	public abstract String toString();
}

class Deposit extends Asset {
	private double apr;
	private double balance;

	public String getType() {
		return "D";
	}
	

	public double getBalance() {
		return balance;
	}


	public double getApr() {
		return apr;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	public Deposit(String code, String label, double apr) {
		super(code, label);
		this.apr = apr;
	}

	public String toString() {
		return  "\"code\": \"" + getCode() + "\",\n    \"label\": \"" + getLabel() + "\",\n    \"type\": \""+ getType() + "\",\n    \"apr\": " + apr;
	}
	

}

class Stock extends Asset {
	private double quarterlyDividend;
	private double baseRateOfReturn;
	private double betaMeasure;
	private String stockSymbol;
	private double sharePrice;
	private int shares;

	public String getType() {
		return "S";
	}

	public double getQuarterlyDividend() {
		return quarterlyDividend;
	}

	public double getBaseRateOfReturn() {
		return baseRateOfReturn;
	}

	public double getBetaMeasure() {
		return betaMeasure;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public double getSharePrice() {
		return sharePrice;
	}
	

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public Stock(String code, String label, double quarterlyDividend, double baseRateOfReturn, double betaMeasure,
			String stockSymbol, double sharePrice) {
		super(code, label);
		this.quarterlyDividend = quarterlyDividend;
		this.baseRateOfReturn = baseRateOfReturn;
		this.betaMeasure = betaMeasure;
		this.stockSymbol = stockSymbol;
		this.sharePrice = sharePrice;
	}
	public String toString() {
		return "\"code\": \"" + getCode() + "\",\n    \"label\": \"" + getLabel() + "\",\n    \"type\": \"" + getType() + "\",\n    \"baseRateOfReturn\": " + baseRateOfReturn + ",\n    \"quarterlyDividend\": " + quarterlyDividend
				+ ",\n    \"sharePrice\": " + sharePrice + ",\n    \"stockSymbol\": \""+ stockSymbol + "\",\n    \"beta\": " + betaMeasure;
	}

}

class Investment extends Asset {
	private double quarterlyDividend;
	private double baseRateOfReturn;
	private double baseOmegaMeasure;
	private double totalValue;
	private double stake;

	public String getType() {
		return "P";
	}

	public double getQuarterlyDividend() {
		return quarterlyDividend;
	}

	public double getBaseRateOfReturn() {
		return baseRateOfReturn;
	}

	public double getBaseOmegaMeasure() {
		return baseOmegaMeasure;
	}

	public double getTotalValue() {
		return totalValue;
	}
	

	public double getStake() {
		return stake;
	}

	public void setStake(double stake) {
		this.stake = stake;
	}

	public Investment(String code, String label, double quarterlyDividend, double baseRateOfReturn,
			double baseOmegaMeasure, double totalValue) {
		super(code, label);
		this.quarterlyDividend = quarterlyDividend;
		this.baseRateOfReturn = baseRateOfReturn;
		this.baseOmegaMeasure = baseOmegaMeasure;
		this.totalValue = totalValue;
	}

	public String toString() {
		return "\"code\": \"" + getCode() + "\",\n    \"label\": \"" + getLabel() + "\",\n    \"type\": \"" + getType() + "\",\n    \"baseRateOfReturn\": " + baseRateOfReturn + ",\n    \"quarterlyDividend\": " + quarterlyDividend
				+ ",\n    \"omega\": " + baseOmegaMeasure + ",\n    \"totalValue\": "+ totalValue;
	}
	

}