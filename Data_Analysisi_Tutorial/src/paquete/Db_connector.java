package paquete;


import java.sql.*;
import javax.swing.*;

public class Db_connector {
	Connection con = null;
	
	public static Connection ConnectDb(){
		// Statement stmt = null;
	    // String sql = null;
		try{
			Connection con = DriverManager.getConnection("jdbc:sqlite:users.db");
			
			/*
			// DROP table when starting to avoid "TABLE ALREADY EXISTS"
			  stmt = con.createStatement();
			  sql = "DROP TABLE IF EXISTS Users";
			  stmt.execute(sql);
			  stmt.close();
			
			
			// CREATE TABLE 
			  stmt = con.createStatement();
			  sql = "CREATE TABLE IF NOT EXISTS Users " + 
					  "(userName CHAR(20) PRIMARY KEY NOT NULL," +
					  " pass CHAR(20) NOT NULL)";
			  stmt.execute(sql);
			  stmt.close();
			  
			  // Insert ADMIN to table
			  stmt = con.createStatement();
			  sql = "INSERT INTO Users(userName,pass) VALUES('admin','admin')";
			  stmt.execute(sql);
			  stmt.close();
			  
			  stmt = con.createStatement();
			  sql = "INSERT INTO Users(userName,pass) VALUES('admin1','admin1')";
			  stmt.execute(sql);
			  stmt.close();
			  */
			
			
			return con;
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    JOptionPane.showMessageDialog(null, e);
		    System.exit(0);
		    return null;
		}
		
	}
		
	public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    String sql = null;
	    
	    try {
	      // SQLite database connection
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:users.db");
		  System.out.println("Opened database successfully");
		  
		  
		  /* DESCOMENTAR LA PRIMERA VEZ QUE SE EJECUTE EL PROGRAMA
		   * PARA CREAR LAS TABLAS EN users.db
		   * TAMBIÉN SE PUEDE DESCOMENTAR SI SE QUIERE RESETEAR LA TABLA
		   * 
		   * 
		   * 
		  // DROP table when starting to avoid "TABLE ALREADY EXISTS"
		  stmt = c.createStatement();
		  sql = "DROP TABLE IF EXISTS Users";
		  stmt.execute(sql);
		  stmt.close();
		  
		  // CREATE TABLE 
		  stmt = c.createStatement();
		  sql = "CREATE TABLE Users " + 
				  "(userName CHAR(20) PRIMARY KEY NOT NULL," +
				  " pass CHAR(20) NOT NULL)";
		  stmt.execute(sql);
		  stmt.close();
		  
		  // Insert ADMIN to table
		  stmt = c.createStatement();
		  sql = "INSERT INTO Users(userName,pass) VALUES('admin','admin')";
		  stmt.execute(sql);
		  stmt.close();
		  */
		    
		    
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      JOptionPane.showMessageDialog(null, e);
	      System.exit(0);
	    }
	  }

}

