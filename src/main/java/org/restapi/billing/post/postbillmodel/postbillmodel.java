package org.restapi.billing.post.postbillmodel;

public class postbillmodel {
	
	private int billID;
	private int billnumber;
	
	//Empty Constructor
	public postbillmodel() {
		
	}
	
	//Constructor
	public postbillmodel(int billID,int billnumber) {
		super();
		this.billID = billID;
		this.billnumber = billnumber;
	}
		
	//Bill ID Getter and Setter
	public int getBillID() {
		return billID;
	}
	
	public void setBillID(long l) {
		this.billID = l;
	}
	
	//Bill Number Getter and Setter
	public int getBillnumber() {
		return billnumber;
	}
	public void setBillnumber(long l) {
		this.billnumber = l;
	}
	

}
