package rt.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import rt.bean.HouEntity;
import rt.util.DBUtil;


public class random {
	
	

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
/*		char[] people = {'A','B','C','D','E'};
		char[] buildingNo = {'1','2','3','4','5'};
		ArrayList buildlist = new ArrayList();	//用来存放已经被抓出的楼号
		Random rm = new Random();
		for(int i=0;i<5;i++){
			System.out.print(people[i]+"抽中的楼号是：");
			for(;;){
				int r = rm.nextInt(5);	//随机产生大于等于0小于5的数
				if(!buildlist.contains(buildingNo[r])){
					buildlist.add(buildingNo[r]);
					System.out.println(buildingNo[r]);
					break;
				}
			}
		}*/
		//读取数据库中可用的房源ID形成列表
		List<String> list = new LinkedList<String>();
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		String strsql= "select id from rt_newBuilding where flag = 0";
		PreparedStatement pstmt = conn.prepareStatement(strsql); 
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			list.add(rs.getInt("id")+"");
//			System.out.println(rs.getInt("id"));
		}
		//计算列表大小
		int max = list.size();
		System.out.println("max:"+max);
		//随机产生大于0小于等于max的数r
		Random rm = new Random();
		
		for(int i=0;i<100;i++){
			int r = rm.nextInt(max)+1;
			System.out.println("random:"+r);
			//读取list(r)的值
			String selected = list.get(r-1);
			System.out.println("selected record id:"+selected);
			String choose = "select * from rt_newBuilding where id ="+selected;
			pstmt = conn.prepareStatement(choose); 
			ResultSet rs1 = pstmt.executeQuery(); 
			while(rs1.next()){
				System.out.println(rs1.getString("buildingNO"));
			}
		}



	}

}
