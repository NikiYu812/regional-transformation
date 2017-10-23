RT_HOUSINGINFO
-- 查询 
-- 按楼栋号查询
select * from rt_housingInfo where BuildingNo like "171栋15号";
-- 按原承租人姓名查询 
select * from rt_housinginfo where originalTenant like "王立平%";
-- 按协议签署人姓名查询 
select * from rt_housinginfo where presentTenant like "王各%";
-- 按顺序号查询
select * from rt_housinginfo where seqId like "329";
-- 验房不合格
select * from rt_housinginfo where seqId = "-1" and oldSeqId is not null;
-- 查询备注信息非空 
select * from rt_housinginfo where remark is not null and remark != '';
------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------
-- 查询
select * from rt_housingInfo;
select count(*) from rt_housingInfo;
-- 协议已签321
select count(*) from rt_housinginfo where state = '1';
select * from rt_housinginfo where state = '1';
select count(*) from rt_housinginfo where state = '1' and buildingno like '144栋%' ; 
-- 协议未签
select * from rt_housingInfo where state != '1';
-- 已排号
select count(*) from rt_housinginfo where seqId is not null and seqId!='';
-- 未排号
select count(*) from rt_housinginfo where state='1' and (seqId is null or seqId = '' or seqId = '-1');
-- 有效号
select count(*) from rt_housinginfo where seqId is not null and seqId!='' and seqId!='-1';
-- 已归档
select count(*) from rt_housinginfo where nqp is not null and nqp != '';
select count(*) from rt_housinginfo where seqId is not null and seqId != '';
select * from rt_housinginfo where seqId is not null and seqId != '';


-- 北平房协议已签
select count(*) as "已签" from rt_housinginfo where state = '1' and areano='2';
-- 北平房排号
select count(*) from rt_housinginfo where seqId!='' and seqId is not null and areano = '2';
-- 北平房未排号
select count(*) from rt_housinginfo where state='1' and (seqId is null or seqId = '' or seqId = '-1') and areaNo = '2';
select * from rt_housinginfo where state='1' and (seqId is null or seqId = '' or seqId = '-1') and areaId = '2';

-- 北平房有效号
select count(*) from rt_housinginfo where seqId!='' and seqId is not null and seqId!='-1' and areano = '2';
-- 北平房归档
select count(*) from rt_housinginfo where nqp!='' and nqp is not null and areano = '2';
-- 北平归档按栋统计
select left(buildingNo,locate('栋',buildingNo)) as '栋',count(*) as '数量'
from rt_housinginfo 
where nqp!='' and nqp is not null and areano = '2' 
group by left(buildingNo,locate('栋',buildingNo)) order by (left(buildingNo,locate('栋',buildingNo)-1)+0) asc;


-- 已归档按'栋'分组
select left(buildingNo,locate('栋',buildingNo)) as '栋',count(*) as '已归档数' from rt_housinginfo where nqp is not null and nqp != '' group by left(buildingNo,locate('栋',buildingNo)) order by left(buildingNo,locate('栋',buildingNo)-1)+0;

-- 已归档按区域分组(1北院，2北平，3南平西，4南平中，5南平东)
select areaId as '区域',count(*) as '已归档数' from rt_housinginfo where nqp is not null and nqp != '' group by areaId order by areaId;

-- 已签协议按区域分组
select areaId as '区域',count(*) as '户数' from rt_housinginfo where state = 1 group by areaId order by areaId;

-- 未签协议按区域分组
select areaId as '区域',count(*) as '户数' from rt_housinginfo where state = 0 group by areaId order by areaId;

-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
-- 一楼一平
select a.originalTenant,a.buildingno,b.buildingno from rt_housinginfo a,rt_multibuilding b where a.originalTenant = b.tenant and a.state = '1' and a.nqp is not null and b.flag <> 0;

select a.originalTenant,a.buildingno,b.buildingno from rt_housinginfo a,rt_multibuilding b where a.originalTenant = b.tenant and a.state = '1' and b.flag <> 0;

-- 两平
select count(buildingNo),originalTenant from rt_housingInfo where state = 1 group by originalTenant having (count(buildingNo)>1);
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
select buildingno as 房号,originalTenant as 原承租人,presentTenant as 协议签署人,tel as 联系电话,state as 是否签协议,seqid as 顺序号,nqp as 暖气片,areano as 区域,remark as 备注,modify_time from rt_housingInfo
-- 排号未归档
select * from rt_housinginfo where seqId is not null and seqId != '-1' and seqId != '' and nqp is null and areaId = '2';


select left(buildingNo,locate('栋',buildingNo)) as '栋', count(*) as '户数' , sum(constructionArea) as 总面积 from rt_housinginfo group by left(buildingNo,locate('栋',buildingNo)) order by left(buildingNo,locate('栋',buildingNo)-1)+0;

select * from rt_housinginfo where state = '1' and seqId is not null;


select count(*) from rt_housingInfo;

select * from rt_housinginfo where state='1';

select * from rt_housinginfo where state='1' and (seqId is null or seqId = '' or seqId = '-1');

select max(seqId+0) from rt_housingInfo;

select * from rt_housingInfo where originalTenant like '杨久然';

select work_year+service_year+0,left(start_work_time,4),(2015 - (left(start_work_time,4)+0)) from rt_employeeInfo where start_work_time != '' and start_work_time is not null;

select * from rt_employeeInfo where start_work_time = '' or start_work_time is null;



create or replace view v_temp as 
select b.uid,b.uname,a.username,a.start_work_time from rt_employeeInfo_original a,rt_employeeInfo b where a.uid = b.uid and (b.start_work_time = '' or b.start_work_time is null);

select * from rt_housingInfo where presentTenant like '%周兰%';

select * from rt_employeeInfo where uname like '%周兰%';

-- 已签协议未搬家
select * from rt_housingInfo where seqId is null and state = '1';



select * from rt_housingInfo where seqId is not null order by seqId;


-- INSERT INTO tb_person (p0_name,p0_uid,p0_state,p1_name,p1_idcNo,telNo,oh_id) SELECT DISTINCT OriginalTenant,otUid,em_state,PresentTenant,IDCardNo,Tel,id FROM tb_oldhouse;

INSERT INTO tb_oldhouse (id,house_no,person_id,person_name,location,area,sign_state,move_seq,remark) SELECT id,buildingNo,personId,OriginalTenant,areaId,S,state,seqId,remark FROM tb_oldhouse0;

-- 

-- 筛选出重复项
select * from (SELECT p0_name as 姓名 , COUNT(p0_name) as 数量 FROM tb_person GROUP BY p0_name) AA where 数量>1;

SELECT * FROM tb_person where oh_id LIKE '%##%';


