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
	 
	 
	 public boolean updateUser(user user) {

	        boolean f = false;
	        try {

	            String query = "update user set User_Name=? , User_Email=? , User_Password=? , User_Gender=? ,User_About=? , User_Profile=? where  User_ID =?";
	            PreparedStatement p = con.prepareStatement(query);
	            p.setString(1, user.getName());
	            p.setString(2, user.getEmail());
	            p.setString(3, user.getPassword());
	            p.setString(4, user.getGender());
	            p.setString(5, user.getAbout());
	            p.setString(6, user.getProfile());
	            p.setInt(7, user.getId());

	            p.executeUpdate();
	            f = true;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return f;
	    }
	 public user getUserByUserId(int userId) {
	        user u = null;
	        try {
	            String q = "select * from user where User_ID=?";
	            PreparedStatement ps = this.con.prepareStatement(q);
	            ps.setInt(1, userId);
	            ResultSet set = ps.executeQuery();
	            if (set.next()) {
	                u = new user();

//	             data from db
	                String name = set.getString("name");
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