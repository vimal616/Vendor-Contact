package com.vendor.Dao;

import java.util.List;

import com.vendor.model.Vendor;

public interface Ivendor {

	//view vendor details
	public abstract List<Vendor> vendorList();

	//to get vendor details by id

	public abstract Vendor vendorById(int id);

	//to search vendor

	public abstract List<Vendor> vendorSearch(String search);

	public abstract int vendorInsert(Vendor vend);

	//to update existing vendor
	public abstract int update(Vendor vend);

	public abstract int disable(int id);

	//to login
	public abstract Vendor RoleChecker(String username, String password);

}