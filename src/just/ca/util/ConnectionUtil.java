package just.ca.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");                            //1.加载驱动；
		String url="jdbc:mysql://localhost:3306/jsd1507";              //2.链接数据库；
    	String user="";                                                       
    	String password="";                                           
    	return DriverManager.getConnection(url, user, password);
	}
}
