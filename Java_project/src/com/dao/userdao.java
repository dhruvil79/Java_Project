package com.dao;
import java.sql.*;

import com.entities.user;

public class userdao {
	private Connection con;

	public userdao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean saveUser(user u)
	{
		boolean f=false;
		try
		{
			String qurey="insert into user(User_Name,User_Email,User_Password,User_Gender,User_About) values(?,?,?,?,?)";
			PreparedStatement pst=this.con.prepareStatement(qurey);
			pst.setString(1,u.getName());
			pst.setString(2,u.getEmail());
			pst.setString(3,u.getPassword());
			pst.setString(4,u.getGender());
			pst.setString(5,u.getAbout());
			pst.executeUpdate();
			f=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	 public user getUserByEmailAndPassword(String email, String password) {
	        user u = null;

	        try {

	            String query = "select * from user where User_Email =? and User_Password=?";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setString(1, email);
	            pstmt.setString(2, password);

	            ResultSet set = pstmt.executeQuery();

	            if (set.next()) {
	                u = new user();

//	             data from db
	                String name = set.getString("User_Name");
//	             set to user object
	                u.setName(name);

	                u.setId(set.getInt("User_ID"));
	                u.setEmail(set.getString("User_Email"));
	                u.setPassword(set.getString("User_Password"));
	                u.setGender(set.getString("User_Gender"));
	                u.setAbout(set.getString("User_About"));
	                u.setDateTIme(set.getTimestamp("User_Date"));
	                u.setProfile(set.getString("User_Profile"));

	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return u;
	    }
}