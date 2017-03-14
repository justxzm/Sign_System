package just.ca.Dao;

import java.util.List;

import just.ca.einity.Administrator;


public interface AdministratorDao {
	List<Administrator> findAll() throws Exception;
	Administrator findById(int number) throws Exception;
	public void insert(int number,String name,String password) throws Exception;
	public void insert2(int number,String name,String password,int times) throws Exception;
	public void modify(int number) throws Exception;
}