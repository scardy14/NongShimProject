CREATE TABLE NongShim_Member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100) NOT NULL,
	nickName VARCHAR2(100) NOT NULL,
	tel VARCHAR2(100) NOT NULL,
	sellerInfo VARCHAR2(100) NOT NULL,
	adminiINfo VARCHAR2(100) NOT NULL,
	email VARCHAR2(100) NOT NULL,
	point NUMBER DEFAULT 0,
	accountNo VARCHAR2(100)	
)
create sequence NongShim_Member_seq;

insert into NongShim_Member(id,password,name,address,nickName,tel,sellerInfo,adminiInfo,email,point,accountNo) 
values('java','a','홍주영','길동','홍','010','판매자1','관리자','daum',0,'356');
insert into NongShim_Member(id,password,name,address,nickName,tel,sellerInfo,adminiInfo,email,point,accountNo) 
values('spring','a','홍주영','길동','홍','011','판매자1','관리자','daum',0,'356');
insert into NongShim_Member(id,password,name,address,nickName,tel,sellerInfo,adminiInfo,email,point,accountNo) 
values('del','a','홍주영','길동','홍','012','판매자1','관리자','daum',0,'356');

select*from NongShim_Member;