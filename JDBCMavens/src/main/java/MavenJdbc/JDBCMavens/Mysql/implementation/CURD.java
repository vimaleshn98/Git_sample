package MavenJdbc.JDBCMavens.Mysql.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CURD extends GetConnection {
	Connection con = getConnection();
//	System.out.println(sql);
	ResultSet rs =null;
	Statement st = null;
	public ResultSet retriveData(String sql) {
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	public int createTable(String sql) {
		int temp = 0;
		try {
			st = con.createStatement();
			temp = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		return temp;
	}
	public  boolean tableExist(String tableName)  {
	    boolean tExists = false;
	    try {
	    	ResultSet rs = con.getMetaData().getTables(null, null, tableName, null);
	        while (rs.next()) { 
	            String tName = rs.getString("TABLE_NAME");
	            if (tName != null && tName.equals(tableName)) {
	                tExists = true;
	                break;
	            }
	        }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return tExists;
	}
	public int insertTable(String sql) {
		int temp = 0;
		try {
			st = con.createStatement();
			temp = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("id is already used ");
		}
		return temp;
	}
	public int removeTable(String sql) {
		int temp = 0;
		try {
			st = con.createStatement();
			temp = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	public int updateTable(String sql) {
	
		int temp = 0;
		try {
			st = con.createStatement();
			temp = st.executeUpdate(sql);
			return temp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return temp;
		return temp;
	}
	public void closeConnection(String sql) {
		try {
			st.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
