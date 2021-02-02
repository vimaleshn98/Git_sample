package MavenJdbc.JDBCMavens.Mysql.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	protected Connection getConnection() {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WatchManagement?autoReconnect=true&useSSL=false","root","vi@7349216534");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("------------------Sorry!! Class Not found(Loading of driver error)------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("------------------Sorry!! Connection Not establish(Connection error)------------------------------");
		}
		return con;
	}
}
