package com.rt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rt.domain.OldHouse;
import com.rt.util.JdbcUtil;

public class OldHouseDao {
	//查询
	public List<OldHouse> findAll(){
		List<OldHouse> list = new ArrayList<OldHouse>();
		try{
			Connection conn = JdbcUtil.getConn();
			String strsql = "select * from tb_oldHouse";
			PreparedStatement pstmt = conn.prepareStatement(strsql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				String house_no = rs.getString("house_no");
				String person_id = rs.getString("person_id");
				String p0_name = rs.getString("p0_name");
				int location = rs.getInt("location");
				String area = rs.getString("area");
				int sign_state = rs.getInt("sign_state");
				int move_state = rs.getInt("move_state");
				String move_seq = rs.getString("move_seq");
				String remark = rs.getString("remark");
				
				OldHouse oh = new OldHouse();
				oh.setId(id);
				oh.setHouse_no(house_no);
				oh.setPerson_id(person_id);
				oh.setP0_name(p0_name);
				oh.setLocation(location);
				oh.setArea(area);
				oh.setSign_state(sign_state);
				oh.setMove_state(move_state);
				oh.setMove_seq(move_seq);
				oh.setRemark(remark);
				
				list.add(oh);
			}
		    JdbcUtil.closeAll(rs,pstmt,conn);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}


	
	
	
	
	

}
