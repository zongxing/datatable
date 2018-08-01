package com.mashensoft.model;

/**
 * {"data":[{"address":"5","age":"5","date":"5","name":"5","office":"5","salary":"5"}],"draw":5,"recordsFiltered":11,"recordsTotal":11}

 * @author zongxing
 *
 */
public class Data {
	private String address;
	private String age;
	private String date;
	private String name;
	private String office;
	private String salary;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Data(String address, String age, String date, String name, String office, String salary) {
		super();
		this.address = address;
		this.age = age;
		this.date = date;
		this.name = name;
		this.office = office;
		this.salary = salary;
	}
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
