package com.frank.cucumberframework.framework.utils.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQLManager implements IDataSource {

	String dbName = "";
	String tableName = "";

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = "";
    Connection conn = null;

	public MySQLManager(String dbName, String tableName) {

		this.dbName = dbName;
		this.tableName = tableName;
		startDBConnection(dbName, tableName);
	}

	private void startDBConnection(String DBName, String collectionName) {
		try {
	        Class.forName(driver).newInstance(); 
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void stopDBConnection() {
		conn = null;
		System.gc();
	}

	private void initData() {


	}

	public String getProperty(String key) {

	    String sql = "select * from tmp1";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;

	}

	public void writeNewProperty(String key, String value) {


	}

	public static void main(String[] args) {

		MySQLManager mysql = new MySQLManager("test", "tmp1");
		mysql.getProperty("url");
		//mongo.writeNewProperty("username", "13810033664");
	}

}
