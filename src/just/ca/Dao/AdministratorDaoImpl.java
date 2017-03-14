package just.ca.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import just.ca.einity.Administrator;
import just.ca.util.ConnectionUtil;



public class AdministratorDaoImpl implements AdministratorDao{
	public void modify(int number) throws Exception{
		Connection conn=ConnectionUtil.getConnection();
		String sql="delete from administrator where number=?";
	    PreparedStatement pstmt=conn.prepareStatement(sql);   
		pstmt.setInt(1, number);
		pstmt.executeUpdate();     	
		pstmt.close();
		conn.close();
	}
	public void insert(int number,String name,String password) throws Exception{
		Connection conn=ConnectionUtil.getConnection();
		String sql="insert into administrator values(?,?,?)";
	    PreparedStatement pstmt=conn.prepareStatement(sql);   
		pstmt.setInt(1, number);
		pstmt.setString(2,name);
		pstmt.setString(3, password);
		pstmt.executeUpdate();     	
		pstmt.close();
		conn.close();
	}
	public void insert2(int number,String name,String password,int times) throws Exception{
		Connection conn=ConnectionUtil.getConnection();
		String sql="insert into administrator values(?,?,?,?)";
	    PreparedStatement pstmt=conn.prepareStatement(sql);   
		pstmt.setInt(1, number);
		pstmt.setString(2,name);
		pstmt.setString(3, password);
		pstmt.setInt(4, times);
		pstmt.executeUpdate();     	
		pstmt.close();
		conn.close();
	}
	public List<Administrator> findAll() throws Exception{
		List<Administrator> administrators=new ArrayList<Administrator>();
		Connection conn=ConnectionUtil.getConnection();
		String sql="select * from administrator";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			Administrator user=new Administrator();
			user.setNumber(rs.getInt("number"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setTimes(rs.getInt("times"));
			administrators.add(user);
		}
		rs.close();
    	stmt.close();
    	conn.close();
		return administrators;
	}
	public Administrator findById(int number) throws Exception{
		Administrator administrator=new Administrator();
		Connection conn=ConnectionUtil.getConnection();
		String sql="select * from administrator where number=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, number);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			administrator.setNumber(number);
			administrator.setName(rs.getString("name"));
			administrator.setPassword(rs.getString("password"));
			administrator.setTimes(rs.getInt("times"));
		}
		return administrator;
	}
}
