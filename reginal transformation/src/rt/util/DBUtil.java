package rt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBUtil {
 public Connection getConn()
 {
  Connection conn=null;
  try {
   Class.forName("com.mysql.jdbc.Driver");
  } catch (ClassNotFoundException e) {
   e.printStackTrace();
  }
  String url="jdbc:mysql://localhost:3306/regional transformation";
  try {
   conn=DriverManager.getConnection(url, "root", "123");
  } catch (SQLException e) {
   e.printStackTrace();
  }  
  return conn;
 }
 
 public void closeAll(ResultSet rs,Statement stat,Connection conn)
 {
  if(rs!=null)
   try {
    rs.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  if(stat!=null)
   try {
    stat.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
  if(conn!=null)
   try {
    conn.close();
   } catch (SQLException e) {
    e.printStackTrace();
   }
 }

}	

