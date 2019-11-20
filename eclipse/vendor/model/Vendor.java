package com.vendor.model;

public class Vendor {

//defining variables
	
	int userId;
	String username;
	String password;
	int id;
	String vendorName;
	String address;
	String location;
	String service;
	int pin;
	int isActive;
	String name;
	int vendorId;
	String department;
	String email;
	String phone;

//to parameterized constructors
	public Vendor(int userId, String username, String password, int id,
			String vendorName, String address, String location, String service,
			int pin, int isActive, String name, int vendorId,
			String department, String email, String phone) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.id = id;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pin = pin;
		this.isActive = isActive;
		this.name = name;
		this.vendorId = vendorId;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}

//getters and setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Vendor [userId=" + userId + ", username=" + username
				+ ", password=" + password + ", id=" + id + ", vendorName="
				+ vendorName + ", address=" + address + ", location="
				+ location + ", service=" + service + ", pin=" + pin
				+ ", isActive=" + isActive + ", name=" + name + ", vendorId="
				+ vendorId + ", department=" + department + ", email=" + email
				+ ", phone=" + phone + "]";
	}

}
