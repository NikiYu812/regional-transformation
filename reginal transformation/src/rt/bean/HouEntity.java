package rt.bean;

public class HouEntity {
	
	private int id;							//序号（自增长）
	private String buildingNo;				//房号
	private String originalTenant;			//原承租人
	private String ot_idcardNo;				//原承租人身份证号码
	private int em_state;					//人员状态
	private String ot_uid;					//原承租人职工号
	private String die_time;				//死亡时间
	private String presentTenant;			//协议签署人
	private String tel;						//电话号码（协议签署人）
	private String idcardNo;				//身份证号码(协议签署人)
	private String username;				//所员工姓名
	private String constructionArea;		//建筑面积
	private int teamId;						//组别
	private int state;						//状态（是否签协议）：0未签，1已签
	private String nQP;						//暖气片数量
	private String seqId;					//顺序号
	private String oldSeqId;				//作废顺序号
	private String checkHouseInfo;			//验房信息
	private int areaId;						//区域号码(1北院，2北平房，3南平房东，4南平房西)	
	private String remark;					//备注
	private boolean isOk;					//flag自用
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getOriginalTenant() {
		return originalTenant;
	}
	public void setOriginalTenant(String originalTenant) {
		this.originalTenant = originalTenant;
	}
	public String getOt_idcardNo() {
		return ot_idcardNo;
	}
	public void setOt_idcardNo(String ot_idcardNo) {
		this.ot_idcardNo = ot_idcardNo;
	}
	public int getEm_state() {
		return em_state;
	}
	public void setEm_state(int em_state) {
		this.em_state = em_state;
	}
	public String getOt_uid() {
		return ot_uid;
	}
	public void setOt_uid(String ot_uid) {
		this.ot_uid = ot_uid;
	}
	public String getDie_time() {
		return die_time;
	}
	public void setDie_time(String die_time) {
		this.die_time = die_time;
	}
	public String getPresentTenant() {
		return presentTenant;
	}
	public void setPresentTenant(String presentTenant) {
		this.presentTenant = presentTenant;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getConstructionArea() {
		return constructionArea;
	}
	public void setConstructionArea(String constructionArea) {
		this.constructionArea = constructionArea;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getnQP() {
		return nQP;
	}
	public void setnQP(String nQP) {
		this.nQP = nQP;
	}
	public String getSeqId() {
		return seqId;
	}
	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}
	public String getOldSeqId() {
		return oldSeqId;
	}
	public void setOldSeqId(String oldSeqId) {
		this.oldSeqId = oldSeqId;
	}
	public String getCheckHouseInfo() {
		return checkHouseInfo;
	}
	public void setCheckHouseInfo(String checkHouseInfo) {
		this.checkHouseInfo = checkHouseInfo;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isOk() {
		return isOk;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
}
