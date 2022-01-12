package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.management.relation.Role;

public class ConnectDB {
	Connection conn;
	Statement stmt;
	//connect from java to sql
	public void connect() {
		try {
			// load driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// start connecting 
			conn = DriverManager.getConnection("jdbc:sqlserver://SANG\\SQLEXPRESS:1433;databaseName=FinalExam;user=sa;password=1234");
			System.out.println("Connection");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error");
		}
	}
		public int ExcuteUpdate(String sql) {
		int record=0; // number of affected rows
		try {
			connect();
			stmt = conn.createStatement(); 
			record = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return record;
	}
	public ResultSet SelectDB(String sql) {
		ResultSet rs=null;
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
}
