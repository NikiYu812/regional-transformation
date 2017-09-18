package model.dao;

import java.sql.*;

public class dbDAO {
	private Connection con;

	public dbDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/regional transformation";
		try {
			this.con = DriverManager.getConnection(url, "root", "123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ִ�в�ѯ  
    public ResultSet query(String sql, Object... args) throws Exception {  
        PreparedStatement ps = con.prepareStatement(sql);  
        for (int i = 0; i < args.length; i++) {  
            ps.setObject(i + 1, args[i]);  
        }  
        return ps.executeQuery();  
    }  
  
    public boolean insert(String sql, Object... args) throws Exception {  
        PreparedStatement ps = con.prepareStatement(sql);  
        for (int i = 0; i < args.length; i++) {  
            ps.setObject(i + 1, args[i]);  
        }  
        if (ps.executeUpdate() != 1) {  
            return false;  
        }  
        return true;  
    }  
  
    public boolean modify(String sql, Object... args) throws Exception {  
        PreparedStatement ps = con.prepareStatement(sql);  
        for (int i = 0; i < args.length; i++) {  
            ps.setObject(i + 1, args[i]);  
        }  
        if (ps.executeUpdate() != 1) {  
            return false;  
        }  
        return true;  
    }  
  
    protected void finalize() throws Exception {  
        if (!con.isClosed() || con != null) {  
            con.close();  
        }  
    }  

}
