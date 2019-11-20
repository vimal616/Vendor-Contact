package com.vendor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.ProductDao;
import com.Model.Admin;
import com.Model.ProductBean;
import com.vendor.Dao.Ivendor;
import com.vendor.model.Vendor;
@RestController
public class VendorController {
	
	//@Autowired
	Ivendor dao;
//to get all vendor details
	
	@RequestMapping(value="/vendors",method=RequestMethod.GET)
	public List vendorView()
	{
		List list=dao.vendorList();
		return list;
	}
	
//to getvendor by id
	@RequestMapping(value="/vendors/{id}",method=RequestMethod.GET)
	public Vendor viewProduct(@PathVariable("id") int id)
	{
		Vendor pd= dao.vendorById(id);
		
		return pd;
		
	}
	
//to search vendor
	@RequestMapping(value="/vendor/{search}",method=RequestMethod.GET)
	public List viewsearch(@PathVariable("search") String search)
	{
		List list=dao.vendorSearch(search);
		return list;
	}
	
//to disable vendor
	@RequestMapping(value="/disable/{id}",method=RequestMethod.PUT)
	public void disable(@PathVariable("id") int id)
	{
		 dao.disable(id);
	}
	
	
//to add new vendor
	@RequestMapping(value="/vendor/add",method={RequestMethod.POST,RequestMethod.PUT})
	public void insertVendor(@RequestBody Vendor vend)
	{
		if(vend.getId()==0)
		{
			dao.vendorInsert(vend);
		}
		else
		{
			dao.update(vend);
		}
		
	}

	//login service
	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	public Vendor getRole(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		System.out.println("Role");
		return dao.RoleChecker(username, password);
		
	}
	
	
	

}
