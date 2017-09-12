package rt.service;
import rt.bean.HouEntity;
import rt.util.MsWordEdit;


public class JacobService {
	/**
	 * 根据Word模板生成新的交接单，打印三份
	 * @param HouEntity hou
	 */
	public static void printTransforList(HouEntity hou,int i){
		if(hou.isOk()){
			MsWordEdit m = new MsWordEdit();
			m.openDocument("E:/区域改造/原稿.doc");
			boolean[] b=new boolean[4];

			b[0] = m.replaceText("OriginalTenant",hou.getOriginalTenant());
			m.moveStart();
			b[1] = m.replaceText("PresentTenant", hou.getPresentTenant());
			m.moveStart();
			b[2]= m.replaceText("房号",hou.getBuildingNo());
			m.moveStart();	
			System.out.println("SeqId:"+hou.getSeqId());
			m.replaceAllText("Seq", hou.getSeqId());
			m.moveStart();
			b[3]=m.replaceText("电话号码", hou.getTel());
			String fname = "E:/区域改造/S"+hou.getSeqId()+"_"+hou.getBuildingNo()+".doc";
			m.save(fname);
			if(b[0]&&b[1]&&b[2]&&b[3]){
				System.out.println("文本替换成功！");
				for(int j=0;j<i;j++){
					m.printFile();
				}
			}
			m.closeDocument();
			m.close();
		}else{
			System.out.println("打印未进行！！！");
		}
	}
	
}
