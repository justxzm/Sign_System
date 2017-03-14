package just.ca.Dao;

import java.util.List;

import just.ca.einity.Administrator;
import just.ca.einity.Member;

public interface MemberDao {
	List<Member> findAll() throws Exception;
	Member findById(long number) throws Exception;
	public void insert(long number,String name,String sex,String profession,String phone,String qqnumber,int times) throws Exception;
	public void delete(long number) throws Exception;
}
