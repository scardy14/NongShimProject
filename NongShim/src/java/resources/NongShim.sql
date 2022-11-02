-- 1. member 회원정보 테이블 
CREATE TABLE NongShim_Member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100) NOT NULL,
	nickName VARCHAR2(100) NOT NULL,
	tel VARCHAR2(100) NOT NULL,
	seller_Info VARCHAR2(100) default '일반',
	admin_INfo VARCHAR2(100) default '유저',
	email VARCHAR2(100) NOT NULL,
	point NUMBER DEFAULT 0,
	account_No VARCHAR2(100) constraint account_uq unique(account_no)
)

--1.1 회원정보 데이터 insert
insert into NongShim_Member(id,password,name,address,nickName,tel,seller_Info,admin_Info,email,point,account_No) 
values('java','a','홍주영','서울','주영','010','daum',0,'356');
insert into NongShim_Member(id,password,name,address,nickName,tel,seller_Info,admin_Info,email,point,account_No) 
values('spring','a','장지영','판교','지영','011','daum',0,'356');
insert into NongShim_Member(id,password,name,address,nickName,tel,seller_Info,admin_Info,email,point,account_No) 
values('del','a','김민석','대구','민석','012','daum',0,'356');

--1.2 회원정보 select
select*from NongShim_Member;