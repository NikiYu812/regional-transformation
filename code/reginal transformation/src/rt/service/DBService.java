package rt.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import rt.bean.HouEntity;
import rt.util.DBUtil;
import rt.util.SysUtil;

/**
 * 数据库操作类
 * @author 于小耘
 */
public class DBService {
	private static Logger logger = Logger.getLogger(DBService.class.getName());
	String time = SysUtil.getCurrentTime("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 向rt_employeeInfo表中批量添加数据
	 * @param String[][] array 二维数组
	 */
	/*public void InsertDataBatch(String[][] array) throws SQLException{
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		conn.setAutoCommit(false);
		String sql = "insert into rt_employeeInfo(id,username,uid,deptid,dept,start_work_time"
				+ ",sex,tech_pos_level,birthday,education,tech_pos,tech_pos_time"
				+ ",admin_pos,admin_pos_level,admin_pos_time,em_identity"
				+ ",current_state,retire_time,create_time,last_modify_time,remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		int i,j;
		int id=0;
		for(i=1;i<array.length;i++){
			ps.setInt(1, ++id);
			for(j=0;j<17;j++){
				ps.setString(j+2, array[i][j]);
			}
			ps.setString(19, time);
			ps.setString(20, time);
			ps.setString(21, "");
			ps.addBatch();
		}
		ps.executeBatch();
		conn.commit();
		conn.close();
	}*/
	
	/**
	 * 向rt_employeeInfo表中批量添加数据
	 * @param String[][] array 二维数组
	 */
	public void InsertDataBatch(String[][] array) throws SQLException{
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		conn.setAutoCommit(false);
		String sql = "insert into rt_employeeInfo(uid,uname,sex,dept,tech_pos,admin_pos"
				+ ",em_state,start_work_time,work_year,tech_pos_time,tech_pos_year"
				+ ",service_year,score,entrance_time,graduate_time,edu_system"
				+ ",spouse_name,spouse_dept,building_addr,constructionArea,property_right,tenant"
				+ ",category,last_modify_time,remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		int i,j;
		for(i=1;i<array.length;i++){
			for(j=0;j<22;j++){
				ps.setString(j+1, array[i][j]);
			}
			ps.setInt(23, 8);
			ps.setString(24, time);
			ps.setString(25, "");
			ps.addBatch();
		}
		ps.executeBatch();
		conn.commit();
		logger.info("【Insert数据成功】");
		conn.close();
	}
	
	/**
	 * 向rt_housingInfo中更新暖气片数量
	 * @param BuildingNo 房号
	 * @param num 暖气片数量
	 * @throws SQLException 
	 */
	public void updateNQP(String buildingNo,String num) throws SQLException{
		int i=0;
		String[] sql = new String[2];
		sql[0]="select * from rt_housingInfo where BuildingNo = ?";
		sql[1]="update rt_housingInfo set NQP = ? "
				+ "where BuildingNo = ? and NQP is null and seqId is not null and seqId != '' and seqId != '-1'";
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql[0]);
		pstmt.setString(1, buildingNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			logger.debug("【NQP】存在记录！房号："+rs.getString("buildingNo")
					+"，原承租人："+rs.getString("OriginalTenant")
					+",协议签署人："+rs.getString("PresentTenant")+",暖气片数量："+rs.getString("NQP"));
			i=1;
		}
		if(i==1){
			pstmt = conn.prepareStatement(sql[1]);
			pstmt.setString(1,num);
			pstmt.setString(2,buildingNo);
			int result = pstmt.executeUpdate();
			if(result==1){
				logger.debug("【NQP】更新成功，"+buildingNo+"更新暖气片数量为"+num);
			}else{
				logger.error("【NQP】更新失败！！！"+buildingNo);
			}
		}
		du.closeAll(rs, pstmt, conn);	
	}
	
	/**
	 * 根据姓名（originalTenant）查询rt_employeeInfo表中current_state信息，并更新rt_housinginfo表中的IDCardNo信息
	 * @param idcardNo 身份证号码
	 * @param buildingNo 房号
	 */
	public static void updateIdCard(String idcardNo , String buildingNo) throws SQLException{
		int i = 0;
		String [] sql = new String[1];
		sql[0] = "update rt_housingInfo set idcardno = ? where BuildingNo = ?";
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql[0]); 
		pstmt.setString(1, idcardNo);
		pstmt.setString(2, buildingNo);
		i = pstmt.executeUpdate();
		if(i==1){
			logger.debug(buildingNo+","+idcardNo+",更新成功！");
		}else{
			logger.error(buildingNo+","+idcardNo+",更新失败！");
		}
		du.closeAll(null, pstmt, conn);
	}

	/**
	 * 更新rt_housingInfo表中电话信息
	 * @param Tel 电话号码
	 * @param buildingNo 房号
	 * @param flag 1替换，2添加
	 */
	public static void updateTel(String Tel, String buildingNo, int flag) throws SQLException{
		int i = 0;
		String [] sql = new String[1];
//		如果flag==1则替换
		if(flag == 1){
			sql[0] = "update rt_housingInfo set Tel = ? where BuildingNo = ?";
//		如果flag==2则添加
		}else if(flag == 2){
			sql[0] = "update rt_housingInfo set Tel = concat(Tel,','+?) where BuildingNo = ?";
		}
		
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql[0]); 
		pstmt.setString(1, Tel);
		pstmt.setString(2, buildingNo);
		i = pstmt.executeUpdate();
		if(i==1){
			logger.debug("【更新协议签署人电话号码】"+buildingNo+","+Tel+",更新成功！");
		}else{
			logger.error("【更新协议签署人电话号码】"+buildingNo+","+Tel+",更新失败！");
		}
		du.closeAll(null, pstmt, conn);
	}
	
	/**
	 * 更新rt_housingInfo表中原承租人身份证号码
	 * @param ot_idcardNo 原承租人身份证号码
	 * @param buildingNo 房号
	 */
	public static void updateOt_idcardNo(String ot_idcardNo, String buildingNo) throws SQLException{
		int i = 0;
		String [] sql = new String[1];
		sql[0] = "update rt_housingInfo set ot_idcardNo = ? where BuildingNo = ?";
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql[0]); 
		pstmt.setString(1, ot_idcardNo);
		pstmt.setString(2, buildingNo);
		i = pstmt.executeUpdate();
		if(i==1){
			logger.debug("【更新原承租人身份证号码】房号："+buildingNo+",原承租人身份证号码："+ot_idcardNo+",更新成功！");
		}else{
			logger.error("【更新原承租人身份证号码】房号："+buildingNo+",原承租人身份证号码："+ot_idcardNo+",更新失败！");
		}
		du.closeAll(null, pstmt, conn);
	}
	
	/**
	 * 更新rt_housingInfo表中原承租人死亡时间
	 * @param die_time 原承租人死亡时间
	 * @param buildingNo 房号
	 */
	public static void updateDie_time(String die_time, String buildingNo) throws SQLException{
		int i = 0;
		String [] sql = new String[1];
		sql[0] = "update rt_housingInfo set die_time = ? where BuildingNo = ?";
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql[0]); 
		pstmt.setString(1, die_time);
		pstmt.setString(2, buildingNo);
		i = pstmt.executeUpdate();
		if(i==1){
			logger.debug("【更新死亡时间】房号："+buildingNo+",原承租人死亡时间："+die_time+",更新成功！");
		}else{
			logger.error("【更新死亡时间】房号："+buildingNo+",原承租人死亡时间："+die_time+",更新失败！");
		}
		du.closeAll(null, pstmt, conn);
	}
	
	
	
	
	
	/**
	 * @param 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

		DBService dbt = new DBService();
//		房号
		String buildingNo = "13栋4号";  							
//		暖气片数量
		String num = "";											
//		原承租人身份证号码
		String ot_idcardNo = "210103198004240918";					
//		原承租人死亡时间
		String die_time = "1990-10-16";
//		 更新暖气片数量
//		dbt.updateNQP(buildingNo, num);
		dbt.updateOt_idcardNo(ot_idcardNo, buildingNo);
//		dbt.updateDie_time(die_time, buildingNo);
		
	}

}
