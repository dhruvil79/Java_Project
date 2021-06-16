package com.dao;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import com.entities.category;
import com.entities.post;

public class postdao {
	private Connection con;
	
	public postdao(Connection con)
	{
		this.con=con;
	}
	
	public ArrayList<category> getAllcategory()
	{
		ArrayList<category> list = new ArrayList<>();

        try {

            String q = "select * from categories";
            Statement st = this.con.createStatement();
            ResultSet set = st.executeQuery(q);
            while (set.next()) {
                int cid = set.getInt("cid");
                String name = set.getString("name");
                String description = set.getString("description");
                category c = new category(cid, name, description);
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
	}
	
	public boolean savePost(post p)
	{
        boolean f = false;
        try 
        {

            String q = "insert into posts(pTitle,pContent,pCode,pPic,cid,user_Id) values(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, p.getpTitle());
            pstmt.setString(2, p.getpContent());
            pstmt.setString(3, p.getpCode());
            pstmt.setString(4, p.getpPic());
            pstmt.setInt(5, p.getCid());
            pstmt.setInt(6, p.getId());
            pstmt.executeUpdate();
            f = true;

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return f;
    }
	
	
	 public List<post> getAllPosts() {

	        List<post> list = new ArrayList<>();
	        //fetch all the post
	        try {

	            PreparedStatement p = con.prepareStatement("select * from posts order by pid desc");

	            ResultSet set = p.executeQuery();

	            while (set.next()) {

	                int pid = set.getInt("pid");
	                String pTitle = set.getString("pTitle");
	                String pContent = set.getString("pContent");
	                String pCode = set.getString("pCode");
	                String pPic = set.getString("pPic");
	                Timestamp date = set.getTimestamp("pDate");
	                int catId = set.getInt("cid");
	                int userId = set.getInt("id");
	                post p1 = new post(pid, pTitle, pContent, pCode, pPic, date, catId, userId);

	                list.add(p1);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    public List<post> getPostByCatId(int catId) {
	        List<post> list = new ArrayList<>();
	        //fetch all post by id
	        //fetch all the post
	        try {

	            PreparedStatement p = con.prepareStatement("select * from posts where cid=?");
	            p.setInt(1,catId);
	            ResultSet set = p.executeQuery();

	            while (set.next()) {

	                int pid = set.getInt("pid");
	                String pTitle = set.getString("pTitle");
	                String pContent = set.getString("pContent");
	                String pCode = set.getString("pCode");
	                String pPic = set.getString("pPic");
	                Timestamp date = set.getTimestamp("pDate");
	                int userId = set.getInt("user_Id");
	                post p1 = new post(pid, pTitle, pContent, pCode, pPic, date, catId, userId);

	                list.add(p1);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	
	    public post getPostByPostId(int postId) {
	        post p1 = null;
	        String q = "select * from posts where pid=?";
	        try {
	            PreparedStatement p = this.con.prepareStatement(q);
	            p.setInt(1, postId);

	            ResultSet set = p.executeQuery();

	            if (set.next()) {

	                int pid = set.getInt("pid");
	                String pTitle = set.getString("pTitle");
	                String pContent = set.getString("pContent");
	                String pCode = set.getString("pCode");
	                String pPic = set.getString("pPic");
	                Timestamp date = set.getTimestamp("pDate");
	                int cid=set.getInt("cid");
	                int userId = set.getInt("user_Id");
	                p1 = new post(pid, pTitle, pContent, pCode, pPic, date, cid, userId);

	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return p1;
	    }
}
