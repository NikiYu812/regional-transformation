package com.rt.domain;

//实体类：旧房
public class OldHouse {
	private String id;				//旧房编号
	private String house_no;		//旧房房号
	private String person_id;		//人员编号
	private String p0_name;			//原承租人姓名
	private int location;			//区域
	private String area;			//建筑面积
	private int sign_state;			//是否签协议
	private int move_state;			//是否搬家
	private String move_seq;		//搬家顺序号
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHouse_no() {
		return house_no;
	}
	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getP0_name() {
		return p0_name;
	}
	public void setP0_name(String p0_name) {
		this.p0_name = p0_name;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getSign_state() {
		return sign_state;
	}
	public void setSign_state(int sign_state) {
		this.sign_state = sign_state;
	}
	public int getMove_state() {
		return move_state;
	}
	public void setMove_state(int move_state) {
		this.move_state = move_state;
	}
	public String getMove_seq() {
		return move_seq;
	}
	public void setMove_seq(String move_seq) {
		this.move_seq = move_seq;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
