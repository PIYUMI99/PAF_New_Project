package org.restapi.crud.crud.model;

public class crudmodel {
	
	private String name;
	private int age;
	
	
	public crudmodel() {
		
	}

	public crudmodel(String name,int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
