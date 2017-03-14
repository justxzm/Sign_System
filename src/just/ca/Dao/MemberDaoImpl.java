package just.ca.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import just.ca.einity.Administrator;
import just.ca.einity.Member;
import just.ca.util.ConnectionUtil;

public class MemberDaoImpl implements MemberDao{
	public void delete(long number) throws Exception{
		Connection conn=ConnectionUtil.getConnection();
		String sql="delete from member where number=?";
	    PreparedStatement pstmt=conn.prepareStatement(sql);   
		pstmt.setLong(1, number);
		pstmt.executeUpdate();     	
		pstmt.close();
		conn.close();
	}
	public void insert(long number,String name,String sex,String profession,String phone,String qqnumber,int times) throws Exception{
		Connection conn=ConnectionUtil.getConnection();
		String sql="insert into member values(?,?,?,?,?,?,?)";
	    PreparedStatement pstmt=conn.prepareStatement(sql);   
		pstmt.setLong(1, number);
		pstmt.setString(2,name);
		pstmt.setString(3,sex);
		pstmt.setString(4,profession);
		pstmt.setString(5,phone);
		pstmt.setString(6, qqnumber);
		pstmt.setInt(7, times);
		pstmt.executeUpdate();     	
		pstmt.close();
		conn.close();
	}
	public List<Member> findAll() throws Exception{
		List<Member> members=new ArrayList<Member>();
		Connection conn=ConnectionUtil.getConnection();
		String sql="select * from member";
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			Member user=new Member();
			user.setNumber(rs.getLong("number"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setProfession(rs.getString("profession"));
			user.setPhone(rs.getString("phone"));
			user.setQqnumber(rs.getString("qqnumber"));
			user.setTimes(rs.getInt("times"));
			members.add(user);
		}
		rs.close();
    	stmt.close();
    	conn.close();
		return members;
	}
	public Member findById(long number) throws Exception{
		Member member=new Member();
		Connection conn=ConnectionUtil.getConnection();
		String sql="select * from member where number=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setLong(1, number);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			member.setNumber(number);
			member.setName(rs.getString("name"));
			member.setSex(rs.getString("sex"));
			member.setProfession(rs.getString("profession"));
			member.setPhone(rs.getString("phone"));
			member.setQqnumber(rs.getString("qqnumber"));
			member.setTimes(rs.getInt("times"));
		}
		return member;
	}
}
