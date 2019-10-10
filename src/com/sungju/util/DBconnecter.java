package com.sungju.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnecter {
	public static Connection getConnect() throws Exception {
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@192.168.183.3:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);

		return con;
	}

}
