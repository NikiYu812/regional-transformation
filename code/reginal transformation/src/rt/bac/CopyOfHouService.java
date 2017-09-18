package rt.bac;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import rt.bean.HouEntity;
import rt.util.DBUtil;

public class CopyOfHouService {
	
	/**
	 * 查询rt_housingInfo表中所有的数据
	 * @param args
	 */
	public static List<HouEntity> getAllByDb(){
		List<HouEntity> list = new ArrayList<HouEntity>();
		try{
			DBUtil du = new DBUtil();
			Connection conn = du.getConn();
//			String strsql = "select * from rt_housinginfo where buildingNo like '197栋%' and NQP is not null and NQP != '' order by AreaNo+0 asc,BuildingNo asc";
//			String strsql = "select * from rt_housinginfo where seqId is not null and seqId!='' and seqId!='-1' and (NQP is null or NQP = '')";
			String strsql = "select left(buildingNo,locate('栋',buildingNo)) as '栋',count(*) as '已归档数' from rt_housinginfo where nqp is not null and nqp != '' group by left(buildingNo,locate('栋',buildingNo)) order by left(buildingNo,locate('栋',buildingNo)-1)+0";
			PreparedStatement pstmt = conn.prepareStatement(strsql); 
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String a = rs.getString("栋");
				String b = rs.getString("已归档数");		
				HouEntity hou = new HouEntity();
				hou.setOriginalTenant(a);
				hou.setPresentTenant(b);
				
				list.add(hou);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}		
		return list;
	}
	
	/**
	 * 定义公共字体格式
	 * @param args
	 */

    
    
    
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			// 获得开始时间   
            long start = System.currentTimeMillis(); 
			WritableWorkbook wwb = null;
			String fileName = "d:\\已归档数量统计（按栋）.xls";
			File file = new File(fileName);
			if(!file.exists()){
				file.createNewFile();
			}
			wwb = Workbook.createWorkbook(file);
			WritableSheet ws = wwb.createSheet("已归档数（按栋）", 0);
			List<HouEntity> list = CopyOfHouService.getAllByDb();
			ws.addCell(new Label(0,0,"栋"));
			ws.addCell(new Label(1,0,"已归档"));

			for(int i=0;i<list.size();i++){
				ws.addCell(new Label(0,i+1,list.get(i).getOriginalTenant()));
				ws.addCell(new Label(1,i+1,list.get(i).getPresentTenant()));
			}
			//写进文档
			wwb.write();
			//关闭Excel工作簿对象
			wwb.close();
			long end = System.currentTimeMillis();   
            System.out.println("----完成该操作共用的时间是:"+(end-start)/1000);   
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
