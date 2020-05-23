package com.studentdatabase.bean;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{

	private String name; 
	private String address; 
	private String department;
	private int rollNo;
	private long phone;
	private Date dob;
	
	public Student() {

	}
	public Student(String name, String address, String department, int rollNo, long phone, Date dob) {
		this.name = name;
		this.address = address;
		this.department = department;
		this.rollNo = rollNo;
		this.phone = phone;
		this.dob = dob;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getName() {
		return this.name;
	}

	public Date getDob() {
		return this.dob;
	}

	public int getRollno() {
		return this.rollNo;
	}

	public String getAddress() {
		return this.address;
	}

	public long getPhone() {
		return this.phone;
	}

	public String getDepartment() {
		return this.department;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", department=" + department + ", rollNo=" + rollNo
				+ ", phone=" + phone + ", dob=" + dob + "]";
	}
	
}