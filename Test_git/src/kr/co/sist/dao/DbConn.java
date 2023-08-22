package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConn {
	private static DbConn dbConn;
	
	private DbConn() {
		
	}//constructor
	
	public static DbConn getInstance() {
		if(dbConn == null) {
			dbConn=new DbConn();
		}//if
		return dbConn;
	}//getInstance
	
	public Connection getConnection(String ip, String id,String pw) throws SQLException {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//catch
		
		String url = "jdbc:oracle:thin:@"+ip+":1521:orcl";
		
		con = DriverManager.getConnection(url,id,pw);
		
	
		return con;
	}//getConnection
	
	public void dbClose(ResultSet rs, Statement stmt, Connection con) throws SQLException {
		if(rs!=null) {rs.close();}
		if(stmt!=null) {stmt.close();}
		if(con!=null) {con.close();}
	}//dbClose
}//class
