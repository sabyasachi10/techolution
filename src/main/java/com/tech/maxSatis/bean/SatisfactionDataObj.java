package com.tech.maxSatis.bean;

public class SatisfactionDataObj implements Comparable<SatisfactionDataObj>{
	
	private int satisAmount;
	
	private int timeTaken;
	
	private double satisByTime;

	public int getSatisAmount() {
		return satisAmount;
	}

	public void setSatisAmount(int satisAmount) {
		this.satisAmount = satisAmount;
	}

	public int getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}

	public double getSatisByTime() {
		return satisByTime;
	}

	public void setSatisByTime(double satisByTime) {
		this.satisByTime = satisByTime;
	}

	@Override
	public int compareTo(SatisfactionDataObj satisfactionDataObj) {
		// TODO Auto-generated method stub
		//return (int) (this.satisByTime - satisfactionDataObj.satisByTime);
		return (int) (satisfactionDataObj.satisByTime - this.satisByTime);
	}
	
}
