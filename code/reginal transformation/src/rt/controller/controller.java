package rt.controller;

import java.sql.SQLException;

import rt.bean.HouEntity;
import rt.service.HouService;
import rt.service.JacobService;


public class controller {
	
	/**
	 * 排号打印三份交接单
	 * @param BuildingNo 房号
	 * @param SeqId 验房顺序号 
	 */
	public static void printTL(String BuildingNo,String SeqId){
		HouService hs = new HouService();
		HouEntity hou = new HouEntity();
		try {
			hou = hs.updateSeqId(BuildingNo, SeqId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JacobService.printTransforList(hou,3);
	}
	
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args){
		String buildingNo = "165栋4号";
		String seqId = "328";
		controller.printTL(buildingNo, seqId);		//打印三份交接单	
	}	
}
