package jdbc_api;

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import control.DBMS;

public class JDriver implements java.sql.Driver{
	
	//*********************************************
	//01_Attributes
	public static DBMS databaseManager;
	

	// Register ourselves with the DriverManager
    static {
        try {
            java.sql.DriverManager.registerDriver(new JDriver());
        } catch (SQLException E) {
            throw new RuntimeException("Can't register driver!");
        }
    }

    //*********************************************
  	//02_Constructor //Construct a new driver and register it with DriverManager
    public JDriver() throws SQLException {
        // Required for Class.forName().newInstance()
    	databaseManager=new DBMS();
    }

	@Override
	public boolean acceptsURL(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		String database_address=url; //how to obtain database name
		if(databaseManager.connectToDatabase(database_address)==true){
			JConnection conn=new JConnection(database_address);
			return conn;
		}
		return null;
	}
	
	@Override
	public DriverPropertyInfo[] getPropertyInfo(String arg0, Properties arg1) throws SQLException {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	//************************************************
	//************************************************
	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}

}
