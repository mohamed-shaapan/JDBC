package testpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AbstractJDBC {

	public static void main(String[] args) throws SQLException {
	
		final String host_address="DatabaseRepository\\";
		//Table info
		String database_name="pepsico";
		String database_address=database_name;
		String sqlQuery="create table clients (name varchar, address varchar);";
		//********************************************************
		
		//********************************************************
		try{
			//00_(Register Driver)Specify which Driver the DriverManager should use
			Class.forName("jdbc_api.JDriver");
			//DriverManager.registerDriver(new JDriver());
			System.out.println("REGISTER DRIVER SUCCESS********************");
			
			//01_Make connection to database
			Connection targetDatabase=DriverManager.getConnection(database_address);
			System.out.println("DATABASE CONNECTION SUCCESSFULL************");
			
			
			//02_Create SQL statement class
			Statement sampleStatement=targetDatabase.createStatement();
			
			//03_Execute SQL query
			ResultSet result=sampleStatement.executeQuery(sqlQuery);
			
			//04_View Result
			/*while(result.next()){
				System.out.println("user name : "+result.getString("userName"));
				System.out.println("user email : "+result.getString("Email"));
				System.out.println("user password : "+result.getString("Password"));
				System.out.println("***********************************************");
			}*/
		}catch(Exception ex){
			System.out.println("Failed");
		}
		
	}

}
