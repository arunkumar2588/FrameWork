	package Practice;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class ReadDataFromMySqlNonSelectQuery {

	public static void main(String[] args) throws SQLException {
		//step 1: Register or load the MySql database
		Driver driverref=new Driver();
		DriverManager.deregisterDriver(driverref);
		
		//step 2: Get connect to database										//database name
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
																				//test_yantra
		//step 3: create sql statement 
		Statement stat=conn.createStatement();
		
		String query = "insert into student(first_name,last_name,address)values('raju','BN','INDIA')";
		
		//step 4: Execute query
		int result =stat.executeUpdate(query); 	//primitive data type contain level comparison
												//non-primitive data type address level comparison
		
		if(result==1) {
			System.out.println("user is created");
		}
		else {
			System.out.println("user is not created");
		}
		//step 5: close the database connection
		conn.close();
	}
	}

