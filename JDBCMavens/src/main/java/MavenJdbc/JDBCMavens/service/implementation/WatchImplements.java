package MavenJdbc.JDBCMavens.service.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import MavenJdbc.JDBCMavens.Mysql.implementation.CURD;
import MavenJdbc.JDBCMavens.entity.WatchTypes;
import MavenJdbc.JDBCMavens.entity.Watches;
import MavenJdbc.JDBCMavens.exception.CustomException;
import MavenJdbc.JDBCMavens.service.WatchInteface;

public class WatchImplements implements WatchInteface {
	Scanner scanner = new Scanner(System.in);

	@Override
	public void addWatchType() throws CustomException {
		String sql = "create table WatchTypes(id int unique,name varchar(50),PRIMARY KEY (id))";
		checkTable("WatchTypes", sql);
		// TODO Auto-generated method stub
		System.out.println("Enter the Watch Type Name");
		System.out.println(scanner.hasNext());
		String name = scanner.next();
		System.out.println("Create id for Watch Type");
		int id = 0;
		id = scanner.nextInt();
		try {
			id = check(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WatchTypes watchTypes = new WatchTypes();
		watchTypes.setId(id);
		watchTypes.setWatchtype(name);
		String sqli = "insert into WatchTypes values(" + watchTypes.getId() + ",'" + watchTypes.getWatchtype() + "')";
		CURD curd = new CURD();
		if (curd.insertTable(sqli) > 0) {
			System.out.println("inserted successfully");
		} else
			System.out.println(" not inserted ");
		scanner.nextLine();
	}

	private void checkTable(String table, String sql) {
		// TODO Auto-generated method stub
		CURD curd = new CURD();
		if (!curd.tableExist(table)) {
			curd.createTable(sql);
			System.out.println(table + " Table is Created");
		} else {
			System.out.println(table + " Table is already created");
		}
	}

	private int check(int id) throws CustomException, SQLException {
		// TODO Auto-generated method stu
		if (validateID(id)) {
			System.out.println("This ID is Already Assigned!! Try Again plzz");
			CustomException c = new CustomException("id is allready ");
			throw c;
		} else {
			System.out.println(id);
			return id;

		}
	}

	private int checkwacth(int id) throws CustomException, SQLException {
		// TODO Auto-generated method stub
		if (validateID(id)) {
			System.out.println(validateID(id)+"ddsss");
			return id;
		} else {
			System.out.println("This ID not found");
			CustomException c = new CustomException("id is not found");
			throw c;
		}
	}

	private boolean validateID(int id) throws SQLException {
		// TODO Auto-generated method stub
		CURD curd = new CURD();
		ResultSet rs = null;
		rs = curd.retriveData("select name from WatchTypes where id =" + id);
//			System.out.println(rs.next());
			if (rs.next() == false) {
				return false;
			} else
				return true;

	}

	@Override
	public void addWatch() throws CustomException {
		// TODO Auto-generated method stub
		String sql = "create table Watch(watchid int unique,modelname varchar(50),price float,typeid int, PRIMARY KEY (watchid),FOREIGN KEY (typeid) REFERENCES WatchTypes(id) on delete cascade);";
		checkTable("Watch", sql);
		System.out.println("Enter the id of wacth type");
		int tid = scanner.nextInt();
		try {
			tid = checkwacth(tid);
		} catch ( SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Enter the id of wacthes");
		int id = scanner.nextInt();
		System.out.println("Enter the Model name");
		String modelname = scanner.next();
		System.out.println("Enter the price of watch");
		float price = scanner.nextFloat();
		CURD curd = new CURD();
		ResultSet rs = curd.retriveData("select name from WatchTypes where id =" + tid);
		String name = null;
		try {
			rs.next();
			System.out.println(rs.getString("name"));
			name = rs.getString("name");
			Watches watchs = new Watches(name, tid);
			watchs.setId(id);
			watchs.setModelnmae(modelname);
			watchs.setPrice(price);
			watchs.setTid(tid);
			String sqli = "insert into Watch values(" + watchs.getId() + ",'" + watchs.getModelnmae() + "',"
					+ watchs.getPrice() + "," + watchs.getTid() + ")";
			if (curd.insertTable(sqli) > 0) {
				System.out.println("inserted successfully");
			} else
				System.out.println("insertion not successfully");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		scanner.nextLine();
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		CURD curd = new CURD();
		boolean flag = false;
		ResultSet rs = null;
		rs = curd.retriveData("select *  from Watch order by price");
		try {
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getFloat(3) + " " + rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		CURD curd = new CURD();
		boolean flag = false;
		ResultSet rs = null;
		rs = curd.retriveData("select *  from Watch");
		try {
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getFloat(3) + " " + rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("enter the type id");
		int tid = scanner.nextInt();
		CURD curd = new CURD();
		int temp = curd.removeTable("delete from WatchTypes where id = " + tid);
		if (temp > 0)
			System.out.println("deleted");
		else
			System.out.println("not deleted");

	}

}
