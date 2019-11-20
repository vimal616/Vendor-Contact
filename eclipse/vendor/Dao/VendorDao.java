package com.vendor.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Model.Admin;
import com.Model.ProductBean;
import com.vendor.model.Vendor;

public class VendorDao implements Ivendor {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;

	}
//view vendor details
	/* (non-Javadoc)
	 * @see com.vendor.Dao.Ivendor#vendorList()
	 */
	public List<Vendor> vendorList() {
		return template
				.query("select tbl_vendor.id,vendorName,address,location,service,pin,name,vendorId,department,email,phone,tbl_vendor.isActive from tbl_vendor join tbl_contact on (tbl_vendor.id=tbl_contact.vendorId)where tbl_vendor.isActive=1",
						new RowMapper<Vendor>() {

								public Vendor mapRow(ResultSet rs, int row)
									throws SQLException {
								// TODO Auto-generated method stub

								Vendor vend = new Vendor();
								vend.setId(rs.getInt(1));
								vend.setVendorName(rs.getString(2));
								vend.setAddress(rs.getString(3));
								vend.setLocation(rs.getString(4));
								vend.setService(rs.getString(5));
								vend.setPin(rs.getInt(6));
								vend.setName(rs.getString(7));
								vend.setVendorId(rs.getInt(8));
								vend.setDepartment(rs.getString(9));
								vend.setEmail(rs.getString(10));
								vend.setPhone(rs.getString(11));
								vend.setIsActive(rs.getInt(12));
								
								

								return vend;
							}
						});

	}
//to get vendor details by id

	/* (non-Javadoc)
	 * @see com.vendor.Dao.Ivendor#vendorById(int)
	 */
	public Vendor vendorById(int id) {
		String sql = "select tbl_vendor.id,vendorName,address,location,service,pin,name,vendorId,department,email,phone from tbl_vendor join tbl_contact on (tbl_vendor.id=tbl_contact.vendorId) where tbl_vendor.id=?";
				
		return (Vendor) template.queryForObject(sql, new Object[] { id },new BeanPropertyRowMapper<Vendor>(Vendor.class)
				);
	}
//to search vendor

	/* (non-Javadoc)
	 * @see com.vendor.Dao.Ivendor#vendorSearch(java.lang.String)
	 */
	public List<Vendor> vendorSearch(String search) {
		return template
				.query("select tbl_vendor.id,vendorName,address,location,service,pin,name,vendorId,department,email,phone from tbl_vendor join tbl_contact on (tbl_vendor.id=tbl_contact.vendorId) where vendorName like'"
						+ search + "%' or location like'" + search + "%' or service like'" +search+"%'",
						new RowMapper<Vendor>() {

							public Vendor mapRow(ResultSet rs, int row)
									throws SQLException {
								Vendor vend = new Vendor();
								vend.setId(rs.getInt(1));
								vend.setVendorName(rs.getString(2));
								vend.setAddress(rs.getString(3));
								vend.setLocation(rs.getString(4));
								vend.setService(rs.getString(5));
								vend.setPin(rs.getInt(6));
								vend.setName(rs.getString(7));
								vend.setVendorId(rs.getInt(8));
								vend.setDepartment(rs.getString(9));
								vend.setEmail(rs.getString(10));
								vend.setPhone(rs.getString(11));

								return vend;
							}

						});
	}

//To add new vendor 
	
	/* (non-Javadoc)
	 * @see com.vendor.Dao.Ivendor#vendorInsert(com.vendor.model.Vendor)
	 */
	public int vendorInsert(Vendor vend)
	{
		String sql="insert into tbl_vendor(id,vendorName,address,location,service,pin,isActive) values(?,?,?,?,?,?,?)";
		template.update(sql,new Object[] {vend.getId(),vend.getVendorName(),vend.getAddress(),vend.getLocation(),vend.getService(),vend.getPin(),1});
		
		String sql1="select max(id) from tbl_vendor";
		int vendorId=template.queryForObject(sql1,Integer.class);
		
		String sql2="insert into tbl_contact(id,name,vendorId,department,email,phone) values(?,?,?,?,?,?)";
		return template.update(sql2,new Object[] {  vend.getId(),vend.getName(),vendorId,vend.getDepartment(),vend.getEmail(),vend.getPhone()});
		
		
		
	}

//to update existing vendor
	/* (non-Javadoc)
	 * @see com.vendor.Dao.Ivendor#update(com.vendor.model.Vendor)
	 */
	public int update(Vendor vend)
	{
		String sql="update tbl_vendor set vendorName=?,address=?,location=?,service=?,pin=?,isActive=1 where id=?";
		template.update(sql,new Object[] {vend.getVendorName(),vend.getAddress(),vend.getLocation(),vend.getService(),vend.getPin(),vend.getIsActive()});
		String sql1="update tbl_contact set name=?,department=?,email=?,phone=? where id=?";
		return template.update(sql1, new Object[] {vend.getName(),vend.getDepartment(),vend.getEmail(),vend.getPhone(),vend.getId()});
	}

//to disable a vendor
	
	/* (non-Javadoc)
	 * @see com.vendor.Dao.Ivendor#disable(int)
	 */
	public int disable(int id){
		String sql="update tbl_vendor set isActive=2 where id="+id+"";
		return template.update(sql);
		
	}
	
//to login
	/* (non-Javadoc)
	 * @see com.vendor.Dao.Ivendor#RoleChecker(java.lang.String, java.lang.String)
	 */
	public Vendor RoleChecker(String username, String password) {
		  
		String sql = "select userId  from ust_log where username = ? and password = ?";
		Vendor ad= template.queryForObject(sql,
				new Object[] { username, password },
				new BeanPropertyRowMapper<Vendor>(Vendor.class));
		
		
		int role=ad.getUserId();
		System.out.println(role);
		
		return ad;
	}

}
