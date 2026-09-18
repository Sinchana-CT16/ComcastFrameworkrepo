package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	Connection con;

	public Connection getDatabaseConnection() throws Exception {
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3037/ninza_hrm", "root@%", "root");
		return con;
	}

	public ResultSet excecuteSelectQuery(String query) throws Exception {
		Statement st = con.createStatement();
		return st.executeQuery(query);
	}

	public ResultSet exeuteNonSelectQuery(String query) throws Exception {
		Statement st = con.createStatement();
		return st.executeQuery(query);
	}

	public void closeDatabaseConnection() throws Exception {
		con.close();
	}

}