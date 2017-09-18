package rt.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import rt.bean.HouEntity;
import rt.util.DBUtil;

/**
 * HouEntity实例操作类
 * @author 于小耘
 */
public class HouService {
	private static Logger logger = Logger.getLogger(DBService.class.getName());
	
	/**
	 * 查询rt_housingInfo表中数据，返回HouEntity列表
	 * @throws SQLException 
	 */
	public static List<HouEntity> getAllByDb() throws SQLException{
		List<HouEntity> list = new ArrayList<HouEntity>();
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		String [] sql = new String[20];
		String strsql = null;
//			已签协议名单
		sql[0] = "state = 1";
//			未签协议名单
		sql[1] = "state = 0";
//			已归档名单
		sql[2] = "nqp is not null and nqp != ''";	
//			已排号名单
		sql[3] = "seqId is not null and seqId!='' and seqId!='-1'";
//			已排号未归档名单
		sql[4] = "seqId is not null and seqId!='' and seqId!='-1' and (NQP is null or NQP = '')";
//			已签协议未排号名单
		sql[5] = "state=1 and (seqId is null or seqId = '' or seqId = '-1')";
//			已归档名单（原承租人在岗、退休）
		sql[6] = "(nqp is not null or nqp != '') and (em_state = 1 or em_state = 2)";
//			无人员信息名单
		sql[7] = "(em_state = 100 or em_state=200) and state = 1";
//			一楼一平名单
		sql[8] = "select a.*,b.buildingno as buildingNo1 from rt_housinginfo a,rt_multibuilding b where a.originalTenant = b.tenant and a.state = '1' and a.nqp is not null and b.flag <> 0";
		
		sql[9] = "buildingNo like '182栋%' or buildingNo like '197栋%'";
		
		strsql = "select * from rt_housinginfo where "+sql[9]+" order by areaId, buildingNo,id";
		
		PreparedStatement pstmt = conn.prepareStatement(strsql); 
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			int id = rs.getInt("id");
			String originalTenant = rs.getString("OriginalTenant");
			String presentTenant = rs.getString("PresentTenant");
			String buildingNo = rs.getString("BuildingNo");
			String tel = rs.getString("Tel");
			int state = rs.getInt("state");
			String nqp = rs.getString("NQP");
			String seqId = rs.getString("SeqId");
			int areaId = rs.getInt("areaId");
			String constructionArea = rs.getString("ConstructionArea");
			String remark = rs.getString("remark");
//			String username = rs.getString("username");
			int em_state = rs.getInt("em_state");
//			String buildingNo1 = rs.getString("BuildingNo1");
			
			HouEntity hou = new HouEntity();
			hou.setId(id);
			hou.setOriginalTenant(originalTenant);
			hou.setPresentTenant(presentTenant);
			hou.setBuildingNo(buildingNo);
			hou.setTel(tel);
			hou.setState(state);
			hou.setnQP(nqp);
			hou.setSeqId(seqId);
			hou.setAreaId(areaId);
			hou.setConstructionArea(constructionArea);
			hou.setEm_state(em_state);
			hou.setRemark(remark);
//			hou.setUsername(username);
			
			list.add(hou);
		}
		return list;
	}
	
	/**
	 * 根据姓名（originalTenant）查询rt_employeeInfo表中current_state信息，并更新rt_housinginfo表中的em_state信息
	 * @param hou Bean HouEntity
	 */
	public static void updateEm_State(HouEntity hou) throws SQLException{
		int i = 0;
		String [] sql = new String[2];
		sql[0] = "select * from rt_employeeInfo where username = ?";
		sql[1] = "update rt_housingInfo set em_state = ? where BuildingNo = ?";
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql[0]); 
		pstmt.setString(1, hou.getOriginalTenant());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			String current_state = rs.getString("current_state");
			int em_state = 0;
			if(current_state.equals("在岗")){
				em_state = 1;
			}else if(current_state.equals("退休")){
				em_state = 2;
			}else if(current_state.equals("已去世")){
				em_state = 3;
			}else if(current_state.equals("内退")){
				em_state = 4;
			}else if(current_state.equals("离职")){
				em_state = 5;
			}else if(current_state.equals("离休")){
				em_state = 6;
			}else if(current_state.equals("长病")){
				em_state = 7;
			}else if(current_state.equals("长期旷工")){
				em_state = 8;
			}else if(current_state.equals("停薪留职")){
				em_state = 9;
			}else{
				em_state = 0;
			}
			hou.setEm_state(em_state);
			i=1;
		}
		if(i==1){
			pstmt=conn.prepareStatement(sql[1]);
			pstmt.setInt(1, hou.getEm_state());
			pstmt.setString(2, hou.getBuildingNo());
			int result = pstmt.executeUpdate();
			if(result==1){
				logger.debug(hou.getBuildingNo()+","+hou.getOriginalTenant()+","+hou.getEm_state()+",更新成功！");
			}else{
				logger.error(hou.getBuildingNo()+","+hou.getOriginalTenant()+","+hou.getEm_state()+",更新失败！");
			}
		}
		du.closeAll(rs, pstmt, conn);
	}
	
	/**
	 * 根据姓名（originalTenant）查询rt_employeeInfo表中current_state信息，并更新rt_housinginfo表中的em_state信息
	 * @param hou Bean HouEntity
	 */
	public static void updateStartWorkTime(String[] arr) throws SQLException{
		String [] sql = new String[1];
		sql[0] = "update rt_employeeInfo set start_work_time = ? where uid = ?";
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql[0]); 
		pstmt.setString(1, arr[3]);
		pstmt.setString(2, arr[0]);
		int result = pstmt.executeUpdate();
		if(result==1){
			logger.debug(arr[0]+","+arr[1]+","+arr[3]+",更新成功！");
		}else{
			logger.error(arr[0]+","+arr[1]+","+arr[3]+",更新失败！");
		}
		du.closeAll(null, pstmt, conn);
	}
	
	
	/**
	 * 根据buildingNo查询rt_housingInfo表中数据，添加seqId信息
	 * @param BuildingNo 房号
	 * @param SeqId 顺序号
	 */
	public HouEntity updateSeqId(String BuildingNo,String SeqId) throws SQLException{
		int i = 0;
		String [] sql = new String[2];
		sql[0] = "select * from rt_housinginfo where BuildingNo = ?";
		sql[1] = "update rt_housingInfo set SeqId = ? where BuildingNo = ? and (seqId is null or seqId = '' or seqId = '-1')";
		
		HouEntity hou = new HouEntity();
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		PreparedStatement pstmt = conn.prepareStatement(sql[0]);
		pstmt.setString(1,BuildingNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){ 	 
			hou.setState(rs.getInt("state"));
			hou.setOriginalTenant(rs.getString("OriginalTenant"));
			hou.setPresentTenant(rs.getString("PresentTenant"));
			hou.setBuildingNo(rs.getString("BuildingNo"));
			hou.setTel(rs.getString("Tel"));
			hou.setSeqId(SeqId);
			i=1;
			logger.debug("原承租人："+hou.getOriginalTenant()+",现承租人："+hou.getPresentTenant()+",房号："+hou.getBuildingNo()+",联系电话："+hou.getTel()+",是否签协议："+hou.getState()+",区域："+hou.getAreaId());  
		}
		if(i==1){
			pstmt=conn.prepareStatement(sql[1]);
			pstmt.setString(1, SeqId);
			pstmt.setString(2, BuildingNo);
			int result = pstmt.executeUpdate();
			if(result==1){
				hou.setOk(true);
				logger.debug("【排号】原承租人："+hou.getOriginalTenant()+",现承租人："+hou.getPresentTenant()+",房号："+hou.getBuildingNo()+",原顺序号"+hou.getOldSeqId()+",顺序号"+hou.getSeqId()+",更新成功！");
			}else{
				hou.setOk(false);
				System.out.println("【排号】原承租人："+hou.getOriginalTenant()+",现承租人："+hou.getPresentTenant()+",房号："+hou.getBuildingNo()+",原顺序号"+hou.getOldSeqId()+",顺序号"+hou.getSeqId()+"更新失败！");
			}
		}
		du.closeAll(rs, pstmt, conn);		
		return hou;
	}
	

 
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
//		List<HouEntity> list = HouService.getAllByDb();
//		for(int i=0;i<list.size();i++){
//			HouService.updateHou(list.get(i));
//		}
//		ExcelService.writeExcel(list);
		
		
	}
}
