package testpackage;

import java.io.OutputStream;
import java.io.PrintStream;

import control.DBMS;

public class Test {

	//*****************************************************
	public static void main(String args[]){
		testDBMS();
	}
	//*****************************************************
	
	//*****************************************************
	public static void testDBMS(){
		//01_Iniialize DBMS
		DBMS databaseManager=new DBMS();
		//02_Create query statements
		String q1="create database pepsico;";
		String q2="use pepsico;";
		String q3="create table clients (name varchar, address varchar);";
		String q4="insert into clients (name, address) values (\"mohamed\", \"cairo\");";
		//03_Implement queries
		databaseManager.implementQuery(q1);
		databaseManager.implementQuery(q2);
		databaseManager.implementQuery(q3);
		databaseManager.implementQuery(q4);
		
		
		//This function prevents System.out.println() statements from called functions
		System.setOut(new PrintStream(new OutputStream() {
			  public void write(int b) {
				  databaseManager.implementQuery(q1);
			  }
		}));
	}
	//*****************************************************
	
	
}
