package rt.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rt.util.DBUtil;
import rt.util.MsWordEdit;
import rt.util.SysUtil;

public class DailyCount {
	
	public void dailyCount() throws SQLException{
		String time = SysUtil.getCurrentTime("yyyy-MM-dd HH:mm");
		String time0 = SysUtil.getCurrentTime(null);
		int[] S = new int[4];
		int[] N = new int[4];
		String[] sql = new String[8];
//		已签
		sql[0]="select count(*) as '数量' from rt_housinginfo where state = '1'";										
//		已排号	
		sql[1]="select count(*) as '数量' from rt_housinginfo where seqId is not null and seqId!='' and seqId!='-1'";	
//		已归档
		sql[2]="select count(*) as '数量' from rt_housinginfo where nqp is not null and nqp != ''";						
//		未排号
		sql[3]="select count(*) as '数量' from rt_housinginfo where state='1' and (seqId is null or seqId='' or seqId = '-1')";						
//		北平房已签
		sql[4]="select count(*) as '数量' from rt_housinginfo where state = '1' and areaId='2'";
//		北平房已排号
		sql[5]="select count(*) as '数量' from rt_housinginfo where seqId!='' and seqId is not null and seqId!='-1' and areaId = '2'";
//		北平房已归档
		sql[6]="select count(*) as '数量' from rt_housinginfo where nqp!='' and nqp is not null and areaid = '2'";
//		北平房未排号
		sql[7]="select count(*) as '数量' from rt_housinginfo where state='1' and (seqId is null or seqId='' or seqId = '-1') "
				+ "and areaId = '2'";
		DBUtil du = new DBUtil();
		Connection conn = du.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		for(int i=0;i<4;i++){
			pstmt = conn.prepareStatement(sql[i]);
			rs = pstmt.executeQuery();
			while(rs.next()){
				S[i]=rs.getInt("数量");
			}
			rs=null;
		}
		for(int i=0;i<4;i++){
			pstmt = conn.prepareStatement(sql[i+4]);
			rs = pstmt.executeQuery();
			while(rs.next()){
				N[i]=rs.getInt("数量");
			}
			rs=null;
		}
		du.closeAll(rs, pstmt, conn);
		System.out.print(S[0]+","+S[1]+","+S[2]+","+S[3]+","+N[0]+","+N[1]+","+N[2]+","+N[3]);
		MsWordEdit m = new MsWordEdit();
		m.openDocument("D:/word/每日统计.doc");
		m.replaceText("当前时间", time);
		m.moveStart();
		m.replaceText("S1",S[0]+"");
		m.moveStart();
		m.replaceText("S2",S[1]+"");
		m.moveStart();
		m.replaceText("S3",S[2]+"");
		m.moveStart();
		m.replaceText("S4",S[3]+"");
		m.moveStart();
		m.replaceText("N1",N[0]+"");
		m.moveStart();
		m.replaceText("N2",N[1]+"");
		m.moveStart();
		m.replaceText("N3",N[2]+"");
		m.moveStart();
		m.replaceText("N4",N[3]+"");
		
		String fname = "D:/word/每日统计"+time0+".doc";
		m.save(fname);
//		m.printFile();
		m.closeDocument();
		m.close();
		
	}
	
	public static void main(String[] args) {		
		
		DailyCount dc = new DailyCount();
		try {
			dc.dailyCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}

