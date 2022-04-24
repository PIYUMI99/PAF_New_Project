package org.restapi.crud.crud.model;

public class crudmodel {
	private int id;
	private String name;
	private String nic;
	private String address;
	private int telNo;
	private int accNo;
	

	public crudmodel() {

	}


	public crudmodel(int id, String name, String nic, String address, int telNo, int accNo) {
		super();
		this.id = id;
		this.name = name;
		this.nic = nic;
		this.address = address;
		this.telNo = telNo;
		this.accNo = accNo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getTelNo() {
		return telNo;
	}


	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}


	public int getAccNo() {
		return accNo;
	}


	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	
	
	
}

	