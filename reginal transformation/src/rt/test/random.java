package rt.test;

import java.util.ArrayList;
import java.util.Random;


public class random {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] people = {'A','B','C','D','E'};
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
		}
		

	}

}
