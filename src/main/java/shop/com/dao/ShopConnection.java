package shop.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShopConnection {// mysql connection
	static final private String URL="jdbc:mysql://localhost:3306/spring_shop";
	static final private String USER="root";
	static final private String PW="mysql";
	static final private String DRIVER="com.mysql.cj.jdbc.Driver";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn=null;
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL,USER,PW);
		return conn;
	}
}
