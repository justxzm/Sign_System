package just.ca.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");                            //1.����������
		String url="jdbc:mysql://localhost:3306/jsd1507";              //2.�������ݿ⣻
    	String user="";                                                       
    	String password="";                                           
    	return DriverManager.getConnection(url, user, password);
	}
}
