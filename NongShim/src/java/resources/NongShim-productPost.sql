drop sequence postNo_seq
drop table NongShim_productPost
-- 2. Product Post 상품 게시판 글
create table NongShim_productPost(
postNo number primary key,
title varchar2(100) not null,
content clob not null,
id varchar2(100) not null,
hits number default 0 not null,
nickname varchar2(100) not null,
comments varchar2(100) not null,
registerDate date not null,
category varchar2(100) not null,
status varchar2(100)not null,
productName varchar2(100) not null,
productPoint number not null,
duration date not null,
minCustomer number not null,
maxCustomer number not null,

CONSTRAINT fk_pp FOREIGN KEY(id) REFERENCES NongShim_Member(id)
);

-- 2.1 시퀀스 생성
create sequence postNo_seq;

-- 2.2 product post data 입력 
insert into NongShim_productPost
values (postNo_seq.nextval, '초록빛깔 상추', '신선하고 맛있습니다','java',default,'민석짱','코멘트부분',sysdate,'야채','status','상추',50,sysdate,5,10);
insert into NongShim_productPost
values (postNo_seq.nextval, '사과사과', '달콤하고 맛있습니다','spring',default,'민석짱2','코멘트부분',sysdate,'과일','status','사과',200,sysdate,10,30);
insert into NongShim_productPost 
values (postNo_seq.nextval, '맛있는 햅쌀', '꼬들꼬들합니다','jdbc',default,'민석짱3','코멘트부분',sysdate,'곡물','status','쌀',150,sysdate,50,100);

commit


-- 2.3 product post 
select * from NongShim_productpost

