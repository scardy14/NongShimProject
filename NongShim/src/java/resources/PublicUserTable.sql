--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!주의사항 및 사용방법!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!--
--1. 이 sql 파일은 앞으로 팀원이 공용으로 사용될 데이터베이스를 조작하는 파일입니다.
--2. 테이블 생성 & 테이블 수정 & 데이터 삽입 등 업무를 진행하실때에는 해당 sql문 제일 아래에다가 현재시간 및 날짜, 그리고 작업자 명을 기입하고 사용해주세요
--3. 로컬이 아닌 온라인 DB라 그런지 작업이 끝난 후 COMMIT를 수동으로 해줘야지 작업 내용이 반영됩니다. 꼭 작업 완료 후 COMMIT을 진행해 주세요.

--**여기서 바꾸는 내용은 팀원 전체 및 프로그램 동작 구조에 영향을 미칩니다.**--
--**공용 데이터베이스의 주소는 54.180.2.161, 포트는 1521, 이름은 xe입니다**--




DROP TABLE BUY_PRODUCT_LIST
DROP TABLE SELLER_IDE
DROP TABLE LIKE_PRODUCT
DROP TABLE NONGSHIM_ANNOUNCE_POST
DROP TABLE NONGSHIM_PRODUCTPOSTCOMMENTS
DROP TABLE NONGSHIM_MEMBER
DROP TABLE NONGSHIM_PRODUCT_POST
-----------------------------------1.멤버테이블 생성----------------------------------------------------------
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

SELECT * FROM NongShim_Member

insert into NongShim_Member
values('java','a','홍주영','서울','주영','010',DEFAULT,DEFAULT,'daum',default,'356-1');
insert into NongShim_Member
values('spring','a','장지영','판교','지영','011',DEFAULT,DEFAULT,'naver',default,'356-2');
insert into NongShim_Member  
values('jdbc','a','김민석','대구','민석','012',DEFAULT,DEFAULT,'hanmail',default,'356-3');
--아래 아이디는 우리가 사용할 운영자 계정. 아이디 및 비번은 운영자임
insert into NongShim_Member  
values('admin','admin','kosta','오리','하37지','20221106',DEFAULT,'운영자','adminmain',default,'1411-14');
COMMIT
---------------------------------------------------------------------------------------------------------
-----------------------------------2.상품게시글 생성----------------------------------------------------------
create table NongShim_product_Post(
post_No number primary key,
title varchar2(100) not null,
content clob not null,
id varchar2(100) not null,
hits number default 0 not null,
nickname varchar2(100) not null,
comments varchar2(100) not null,
register_Date date not null,
category varchar2(100) not null,
status varchar2(100)not null,
product_Name varchar2(100) not null,
product_Point number not null,
duration date not null,
min_Customer number not null,
max_Customer number not null,
CONSTRAINT fk_pp FOREIGN KEY(id) REFERENCES NongShim_Member(id) ON DELETE CASCADE
);
SELECT * FROM NONGSHIM_PRODUCT_POST

CREATE SEQUENCE postNo_seq;

insert into NongShim_product_Post
values (postNo_seq.nextval, '초록빛깔 상추', '신선하고 맛있습니다','java',default,'민석짱','코멘트부분',sysdate,'야채','status','상추',50,sysdate,5,10);
insert into NongShim_product_Post
values (postNo_seq.nextval, '사과사과', '달콤하고 맛있습니다','spring',default,'민석짱2','코멘트부분',sysdate,'과일','status','사과',200,sysdate,10,30);
insert into NongShim_product_Post 
values (postNo_seq.nextval, '맛있는 햅쌀', '꼬들꼬들합니다','jdbc',default,'민석짱3','코멘트부분',sysdate,'곡물','status','쌀',150,sysdate,50,100);
insert into NongShim_product_Post 
values (postNo_seq.nextval, '탐스런 과일', '크고 달아요','java',default,'짱아','맛있네요',sysdate,'과일','status','청포도',100,sysdate,10,30);
---------------------------------------------------------------------------------------------------------
-----------------------------------3.마이페이지쪽 ----------------------------------------------------------
CREATE TABLE like_product(
  post_no NUMBER NOT NULL,
  id VARCHAR2(100) NOT NULL,
--						  [별명]									(내 테이블에서 fk로 지정할 컬럼)			[가져올 fk가 있는 테이블명](가져 올 fk의 컬럼)
  CONSTRAINT post_no_fk FOREIGN KEY (post_no) REFERENCES NongShim_product_Post(post_no) ON DELETE CASCADE,
--						  [별명]									(내 테이블에서 fk로 지정할 컬럼)			[가져올 fk가 있는 테이블명](가져 올 fk의 컬럼)
  CONSTRAINT id_fk FOREIGN KEY (id) REFERENCES NongShim_Member(id) ON DELETE CASCADE,
-- 							[별명]										 (내 테이블에서 만들 컬럼1,컬럼2)
  CONSTRAINT like_product_pk PRIMARY KEY (post_no, id)
)

create table seller_ide(
	id varchar2(100) primary key,
	company_register_num varchar2(100) not null,
	constraint seller_id_fk foreign key (id) references NongShim_Member(id) ON DELETE CASCADE
)

create table buy_product_list(
	id varchar2(100) not null,
	post_no number not null,
	ns_date date not null,
	status varchar2(100) DEFAULT '발송전'not null,
	amount number DEFAULT 1 not null,
	constraint buy_product_id_fk foreign key(id) references NongShim_Member(id) ON DELETE CASCADE,
	constraint buy_product_product_no_fk foreign key(post_no) references NongShim_product_Post(post_no) ON DELETE CASCADE,
	constraint buy_product_pk primary key (id,post_no,ns_date)
)

--sell_product_list는 안쓴는 테이블, 흔적은 남겨둠
create table sell_product_list(
	id varchar2(100) not null,
	post_no number not null,
	status varchar2(100) DEFAULT '판매중' not null,
	constraint sell_product_id_fk foreign key(id) references NongShim_Member(id) ON DELETE CASCADE,
	constraint sell_product_product_no_fk foreign key(post_no) references NongShim_product_Post(post_no),
	constraint sell_product_pk primary key (id,post_no)
)

create table confirm_list(
	id varchar2(100) not null,
	post_no number not null,
	product_amount varchar2(100) DEFAULT 1 not null,
	post_status varchar2(100) DEFAULT '발송전' not null ,
	ns_date DATE DEFAULT sysdate NOT NULL,
	constraint confirm_id_fk foreign key(id) references NongShim_Member(id) ON DELETE CASCADE,
	constraint confirm_product_fk foreign key(post_no) references NongShim_product_Post(post_no) ON DELETE CASCADE,
	constraint confirm_product_pk primary key(id,post_no,ns_date)
)


SELECT * FROM confirm_list
--------------------------------------------------------------------------------------------------------
------------------------------------4.상품게시판 댓글 생성----------------------------------------------------------
create table NongShim_productPostComments(
id varchar2(100) not null,
post_No number not null,
comments_date date not null,
content clob not null,
category varchar2(100) not null,
constraint comments_id_fk foreign key(id) references NongShim_Member(id) ON DELETE CASCADE, 
constraint comments_post_no_fk foreign key(post_no) references NongShim_product_Post(post_no) ON DELETE CASCADE,
constraint comments_pk primary key(id, post_no,comments_date)
)

SELECT * FROM NongShim_productPostComments
----------------------------------------------------------------------------------------------------------
----------------------------------5.공지게시판 생성----------------------------------------------------------
create table NongShim_Announce_Post(
post_No number primary key,
id VARCHAR2(100) NOT NULL,
title varchar2(100) not null,
content clob not null,
hits number default 0 not null,
nickname varchar2(100) DEFAULT '운영자' not null,
register_Date date not null,
CONSTRAINT fk_anounce_post FOREIGN KEY(id) REFERENCES NongShim_Member(id) ON DELETE CASCADE
);
CREATE SEQUENCE announce_seq;
DROP TABLE NongShim_Announce_Post
SELECT * FROM NongShim_Announce_Post
----------------------------------------------------------------------------------------------------------
----------------------------------6.자유게시판 생성----------------------------------------------------------
create table NongShim_Free_Post(
post_No number primary key,
id VARCHAR2(100) NOT NULL,
title varchar2(100) not null,
content clob not null,
hits number default 0 not null,
register_Date date not null,
CONSTRAINT fk_free_post FOREIGN KEY(id) REFERENCES NongShim_Member(id) ON DELETE CASCADE
);
CREATE SEQUENCE free_seq;
ALTER TABLE NongShim_Free_Post_Comments DROP CONSTRAINT fk_free_post FOREIGN KEY(id) REFERENCES NongShim_Member(id) ON DELETE CASCADE

create table NongShim_Free_Post_Comments(
id varchar2(100) not null,
nickName VARCHAR2(100) not null,
post_No number not null,
comments_date date not null,
content clob not null,
constraint comments_id_fk1 foreign key(id) references NongShim_Member(id) ON DELETE CASCADE, 
constraint comments_post_no_fk1 foreign key(post_no) references NongShim_Free_Post(post_no) ON DELETE CASCADE,
constraint comments_pk1 primary key(id, post_no,comments_date)
)
----------------------------------------------------------------------------------------------------------
