package rt.bac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rt.util.DBUtil;
import rt.util.MsWordEdit;


public class test {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		int i = 0;
		String ot=null;
		String pt=null;
		String bn=null;
		String telNo = null;
		String isOrNot = null;
		String areaNo = null;
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		String strsql = "select * from rt_housinginfo where BuildingNo = ?";
		String strsql1 = "update rt_housingInfo set SeqId = ? where BuildingNo = ? and (seqId is null or seqId = '' or seqId = '-1')";
		PreparedStatement pstmt = conn.prepareStatement(strsql); 	
		PreparedStatement pstmt1 = conn.prepareStatement(strsql1);
		String BuildingNo = "138栋5号";    	//房号
		String Num = "253";			    	//顺序号
		
		pstmt.setString(1,BuildingNo);
		
		pstmt1.setString(1, Num);
		pstmt1.setString(2, BuildingNo);
		ResultSet rs = pstmt.executeQuery();
		int result = pstmt1.executeUpdate();
		
		while(rs.next()){ 	 
			isOrNot = rs.getString("state");
			ot = rs.getString("OriginalTenant");
			pt = rs.getString("PresentTenant");
			bn = rs.getString("BuildingNo");
			telNo = rs.getString("Tel");
//			areaNo = rs.getString("AreaNo");
			System.out.println("原承租人："+ot+
					",现承租人："+pt+
					",房号："+bn+
					",联系电话："+telNo+
					",是否签协议："+isOrNot+
					",区域：");  
			i=1;
		}  
		System.out.println("更新结果："+result);
		
		du.closeAll(rs, pstmt, conn);
		du.closeAll(rs, pstmt1, conn);
		
		if(i==1&&result==1){
			MsWordEdit m = new MsWordEdit();
			m.openDocument("E:/区域改造/原稿.doc");
			boolean b1 = m.replaceText("OriginalTenant",ot);
			m.moveStart();
			boolean b2 = m.replaceText("PresentTenant", pt);
			m.moveStart();
			boolean b3 = m.replaceText("房号",bn);
			m.moveStart();
			m.replaceAllText("Seq", Num);
			m.moveStart();
			m.replaceText("电话号码", telNo);
			System.out.println(b1+","+b2+","+b3);
			String fname = "E:/区域改造/S"+Num+"_"+bn+".doc";
			m.save(fname);
			for(int j=0;j<3;j++){
				m.printFile();
			}
			m.closeDocument();
			m.close();
		}						
	}
}
