-- 1. member 회원정보 테이블 
drop table NongShim_Member

CREATE TABLE NongShim_Member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100) NOT NULL,
	nickName VARCHAR2(100) NOT NULL,
	tel VARCHAR2(100) NOT NULL,
	seller_Info VARCHAR2(100) default '일반' NOT NULL,
	admin_INfo VARCHAR2(100) default '유저' NOT NULL,
	email VARCHAR2(100) NOT NULL,
	point NUMBER DEFAULT 0 NOT NULL,
	account_No VARCHAR2(100) NOT NULL,
	constraint account_uq unique(account_No),
	constraint email_uq unique(email),
	constraint tel_uq unique(tel),
	constraint nick_uq unique(nickName)
)

--1.1 회원정보 데이터 insert
insert into NongShim_Member
values('java','a','홍주영','서울','주영','010',DEFAULT,DEFAULT,'daum',default,'356-1');
insert into NongShim_Member
values('spring','a','장지영','판교','지영','011',DEFAULT,DEFAULT,'naver',default,'356-2');
insert into NongShim_Member  
values('jdbc','a','김민석','대구','민석','012',DEFAULT,DEFAULT,'hanmail',default,'356-3');

commit

--1.2 회원정보 select
select * from NongShim_Member;

DROP TABLE NongShim_member
DROP TABLE NongShim_productpost
DROP TABLE NongShimmember
DROP TABLE NongShimproductinfo
