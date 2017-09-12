package rt.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import rt.bean.HouEntity;
import rt.util.SysUtil;


/**
 * Excel操作类：读写Excel
 * @author 于小耘
 */
public class ExcelService {
	private static Logger logger = Logger.getLogger(DBService.class.getName());
	
	/**
	 * 将数据写入Excel
	 * @param List<HouEntity> list 
	 */
	public static void writeExcel(List<HouEntity> list){
		try{
            long start = System.currentTimeMillis(); 
            String time = SysUtil.getCurrentTime(null);
			WritableWorkbook wwb = null;
			String fileName = "d:\\Excel/名单"+time+".xls";
			File file = new File(fileName);
			if(!file.exists()){
				file.createNewFile();
			}
			wwb = Workbook.createWorkbook(file);
			WritableSheet ws = wwb.createSheet("182栋、197栋", 1);
			WritableCellFormat wc = ExcelService.setGlobalStyle();   
			
//			ws.addCell(new Label(,0,"顺序号"));
			ws.addCell(new Label(0,0,"房号",wc));
			ws.addCell(new Label(1,0,"原承租人",wc));
			ws.addCell(new Label(2,0,"协议签署人",wc));
			ws.addCell(new Label(3,0,"联系电话",wc));
//			ws.addCell(new Label(4,0,"所员工姓名",wc));
//			ws.addCell(new Label(4,0,"员工状态",wc));
			ws.addCell(new Label(4,0,"建筑面积"));
//			ws.addCell(new Label(3,0,"暖气片数量"));
//			ws.addCell(new Label(4,0,"协议状态",wc));
//			ws.addCell(new Label(5,0,"腾房状态",wc));
			ws.addCell(new Label(5,0,"块区",wc));
			ws.addCell(new Label(6,0,"备注",wc));
			for(int i=0;i<list.size();i++){
//				ws.addCell(new Label(0,i+1,list.get(i).getSeqId()));
				ws.addCell(new Label(0,i+1,list.get(i).getBuildingNo(),wc));
				ws.addCell(new Label(1,i+1,list.get(i).getOriginalTenant(),wc));
				ws.addCell(new Label(2,i+1,list.get(i).getPresentTenant(),wc));
				ws.addCell(new Label(3,i+1,list.get(i).getTel(),wc));

//				if(list.get(i).getState()==1){
//					ws.addCell(new Label(4,i+1,"已签",wc));
//				}else{
//					ws.addCell(new Label(4,i+1,"未签",wc));
//				}
//				ws.addCell(new Label(4,i+1,list.get(i).getUsername(),wc));
//				ws.addCell(new Label(4,i+1,list.get(i).getEm_state()+"",wc));
				ws.addCell(new Label(4,i+1,list.get(i).getConstructionArea(),wc));
//				ws.addCell(new Label(3,i+1,list.get(i).getNQP()));
				int areaId = list.get(i).getAreaId();
				String areaLabel=null;		
				if(areaId==1){
					areaLabel = "北院";
				}else if(areaId==2){
					areaLabel = "北平房";
				}else if(areaId==3){
					areaLabel = "南平房西";
				}
				else if(areaId==4){
					areaLabel = "南平房东";
				}else{
					areaLabel = "未知";
				}
//				System.out.println(areaId);
//				System.out.println(areaLabel);
				ws.addCell(new Label(5,i+1,areaLabel,wc));
				ws.addCell(new Label(6,i+1,list.get(i).getRemark(),wc));
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

	/**
	 * 读取Excel数据
	 * @param String file 文件位置   例："d:\\yvonne/123.xls"
	 * @return String[][]  写入Excel文件数据的二元数组
	 */
	public static String[][] readExcel(String file,int sheetNo) throws BiffException, IOException {
		Workbook rwb = null;
		Cell cell = null;
		InputStream stream = new FileInputStream(file);
		rwb = Workbook.getWorkbook(stream);
		Sheet sheet = rwb.getSheet(sheetNo);
		String array[][] = new String[sheet.getRows()][];
		for (int i = 0; i < sheet.getRows(); i++) {
			array[i] = new String[sheet.getColumns()];
			for (int j = 0; j < sheet.getColumns(); j++) {
				cell = sheet.getCell(j, i);
				array[i][j] = cell.getContents();
//				System.out.println(i+","+j+","+array[i][j]);
			}
		}
		return array;
	}
	
	/**
	 * 定义公共字体格式
	 */
	public static WritableCellFormat setGlobalStyle() throws WriteException{
		WritableFont wfc = new WritableFont(WritableFont.createFont("微软雅黑"),12);		//设置字体
	    WritableCellFormat wc = new WritableCellFormat(wfc);   
	    wc.setAlignment(Alignment.CENTRE);   											// 设置居中  
	    wc.setBorder(Border.ALL, BorderLineStyle.THIN);									// 设置边框线
	    return wc;
	}
 
	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws BiffException, IOException, SQLException {	
//		List<HouEntity> list = HouService.getAllByDb();
//		writeExcel(list);
/*		try {
			String[][] arr=ExcelService.readExcel();
			DBService dbs = new DBService();
			dbs.InsertDataBatch(arr);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String[][] arr = ExcelService.readExcel("d:\\修改后在职人员情况总表.xls",13);
		for(int i=0;i<arr.length;i++){
			String printStr = i+"";
			for(int j=0;j<arr[i].length;j++){
				printStr += ","+arr[i][j];
			}
			logger.debug("【从excel读取数据】"+printStr);
		}
//		DBService dbs = new DBService();
//		dbs.InsertDataBatch(arr);
		for(int i=0;i<arr.length;i++){
			HouService.updateStartWorkTime(arr[i]);
		}
		
	}
}
