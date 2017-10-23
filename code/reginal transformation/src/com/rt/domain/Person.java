/**
 * 
 */
package com.rt.domain;

/**
 * @author 于小耘
 * @category 实体类
 *
 */
public class Person {
	
	private String id;
	private String p0_name;
	private String p0_uid;
	private String p0_state;
	private String p1_name;
	private String p1_idcNo;
	private String telNo;
	private String oh_id;
	private String nh_id;
	private int flag;				//是否抽签
	private String remark;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getP0_name() {
		return p0_name;
	}
	public void setP0_name(String p0_name) {
		this.p0_name = p0_name;
	}
	public String getP0_uid() {
		return p0_uid;
	}
	public void setP0_uid(String p0_uid) {
		this.p0_uid = p0_uid;
	}
	public String getP0_state() {
		return p0_state;
	}
	public void setP0_state(String p0_state) {
		this.p0_state = p0_state;
	}
	public String getP1_name() {
		return p1_name;
	}
	public void setP1_name(String p1_name) {
		this.p1_name = p1_name;
	}
	public String getP1_idcNo() {
		return p1_idcNo;
	}
	public void setP1_idcNo(String p1_idcNo) {
		this.p1_idcNo = p1_idcNo;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getOh_id() {
		return oh_id;
	}
	public void setOh_id(String oh_id) {
		this.oh_id = oh_id;
	}
	public String getNh_id() {
		return nh_id;
	}
	public void setNh_id(String nh_id) {
		this.nh_id = nh_id;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
