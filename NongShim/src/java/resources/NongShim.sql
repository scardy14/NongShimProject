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

-- 좋아요 리스트
CREATE TABLE like_product(
  post_no NUMBER NOT NULL,
  id VARCHAR2(100) NOT NULL,
   CONSTRAINT post_no_fk FOREIGN KEY (post_no) REFERENCES product_post_test(post_no),
    CONSTRAINT id_fk FOREIGN KEY (id) REFERENCES member_test(id),
    CONSTRAINT like_product_pk PRIMARY KEY (post_no, id)
)

-- 인증정보
create table seller_ide(
	id varchar2(100) not null,
	company_register_num varchar2(100) not null,
	constraint seller_id_fk foreign key (id) references member_test(id)
)


-- 구매중인 목록: member(id), product_info(product_no) fk 및 pk, date도 pk
create table buy_product_list(
	id varchar2(100) not null,
	product_no varchar2(100) not null,
	ns_date date not null,
	status varchar2(100) not null,
	amount number not null,
	constraint buy_product_id_fk foreign key(id) references member_test(id),
	constraint buy_product_product_no_fk foreign key(product_no) references product_info_test(product_no),
	constraint buy_product_pk primary key (id,product_no,ns_date)
)

-- 판매중인 목록: member(id), product_info(product_no) fk 및 pk
create table sell_product_list(
	id varchar2(100) not null,
	product_no varchar2(100) not null,
	status varchar2(100) not null,
	constraint sell_product_id_fk foreign key(id) references member_test(id),
	constraint sell_product_product_no_fk foreign key(product_no) references product_info_test(product_no),
	constraint sell_product_pk primary key (id,product_no)
)

-- 구매 확인 리스트: member(id), product_info(product_no) fk 및 pk
create table confirm_list(
	id varchar2(100) not null,
	product_no varchar2(100) not null,
	product_amount varchar2(100) not null,
	post_status varchar2(100) not null,
	constraint confirm_id_fk foreign key(id) references member_test(id),
	constraint confirm_product_fk foreign key(product_no) references product_info_test(product_no),
	constraint confirm_product_pk primary key(id,product_no)
)