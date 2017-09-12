RT_HOUSINGINFO
-- 更新
-- 承租人姓名（替换某个字） 
update rt_housingInfo set OriginalTenant = replace(originalTenant,'曾宪先','曾宪珍') where BuildingNo like "197栋8号";
update rt_housingInfo set OriginalTenant = PresentTenant where buildingNo like '221栋2号';
-- 修改协议签署人
update rt_housingInfo set PresentTenant = '回民独身'  where BuildingNo like "220栋10号";
-- 修改电话号码
-- 添加电话号码 
update rt_housingInfo set Tel = concat(Tel,",13840234095") where BuildingNo like "206栋7号";
-- 替换电话号码
update rt_housingInfo set Tel = "本人17162436627,儿子15640368998" where BuildingNo like "171栋15号";
-- 添加备注信息
update rt_housingInfo set remark=concat(remark,"一楼一平") where BuildingNo like "171栋4号";
-- 修改顺序号
update rt_housinginfo set seqid = "8" where buildingno like "136栋4号";
-- 重置顺序号
update rt_housinginfo set oldseqId='303' where buildingNo = '144栋13号';

-- update rt_housingInfo set mistake_emp = '孙永革' ,mistake_emp_tel = '13940034181' where buildingNo like '170栋1、2号';
-- update rt_housingInfo set mistake_emp = '蔡天更' ,mistake_emp_tel = '' where buildingNo like '36栋12号';
-- update rt_housingInfo set mistake_emp = '郑鸿恩' ,mistake_emp_tel = '' where buildingNo like '197栋4号';
-- update rt_housingInfo set mistake_emp = '王德铭' ,mistake_emp_tel = '' where buildingNo like '197栋13号';
-- update rt_housingInfo set mistake_emp = '王照福' ,mistake_emp_tel = '18809832026' where buildingNo like '154栋2号';
-- update rt_housingInfo set mistake_emp = '韩锡宽' ,mistake_emp_tel = '' where buildingNo like '161栋4号';


update rt_housinginfo set nqp = concat(nqp,",5组(235栋20号)") where buildingNo = '127栋2号';
update rt_housinginfo set nqp = "7" where buildingNo = '165栋6号';

update rt_housinginfo set oldseqId='285,289' where buildingNo = '8栋1、2号';
update rt_housinginfo set seqId='331' where buildingNo = '136栋5、6号';
-- 修改签协议状态
update rt_housinginfo set state = '1' where buildingNo = '197栋9号';

update rt_housingInfo set idcardno='21010319350105091x' where buildingNo = '127栋9、10号';

update rt_housinginfo set remark='' where buildingNo = '165栋6号';
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
update rt_housinginfo set remark = concat(remark,';一楼一平') where (select a.originalTenant,a.buildingno,b.buildingno from rt_housinginfo a,rt_multibuilding b where a.originalTenant = b.tenant and a.state = 1)

-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
update rt_housinginfo set em_state = 1 where buildingno = '197栋7号';
update rt_housinginfo set em_state = 100 where em_state is null;
---------------------------------------------------------------------
update rt_housinginfo set em_state = 
(select
(case current_state 
	when '在岗' then 1
	when '退休' then 2
	when '已去世' then 3
	when '内退' then 4
	when '离职' then 5
	when '离休' then 6
	when '长病' then 7
	when '长期旷工' then 8
	when '停薪留职' then 9
else 0
end) 
from rt_employeeInfo where uid= '3266') where buildingno = '171栋14号';
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
update rt_housinginfo set otuid = '-1' where buildingNo = '171栋14号';
update rt_housinginfo set otuid = '2691' where buildingNo = '168栋3、4号';
update rt_housinginfo set otuid = '-1' where em_state = 100;
------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------
insert rt_housinginfo(buildingNo,originalTenant,PresentTenant,em_state,ConstructionArea,areaId) values('220栋10号','回民独身','回民独身',-1,'45.38',1);
insert rt_housinginfo(buildingNo,originalTenant,PresentTenant,em_state,ConstructionArea,areaId) values('163栋10、11号','潘秀荣','外户',-1,'54.25',3);
insert rt_housinginfo(buildingNo,originalTenant,PresentTenant,em_state,ConstructionArea,areaId) values('178栋2号','安云平','外户',-1,'55.52',4);
insert rt_housinginfo(buildingNo,originalTenant,PresentTenant,em_state,ConstructionArea,areaId) values('155栋1号','万莲下水','万莲下水',-1,'74.17',4);
insert rt_housinginfo(buildingNo,originalTenant,PresentTenant,em_state,ConstructionArea,areaId) values('155栋4号','万莲下水','万莲下水',-1,'64.58',4);
insert rt_housinginfo(buildingNo,originalTenant,PresentTenant,em_state,ConstructionArea,areaId) values('155栋3号','万莲下水','万莲下水',-1,'33.18',4);

update rt_housinginfo set em_state = null where state = -1;

CREATE OR REPLACE VIEW V_RT_MONEY AS
SELECT ID
,BUILDINGNO as 房号
,ORIGINALTENANT as 原承租人
,em_state as 原承租人状态
,otUid as 原承租人职工号
,PRESENTTENANT as 协议签署人
,tel as 协议签署人联系方式
,idcardno as 协议签署人身份证号码
,constructionArea as 建筑面积
,建筑面积*10% as 改善面积
,(case when 50-建筑面积>0 then 50-建筑面积>0 else 0 end) as 补贴面积
,1.2*补贴面积+0.4*5000 as 补偿金额
,建筑面积+改善面积 as 调房核算面积
,(case 
		when 300*建筑面积<20000
		then 20000
		else 300*建筑面积
   end) as 搬迁奖励
,1000 as 搬迁奖励+
,建筑面积*18
,(case 
		when (建筑面积*18)<800 
		then 800 
		else (
			case
				when (建筑面积*18)>1200
				then 1200
				else (建筑面积*18)
		 end)
	end ) as 临时安置费
,nqp as 暖气片
,seqid as 顺序号
,areaid as 区块
,lastmodifytime as 最后更改时间
,remark as 备注
FROM RT_HOUSINGINFO
WHERE STATE = 1;

CREATE OR REPLACE VIEW V_RT AS
select `a`.`Id` AS `ID`
,`a`.`BuildingNo` AS `房号`
,`a`.`OriginalTenant` AS `原承租人`
,(case `a`.`em_state` when 1 then '在岗' when 2 then '退休' when 3 then '已去世' when 4 then '内退' when 5 then '离职' when 6 then '离休' when 7 then '长病' when 8 then '长期矿工' when 9 then '停薪留职' else '未知' end) AS `原承租人状态`
,(case `a`.`otUid` when -1 then '未知' else otUid end) AS `原承租人职工号`
,ot_idcardNo as '原承租人身份证号码'
,`a`.`PresentTenant` AS `协议签署人`
,`a`.`Tel` AS `联系方式`
,`a`.`IDCardNo` AS `协议签署人身份证号码`
,die_time AS 原承租人死亡时间
,`a`.`ConstructionArea` AS `建筑面积`
,round((`a`.`ConstructionArea` * 0.1),2) AS `改善面积`
,(case when ((50 - `a`.`ConstructionArea`) > 0) then round((50 - `a`.`ConstructionArea`),2) else 0 end) AS `补贴面积`
,round((((case when ((50 - `a`.`ConstructionArea`) > 0) then round((50 - `a`.`ConstructionArea`),2) else 0 end) * 5000) * 0.48),0) AS `补偿金额`
,round((`a`.`ConstructionArea` * 1.1),2) AS `调房核算面积`
,round((case when ((300 * `a`.`ConstructionArea`) < 20000) then 20000 else (300 * `a`.`ConstructionArea`) end),0) AS `搬迁奖励`
,1000 AS `搬迁奖励plus`
,round((case when ((`a`.`ConstructionArea` * 18) < 800) then 800 else (case when ((`a`.`ConstructionArea` * 18) > 1200) then 1200 else (`a`.`ConstructionArea` * 18) end) end),2) AS `临时安置费`
,`a`.`NQP` AS `暖气片`
,`a`.`SeqId` AS `顺序号`
,(case `a`.`areaId` when 1 then '北院' when 2 then '北平房' when 3 then '南平房东' when 4 then '南平房西' when 5 then '南平房西' end) AS `区块`
,`a`.`modify_time` AS `最后更改时间`
,`a`.`remark` AS `备注` 
,mistake_emp as 错扣人姓名
,mistake_emp_tel as 错扣人联系电话
from `rt_housinginfo` `a` 
where (`a`.`state` = 1)
order by areaId,left(buildingNo,locate('栋',buildingNo)-1)+0,id;

update rt_housinginfo set ot_idcardNo = idcardNo where originalTenant = presentTenant;
update rt_housinginfo set remark=concat(remark,"错扣") where mistake_emp is not null or mistake_emp_tel is not null;

update rt_employeeInfo set work_year = 2015 - (left(start_work_time,4)+0) where start_work_time != '' and start_work_time is not null;
update rt_employeeInfo set score = work_year+service_year+0;

update rt_housinginfo set seqId = '332' and remark = concat(remark,';顺序号需确认') where buildingNo = '136栋5、6号';

create or replace view v_rt_empByPos_1 as select * from rt_employeeInfo where category = 1 order by score+0 desc;
create or replace view v_rt_empByPos_2 as select * from rt_employeeInfo where category = 2 order by score+0 desc;
create or replace view v_rt_empByPos_3 as select * from rt_employeeInfo where category = 3 order by score+0 desc;
create or replace view v_rt_empByPos_4 as select * from rt_employeeInfo where category = 4 order by score+0 desc;
create or replace view v_rt_empByPos_5 as select * from rt_employeeInfo where category = 5 order by score+0 desc;
create or replace view v_rt_empByPos_6 as select * from rt_employeeInfo where category = 6 order by score+0 desc;
create or replace view v_rt_empByPos_7 as select * from rt_employeeInfo where category = 7 order by score+0 desc;
create or replace view v_rt_empByPos_8 as select * from rt_employeeInfo where category = 8 order by score+0 desc;





CREATE OR REPLACE VIEW V_RT_MONEY_315 AS
SELECT ID
,BUILDINGNO as '房号'
,ORIGINALTENANT as '原承租人'
,(case `a`.`em_state` when 1 then '在岗' when 2 then '退休' when 3 then '已去世' when 4 then '内退' when 5 then '离职' when 6 then '离休' when 7 then '长病' when 8 then '长期矿工' when 9 then '停薪留职' else '未知' end) AS 原承租人状态
,otUid as 原承租人职工号
,PRESENTTENANT as 协议签署人
,tel as 协议签署人联系方式
,idcardno as 协议签署人身份证号码
,constructionArea as 建筑面积
,(case when 50-constructionArea>0 then 50-constructionArea>0 else 0 end) as 补贴面积
,1.2*(case when 50-constructionArea>0 then 50-constructionArea>0 else 0 end)+0.4*5000 as 补偿金额



FROM RT_HOUSINGINFO a
WHERE seqId is not null;

,(case when 50-建筑面积>0 then 50-建筑面积>0 else 0 end) as 补贴面积
,1.2*补贴面积+0.4*5000 as 补偿金额
,建筑面积+改善面积 as 调房核算面积
,(case 
		when 300*建筑面积<20000
		then 20000
		else 300*建筑面积
   end) as 搬迁奖励
,1000 as 搬迁奖励+
,建筑面积*18
,(case 
		when (建筑面积*18)<800 
		then 800 
		else (
			case
				when (建筑面积*18)>1200
				then 1200
				else (建筑面积*18)
		 end)
	end ) as 临时安置费
,nqp as 暖气片
,seqid as 顺序号
,areaid as 区块
,lastmodifytime as 最后更改时间
,remark as 备注
-- 
update rt_housingInfo set ;
-- 改善面积S1
update rt_housingInfo set S1=round(S*0.1,2);
-- 补贴面积S2
update rt_housingInfo set S2=(case when ((50 - S) > 0) then round((50 - S),2) else 0 end);
-- 调房核算面积 S3=S+S1=S*1.1
update rt_housingInfo set S3=round(S+S1,2);
-- 搬家奖励0 R0
update rt_housingInfo set R0 = round((case when ((300 * `a`.`ConstructionArea`) < 20000) then 20000 else (300 * `a`.`ConstructionArea`) end),0);
-- 
update rt_housingInfo set ;
-- 
update rt_housingInfo set ;
-- 
update rt_housingInfo set ;